# Explicación Completa — CosoScript

**Integrantes:** Santiago Cano, Tomas Casco
**Variante diferencial:** repeat-until (`repetir` / `hasta`)

---

## 1. Vista general del proyecto

Creamos un lenguaje de programación imperativo en español llamado **CosoScript** y su intérprete, usando **ANTLR4** + **Java 8** con **Maven**.

El flujo de ejecución es:

```
Código fuente (.cs)
    ↓ Lexer (ANTLR) → tokens
    ↓ Parser (ANTLR) → árbol de parseo
    ↓ CustomVisitor → construye AST (lista de ASTNode)
    ↓ SemanticAnalyzer → valida errores semánticos
    ↓ Ejecución: cada ASTNode.execute() contra la SymbolTable
```

### Archivos del proyecto

```
src/main/antlr4/
  └── CosoScript.g4              → Gramática (léxica + sintáctica)

src/main/java/com/equipoc/cososcript/interprete/
  ├── Main.java                   → Punto de entrada
  ├── CosoScriptCustomVisitor.java → Visitor: árbol de parseo → AST
  ├── SemanticAnalyzer.java       → Valida errores semánticos antes de ejecutar
  ├── SymbolTable.java            → HashMap que guarda variables y valores
  └── ast/
      ├── ASTNode.java            → Interfaz: Object execute(Map)
      ├── VarDecl.java            → coso x : entero = 5;
      ├── VarAssign.java          → x = x + 1;
      ├── VarRef.java             → usar x en una expresión
      ├── Literal.java            → 42, 3.14, "hola", verdadero
      ├── BinOp.java              → a + b, x > y, a && b
      ├── UnOp.java               → !activo, -x
      ├── Println.java            → mostrar(expresion)
      ├── If.java                 → si (cond) { } sino { }
      └── Repeat.java             → repetir { } hasta (cond);

test/
  ├── test.cs                     → programa completo de ejemplo
  ├── expresiones.cs              → prueba de operadores
  ├── ifelse.cs                   → prueba de condicionales
  ├── repeat.cs                   → prueba de repeat-until
  └── default.cs                  → copia de test.cs
```

---

## 2. La gramática (CosoScript.g4)

### Enfoque

La gramática tiene **reglas sintácticas** primero y **reglas léxicas** después. No tiene acciones embebidas (código Java dentro de la gramática). ANTLR genera automáticamente:

- `CosoScriptLexer.java` — tokeniza el código
- `CosoScriptParser.java` — parsea y genera el árbol
- `CosoScriptVisitor.java` — interfaz con métodos `visitXxx()` por cada regla
- `CosoScriptBaseVisitor.java` — implementación default de cada `visitXxx()` que llama a `visitChildren()`

### Reglas principales

```
programa     → sentencia* EOF

sentencia    → declaracion | asignacion | mostrar | condicional | repetir

declaracion  → 'coso' ID ':' tipo ('=' expresion)? ';'
asignacion   → ID '=' expresion ';'
mostrar      → 'mostrar' '(' expresion ')' ';'
condicional  → 'si' '(' expresion ')' '{' sentencia* '}'
               ('sino' '{' sentencia* '}')?
repetir      → 'repetir' '{' sentencia* '}' 'hasta' '(' expresion ')' ';'
```

### Precedencia de operadores

Se maneja por **jerarquía de reglas** en lugar de definirla explícitamente. Cada nivel de precedencia es una regla:

```
expresion      → logica_o
logica_o       → logica_y (|| logica_y)*
logica_y       → igualdad (&& igualdad)*
igualdad       → comparacion (== | != comparacion)*
comparacion    → aditiva (< | <= | > | >= aditiva)*
aditiva        → multiplicativa (+ | - multiplicativa)*
multiplicativa → unaria (* | / unaria)*
unaria         → (! | -)? postfija
postfija       → primaria
primaria       → numero | cadena | ID | booleano | '(' expresion ')'
```

Esto da la precedencia: `!` `-` (unarios) > `*` `/` > `+` `-` > `<` `<=` `>` `>=` > `==` `!=` > `&&` > `||`

### Tipos de dato

```
tipo → 'entero' | 'real' | 'cadena' | 'logico'
```

### Palabras clave

Todas en español: `coso`, `mostrar`, `si`, `sino`, `repetir`, `hasta`, `entero`, `real`, `cadena`, `logico`, `verdadero`, `falso`.

### Tokens importantes

