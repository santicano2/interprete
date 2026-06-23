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

## Compilar y ejecutar desde Eclipse

1. Importar el proyecto como **Existing Maven Project**
2. Hacer click en Project -> Clean para compilar
3. Hacer clic derecho sobre `Main.java` → **Run As** → **Java Application**
4. Ir cambiando el codigo de test.cs por los otros ejemplos en /test

Alternativamente si no funciona asi, hacer esto:

1. Importar el proyecto como **Existing Maven Project**
1. Hacer clic derecho sobre el proyecto → **Run As** → **Maven build...**
1. En **Goals** escribir: `antlr4:antlr4 compile`
1. Hacer clic derecho sobre `Main.java` → **Run As** → **Java Application**

## Decisiones de diseño

- Separamos el Visitor de la ejecución (construcción del AST) del intérprete
  para tener una fase de análisis semántico previa, en lugar de usar
  acciones embebidas en la gramática como sugiere el tutorial.
- Si una variable no se inicializa, se le asigna un valor por defecto
  según su tipo (0, 0.0, "", false).
- Detectamos errores semánticos (variable no declarada, redeclarada,
  división por cero, tipos incompatibles) antes de ejecutar,
  en una etapa separada del intérprete.

## Estructura del Proyecto

```
interprete/
├── pom.xml                              # Configuracion Maven
├── test/
│   └── test.cs                          # Programa de prueba
└── src/main/
    ├── antlr4/com/equipoc/cososcript/interprete/
    │   └── CosoScript.g4               # Gramatica ANTLR (lexica + sintactica)
    └── java/com/equipoc/cososcript/interprete/
         ├── Main.java                    # Punto de entrada
         ├── SymbolTable.java            # Tabla de símbolos (gestion de variables)
         ├── SemanticAnalyzer.java       # Análisis semántico previo a ejecucion
         ├── CosoScriptCustomVisitor.java # Visitor: recorre el arbol y construye el AST
        └── ast/
            ├── ASTNode.java            # Interfaz base del AST
            ├── BinOp.java              # Operaciones binarias (+, -, *, /, ==, etc.)
            ├── If.java                 # Condicional si-sino
            ├── Literal.java            # Valores constantes
            ├── Println.java            # Instruccion mostrar
            ├── Repeat.java             # Bucle repetir-hasta
            ├── UnOp.java               # Operaciones unarias (!, -)
            ├── VarAssign.java          # Asignacion de variable
            ├── VarDecl.java            # Declaracion de variable
            └── VarRef.java             # Referencia a variable
```
