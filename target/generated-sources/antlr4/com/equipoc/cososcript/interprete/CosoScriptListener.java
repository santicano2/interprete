// Generated from com\equipoc\cososcript\interprete\CosoScript.g4 by ANTLR 4.5.1
package com.equipoc.cososcript.interprete;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CosoScriptParser}.
 */
public interface CosoScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(CosoScriptParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(CosoScriptParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(CosoScriptParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(CosoScriptParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracion(CosoScriptParser.DeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracion(CosoScriptParser.DeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(CosoScriptParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(CosoScriptParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#mostrar}.
	 * @param ctx the parse tree
	 */
	void enterMostrar(CosoScriptParser.MostrarContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#mostrar}.
	 * @param ctx the parse tree
	 */
	void exitMostrar(CosoScriptParser.MostrarContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#condicional}.
	 * @param ctx the parse tree
	 */
	void enterCondicional(CosoScriptParser.CondicionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#condicional}.
	 * @param ctx the parse tree
	 */
	void exitCondicional(CosoScriptParser.CondicionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#repetir}.
	 * @param ctx the parse tree
	 */
	void enterRepetir(CosoScriptParser.RepetirContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#repetir}.
	 * @param ctx the parse tree
	 */
	void exitRepetir(CosoScriptParser.RepetirContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpresion(CosoScriptParser.ExpresionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpresion(CosoScriptParser.ExpresionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#logica_o}.
	 * @param ctx the parse tree
	 */
	void enterLogica_o(CosoScriptParser.Logica_oContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#logica_o}.
	 * @param ctx the parse tree
	 */
	void exitLogica_o(CosoScriptParser.Logica_oContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#logica_y}.
	 * @param ctx the parse tree
	 */
	void enterLogica_y(CosoScriptParser.Logica_yContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#logica_y}.
	 * @param ctx the parse tree
	 */
	void exitLogica_y(CosoScriptParser.Logica_yContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#igualdad}.
	 * @param ctx the parse tree
	 */
	void enterIgualdad(CosoScriptParser.IgualdadContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#igualdad}.
	 * @param ctx the parse tree
	 */
	void exitIgualdad(CosoScriptParser.IgualdadContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#comparacion}.
	 * @param ctx the parse tree
	 */
	void enterComparacion(CosoScriptParser.ComparacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#comparacion}.
	 * @param ctx the parse tree
	 */
	void exitComparacion(CosoScriptParser.ComparacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#aditiva}.
	 * @param ctx the parse tree
	 */
	void enterAditiva(CosoScriptParser.AditivaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#aditiva}.
	 * @param ctx the parse tree
	 */
	void exitAditiva(CosoScriptParser.AditivaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#multiplicativa}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativa(CosoScriptParser.MultiplicativaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#multiplicativa}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativa(CosoScriptParser.MultiplicativaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#unaria}.
	 * @param ctx the parse tree
	 */
	void enterUnaria(CosoScriptParser.UnariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#unaria}.
	 * @param ctx the parse tree
	 */
	void exitUnaria(CosoScriptParser.UnariaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#postfija}.
	 * @param ctx the parse tree
	 */
	void enterPostfija(CosoScriptParser.PostfijaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#postfija}.
	 * @param ctx the parse tree
	 */
	void exitPostfija(CosoScriptParser.PostfijaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#primaria}.
	 * @param ctx the parse tree
	 */
	void enterPrimaria(CosoScriptParser.PrimariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#primaria}.
	 * @param ctx the parse tree
	 */
	void exitPrimaria(CosoScriptParser.PrimariaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#numero}.
	 * @param ctx the parse tree
	 */
	void enterNumero(CosoScriptParser.NumeroContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#numero}.
	 * @param ctx the parse tree
	 */
	void exitNumero(CosoScriptParser.NumeroContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#cadena}.
	 * @param ctx the parse tree
	 */
	void enterCadena(CosoScriptParser.CadenaContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#cadena}.
	 * @param ctx the parse tree
	 */
	void exitCadena(CosoScriptParser.CadenaContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#booleano}.
	 * @param ctx the parse tree
	 */
	void enterBooleano(CosoScriptParser.BooleanoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#booleano}.
	 * @param ctx the parse tree
	 */
	void exitBooleano(CosoScriptParser.BooleanoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CosoScriptParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(CosoScriptParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CosoScriptParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(CosoScriptParser.TipoContext ctx);
}