- `NUMERO: [0-9]+('.'[0-9]+)?;` — acepta enteros y reales
- `CADENA: '"' (~["\r\n\\] | '\\' .)* '"';` — strings con escapes
- `ID: [a-zA-Z_][a-zA-Z0-9_]*;` — identificadores
- `WS: [ \t\r\n]+ -> skip;` — espacios ignorados
- `COMENTARIO: '//' ~[\r\n]* -> skip;` — comentarios de línea ignorados

---

## 3. El Visitor (CosoScriptCustomVisitor.java)

### Qué hace

Recorre el árbol de parseo generado por ANTLR y construye una lista de nodos AST (`List<ASTNode>`). NO ejecuta nada todavía, solo construye el AST.

### El problema del dispatch

ANTLR genera interfaces como `CosoScriptVisitor<T>` con métodos como:

```java
T visitDeclaracion(DeclaracionContext ctx);
T visitAsignacion(AsignacionContext ctx);
// etc.
```

Y `CosoScriptBaseVisitor<T>` los implementa con `return visitChildren(ctx)`.

Lo que debería pasar: `visitor.visit(tree)` llama a `tree.accept(visitor)`, que redirige al método específico (`visitDeclaracion`, etc.).

El problema: **ANTLR 4.4 no genera el método `accept()` en las clases de contexto**. Sin `accept()`, la JVM usa `RuleContext.accept()` del runtime, que solo llama a `visitor.visitChildren(this)` (nunca a `visitDeclaracion`, `visitAsignacion`, etc.).

Ningún método `visitXxx()` de nuestro Visitor se ejecutaba. El AST quedaba vacío → NullPointerException.

### La solución

Sobrescribimos `visit()` con dispatch manual via `instanceof`:

```java
@Override
public Object visit(ParseTree tree) {
    if (tree instanceof TerminalNode) return visitTerminal((TerminalNode) tree);
    RuleNode r = (RuleNode) tree;
    if (r instanceof DeclaracionContext) return visitDeclaracion((DeclaracionContext) r);
    if (r instanceof AsignacionContext) return visitAsignacion((AsignacionContext) r);
    // ... todos los contextos ...
    return visitChildren(r);
}
```

Y también sobrescribimos `visitChildren()` para que llame a `visit()` (nuestro dispatch) en vez de a `accept()`:

```java
@Override
public Object visitChildren(RuleNode node) {
    Object result = defaultResult();
    int n = node.getChildCount();
    for (int i = 0; i < n; i++) {
        if (!shouldVisitNextChild(node, result)) break;
        ParseTree c = node.getChild(i);
        if (c instanceof TerminalNode) continue;  // ignorar tokens
        Object childResult = visit(c);
        result = aggregateResult(result, childResult);
    }
    return result;
}
```

### Cómo construye cada nodo AST

Cada método `visitXxx()` toma el contexto ANTLR, extrae la información relevante y crea un nodo AST:

```java
// DeclaracionContext → VarDecl
public Object visitDeclaracion(DeclaracionContext ctx) {
    String nombre = ctx.ID().getText();
    String tipo = ctx.tipo().getText();
    ASTNode valor = null;
    if (ctx.expresion() != null)
        valor = (ASTNode) visit(ctx.expresion());
    return new VarDecl(nombre, tipo, valor);
}

// MostrarContext → Println
public Object visitMostrar(MostrarContext ctx) {
    ASTNode expr = (ASTNode) visit(ctx.expresion());
    return new Println(expr);
}

// CondicionalContext → If
// Usa las labels entonces y sino (definidas en la gramática)
public Object visitCondicional(CondicionalContext ctx) {
    ASTNode condicion = (ASTNode) visit(ctx.expresion());
    List<ASTNode> thenBody = new ArrayList<>();
    for (SentenciaContext s : ctx.entonces) thenBody.add((ASTNode) visit(s));
    List<ASTNode> elseBody = new ArrayList<>();
    if (ctx.sino != null)
        for (SentenciaContext s : ctx.sino) elseBody.add((ASTNode) visit(s));
    return new If(condicion, thenBody, elseBody);
}
```

Para expresiones binarias (ej: `visitLogica_o`), se construye una cadena de BinOp:

```java
// Para a || b || c: BinOp(BinOp(a, "||", b), "||", c)
public Object visitLogica_o(Logica_oContext ctx) {
    ASTNode node = (ASTNode) visit(ctx.logica_y(0));
    for (int i = 1; i < ctx.logica_y().size(); i++) {
        ASTNode right = (ASTNode) visit(ctx.logica_y(i));
        node = new BinOp(node, "||", right);
    }
    return node;
}
```

