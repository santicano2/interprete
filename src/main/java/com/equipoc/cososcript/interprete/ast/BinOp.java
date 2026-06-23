package com.equipoc.cososcript.interprete.ast;

import java.util.Map;

/**
 * Nodo AST para operaciones binarias.
 * Ejemplos: a + b, x * y, a == b, x > y, a && b
 */
public class BinOp implements ASTNode {
	private ASTNode izquierda;
	private String operador;
	private ASTNode derecha;

	public BinOp(ASTNode izquierda, String operador, ASTNode derecha) {
		this.izquierda = izquierda;
		this.operador = operador;
		this.derecha = derecha;
	}

	@Override
	public Object execute(Map<String, Object> symbolTable) {
		Object valIzq = izquierda.execute(symbolTable);
		Object valDer = derecha.execute(symbolTable);

		switch (operador) {
		// Operadores aritmeticos
		case "+":
			return sumar(valIzq, valDer);
		case "-":
			return restar(valIzq, valDer);
		case "*":
			return multiplicar(valIzq, valDer);
		case "/":
			return dividir(valIzq, valDer);

		// Operadores relacionales
		case "==":
			return valIzq.equals(valDer);
		case "!=":
			return !valIzq.equals(valDer);
		case "<":
			return compararMenor(valIzq, valDer);
		case "<=":
			return compararMenorIgual(valIzq, valDer);
		case ">":
			return compararMayor(valIzq, valDer);
		case ">=":
			return compararMayorIgual(valIzq, valDer);

		// Operadores logicos
		case "&&":
			return ((Boolean) valIzq) && ((Boolean) valDer);
		case "||":
			return ((Boolean) valIzq) || ((Boolean) valDer);

		default:
			throw new RuntimeException("Operador desconocido: " + operador);
		}
	}

	private Object sumar(Object izq, Object der) {
		if (izq instanceof Integer && der instanceof Integer) {
			return (Integer) izq + (Integer) der;
		}
		if (izq instanceof Double || der instanceof Double) {
			double d1 = izq instanceof Double ? (Double) izq : ((Integer) izq).doubleValue();
			double d2 = der instanceof Double ? (Double) der : ((Integer) der).doubleValue();
			return d1 + d2;
		}
		if (izq instanceof String || der instanceof String) {
			return izq.toString() + der.toString();
		}
		throw new RuntimeException("Error semantico: No se puede sumar " + izq.getClass().getSimpleName() + " y "
				+ der.getClass().getSimpleName());
	}

	private Object restar(Object izq, Object der) {
		if (izq instanceof Integer && der instanceof Integer) {
			return (Integer) izq - (Integer) der;
		}
		if (izq instanceof Double || der instanceof Double) {
			double d1 = izq instanceof Double ? (Double) izq : ((Integer) izq).doubleValue();
			double d2 = der instanceof Double ? (Double) der : ((Integer) der).doubleValue();
			return d1 - d2;
		}
		throw new RuntimeException("Error semantico: No se puede restar " + izq.getClass().getSimpleName() + " y "
				+ der.getClass().getSimpleName());
	}

	private Object multiplicar(Object izq, Object der) {
		if (izq instanceof Integer && der instanceof Integer) {
			return (Integer) izq * (Integer) der;
		}
		if (izq instanceof Double || der instanceof Double) {
			double d1 = izq instanceof Double ? (Double) izq : ((Integer) izq).doubleValue();
			double d2 = der instanceof Double ? (Double) der : ((Integer) der).doubleValue();
			return d1 * d2;
		}
		throw new RuntimeException("Error semantico: No se puede multiplicar " + izq.getClass().getSimpleName() + " y "
				+ der.getClass().getSimpleName());
	}

	private Object dividir(Object izq, Object der) {
		// Validar division por cero
		if ((der instanceof Integer && (Integer) der == 0) || (der instanceof Double && (Double) der == 0.0)) {
			throw new RuntimeException("Error semantico: División por cero");
		}

		if (izq instanceof Integer && der instanceof Integer) {
			return (Integer) izq / (Integer) der;
		}
		if (izq instanceof Double || der instanceof Double) {
			double d1 = izq instanceof Double ? (Double) izq : ((Integer) izq).doubleValue();
			double d2 = der instanceof Double ? (Double) der : ((Integer) der).doubleValue();
			return d1 / d2;
		}
		throw new RuntimeException("Error semantico: No se puede dividir " + izq.getClass().getSimpleName() + " y "
				+ der.getClass().getSimpleName());
	}

	private boolean compararMenor(Object izq, Object der) {
		if (izq instanceof Integer && der instanceof Integer) {
			return (Integer) izq < (Integer) der;
		}
		if (izq instanceof Double || der instanceof Double) {
			double d1 = izq instanceof Double ? (Double) izq : ((Integer) izq).doubleValue();
			double d2 = der instanceof Double ? (Double) der : ((Integer) der).doubleValue();
			return d1 < d2;
		}
		throw new RuntimeException("Error semantico: No se puede comparar");
	}

	private boolean compararMenorIgual(Object izq, Object der) {
		if (izq instanceof Integer && der instanceof Integer) {
			return (Integer) izq <= (Integer) der;
		}
		if (izq instanceof Double || der instanceof Double) {
			double d1 = izq instanceof Double ? (Double) izq : ((Integer) izq).doubleValue();
			double d2 = der instanceof Double ? (Double) der : ((Integer) der).doubleValue();
			return d1 <= d2;
		}
		throw new RuntimeException("Error semantico: No se puede comparar");
	}

	private boolean compararMayor(Object izq, Object der) {
		if (izq instanceof Integer && der instanceof Integer) {
			return (Integer) izq > (Integer) der;
		}
		if (izq instanceof Double || der instanceof Double) {
			double d1 = izq instanceof Double ? (Double) izq : ((Integer) izq).doubleValue();
			double d2 = der instanceof Double ? (Double) der : ((Integer) der).doubleValue();
			return d1 > d2;
		}
		throw new RuntimeException("Error semantico: No se puede comparar");
	}

	private boolean compararMayorIgual(Object izq, Object der) {
		if (izq instanceof Integer && der instanceof Integer) {
			return (Integer) izq >= (Integer) der;
		}
		if (izq instanceof Double || der instanceof Double) {
			double d1 = izq instanceof Double ? (Double) izq : ((Integer) izq).doubleValue();
			double d2 = der instanceof Double ? (Double) der : ((Integer) der).doubleValue();
			return d1 >= d2;
		}
		throw new RuntimeException("Error semantico: No se puede comparar");
	}

	public String getOperador() {
		return operador;
	}

	public ASTNode getIzquierda() { return izquierda; }
	public ASTNode getDerecha() { return derecha; }
}
