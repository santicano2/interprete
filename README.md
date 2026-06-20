# CosoScript - Intérprete con ANTLR

Trabajo Práctico - Conceptos y Paradigmas de Lenguajes de Programación

**Integrantes:** Santiago Cano, Tomas Casco

**Variante diferencial:** repeat-until (`repetir` / `hasta`)

## Descripción

CosoScript es un lenguaje de programación imperativo diseñado en español. Su intérprete está construido con ANTLR4 y Java. El parser genera un árbol sintáctico que es recorrido mediante el patrón **Visitor** para construir y ejecutar el AST (Abstract Syntax Tree).

## Características del Lenguaje

### Tipos de datos

- `entero` (int)
- `real` (double)
- `cadena` (String)
- `logico` (boolean)

### Estructuras de control

- `si` / `sino` (if-else)
- `repetir` / `hasta` (repeat-until) — variante diferencial

### Operadores

| Tipo         | Operadores                       |
| ------------ | -------------------------------- | --- | ------ |
| Aritméticos  | `+`, `-`, `*`, `/`               |
| Relacionales | `==`, `!=`, `<`, `<=`, `>`, `>=` |
| Lógicos      | `&&`, `                          |     | `, `!` |

### Comentarios

- Línea: `// texto`

### Inicialización

- Opcional: `coso x : entero;` → valor por defecto (0, 0.0, "", false)

## Análisis Semántico Implementado

- Variable no declarada → error
- Variable redeclarada → error
- División por cero → error
- Condición no booleana en `si` / `hasta` → error
- Tipo inválido en operaciones → error

## Ejemplo

```cs
coso contador : entero = 0;

repetir {
    mostrar(contador);
    contador = contador + 1;
} hasta (contador == 5);

mostrar("---");

si (contador > 3) {
    mostrar("re copado");
} sino {
    mostrar("dale de nuevo");
}
```

Salida:

```
0
1
2
3
4
---
re copado
```

## Estructura del Proyecto

```
interprete/
├── pom.xml                              # Configuración Maven
├── test/
│   └── test.cs                          # Programa de prueba
└── src/main/
    ├── antlr4/com/equipoc/cososcript/interprete/
    │   └── CosoScript.g4               # Gramática ANTLR (léxica + sintáctica)
    └── java/com/equipoc/cososcript/interprete/
        ├── Main.java                    # Punto de entrada
        ├── SymbolTable.java            # Tabla de símbolos (gestión de variables)
        ├── CosoScriptCustomVisitor.java # Visitor: recorre el AST y ejecuta
        └── ast/
            ├── ASTNode.java            # Interfaz base del AST
            ├── BinOp.java              # Operaciones binarias (+, -, *, /, ==, etc.)
            ├── If.java                 # Condicional si-sino
            ├── Literal.java            # Valores constantes
            ├── Println.java            # Instrucción mostrar
            ├── Repeat.java             # Bucle repetir-hasta
            ├── UnOp.java               # Operaciones unarias (!, -)
            ├── VarAssign.java          # Asignación de variable
            ├── VarDecl.java            # Declaración de variable
            └── VarRef.java             # Referencia a variable
```

## Compilar y Ejecutar

### Desde terminal (recomendado)

```bash
cd interprete
mvn antlr4:antlr4 compile exec:java -D"exec.mainClass=com.equipoc.cososcript.interprete.Main"
```

> Si ya compilaste antes y solo querés ejecutar de nuevo:
>
> ```bash
> mvn exec:java -D"exec.mainClass=com.equipoc.cososcript.interprete.Main"
> ```

### Para ejecutar un archivo específico

```bash
mvn antlr4:antlr4 compile exec:java -D"exec.mainClass=com.equipoc.cososcript.interprete.Main" -D"exec.args=ruta/archivo.cs"
```

### Desde Eclipse

Eclipse no genera automáticamente las clases de ANTLR. Para que funcione:

1. En terminal: `mvn antlr4:antlr4 compile` (genera fuentes ANTLR + compila)
2. En Eclipse: seleccionar proyecto → **F5** (Refresh)
3. Ejecutar `Main.java` como Java Application

> Si cambiás la gramática `.g4`, repetí el paso 1 desde terminal.

## Gramática (resumen)

```
programa      → sentencia*
sentencia     → declaracion | asignacion | mostrar | condicional | repetir
declaracion   → 'coso' ID ':' tipo ('=' expresion)? ';'
asignacion    → ID '=' expresion ';'
mostrar       → 'mostrar' '(' expresion ')' ';'
condicional   → 'si' '(' expresion ')' '{' sentencia* '}' ('sino' '{' sentencia* '}')?
repetir       → 'repetir' '{' sentencia* '}' 'hasta' '(' expresion ')' ';'
expresion     → logica_o (operador)*  (precedencia: *, / > +, - > relacional > lógico)
```

## Tecnologías

- **ANTLR 4.5.2** — generación de lexer/parser
- **Java 8** — implementación del intérprete
- **Maven** — gestión de dependencias y build
