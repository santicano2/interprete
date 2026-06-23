package com.equipoc.cososcript.interprete.ast;

import java.util.List;
import java.util.Map;

/**
 * Nodo AST para la instruccion repetir-hasta.
 * Ejemplo:
 *   repetir {
 *       mostrar(contador);
 *       contador = contador + 1;
 *   } hasta (contador == 5);
 */
public class Repeat implements ASTNode {
	private List<ASTNode> cuerpo;
	private ASTNode condicion;

	public Repeat(List<ASTNode> cuerpo, ASTNode condicion) {
		this.cuerpo = cuerpo;
		this.condicion = condicion;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		do {
			for (ASTNode sentencia : cuerpo) {
				sentencia.execute(symbolTable);
			}

			Object valCond = condicion.execute(symbolTable);

			if (!(valCond instanceof Boolean)) {
				throw new RuntimeException("Error semantico: La condición del 'hasta' debe ser booleana");
			}

			if ((Boolean) valCond) {
				break;
			}
		} while (true);

		return null;
	}

	public List<ASTNode> getCuerpo() { return cuerpo; }
	public ASTNode getCondicion() { return condicion; }
}
