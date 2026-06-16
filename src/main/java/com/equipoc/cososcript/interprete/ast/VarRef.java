package com.equipoc.cososcript.interprete.ast;

import java.util.Map;

/**
 * Nodo AST para referencia a variables.
 * Ejemplo: contador (cuando se usa en una expresión)
 */
public class VarRef implements ASTNode {
	private String nombre;

	public VarRef(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		if (!symbolTable.containsKey(nombre)) {
			throw new RuntimeException("Error semántico: Variable '" + nombre + "' no fue declarada");
		}
		return symbolTable.get(nombre);
	}

	public String getNombre() {
		return nombre;
	}
}
