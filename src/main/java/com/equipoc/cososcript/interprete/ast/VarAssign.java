package com.equipoc.cososcript.interprete.ast;

import java.util.Map;

/**
 * Nodo AST para asignacion de variables.
 * Ejemplo: contador = 0;
 */
public class VarAssign implements ASTNode {
	private String nombre;
	private ASTNode valor;

	public VarAssign(String nombre, ASTNode valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		// Verificar que la variable existe
		if (!symbolTable.containsKey(nombre)) {
			throw new RuntimeException("Error semantico: Variable '" + nombre + "' no fue declarada");
		}

		// Evaluar la expresión
		Object val = valor.execute(symbolTable);

		// Actualizar en la tabla de simbolos
		symbolTable.put(nombre, val);
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public ASTNode getValor() {
		return valor;
	}
}