Para operadores como `==`, `!=`, `<`, etc. (en `visitIgualdad`, `visitComparacion`, etc.), el operador se extrae del árbol con `ctx.getChild(i * 2 - 1).getText()`.

---

## 4. Los nodos AST

### ASTNode (interfaz)

```java
public interface ASTNode {
    Object execute(Map<String, Object> symbolTable);
}
```

Un único método: recibe la tabla de símbolos, ejecuta la operación, devuelve un resultado (o null para instrucciones).

### VarDecl — Declaración de variable

```java
coso x : entero = 5;
```

En `execute()`:
1. Si la variable ya existe en la tabla → lanza error
2. Si tiene valor inicial: evalúa la expresión y valida compatibilidad de tipos
3. Si no tiene valor: asigna valor por defecto según tipo (`0`, `0.0`, `""`, `false`)
4. Guarda en la tabla de símbolos

### VarAssign — Asignación

```java
x = x + 1;
```

En `execute()`:
1. Verifica que la variable existe → error si no
2. Evalúa la expresión
3. Actualiza el valor en la tabla

### VarRef — Referencia a variable

```java
mostrar(contador);  // "contador" es un VarRef
```

En `execute()`: busca el nombre en la tabla y devuelve su valor. Error si no existe.

### Literal — Valor constante

```java
42, 3.14, "hola", verdadero, falso
```

En `execute()`: devuelve el valor directamente (Integer, Double, String, Boolean).

### BinOp — Operación binaria

Soporta: `+`, `-`, `*`, `/`, `==`, `!=`, `<`, `<=`, `>`, `>=`, `&&`, `||`

En `execute()`:
1. Evalúa izquierda y derecha
2. Según el operador:
   - **Aritméticos** (`+`, `-`, `*`, `/`): maneja Integer y Double con promoción automática (int + double → double). `+` también concatena strings.
   - **Relacionales** (`==`, `!=`, `<`, `<=`, `>`, `>=`): comparan números con promoción.
   - **Lógicos** (`&&`, `||`): castean a Boolean.

Cada operación lanza error si los tipos no son compatibles. La división valida cero en runtime (además del análisis semántico previo).

### UnOp — Operación unaria

Soporta: `!` (negación lógica), `-` (negación aritmética)

En `execute()`:
- `!`: requiere Boolean
- `-`: requiere Integer o Double

### Println — Mostrar

```java
mostrar(contador);
```

Evalúa la expresión e imprime el resultado con `System.out.println()`.

### If — Condicional

```java
si (nota >= 6) {
    mostrar("aprobado");
} sino {
    mostrar("desaprobado");
}
```

En `execute()`:
1. Evalúa la condición
2. Si no es Boolean → error
3. Si es true: ejecuta cuerpo then; si no: ejecuta cuerpo else (puede estar vacío)

### Repeat — Bucle repetir-hasta (variante diferencial)

```java
repetir {
    mostrar(contador);
    contador = contador + 1;
} hasta (contador == 5);
```

En `execute()`:
1. Ejecuta el cuerpo
2. Evalúa la condición
3. Si no es Boolean → error
4. Si es true → termina; si es false → vuelve al paso 1

Garantiza que el cuerpo se ejecuta **al menos una vez** (porque evalúa la condición después del cuerpo). Esto la diferencia del while convencional.

---

## 5. El análisis semántico (SemanticAnalyzer.java)

### Qué hace

Recorre el AST **antes de ejecutar** y detecta errores que podrían ocurrir en tiempo de ejecución. Si encuentra errores, los muestra y cancela la ejecución.

### Validaciones

| Validación | Cómo se detecta | Ejemplo que falla |
|---|---|---|
| Variable no declarada | `analizarVarAssign` y `analizarExpresion` para VarRef verifican que el nombre esté en el mapa `tipos` | `coso x : entero = 10; mostrar(y);` |
| Variable redeclarada | `analizarVarDecl` verifica que el nombre NO esté ya en `tipos` | `coso x : entero = 10; coso x : real = 5.5;` |
| División por cero literal | `analizarExpresion` para BinOp con `/` verifica si el lado derecho es Literal con valor 0 | `coso x : entero = 10 / 0;` |
| Tipo incompatible | `analizarVarDecl` usa `inferirTipo()` y `sonCompatibles()` para verificar | `coso x : entero = "hola";` |

### Cómo funciona la inferencia de tipos

`inferirTipo(ASTNode)` devuelve un String (`"entero"`, `"real"`, `"cadena"`, `"logico"`) según:
- **Literal**: por el tipo del objeto Java (Integer, Double, String, Boolean)
- **VarRef**: busca el tipo declarado en el mapa `tipos`
- **BinOp**: depende del operador:
  - Aritméticos: si alguno es `real` → `real`; si ambos son `entero` → `entero`
  - Relacionales/lógicos: `logico`
