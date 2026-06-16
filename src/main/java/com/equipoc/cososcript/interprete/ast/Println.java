package com.equipoc.cososcript.interprete.ast;

import java.util.Map;

/**
 * Nodo AST para la instrucción mostrar.
 * Ejemplo: mostrar(contador);
 */
public class Println implements ASTNode {
	private ASTNode expresion;

	public Println(ASTNode expresion) {
		this.expresion = expresion;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		Object resultado = expresion.execute(symbolTable);
		System.out.println(resultado);
		return null;
	}
}
