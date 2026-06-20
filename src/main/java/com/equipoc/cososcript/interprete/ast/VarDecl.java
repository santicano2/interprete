package com.equipoc.cososcript.interprete.ast;

import java.util.Map;

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
        if (symbolTable.containsKey(nombre)) {
            throw new RuntimeException("Error semantico: Variable '" + nombre + "' ya fue declarada");
        }

        Object val;
        if (valor != null) {
            val = valor.execute(symbolTable);
            if (!validarTipo(tipo, val)) {
                throw new RuntimeException("Error semantico: Tipo incompatible para variable '" + nombre + "'");
            }
        } else {
            val = valorDefault(tipo);
        }

        symbolTable.put(nombre, val);
        return null;
    }

    private Object valorDefault(String tipo) {
        switch (tipo) {
        case "entero": return 0;
        case "real": return 0.0;
        case "cadena": return "";
        case "logico": return false;
        default: return null;
        }
    }

    private boolean validarTipo(String tipo, Object valor) {
        switch (tipo) {
        case "entero": return valor instanceof Integer;
        case "real": return valor instanceof Double || valor instanceof Integer;
        case "cadena": return valor instanceof String;
        case "logico": return valor instanceof Boolean;
        default: return false;
        }
    }
}