- **UnOp**: `!` → `logico`; `-` → tipo del operando

### Compatibilidad

`sonCompatibles(tipoDeclarado, tipoValor)`:
- Mismos tipos → compatible
- `real` declarado con valor `entero` → compatible (promoción)
- Cualquier otra combinación → incompatible

### Nota

Esta validación es **estática** (antes de ejecutar). Algunos errores también se validan en runtime dentro de `execute()` por si llegara a pasar algo (doble chequeo). Pero si el análisis semántico no encuentra errores, el runtime no debería lanzar ninguno (para los casos cubiertos).

---

## 6. La tabla de símbolos (SymbolTable.java)

Es un wrapper sobre `HashMap<String, Object>` con métodos:

```java
declarar(nombre, valor)  → put si no existe, error si ya existe
asignar(nombre, valor)   → put si existe, error si no
obtener(nombre)          → get si existe, error si no
existe(nombre)           → containsKey
getMap()                 → devuelve el HashMap (para pasar a execute())
```

Se usa durante la ejecución. Los nombres de variables son las claves, los valores son Object (Integer, Double, String, Boolean).

---

## 7. Main.java — Punto de entrada

```java
public static void main(String[] args) throws IOException {
    String program = args.length > 0 ? args[0] : "test/test.cs";

    // 1. Lexer + Parser (ANTLR)
    CosoScriptLexer lexer = new CosoScriptLexer(new ANTLRFileStream(program));
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    CosoScriptParser parser = new CosoScriptParser(tokens);
    CosoScriptParser.ProgramaContext tree = parser.programa();

    // 2. Visitor → List<ASTNode>
    CosoScriptCustomVisitor visitor = new CosoScriptCustomVisitor();
    List<ASTNode> programa = (List<ASTNode>) visitor.visitPrograma(tree);

    // 3. Análisis semántico
    SemanticAnalyzer analyzer = new SemanticAnalyzer();
    if (!analyzer.analizar(programa)) {
        System.err.println("Interpretacion cancelada por errores semanticos.");
        return;
    }

    // 4. Ejecutar
    SymbolTable symbolTable = new SymbolTable();
    for (ASTNode node : programa) {
        node.execute(symbolTable.getMap());
    }
}
```

### Observaciones sobre el flujo

- Usamos `visitor.visitPrograma(tree)` en vez de `visitor.visit(tree)` porque el `visit()` genérico no redirige correctamente en ANTLR 4.4 (como explicamos antes). Pero como sobrescribimos `visit()` en nuestro Visitor, cualquiera de las dos formas funciona ahora.
- `SemanticAnalyzer.analizar()` devuelve `boolean`: si hay errores, no se ejecuta nada.
- La `SymbolTable` se crea vacía y los nodos la van llenando.

### Sobre RuntimeException

Los errores en `execute()` se lanzan como `RuntimeException`. No los capturamos en Main porque si el análisis semántico funciona bien, no deberían ocurrir. Si ocurren igual, el programa termina con el mensaje de error.

---

## 8. La variante diferencial: repeat-until

### Gramática

```
repetir: REPETIR LLAVE_IZQD sentencia* LLAVE_DER
         HASTA PAREN_IZQD expresion PAREN_DER PUNTO_COMA;
```

### Semántica

```
repetir {
    <cuerpo>
} hasta (<condición>);
```

1. Ejecuta `<cuerpo>` (siempre al menos una vez)
2. Evalúa `<condición>`
3. Si la condición es `true` → termina
4. Si es `false` → vuelve al paso 1

### Diferencia con while

- `while (cond) { }` puede ejecutar 0 veces si la condición inicial es false
- `repetir { } hasta (cond)` ejecuta **siempre al menos 1 vez**

### Implementación en Repeat.java

```java
do {
    for (ASTNode sentencia : cuerpo)
        sentencia.execute(symbolTable);
    Object valCond = condicion.execute(symbolTable);
    if (!(valCond instanceof Boolean))
        throw new RuntimeException("Error semántico: ...");
    if ((Boolean) valCond) break;
} while (true);
```

Usamos `do { } while (true)` con `break` cuando la condición es true, que es la semántica correcta de repeat-until (repite HASTA que sea true).

---

## 9. Manejo del tipado

### Sistema de tipos en CosoScript

- **entero**: Integer (Java)
- **real**: Double (Java)
- **cadena**: String (Java)
- **logico**: Boolean (Java)

