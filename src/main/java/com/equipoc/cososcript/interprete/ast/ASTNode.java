package com.equipoc.cososcript.interprete.ast;

import java.util.Map;

/**
 * Interfaz base para todos los nodos del árbol sintáctico abstracto (AST).
 * Cada nodo puede ejecutarse en un contexto de tabla de símbolos.
 */
public interface ASTNode {
	/**
	 * Ejecuta el nodo en el contexto de una tabla de símbolos.
	 * 
	 * @param symbolTable Tabla de símbolos que contiene las variables y sus valores
	 * @return El resultado de la ejecución del nodo
	 */
	public Object execute(Map<String, Object> symbolTable);
}
