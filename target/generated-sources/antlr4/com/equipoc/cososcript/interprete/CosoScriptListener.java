// Generated from CosoScript.g4 by ANTLR 4.4
package com.equipoc.cososcript.interprete;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CosoScriptParser}.
 */
public interface CosoScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#unaria}.
	 * @param ctx the parse tree
	 */
	void enterUnaria(@NotNull CosoScriptParser.UnariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#unaria}.
	 * @param ctx the parse tree
	 */
	void exitUnaria(@NotNull CosoScriptParser.UnariaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(@NotNull CosoScriptParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(@NotNull CosoScriptParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(@NotNull CosoScriptParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(@NotNull CosoScriptParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(@NotNull CosoScriptParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(@NotNull CosoScriptParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#numero}.
	 * @param ctx the parse tree
	 */
	void enterNumero(@NotNull CosoScriptParser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#numero}.
	 * @param ctx the parse tree
	 */
	void exitNumero(@NotNull CosoScriptParser.NumeroContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#cadena}.
	 * @param ctx the parse tree
	 */
	void enterCadena(@NotNull CosoScriptParser.CadenaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#cadena}.
	 * @param ctx the parse tree
	 */
	void exitCadena(@NotNull CosoScriptParser.CadenaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#igualdad}.
	 * @param ctx the parse tree
	 */
	void enterIgualdad(@NotNull CosoScriptParser.IgualdadContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#igualdad}.
	 * @param ctx the parse tree
	 */
	void exitIgualdad(@NotNull CosoScriptParser.IgualdadContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(@NotNull CosoScriptParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(@NotNull CosoScriptParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#primaria}.
	 * @param ctx the parse tree
	 */
	void enterPrimaria(@NotNull CosoScriptParser.PrimariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#primaria}.
	 * @param ctx the parse tree
	 */
	void exitPrimaria(@NotNull CosoScriptParser.PrimariaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(@NotNull CosoScriptParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(@NotNull CosoScriptParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#repetir}.
	 * @param ctx the parse tree
	 */
	void enterRepetir(@NotNull CosoScriptParser.RepetirContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#repetir}.
	 * @param ctx the parse tree
	 */
	void exitRepetir(@NotNull CosoScriptParser.RepetirContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#multiplicativa}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativa(@NotNull CosoScriptParser.MultiplicativaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#multiplicativa}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativa(@NotNull CosoScriptParser.MultiplicativaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(@NotNull CosoScriptParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(@NotNull CosoScriptParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#booleano}.
	 * @param ctx the parse tree
	 */
	void enterBooleano(@NotNull CosoScriptParser.BooleanoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#booleano}.
	 * @param ctx the parse tree
	 */
	void exitBooleano(@NotNull CosoScriptParser.BooleanoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#logica_y}.
	 * @param ctx the parse tree
	 */
	void enterLogica_y(@NotNull CosoScriptParser.Logica_yContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#logica_y}.
	 * @param ctx the parse tree
	 */
	void exitLogica_y(@NotNull CosoScriptParser.Logica_yContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#condicional}.
	 * @param ctx the parse tree
	 */
	void enterCondicional(@NotNull CosoScriptParser.CondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#condicional}.
	 * @param ctx the parse tree
	 */
	void exitCondicional(@NotNull CosoScriptParser.CondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#logica_o}.
	 * @param ctx the parse tree
	 */
	void enterLogica_o(@NotNull CosoScriptParser.Logica_oContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#logica_o}.
	 * @param ctx the parse tree
	 */
	void exitLogica_o(@NotNull CosoScriptParser.Logica_oContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#aditiva}.
	 * @param ctx the parse tree
	 */
	void enterAditiva(@NotNull CosoScriptParser.AditivaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#aditiva}.
	 * @param ctx the parse tree
	 */
	void exitAditiva(@NotNull CosoScriptParser.AditivaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#mostrar}.
	 * @param ctx the parse tree
	 */
	void enterMostrar(@NotNull CosoScriptParser.MostrarContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#mostrar}.
	 * @param ctx the parse tree
	 */
	void exitMostrar(@NotNull CosoScriptParser.MostrarContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#comparacion}.
	 * @param ctx the parse tree
	 */
	void enterComparacion(@NotNull CosoScriptParser.ComparacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#comparacion}.
	 * @param ctx the parse tree
	 */
	void exitComparacion(@NotNull CosoScriptParser.ComparacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#postfija}.
	 * @param ctx the parse tree
	 */
	void enterPostfija(@NotNull CosoScriptParser.PostfijaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#postfija}.
	 * @param ctx the parse tree
	 */
	void exitPostfija(@NotNull CosoScriptParser.PostfijaContext ctx);
}