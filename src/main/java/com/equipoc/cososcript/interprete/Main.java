package com.equipoc.cososcript.interprete;

import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

import com.equipoc.cososcript.interprete.ast.ASTNode;

public class Main {

    private static final String EXTENSION = "cs";

    public static void main(String[] args) throws IOException {
        String program = args.length > 0 ? args[0] : "test/test." + EXTENSION;

        System.out.println("Interpreting file " + program);

        // Lexer + Parser
        CosoScriptLexer lexer = new CosoScriptLexer(new ANTLRFileStream(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CosoScriptParser parser = new CosoScriptParser(tokens);

        CosoScriptParser.ProgramaContext tree = parser.programa();

        // Construir AST Visitor
        CosoScriptCustomVisitor visitor = new CosoScriptCustomVisitor();
        @SuppressWarnings("unchecked")
        List<ASTNode> programa = (List<ASTNode>) visitor.visitPrograma(tree);

        // Analisis semantico previo a la ejecucion
        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        if (!analyzer.analizar(programa)) {
            System.err.println("Interpretacion cancelada por errores semanticos.");
            return;
        }

        // Ejecutar
        SymbolTable symbolTable = new SymbolTable();
        for (ASTNode node : programa) {
            node.execute(symbolTable.getMap());
        }

        System.out.println("Interpretation finished");
    }
}
