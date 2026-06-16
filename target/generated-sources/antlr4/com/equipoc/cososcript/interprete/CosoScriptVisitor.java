// Generated from com\equipoc\cososcript\interprete\CosoScript.g4 by ANTLR 4.5.1
package com.equipoc.cososcript.interprete;

	import java.util.Map;
	import java.util.HashMap;
	import java.util.List;
	import java.util.ArrayList;
	import com.equipoc.cososcript.interprete.ast.*;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CosoScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CosoScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(CosoScriptParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(CosoScriptParser.SContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracion(CosoScriptParser.DeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#asignacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignacion(CosoScriptParser.AsignacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#mostrar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMostrar(CosoScriptParser.MostrarContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#condicional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondicional(CosoScriptParser.CondicionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#repetir}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRepetir(CosoScriptParser.RepetirContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpresion(CosoScriptParser.ExpresionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#logica_o}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogica_o(CosoScriptParser.Logica_oContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#logica_y}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogica_y(CosoScriptParser.Logica_yContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#igualdad}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgualdad(CosoScriptParser.IgualdadContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#comparacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparacion(CosoScriptParser.ComparacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#aditiva}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAditiva(CosoScriptParser.AditivaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#multiplicativa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativa(CosoScriptParser.MultiplicativaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#unaria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaria(CosoScriptParser.UnariaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#postfija}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfija(CosoScriptParser.PostfijaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#primaria}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaria(CosoScriptParser.PrimariaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#numero}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumero(CosoScriptParser.NumeroContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#cadena}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCadena(CosoScriptParser.CadenaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#booleano}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleano(CosoScriptParser.BooleanoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CosoScriptParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(CosoScriptParser.TipoContext ctx);
}