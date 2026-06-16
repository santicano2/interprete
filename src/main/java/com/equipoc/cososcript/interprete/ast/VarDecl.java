package com.equipoc.cososcript.interprete.ast;

import java.util.Map;

/**
 * Nodo AST para declaración de variables.
 * Ejemplo: coso contador : entero = 0;
 */
public class VarDecl implements ASTNode {
	private String nombre;
	private String tipo;
	private ASTNode valor;

	public VarDecl(String nombre, String tipo, ASTNode valor) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.valor = valor;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		// Verificar si la variable ya existe
		if (symbolTable.containsKey(nombre)) {
			throw new RuntimeException("Error semántico: Variable '" + nombre + "' ya fue declarada");
		}

		// Evaluar la expresión inicial
		Object val = valor.execute(symbolTable);

		// Validar que el tipo coincida (validación semántica básica)
		if (!validarTipo(tipo, val)) {
			throw new RuntimeException("Error semántico: Incompatibilidad de tipos para variable '" + nombre + "'");
		}

		// Guardar en la tabla de símbolos
		symbolTable.put(nombre, val);
		return null;
	}

	/**
	 * Valida que el valor sea compatible con el tipo declarado.
	 */
	private boolean validarTipo(String tipo, Object valor) {
		switch (tipo) {
		case "entero":
			return valor instanceof Integer;
		case "real":
			return valor instanceof Double || valor instanceof Integer;
		case "cadena":
			return valor instanceof String;
		case "logico":
			return valor instanceof Boolean;
		default:
			return false;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}
}
