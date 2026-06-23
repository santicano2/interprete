package com.equipoc.cososcript.interprete.ast;

import java.util.Map;

/**
 * Nodo AST para operaciones unarias.
 * Ejemplos: !verdadero, -42
 */
public class UnOp implements ASTNode {
	private String operador;
	private ASTNode operando;

	public UnOp(String operador, ASTNode operando) {
		this.operador = operador;
		this.operando = operando;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		Object val = operando.execute(symbolTable);

		switch (operador) {
		case "!":
			if (!(val instanceof Boolean)) {
				throw new RuntimeException("Error semantico: Operador ! requiere un booleano");
			}
			return !((Boolean) val);
		case "-":
			if (val instanceof Integer) {
				return -((Integer) val);
			}
			if (val instanceof Double) {
				return -((Double) val);
			}
			throw new RuntimeException("Error semantico: Operador - requiere un numero");
		default:
			throw new RuntimeException("Operador unario desconocido: " + operador);
		}
	}

	public String getOperador() {
		return operador;
	}

	public ASTNode getOperando() { return operando; }
}
