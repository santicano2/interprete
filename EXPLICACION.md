# Explicación Corta — CosoScript

**Integrantes:** Santiago Cano, Tomas Casco
**Variante diferencial:** repeat-until (`repetir` / `hasta`)

---

## Qué hicimos

Creamos un **lenguaje de programación en español** llamado CosoScript y su **intérprete** usando ANTLR4 + Java, siguiendo el patrón **Visitor** para recorrer el árbol sintáctico.

---

## 1. Gramática (CosoScript.g4)

Escribimos las reglas del lenguaje en un archivo `.g4`. ANTLR genera automáticamente:

- **Lexer**: tokeniza el código fuente (`"contador"` → ID, `"42"` → NUMERO)
- **Parser**: verifica la estructura y genera un árbol de parseo

La gramática tiene reglas léxicas (tokens) y sintácticas (estructura):

```
programa      → sentencia*
sentencia     → declaracion | asignacion | mostrar | condicional | repetir
declaracion   → 'coso' ID ':' tipo ('=' expresion)? ';'
repetir       → 'repetir' '{' sentencia* '}' 'hasta' '(' expresion ')' ';'
```

La precedencia de operadores se maneja por jerarquía de reglas:
`*`, `/` > `+`, `-` > relacionales > `&&` > `||`

---

## 2. Visitor (CosoScriptCustomVisitor.java)

Recorremos el árbol de parseo usando el patrón **Visitor**. Cada método `visit*()` construye un nodo AST:

```java
@Override
public Object visitDeclaracion(DeclaracionContext ctx) {
    String nombre = ctx.ID().getText();
    String tipo = ctx.tipo().getText();
    ASTNode valor = (ctx.expresion() != null)
        ? (ASTNode) visit(ctx.expresion())
        : null;
    return new VarDecl(nombre, tipo, valor);
}
```

El `visitPrograma` ejecuta cada sentencia recorriendo el árbol y llamando a `execute()`.

---

## 3. AST (9 nodos)

Cada nodo implementa `ASTNode.execute(Map symbolTable)`:

| Clase       | Función                                      |
| ----------- | -------------------------------------------- |
| `VarDecl`   | Declarar variable: `coso x : entero = 0;`    |
| `VarAssign` | Asignar: `x = x + 1;`                        |
| `VarRef`    | Usar variable: `contador + 1`                |
| `Literal`   | Valor fijo: `42`, `"hola"`, `verdadero`      |
| `BinOp`     | Operación de dos operandos: `a + b`, `x > y` |
| `UnOp`      | Operación de un operando: `!activo`          |
| `Println`   | Mostrar en pantalla                          |
| `If`        | Condicional si-sino                          |
| `Repeat`    | Bucle repetir-hasta                          |

---

## 4. Tabla de Símbolos (SymbolTable.java)

Clase separada que envuelve un `HashMap<String, Object>`:

- `declarar(nombre, valor)` — agrega variable (error si ya existe)
- `asignar(nombre, valor)` — actualiza valor (error si no existe)
- `obtener(nombre)` — consulta valor (error si no existe)
- `existe(nombre)` — verifica existencia

---

## 5. Análisis Semántico

| Validación            | Dónde ocurre                           |
| --------------------- | -------------------------------------- |
| Variable no declarada | Si usás `mostrar(x)` sin declararla    |
| Variable redeclarada  | Dos `coso x : ...` con el mismo nombre |
| División por cero     | Si hacés `a / 0`                       |
| Condición no booleana | Si ponés `si (5) { }`                  |
| Tipo inválido         | Sumar número con booleano              |

---

## 6. Variante diferencial: repeat-until

```
repetir {
    mostrar(contador);
    contador = contador + 1;
} hasta (contador == 5);
```

- Ejecuta el cuerpo **siempre al menos una vez**
- Si la condición es `true` → termina
- Si es `false` → repite

---

## 7. Ejecución paso a paso

```
Main.java → crea Lexer → tokeniza → crea Parser → parsea → genera árbol
→ Visitor recorre el árbol → construye nodos AST → ejecuta cada nodo
```

---

## Resumen

| Componente        | Archivo                        | Función                          |
| ----------------- | ------------------------------ | -------------------------------- |
| Gramática         | `CosoScript.g4`                | Reglas del lenguaje              |
| Visitor           | `CosoScriptCustomVisitor.java` | Recorre el árbol y construye AST |
| Tabla de símbolos | `SymbolTable.java`             | Gestiona variables               |
| Nodos AST         | `ast/*.java` (9 clases)        | Cada construcción del lenguaje   |
| Entry point       | `Main.java`                    | Orquesta todo                    |
