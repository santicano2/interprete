package com.equipoc.cososcript.interprete;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Object> tabla;

    public SymbolTable() {
        this.tabla = new HashMap<String, Object>();
    }

    public void declarar(String nombre, Object valor) {
        if (tabla.containsKey(nombre)) {
            throw new RuntimeException("Error semántico: Variable '" + nombre + "' ya fue declarada");
        }
        tabla.put(nombre, valor);
    }

    public void asignar(String nombre, Object valor) {
        if (!tabla.containsKey(nombre)) {
            throw new RuntimeException("Error semántico: Variable '" + nombre + "' no fue declarada");
        }
        tabla.put(nombre, valor);
    }

    public Object obtener(String nombre) {
        if (!tabla.containsKey(nombre)) {
            throw new RuntimeException("Error semántico: Variable '" + nombre + "' no fue declarada");
        }
        return tabla.get(nombre);
    }

    public boolean existe(String nombre) {
        return tabla.containsKey(nombre);
    }

    public Map<String, Object> getMap() {
        return tabla;
    }
}
