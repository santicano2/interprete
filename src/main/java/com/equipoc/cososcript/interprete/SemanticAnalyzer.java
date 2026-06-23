package com.equipoc.cososcript.interprete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.equipoc.cososcript.interprete.ast.*;

public class SemanticAnalyzer {

    private Map<String, String> tipos;
    private List<String> errores;

    public SemanticAnalyzer() {
        this.tipos = new HashMap<String, String>();
        this.errores = new ArrayList<String>();
    }

    public boolean analizar(List<ASTNode> programa) {
        errores.clear();
        tipos.clear();
        for (ASTNode node : programa) {
            analizarNodo(node);
        }
        if (!errores.isEmpty()) {
            System.err.println("Errores semanticos encontrados:");
            for (String err : errores) {
                System.err.println("  " + err);
            }
        }
        return errores.isEmpty();
    }

    private void analizarNodo(ASTNode node) {
        if (node instanceof VarDecl) {
            analizarVarDecl((VarDecl) node);
        } else if (node instanceof VarAssign) {
            analizarVarAssign((VarAssign) node);
        } else if (node instanceof Println) {
            analizarExpresion(((Println) node).getExpresion());
        } else if (node instanceof If) {
            analizarIf((If) node);
        } else if (node instanceof Repeat) {
            analizarRepeat((Repeat) node);
        }
    }

    private void analizarVarDecl(VarDecl node) {
        String nombre = node.getNombre();
        if (tipos.containsKey(nombre)) {
            errores.add("Error semántico: Variable '" + nombre + "' ya fue declarada");
            return;
        }
        String tipoDecl = node.getTipo();
        if (node.getValor() != null) {
            analizarExpresion(node.getValor());
            String tipoValor = inferirTipo(node.getValor());
            if (tipoValor != null && !sonCompatibles(tipoDecl, tipoValor)) {
                errores.add("Error semántico: Tipo incompatible para variable '" + nombre + "': se esperaba " + tipoDecl + " pero el valor es " + tipoValor);
            }
        }
        tipos.put(nombre, tipoDecl);
    }

    private void analizarVarAssign(VarAssign node) {
        String nombre = node.getNombre();
        if (!tipos.containsKey(nombre)) {
            errores.add("Error semántico: Variable '" + nombre + "' no fue declarada");
        }
        analizarExpresion(node.getValor());
    }

    private void analizarIf(If node) {
        analizarExpresion(node.getCondicion());
        for (ASTNode s : node.getCuerpoThen()) {
            analizarNodo(s);
        }
        for (ASTNode s : node.getCuerpoElse()) {
            analizarNodo(s);
        }
    }

    private void analizarRepeat(Repeat node) {
        for (ASTNode s : node.getCuerpo()) {
            analizarNodo(s);
        }
        analizarExpresion(node.getCondicion());
    }

    private void analizarExpresion(ASTNode node) {
        if (node instanceof VarRef) {
            String nombre = ((VarRef) node).getNombre();
            if (!tipos.containsKey(nombre)) {
                errores.add("Error semántico: Variable '" + nombre + "' no fue declarada");
            }
        } else if (node instanceof BinOp) {
            BinOp bin = (BinOp) node;
            analizarExpresion(bin.getIzquierda());
            analizarExpresion(bin.getDerecha());
            if (bin.getOperador().equals("/") && esCeroLiteral(bin.getDerecha())) {
                errores.add("Error semántico: División por cero");
            }
        } else if (node instanceof UnOp) {
            analizarExpresion(((UnOp) node).getOperando());
        } else if (node instanceof Println) {
            analizarExpresion(((Println) node).getExpresion());
        }
    }

    private boolean esCeroLiteral(ASTNode node) {
        if (node instanceof Literal) {
            Object val = ((Literal) node).getValor();
            return (val instanceof Integer && (Integer) val == 0)
                || (val instanceof Double && (Double) val == 0.0);
        }
        return false;
    }

    private String inferirTipo(ASTNode node) {
        if (node instanceof Literal) {
            Object val = ((Literal) node).getValor();
            if (val instanceof Integer) return "entero";
            if (val instanceof Double) return "real";
            if (val instanceof String) return "cadena";
            if (val instanceof Boolean) return "logico";
        }
        if (node instanceof VarRef) {
            String nombre = ((VarRef) node).getNombre();
            return tipos.get(nombre);
        }
        if (node instanceof BinOp) {
            BinOp bin = (BinOp) node;
            String op = bin.getOperador();
            if (op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/")) {
                String t1 = inferirTipo(bin.getIzquierda());
                String t2 = inferirTipo(bin.getDerecha());
                if (t1 == null || t2 == null) return null;
                if (t1.equals("real") || t2.equals("real")) return "real";
                if (t1.equals("entero") && t2.equals("entero")) return "entero";
                return null;
            }
            if (op.equals("==") || op.equals("!=") || op.equals("<") || op.equals(">")
                || op.equals("<=") || op.equals(">=") || op.equals("&&") || op.equals("||")) {
                return "logico";
            }
        }
        if (node instanceof UnOp) {
            UnOp un = (UnOp) node;
            if (un.getOperador().equals("!")) return "logico";
            if (un.getOperador().equals("-")) return inferirTipo(un.getOperando());
        }
        return null;
    }

    private boolean sonCompatibles(String declarado, String valor) {
        if (declarado.equals(valor)) return true;
        if (declarado.equals("real") && valor.equals("entero")) return true;
        return false;
    }
}