### Promoción automática

En operaciones aritméticas, si un operando es `Integer` y el otro `Double`, se promociona el Integer a Double:

```java
// BinOp.sumar()
if (izq instanceof Integer && der instanceof Integer) {
    return (Integer) izq + (Integer) der;
}
if (izq instanceof Double || der instanceof Double) {
    double d1 = izq instanceof Double ? (Double) izq : ((Integer) izq).doubleValue();
    double d2 = der instanceof Double ? (Double) der : ((Integer) der).doubleValue();
    return d1 + d2;
}
```

### Concatencación de strings con +

Si alguno de los operandos de `+` es String, se concatenan como strings (comportamiento tipo Java).

### Casting en operadores lógicos

`&&` y `||` requieren que ambos operandos sean Boolean. Se castean directamente.

---

## 10. Errores semánticos (lista completa)

### Detectados en SemanticAnalyzer (antes de ejecutar)

1. **Variable no declarada** — usás una variable que no fue declarada con `coso`
2. **Variable redeclarada** — declarás dos veces la misma variable
3. **División por cero literal** — dividís por un literal 0 (ej: `x / 0`)
4. **Tipo incompatible** — asignás un valor de tipo incorrecto (ej: `coso x : entero = "texto"`)

### Detectados en runtime (ASTNode.execute())

1. **Variable no declarada** (VarRef, VarAssign) — doble chequeo por si algo pasó
2. **Variable redeclarada** (VarDecl) — doble chequeo
3. **División por cero** (BinOp) — si el cero no es literal sino resultado de expresión
4. **Tipo inválido en operación** (BinOp, UnOp) — sumar booleano con entero, etc.
5. **Condición no booleana** (If, Repeat) — poner `si (5) { }` o `hasta (5)`
6. **Operador aritmético con tipos no numéricos** — sumar booleanos, etc.

---

## 11. Compilación y ejecución en Eclipse

1. Importar Existing Maven Project
2. Click derecho → Run As → Maven build... → Goals: `antlr4:antlr4 compile` → Run
3. Click derecho en Main.java → Run As → Java Application

Para ejecutar un archivo distinto de `test/test.cs`: crear Run Configuration → Arguments → pasar la ruta como `args[0]`.

---

## Preguntas frecuentes para la defensa

### ¿Por qué no usaron acciones embebidas en la gramática?

Porque queríamos separar claramente la gramática (sintaxis del lenguaje) de la construcción del AST. Con Visitor tenemos una clase separada que recorre el árbol, lo que hace el código más mantenible y permite cambiar la construcción del AST sin tocar la gramática. Además la consigna pedía explícitamente recorrer el árbol con Visitor.

### ¿Por qué el análisis semántico es una fase separada?

Para detectar errores antes de ejecutar. Si ejecutáramos directamente y encontráramos un error a mitad del programa, el resto no se ejecutaría y el usuario no sabría cuántos errores hay. Con el análisis previo mostramos TODOS los errores de una vez.

### ¿Cómo manejan la precedencia de operadores?

Por jerarquía de reglas en la gramática. Cada nivel de precedencia es una regla diferente. Por ejemplo, `multiplicativa` contiene `unaria (*|/ unaria)*`, y `aditiva` contiene `multiplicativa (+|- multiplicativa)*`. Como `aditiva` llama a `multiplicativa`, la multiplicación tiene mayor precedencia.

### ¿Por qué sobrescribieron visit() en el Visitor?

Porque ANTLR 4.4 no genera el método `accept()` en las clases de contexto. Sin él, `visitor.visit(tree)` no redirige a `visitPrograma`, `visitDeclaracion`, etc. En su lugar llama a `visitChildren()` en todos los nodos, y los métodos específicos nunca se ejecutan. Lo solucionamos con dispatch manual via `instanceof`.

### ¿Qué es la variante repeat-until?

Es un bucle que ejecuta el cuerpo al menos una vez y luego evalúa la condición. Si la condición es verdadera, termina; si es falsa, repite. Se diferencia del while en que el cuerpo se ejecuta siempre al menos una vez.

### ¿Qué tipos de dato soporta CosoScript?

Entero, real, cadena y lógico. Las declaraciones pueden tener inicialización opcional; si no se inicializa, se asigna valor por defecto (0, 0.0, "", false).

### ¿Cómo funciona la tabla de símbolos?

Es un HashMap<String, Object> donde las claves son los nombres de variable y los valores son su contenido actual (Integer, Double, String o Boolean). El acceso a variables no declaradas lanza error tanto en el análisis semántico como en el runtime.
