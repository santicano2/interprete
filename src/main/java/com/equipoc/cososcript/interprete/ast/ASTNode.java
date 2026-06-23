package com.equipoc.cososcript.interprete.ast;

import java.util.Map;

/**
 * Interfaz base para todos los nodos del arbol sintactico abstracto (AST).
*/

public interface ASTNode {
	public Object execute(Map<String, Object> symbolTable);
}
