package com.equipoc.cososcript.interprete;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    private static final String EXTENSION = "cs";

    public static void main(String[] args) throws IOException {
        String program = args.length > 0 ? args[0] : "test/test." + EXTENSION;

        System.out.println("Interpreting file " + program);

        CosoScriptLexer lexer = new CosoScriptLexer(new ANTLRFileStream(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CosoScriptParser parser = new CosoScriptParser(tokens);

        CosoScriptParser.ProgramaContext tree = parser.programa();

        System.out.println("Interpretation finished");
    }
}
