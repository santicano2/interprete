package com.equipoc.cososcript.interprete.ast;

import java.util.Map;

/**
 * Nodo AST para literales o valores constantes.
 * Ejemplos: 42, 3.14, "texto", verdadero, falso
 */
public class Literal implements ASTNode {
	private Object valor;

	public Literal(Object valor) {
		this.valor = valor;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		return valor;
	}

	public Object getValor() {
		return valor;
	}
}
