package com.equipoc.cososcript.interprete.ast;

import java.util.List;
import java.util.Map;

/**
 * Nodo AST para la instruccion si-sino.
 * Ejemplo:
 *   si (contador > 3) {
 *       mostrar("copado");
 *   } sino {
 *       mostrar("dale de nuevo");
 *   }
 */
public class If implements ASTNode {
	private ASTNode condicion;
	private List<ASTNode> cuerpoThen;
	private List<ASTNode> cuerpoElse;

	public If(ASTNode condicion, List<ASTNode> cuerpoThen, List<ASTNode> cuerpoElse) {
		this.condicion = condicion;
		this.cuerpoThen = cuerpoThen;
		this.cuerpoElse = cuerpoElse;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		Object valCond = condicion.execute(symbolTable);

		if (!(valCond instanceof Boolean)) {
			throw new RuntimeException("Error semantico: La condición del 'si' debe ser booleana");
		}

		if ((Boolean) valCond) {
			for (ASTNode sentencia : cuerpoThen) {
				sentencia.execute(symbolTable);
			}
		} else {
			for (ASTNode sentencia : cuerpoElse) {
				sentencia.execute(symbolTable);
			}
		}
		return null;
	}

	public ASTNode getCondicion() { return condicion; }
	public List<ASTNode> getCuerpoThen() { return cuerpoThen; }
	public List<ASTNode> getCuerpoElse() { return cuerpoElse; }
}
