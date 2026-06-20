package com.equipoc.cososcript.interprete;

import com.equipoc.cososcript.interprete.ast.*;
import com.equipoc.cososcript.interprete.CosoScriptParser.*;

public class CosoScriptCustomVisitor extends CosoScriptBaseVisitor<Object> {

    private SymbolTable symbolTable;

    public CosoScriptCustomVisitor() {
        this.symbolTable = new SymbolTable();
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    @Override
    public Object visitPrograma(ProgramaContext ctx) {
        for (SentenciaContext s : ctx.sentencia()) {
            ASTNode node = (ASTNode) visit(s);
            if (node != null) {
                node.execute(symbolTable.getMap());
            }
        }
        return null;
    }

    @Override
    public Object visitDeclaracion(DeclaracionContext ctx) {
        String nombre = ctx.ID().getText();
        String tipo = ctx.tipo().getText();

        ASTNode valor = null;
        if (ctx.expresion() != null) {
            valor = (ASTNode) visit(ctx.expresion());
        }

        return new VarDecl(nombre, tipo, valor);
    }

    @Override
    public Object visitAsignacion(AsignacionContext ctx) {
        String nombre = ctx.ID().getText();
        ASTNode valor = (ASTNode) visit(ctx.expresion());
        return new VarAssign(nombre, valor);
    }

    @Override
    public Object visitMostrar(MostrarContext ctx) {
        ASTNode expr = (ASTNode) visit(ctx.expresion());
        return new Println(expr);
    }

    @Override
    public Object visitCondicional(CondicionalContext ctx) {
        ASTNode condicion = (ASTNode) visit(ctx.expresion());

        java.util.List<ASTNode> thenBody = new java.util.ArrayList<>();
        for (SentenciaContext s : ctx.entonces) {
            thenBody.add((ASTNode) visit(s));
        }

        java.util.List<ASTNode> elseBody = new java.util.ArrayList<>();
        if (ctx.sino != null) {
            for (SentenciaContext s : ctx.sino) {
                elseBody.add((ASTNode) visit(s));
            }
        }

        return new If(condicion, thenBody, elseBody);
    }

    @Override
    public Object visitRepetir(RepetirContext ctx) {
        java.util.List<ASTNode> body = new java.util.ArrayList<>();
        for (SentenciaContext s : ctx.sentencia()) {
            body.add((ASTNode) visit(s));
        }
        ASTNode condicion = (ASTNode) visit(ctx.expresion());
        return new Repeat(body, condicion);
    }

    @Override
    public Object visitLogica_o(Logica_oContext ctx) {
        ASTNode node = (ASTNode) visit(ctx.logica_y(0));
        for (int i = 1; i < ctx.logica_y().size(); i++) {
            ASTNode right = (ASTNode) visit(ctx.logica_y(i));
            node = new BinOp(node, "||", right);
        }
        return node;
    }

    @Override
    public Object visitLogica_y(Logica_yContext ctx) {
        ASTNode node = (ASTNode) visit(ctx.igualdad(0));
        for (int i = 1; i < ctx.igualdad().size(); i++) {
            ASTNode right = (ASTNode) visit(ctx.igualdad(i));
            node = new BinOp(node, "&&", right);
        }
        return node;
    }

    @Override
    public Object visitIgualdad(IgualdadContext ctx) {
        ASTNode node = (ASTNode) visit(ctx.comparacion(0));
        for (int i = 1; i < ctx.comparacion().size(); i++) {
            String op = ctx.getChild(i * 2 - 1).getText();
            ASTNode right = (ASTNode) visit(ctx.comparacion(i));
            node = new BinOp(node, op, right);
        }
        return node;
    }

    @Override
    public Object visitComparacion(ComparacionContext ctx) {
        ASTNode node = (ASTNode) visit(ctx.aditiva(0));
        for (int i = 1; i < ctx.aditiva().size(); i++) {
            String op = ctx.getChild(i * 2 - 1).getText();
            ASTNode right = (ASTNode) visit(ctx.aditiva(i));
            node = new BinOp(node, op, right);
        }
        return node;
    }

    @Override
    public Object visitAditiva(AditivaContext ctx) {
        ASTNode node = (ASTNode) visit(ctx.multiplicativa(0));
        for (int i = 1; i < ctx.multiplicativa().size(); i++) {
            String op = ctx.getChild(i * 2 - 1).getText();
            ASTNode right = (ASTNode) visit(ctx.multiplicativa(i));
            node = new BinOp(node, op, right);
        }
        return node;
    }

    @Override
    public Object visitMultiplicativa(MultiplicativaContext ctx) {
        ASTNode node = (ASTNode) visit(ctx.unaria(0));
        for (int i = 1; i < ctx.unaria().size(); i++) {
            String op = ctx.getChild(i * 2 - 1).getText();
            ASTNode right = (ASTNode) visit(ctx.unaria(i));
            node = new BinOp(node, op, right);
        }
        return node;
    }

    @Override
    public Object visitUnaria(UnariaContext ctx) {
        ASTNode node = (ASTNode) visit(ctx.postfija());
        if (ctx.NO() != null) {
            node = new UnOp("!", node);
        } else if (ctx.MENOS() != null) {
            node = new UnOp("-", node);
        }
        return node;
    }

    @Override
    public Object visitPrimaria(PrimariaContext ctx) {
        if (ctx.numero() != null) {
            return visit(ctx.numero());
        }
        if (ctx.cadena() != null) {
            return visit(ctx.cadena());
        }
        if (ctx.ID() != null) {
            return new VarRef(ctx.ID().getText());
        }
        if (ctx.booleano() != null) {
            return visit(ctx.booleano());
        }
        return visit(ctx.expresion());
    }

    @Override
    public Object visitNumero(NumeroContext ctx) {
        String texto = ctx.NUMERO().getText();
        if (texto.contains(".")) {
            return new Literal(Double.parseDouble(texto));
        } else {
            return new Literal(Integer.parseInt(texto));
        }
    }

    @Override
    public Object visitCadena(CadenaContext ctx) {
        String texto = ctx.CADENA().getText();
        return new Literal(texto.substring(1, texto.length() - 1));
    }

    @Override
    public Object visitBooleano(BooleanoContext ctx) {
        if (ctx.VERDADERO() != null) {
            return new Literal(Boolean.TRUE);
        } else {
            return new Literal(Boolean.FALSE);
        }
    }
}
