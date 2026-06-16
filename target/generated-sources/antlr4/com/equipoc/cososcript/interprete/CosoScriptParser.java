// Generated from CosoScript.g4 by ANTLR 4.4
package com.equipoc.cososcript.interprete;

	import java.util.Map;
	import java.util.HashMap;
	import java.util.List;
	import java.util.ArrayList;
	import com.equipoc.cososcript.interprete.ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CosoScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COSO=1, MOSTRAR=2, SI=3, SINO=4, REPETIR=5, HASTA=6, ENTERO=7, REAL=8, 
		CADENA_TIPO=9, LOGICO_TIPO=10, VERDADERO=11, FALSO=12, MAS=13, MENOS=14, 
		MULT=15, DIV=16, IGUAL=17, NO_IGUAL=18, MENOR=19, MENOR_IGUAL=20, MAYOR=21, 
		MAYOR_IGUAL=22, Y=23, O=24, NO=25, ASIGN=26, PUNTO_COMA=27, COLON=28, 
		PAREN_IZQD=29, PAREN_DER=30, LLAVE_IZQD=31, LLAVE_DER=32, NUMERO=33, CADENA=34, 
		ID=35, WS=36, COMENTARIO=37;
	public static final String[] tokenNames = {
		"<INVALID>", "'coso'", "'mostrar'", "'si'", "'sino'", "'repetir'", "'hasta'", 
		"'entero'", "'real'", "'cadena'", "'logico'", "'verdadero'", "'falso'", 
		"'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", 
		"'&&'", "'||'", "'!'", "'='", "';'", "':'", "'('", "')'", "'{'", "'}'", 
		"NUMERO", "CADENA", "ID", "WS", "COMENTARIO"
	};
	public static final int
		RULE_programa = 0, RULE_s = 1, RULE_declaracion = 2, RULE_asignacion = 3, 
		RULE_mostrar = 4, RULE_condicional = 5, RULE_repetir = 6, RULE_expresion = 7, 
		RULE_logica_o = 8, RULE_logica_y = 9, RULE_igualdad = 10, RULE_comparacion = 11, 
		RULE_aditiva = 12, RULE_multiplicativa = 13, RULE_unaria = 14, RULE_postfija = 15, 
		RULE_primaria = 16, RULE_numero = 17, RULE_cadena = 18, RULE_booleano = 19, 
		RULE_tipo = 20;
	public static final String[] ruleNames = {
		"programa", "s", "declaracion", "asignacion", "mostrar", "condicional", 
		"repetir", "expresion", "logica_o", "logica_y", "igualdad", "comparacion", 
		"aditiva", "multiplicativa", "unaria", "postfija", "primaria", "numero", 
		"cadena", "booleano", "tipo"
	};

	@Override
	public String getGrammarFileName() { return "CosoScript.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		Map<String, Object> symbolTable = new HashMap<String, Object>();

	public CosoScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public SContext s;
		public TerminalNode EOF() { return getToken(CosoScriptParser.EOF, 0); }
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

					List<ASTNode> body = new ArrayList<ASTNode>();
				
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COSO) | (1L << MOSTRAR) | (1L << SI) | (1L << REPETIR) | (1L << ID))) != 0)) {
				{
				{
				setState(43); ((ProgramaContext)_localctx).s = s();
				body.add(((ProgramaContext)_localctx).s.node);
				}
				}
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(51); match(EOF);

					for (ASTNode n : body) {
						n.execute(symbolTable);
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SContext extends ParserRuleContext {
		public ASTNode node;
		public DeclaracionContext declaracion;
		public AsignacionContext asignacion;
		public MostrarContext mostrar;
		public CondicionalContext condicional;
		public RepetirContext repetir;
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public RepetirContext repetir() {
			return getRuleContext(RepetirContext.class,0);
		}
		public CondicionalContext condicional() {
			return getRuleContext(CondicionalContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public MostrarContext mostrar() {
			return getRuleContext(MostrarContext.class,0);
		}
		public SContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitS(this);
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_s);
		try {
			setState(69);
			switch (_input.LA(1)) {
			case COSO:
				enterOuterAlt(_localctx, 1);
				{
				setState(54); ((SContext)_localctx).declaracion = declaracion();
				((SContext)_localctx).node =  ((SContext)_localctx).declaracion.node;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(57); ((SContext)_localctx).asignacion = asignacion();
				((SContext)_localctx).node =  ((SContext)_localctx).asignacion.node;
				}
				break;
			case MOSTRAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(60); ((SContext)_localctx).mostrar = mostrar();
				((SContext)_localctx).node =  ((SContext)_localctx).mostrar.node;
				}
				break;
			case SI:
				enterOuterAlt(_localctx, 4);
				{
				setState(63); ((SContext)_localctx).condicional = condicional();
				((SContext)_localctx).node =  ((SContext)_localctx).condicional.node;
				}
				break;
			case REPETIR:
				enterOuterAlt(_localctx, 5);
				{
				setState(66); ((SContext)_localctx).repetir = repetir();
				((SContext)_localctx).node =  ((SContext)_localctx).repetir.node;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaracionContext extends ParserRuleContext {
		public ASTNode node;
		public Token ID;
		public TipoContext t;
		public ExpresionContext exp;
		public TerminalNode ID() { return getToken(CosoScriptParser.ID, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode COLON() { return getToken(CosoScriptParser.COLON, 0); }
		public TerminalNode ASIGN() { return getToken(CosoScriptParser.ASIGN, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(CosoScriptParser.PUNTO_COMA, 0); }
		public TerminalNode COSO() { return getToken(CosoScriptParser.COSO, 0); }
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterDeclaracion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitDeclaracion(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaracion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71); match(COSO);
			setState(72); ((DeclaracionContext)_localctx).ID = match(ID);
			setState(73); match(COLON);
			setState(74); ((DeclaracionContext)_localctx).t = tipo();
			setState(75); match(ASIGN);
			setState(76); ((DeclaracionContext)_localctx).exp = expresion();
			setState(77); match(PUNTO_COMA);
			((DeclaracionContext)_localctx).node =  new VarDecl((((DeclaracionContext)_localctx).ID!=null?((DeclaracionContext)_localctx).ID.getText():null), ((DeclaracionContext)_localctx).t.tipoVar, ((DeclaracionContext)_localctx).exp.node);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsignacionContext extends ParserRuleContext {
		public ASTNode node;
		public Token ID;
		public ExpresionContext exp;
		public TerminalNode ID() { return getToken(CosoScriptParser.ID, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode ASIGN() { return getToken(CosoScriptParser.ASIGN, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(CosoScriptParser.PUNTO_COMA, 0); }
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitAsignacion(this);
		}
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_asignacion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); ((AsignacionContext)_localctx).ID = match(ID);
			setState(81); match(ASIGN);
			setState(82); ((AsignacionContext)_localctx).exp = expresion();
			setState(83); match(PUNTO_COMA);
			((AsignacionContext)_localctx).node =  new VarAssign((((AsignacionContext)_localctx).ID!=null?((AsignacionContext)_localctx).ID.getText():null), ((AsignacionContext)_localctx).exp.node);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MostrarContext extends ParserRuleContext {
		public ASTNode node;
		public ExpresionContext exp;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_IZQD() { return getToken(CosoScriptParser.PAREN_IZQD, 0); }
		public TerminalNode MOSTRAR() { return getToken(CosoScriptParser.MOSTRAR, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(CosoScriptParser.PUNTO_COMA, 0); }
		public TerminalNode PAREN_DER() { return getToken(CosoScriptParser.PAREN_DER, 0); }
		public MostrarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mostrar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterMostrar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitMostrar(this);
		}
	}

	public final MostrarContext mostrar() throws RecognitionException {
		MostrarContext _localctx = new MostrarContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_mostrar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(MOSTRAR);
			setState(87); match(PAREN_IZQD);
			setState(88); ((MostrarContext)_localctx).exp = expresion();
			setState(89); match(PAREN_DER);
			setState(90); match(PUNTO_COMA);
			((MostrarContext)_localctx).node =  new Println(((MostrarContext)_localctx).exp.node);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondicionalContext extends ParserRuleContext {
		public ASTNode node;
		public ExpresionContext cond;
		public SContext s1;
		public SContext s2;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_IZQD() { return getToken(CosoScriptParser.PAREN_IZQD, 0); }
		public TerminalNode LLAVE_IZQD(int i) {
			return getToken(CosoScriptParser.LLAVE_IZQD, i);
		}
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public List<TerminalNode> LLAVE_IZQD() { return getTokens(CosoScriptParser.LLAVE_IZQD); }
		public TerminalNode SI() { return getToken(CosoScriptParser.SI, 0); }
		public TerminalNode PAREN_DER() { return getToken(CosoScriptParser.PAREN_DER, 0); }
		public TerminalNode SINO() { return getToken(CosoScriptParser.SINO, 0); }
		public List<TerminalNode> LLAVE_DER() { return getTokens(CosoScriptParser.LLAVE_DER); }
		public TerminalNode LLAVE_DER(int i) {
			return getToken(CosoScriptParser.LLAVE_DER, i);
		}
		public CondicionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condicional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterCondicional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitCondicional(this);
		}
	}

	public final CondicionalContext condicional() throws RecognitionException {
		CondicionalContext _localctx = new CondicionalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_condicional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93); match(SI);
			setState(94); match(PAREN_IZQD);
			setState(95); ((CondicionalContext)_localctx).cond = expresion();
			setState(96); match(PAREN_DER);

					List<ASTNode> thenBody = new ArrayList<ASTNode>();
				
			setState(98); match(LLAVE_IZQD);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COSO) | (1L << MOSTRAR) | (1L << SI) | (1L << REPETIR) | (1L << ID))) != 0)) {
				{
				{
				setState(99); ((CondicionalContext)_localctx).s1 = s();
				thenBody.add(((CondicionalContext)_localctx).s1.node);
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107); match(LLAVE_DER);

					List<ASTNode> elseBody = new ArrayList<ASTNode>();
				
			setState(120);
			_la = _input.LA(1);
			if (_la==SINO) {
				{
				setState(109); match(SINO);
				setState(110); match(LLAVE_IZQD);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COSO) | (1L << MOSTRAR) | (1L << SI) | (1L << REPETIR) | (1L << ID))) != 0)) {
					{
					{
					setState(111); ((CondicionalContext)_localctx).s2 = s();
					elseBody.add(((CondicionalContext)_localctx).s2.node);
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(119); match(LLAVE_DER);
				}
			}


					((CondicionalContext)_localctx).node =  new If(((CondicionalContext)_localctx).cond.node, thenBody, elseBody);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepetirContext extends ParserRuleContext {
		public ASTNode node;
		public SContext s1;
		public ExpresionContext cond;
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_IZQD() { return getToken(CosoScriptParser.PAREN_IZQD, 0); }
		public List<SContext> s() {
			return getRuleContexts(SContext.class);
		}
		public SContext s(int i) {
			return getRuleContext(SContext.class,i);
		}
		public TerminalNode LLAVE_IZQD() { return getToken(CosoScriptParser.LLAVE_IZQD, 0); }
		public TerminalNode REPETIR() { return getToken(CosoScriptParser.REPETIR, 0); }
		public TerminalNode HASTA() { return getToken(CosoScriptParser.HASTA, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(CosoScriptParser.PUNTO_COMA, 0); }
		public TerminalNode PAREN_DER() { return getToken(CosoScriptParser.PAREN_DER, 0); }
		public TerminalNode LLAVE_DER() { return getToken(CosoScriptParser.LLAVE_DER, 0); }
		public RepetirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repetir; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterRepetir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitRepetir(this);
		}
	}

	public final RepetirContext repetir() throws RecognitionException {
		RepetirContext _localctx = new RepetirContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_repetir);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); match(REPETIR);

					List<ASTNode> body = new ArrayList<ASTNode>();
				
			setState(126); match(LLAVE_IZQD);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COSO) | (1L << MOSTRAR) | (1L << SI) | (1L << REPETIR) | (1L << ID))) != 0)) {
				{
				{
				setState(127); ((RepetirContext)_localctx).s1 = s();
				body.add(((RepetirContext)_localctx).s1.node);
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135); match(LLAVE_DER);
			setState(136); match(HASTA);
			setState(137); match(PAREN_IZQD);
			setState(138); ((RepetirContext)_localctx).cond = expresion();
			setState(139); match(PAREN_DER);
			setState(140); match(PUNTO_COMA);

					((RepetirContext)_localctx).node =  new Repeat(body, ((RepetirContext)_localctx).cond.node);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpresionContext extends ParserRuleContext {
		public ASTNode node;
		public Logica_oContext logica_o;
		public Logica_oContext logica_o() {
			return getRuleContext(Logica_oContext.class,0);
		}
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterExpresion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitExpresion(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		ExpresionContext _localctx = new ExpresionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expresion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); ((ExpresionContext)_localctx).logica_o = logica_o();
			((ExpresionContext)_localctx).node =  ((ExpresionContext)_localctx).logica_o.node;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logica_oContext extends ParserRuleContext {
		public ASTNode node;
		public Logica_yContext t1;
		public Logica_yContext t2;
		public TerminalNode O(int i) {
			return getToken(CosoScriptParser.O, i);
		}
		public List<TerminalNode> O() { return getTokens(CosoScriptParser.O); }
		public Logica_yContext logica_y(int i) {
			return getRuleContext(Logica_yContext.class,i);
		}
		public List<Logica_yContext> logica_y() {
			return getRuleContexts(Logica_yContext.class);
		}
		public Logica_oContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logica_o; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterLogica_o(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitLogica_o(this);
		}
	}

	public final Logica_oContext logica_o() throws RecognitionException {
		Logica_oContext _localctx = new Logica_oContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_logica_o);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); ((Logica_oContext)_localctx).t1 = logica_y();
			((Logica_oContext)_localctx).node =  ((Logica_oContext)_localctx).t1.node;
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==O) {
				{
				{
				setState(148); match(O);
				setState(149); ((Logica_oContext)_localctx).t2 = logica_y();
				((Logica_oContext)_localctx).node =  new BinOp(_localctx.node, "||", ((Logica_oContext)_localctx).t2.node);
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logica_yContext extends ParserRuleContext {
		public ASTNode node;
		public IgualdadContext t1;
		public IgualdadContext t2;
		public List<TerminalNode> Y() { return getTokens(CosoScriptParser.Y); }
		public IgualdadContext igualdad(int i) {
			return getRuleContext(IgualdadContext.class,i);
		}
		public TerminalNode Y(int i) {
			return getToken(CosoScriptParser.Y, i);
		}
		public List<IgualdadContext> igualdad() {
			return getRuleContexts(IgualdadContext.class);
		}
		public Logica_yContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logica_y; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterLogica_y(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitLogica_y(this);
		}
	}

	public final Logica_yContext logica_y() throws RecognitionException {
		Logica_yContext _localctx = new Logica_yContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_logica_y);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157); ((Logica_yContext)_localctx).t1 = igualdad();
			((Logica_yContext)_localctx).node =  ((Logica_yContext)_localctx).t1.node;
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Y) {
				{
				{
				setState(159); match(Y);
				setState(160); ((Logica_yContext)_localctx).t2 = igualdad();
				((Logica_yContext)_localctx).node =  new BinOp(_localctx.node, "&&", ((Logica_yContext)_localctx).t2.node);
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IgualdadContext extends ParserRuleContext {
		public ASTNode node;
		public ComparacionContext t1;
		public Token op;
		public ComparacionContext t2;
		public ComparacionContext comparacion(int i) {
			return getRuleContext(ComparacionContext.class,i);
		}
		public List<ComparacionContext> comparacion() {
			return getRuleContexts(ComparacionContext.class);
		}
		public List<TerminalNode> NO_IGUAL() { return getTokens(CosoScriptParser.NO_IGUAL); }
		public TerminalNode IGUAL(int i) {
			return getToken(CosoScriptParser.IGUAL, i);
		}
		public List<TerminalNode> IGUAL() { return getTokens(CosoScriptParser.IGUAL); }
		public TerminalNode NO_IGUAL(int i) {
			return getToken(CosoScriptParser.NO_IGUAL, i);
		}
		public IgualdadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_igualdad; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterIgualdad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitIgualdad(this);
		}
	}

	public final IgualdadContext igualdad() throws RecognitionException {
		IgualdadContext _localctx = new IgualdadContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_igualdad);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); ((IgualdadContext)_localctx).t1 = comparacion();
			((IgualdadContext)_localctx).node =  ((IgualdadContext)_localctx).t1.node;
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IGUAL || _la==NO_IGUAL) {
				{
				{
				setState(170);
				((IgualdadContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==IGUAL || _la==NO_IGUAL) ) {
					((IgualdadContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(171); ((IgualdadContext)_localctx).t2 = comparacion();
				((IgualdadContext)_localctx).node =  new BinOp(_localctx.node, (((IgualdadContext)_localctx).op!=null?((IgualdadContext)_localctx).op.getText():null), ((IgualdadContext)_localctx).t2.node);
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparacionContext extends ParserRuleContext {
		public ASTNode node;
		public AditivaContext t1;
		public Token op;
		public AditivaContext t2;
		public AditivaContext aditiva(int i) {
			return getRuleContext(AditivaContext.class,i);
		}
		public TerminalNode MENOR(int i) {
			return getToken(CosoScriptParser.MENOR, i);
		}
		public List<TerminalNode> MAYOR() { return getTokens(CosoScriptParser.MAYOR); }
		public List<TerminalNode> MAYOR_IGUAL() { return getTokens(CosoScriptParser.MAYOR_IGUAL); }
		public List<TerminalNode> MENOR_IGUAL() { return getTokens(CosoScriptParser.MENOR_IGUAL); }
		public List<TerminalNode> MENOR() { return getTokens(CosoScriptParser.MENOR); }
		public TerminalNode MAYOR(int i) {
			return getToken(CosoScriptParser.MAYOR, i);
		}
		public TerminalNode MAYOR_IGUAL(int i) {
			return getToken(CosoScriptParser.MAYOR_IGUAL, i);
		}
		public List<AditivaContext> aditiva() {
			return getRuleContexts(AditivaContext.class);
		}
		public TerminalNode MENOR_IGUAL(int i) {
			return getToken(CosoScriptParser.MENOR_IGUAL, i);
		}
		public ComparacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterComparacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitComparacion(this);
		}
	}

	public final ComparacionContext comparacion() throws RecognitionException {
		ComparacionContext _localctx = new ComparacionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comparacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); ((ComparacionContext)_localctx).t1 = aditiva();
			((ComparacionContext)_localctx).node =  ((ComparacionContext)_localctx).t1.node;
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOR) | (1L << MENOR_IGUAL) | (1L << MAYOR) | (1L << MAYOR_IGUAL))) != 0)) {
				{
				{
				setState(181);
				((ComparacionContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOR) | (1L << MENOR_IGUAL) | (1L << MAYOR) | (1L << MAYOR_IGUAL))) != 0)) ) {
					((ComparacionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(182); ((ComparacionContext)_localctx).t2 = aditiva();
				((ComparacionContext)_localctx).node =  new BinOp(_localctx.node, (((ComparacionContext)_localctx).op!=null?((ComparacionContext)_localctx).op.getText():null), ((ComparacionContext)_localctx).t2.node);
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AditivaContext extends ParserRuleContext {
		public ASTNode node;
		public MultiplicativaContext t1;
		public Token op;
		public MultiplicativaContext t2;
		public List<TerminalNode> MENOS() { return getTokens(CosoScriptParser.MENOS); }
		public List<TerminalNode> MAS() { return getTokens(CosoScriptParser.MAS); }
		public TerminalNode MENOS(int i) {
			return getToken(CosoScriptParser.MENOS, i);
		}
		public TerminalNode MAS(int i) {
			return getToken(CosoScriptParser.MAS, i);
		}
		public List<MultiplicativaContext> multiplicativa() {
			return getRuleContexts(MultiplicativaContext.class);
		}
		public MultiplicativaContext multiplicativa(int i) {
			return getRuleContext(MultiplicativaContext.class,i);
		}
		public AditivaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aditiva; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterAditiva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitAditiva(this);
		}
	}

	public final AditivaContext aditiva() throws RecognitionException {
		AditivaContext _localctx = new AditivaContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_aditiva);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190); ((AditivaContext)_localctx).t1 = multiplicativa();
			((AditivaContext)_localctx).node =  ((AditivaContext)_localctx).t1.node;
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MAS || _la==MENOS) {
				{
				{
				setState(192);
				((AditivaContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MAS || _la==MENOS) ) {
					((AditivaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(193); ((AditivaContext)_localctx).t2 = multiplicativa();
				((AditivaContext)_localctx).node =  new BinOp(_localctx.node, (((AditivaContext)_localctx).op!=null?((AditivaContext)_localctx).op.getText():null), ((AditivaContext)_localctx).t2.node);
				}
				}
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplicativaContext extends ParserRuleContext {
		public ASTNode node;
		public UnariaContext t1;
		public Token op;
		public UnariaContext t2;
		public TerminalNode MULT(int i) {
			return getToken(CosoScriptParser.MULT, i);
		}
		public List<UnariaContext> unaria() {
			return getRuleContexts(UnariaContext.class);
		}
		public List<TerminalNode> MULT() { return getTokens(CosoScriptParser.MULT); }
		public List<TerminalNode> DIV() { return getTokens(CosoScriptParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(CosoScriptParser.DIV, i);
		}
		public UnariaContext unaria(int i) {
			return getRuleContext(UnariaContext.class,i);
		}
		public MultiplicativaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterMultiplicativa(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitMultiplicativa(this);
		}
	}

	public final MultiplicativaContext multiplicativa() throws RecognitionException {
		MultiplicativaContext _localctx = new MultiplicativaContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_multiplicativa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201); ((MultiplicativaContext)_localctx).t1 = unaria();
			((MultiplicativaContext)_localctx).node =  ((MultiplicativaContext)_localctx).t1.node;
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIV) {
				{
				{
				setState(203);
				((MultiplicativaContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MULT || _la==DIV) ) {
					((MultiplicativaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(204); ((MultiplicativaContext)_localctx).t2 = unaria();
				((MultiplicativaContext)_localctx).node =  new BinOp(_localctx.node, (((MultiplicativaContext)_localctx).op!=null?((MultiplicativaContext)_localctx).op.getText():null), ((MultiplicativaContext)_localctx).t2.node);
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnariaContext extends ParserRuleContext {
		public ASTNode node;
		public Token op;
		public PostfijaContext t1;
		public TerminalNode MENOS() { return getToken(CosoScriptParser.MENOS, 0); }
		public TerminalNode NO() { return getToken(CosoScriptParser.NO, 0); }
		public PostfijaContext postfija() {
			return getRuleContext(PostfijaContext.class,0);
		}
		public UnariaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterUnaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitUnaria(this);
		}
	}

	public final UnariaContext unaria() throws RecognitionException {
		UnariaContext _localctx = new UnariaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unaria);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			_la = _input.LA(1);
			if (_la==MENOS || _la==NO) {
				{
				setState(212);
				((UnariaContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MENOS || _la==NO) ) {
					((UnariaContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(215); ((UnariaContext)_localctx).t1 = postfija();

					if (((UnariaContext)_localctx).op != null) {
						((UnariaContext)_localctx).node =  new UnOp((((UnariaContext)_localctx).op!=null?((UnariaContext)_localctx).op.getText():null), ((UnariaContext)_localctx).t1.node);
					} else {
						((UnariaContext)_localctx).node =  ((UnariaContext)_localctx).t1.node;
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfijaContext extends ParserRuleContext {
		public ASTNode node;
		public PrimariaContext primaria;
		public PrimariaContext primaria() {
			return getRuleContext(PrimariaContext.class,0);
		}
		public PostfijaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfija; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterPostfija(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitPostfija(this);
		}
	}

	public final PostfijaContext postfija() throws RecognitionException {
		PostfijaContext _localctx = new PostfijaContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_postfija);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218); ((PostfijaContext)_localctx).primaria = primaria();
			((PostfijaContext)_localctx).node =  ((PostfijaContext)_localctx).primaria.node;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimariaContext extends ParserRuleContext {
		public ASTNode node;
		public NumeroContext numero;
		public CadenaContext cadena;
		public Token ID;
		public BooleanoContext booleano;
		public ExpresionContext exp;
		public TerminalNode ID() { return getToken(CosoScriptParser.ID, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_IZQD() { return getToken(CosoScriptParser.PAREN_IZQD, 0); }
		public NumeroContext numero() {
			return getRuleContext(NumeroContext.class,0);
		}
		public BooleanoContext booleano() {
			return getRuleContext(BooleanoContext.class,0);
		}
		public TerminalNode PAREN_DER() { return getToken(CosoScriptParser.PAREN_DER, 0); }
		public CadenaContext cadena() {
			return getRuleContext(CadenaContext.class,0);
		}
		public PrimariaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaria; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterPrimaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitPrimaria(this);
		}
	}

	public final PrimariaContext primaria() throws RecognitionException {
		PrimariaContext _localctx = new PrimariaContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_primaria);
		try {
			setState(237);
			switch (_input.LA(1)) {
			case NUMERO:
				enterOuterAlt(_localctx, 1);
				{
				setState(221); ((PrimariaContext)_localctx).numero = numero();
				((PrimariaContext)_localctx).node =  ((PrimariaContext)_localctx).numero.node;
				}
				break;
			case CADENA:
				enterOuterAlt(_localctx, 2);
				{
				setState(224); ((PrimariaContext)_localctx).cadena = cadena();
				((PrimariaContext)_localctx).node =  ((PrimariaContext)_localctx).cadena.node;
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(227); ((PrimariaContext)_localctx).ID = match(ID);
				((PrimariaContext)_localctx).node =  new VarRef((((PrimariaContext)_localctx).ID!=null?((PrimariaContext)_localctx).ID.getText():null));
				}
				break;
			case VERDADERO:
			case FALSO:
				enterOuterAlt(_localctx, 4);
				{
				setState(229); ((PrimariaContext)_localctx).booleano = booleano();
				((PrimariaContext)_localctx).node =  ((PrimariaContext)_localctx).booleano.node;
				}
				break;
			case PAREN_IZQD:
				enterOuterAlt(_localctx, 5);
				{
				setState(232); match(PAREN_IZQD);
				setState(233); ((PrimariaContext)_localctx).exp = expresion();
				setState(234); match(PAREN_DER);
				((PrimariaContext)_localctx).node =  ((PrimariaContext)_localctx).exp.node;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumeroContext extends ParserRuleContext {
		public ASTNode node;
		public Token n;
		public TerminalNode NUMERO() { return getToken(CosoScriptParser.NUMERO, 0); }
		public NumeroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numero; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterNumero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitNumero(this);
		}
	}

	public final NumeroContext numero() throws RecognitionException {
		NumeroContext _localctx = new NumeroContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_numero);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239); ((NumeroContext)_localctx).n = match(NUMERO);

					if ((((NumeroContext)_localctx).n!=null?((NumeroContext)_localctx).n.getText():null).contains(".")) {
						((NumeroContext)_localctx).node =  new Literal(Double.parseDouble((((NumeroContext)_localctx).n!=null?((NumeroContext)_localctx).n.getText():null)));
					} else {
						((NumeroContext)_localctx).node =  new Literal(Integer.parseInt((((NumeroContext)_localctx).n!=null?((NumeroContext)_localctx).n.getText():null)));
					}
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CadenaContext extends ParserRuleContext {
		public ASTNode node;
		public Token c;
		public TerminalNode CADENA() { return getToken(CosoScriptParser.CADENA, 0); }
		public CadenaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cadena; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterCadena(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitCadena(this);
		}
	}

	public final CadenaContext cadena() throws RecognitionException {
		CadenaContext _localctx = new CadenaContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_cadena);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242); ((CadenaContext)_localctx).c = match(CADENA);

					String val = (((CadenaContext)_localctx).c!=null?((CadenaContext)_localctx).c.getText():null);
					((CadenaContext)_localctx).node =  new Literal(val.substring(1, val.length() - 1));
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BooleanoContext extends ParserRuleContext {
		public ASTNode node;
		public TerminalNode VERDADERO() { return getToken(CosoScriptParser.VERDADERO, 0); }
		public TerminalNode FALSO() { return getToken(CosoScriptParser.FALSO, 0); }
		public BooleanoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleano; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterBooleano(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitBooleano(this);
		}
	}

	public final BooleanoContext booleano() throws RecognitionException {
		BooleanoContext _localctx = new BooleanoContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_booleano);
		try {
			setState(249);
			switch (_input.LA(1)) {
			case VERDADERO:
				enterOuterAlt(_localctx, 1);
				{
				setState(245); match(VERDADERO);
				((BooleanoContext)_localctx).node =  new Literal(Boolean.TRUE);
				}
				break;
			case FALSO:
				enterOuterAlt(_localctx, 2);
				{
				setState(247); match(FALSO);
				((BooleanoContext)_localctx).node =  new Literal(Boolean.FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public String tipoVar;
		public TerminalNode REAL() { return getToken(CosoScriptParser.REAL, 0); }
		public TerminalNode CADENA_TIPO() { return getToken(CosoScriptParser.CADENA_TIPO, 0); }
		public TerminalNode LOGICO_TIPO() { return getToken(CosoScriptParser.LOGICO_TIPO, 0); }
		public TerminalNode ENTERO() { return getToken(CosoScriptParser.ENTERO, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_tipo);
		try {
			setState(259);
			switch (_input.LA(1)) {
			case ENTERO:
				enterOuterAlt(_localctx, 1);
				{
				setState(251); match(ENTERO);
				((TipoContext)_localctx).tipoVar =  "entero";
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(253); match(REAL);
				((TipoContext)_localctx).tipoVar =  "real";
				}
				break;
			case CADENA_TIPO:
				enterOuterAlt(_localctx, 3);
				{
				setState(255); match(CADENA_TIPO);
				((TipoContext)_localctx).tipoVar =  "cadena";
				}
				break;
			case LOGICO_TIPO:
				enterOuterAlt(_localctx, 4);
				{
				setState(257); match(LOGICO_TIPO);
				((TipoContext)_localctx).tipoVar =  "logico";
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u0108\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\2\3\2\7\2\61\n\2\f"+
		"\2\16\2\64\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\5\3H\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\7\7i\n\7\f\7\16\7l\13\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7u"+
		"\n\7\f\7\16\7x\13\7\3\7\5\7{\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u0085"+
		"\n\b\f\b\16\b\u0088\13\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\7\n\u009b\n\n\f\n\16\n\u009e\13\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\7\13\u00a6\n\13\f\13\16\13\u00a9\13\13\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\7\f\u00b1\n\f\f\f\16\f\u00b4\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r"+
		"\u00bc\n\r\f\r\16\r\u00bf\13\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00c7"+
		"\n\16\f\16\16\16\u00ca\13\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00d2"+
		"\n\17\f\17\16\17\u00d5\13\17\3\20\5\20\u00d8\n\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\5\22\u00f0\n\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\5\25\u00fc\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\5\26\u0106\n\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*\2\7\3\2\23\24\3\2\25\30\3\2\17\20\3\2\21\22\4\2\20\20\33\33\u010a"+
		"\2,\3\2\2\2\4G\3\2\2\2\6I\3\2\2\2\bR\3\2\2\2\nX\3\2\2\2\f_\3\2\2\2\16"+
		"~\3\2\2\2\20\u0091\3\2\2\2\22\u0094\3\2\2\2\24\u009f\3\2\2\2\26\u00aa"+
		"\3\2\2\2\30\u00b5\3\2\2\2\32\u00c0\3\2\2\2\34\u00cb\3\2\2\2\36\u00d7\3"+
		"\2\2\2 \u00dc\3\2\2\2\"\u00ef\3\2\2\2$\u00f1\3\2\2\2&\u00f4\3\2\2\2(\u00fb"+
		"\3\2\2\2*\u0105\3\2\2\2,\62\b\2\1\2-.\5\4\3\2./\b\2\1\2/\61\3\2\2\2\60"+
		"-\3\2\2\2\61\64\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\65\3\2\2\2\64\62"+
		"\3\2\2\2\65\66\7\2\2\3\66\67\b\2\1\2\67\3\3\2\2\289\5\6\4\29:\b\3\1\2"+
		":H\3\2\2\2;<\5\b\5\2<=\b\3\1\2=H\3\2\2\2>?\5\n\6\2?@\b\3\1\2@H\3\2\2\2"+
		"AB\5\f\7\2BC\b\3\1\2CH\3\2\2\2DE\5\16\b\2EF\b\3\1\2FH\3\2\2\2G8\3\2\2"+
		"\2G;\3\2\2\2G>\3\2\2\2GA\3\2\2\2GD\3\2\2\2H\5\3\2\2\2IJ\7\3\2\2JK\7%\2"+
		"\2KL\7\36\2\2LM\5*\26\2MN\7\34\2\2NO\5\20\t\2OP\7\35\2\2PQ\b\4\1\2Q\7"+
		"\3\2\2\2RS\7%\2\2ST\7\34\2\2TU\5\20\t\2UV\7\35\2\2VW\b\5\1\2W\t\3\2\2"+
		"\2XY\7\4\2\2YZ\7\37\2\2Z[\5\20\t\2[\\\7 \2\2\\]\7\35\2\2]^\b\6\1\2^\13"+
		"\3\2\2\2_`\7\5\2\2`a\7\37\2\2ab\5\20\t\2bc\7 \2\2cd\b\7\1\2dj\7!\2\2e"+
		"f\5\4\3\2fg\b\7\1\2gi\3\2\2\2he\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2"+
		"km\3\2\2\2lj\3\2\2\2mn\7\"\2\2nz\b\7\1\2op\7\6\2\2pv\7!\2\2qr\5\4\3\2"+
		"rs\b\7\1\2su\3\2\2\2tq\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wy\3\2\2\2"+
		"xv\3\2\2\2y{\7\"\2\2zo\3\2\2\2z{\3\2\2\2{|\3\2\2\2|}\b\7\1\2}\r\3\2\2"+
		"\2~\177\7\7\2\2\177\u0080\b\b\1\2\u0080\u0086\7!\2\2\u0081\u0082\5\4\3"+
		"\2\u0082\u0083\b\b\1\2\u0083\u0085\3\2\2\2\u0084\u0081\3\2\2\2\u0085\u0088"+
		"\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0089\u008a\7\"\2\2\u008a\u008b\7\b\2\2\u008b\u008c\7\37"+
		"\2\2\u008c\u008d\5\20\t\2\u008d\u008e\7 \2\2\u008e\u008f\7\35\2\2\u008f"+
		"\u0090\b\b\1\2\u0090\17\3\2\2\2\u0091\u0092\5\22\n\2\u0092\u0093\b\t\1"+
		"\2\u0093\21\3\2\2\2\u0094\u0095\5\24\13\2\u0095\u009c\b\n\1\2\u0096\u0097"+
		"\7\32\2\2\u0097\u0098\5\24\13\2\u0098\u0099\b\n\1\2\u0099\u009b\3\2\2"+
		"\2\u009a\u0096\3\2\2\2\u009b\u009e\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d"+
		"\3\2\2\2\u009d\23\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a0\5\26\f\2\u00a0"+
		"\u00a7\b\13\1\2\u00a1\u00a2\7\31\2\2\u00a2\u00a3\5\26\f\2\u00a3\u00a4"+
		"\b\13\1\2\u00a4\u00a6\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a6\u00a9\3\2\2\2"+
		"\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\25\3\2\2\2\u00a9\u00a7"+
		"\3\2\2\2\u00aa\u00ab\5\30\r\2\u00ab\u00b2\b\f\1\2\u00ac\u00ad\t\2\2\2"+
		"\u00ad\u00ae\5\30\r\2\u00ae\u00af\b\f\1\2\u00af\u00b1\3\2\2\2\u00b0\u00ac"+
		"\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\27\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\5\32\16\2\u00b6\u00bd\b\r"+
		"\1\2\u00b7\u00b8\t\3\2\2\u00b8\u00b9\5\32\16\2\u00b9\u00ba\b\r\1\2\u00ba"+
		"\u00bc\3\2\2\2\u00bb\u00b7\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\31\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1"+
		"\5\34\17\2\u00c1\u00c8\b\16\1\2\u00c2\u00c3\t\4\2\2\u00c3\u00c4\5\34\17"+
		"\2\u00c4\u00c5\b\16\1\2\u00c5\u00c7\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c7"+
		"\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\33\3\2\2"+
		"\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\5\36\20\2\u00cc\u00d3\b\17\1\2\u00cd"+
		"\u00ce\t\5\2\2\u00ce\u00cf\5\36\20\2\u00cf\u00d0\b\17\1\2\u00d0\u00d2"+
		"\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\35\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d8\t\6\2"+
		"\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da"+
		"\5 \21\2\u00da\u00db\b\20\1\2\u00db\37\3\2\2\2\u00dc\u00dd\5\"\22\2\u00dd"+
		"\u00de\b\21\1\2\u00de!\3\2\2\2\u00df\u00e0\5$\23\2\u00e0\u00e1\b\22\1"+
		"\2\u00e1\u00f0\3\2\2\2\u00e2\u00e3\5&\24\2\u00e3\u00e4\b\22\1\2\u00e4"+
		"\u00f0\3\2\2\2\u00e5\u00e6\7%\2\2\u00e6\u00f0\b\22\1\2\u00e7\u00e8\5("+
		"\25\2\u00e8\u00e9\b\22\1\2\u00e9\u00f0\3\2\2\2\u00ea\u00eb\7\37\2\2\u00eb"+
		"\u00ec\5\20\t\2\u00ec\u00ed\7 \2\2\u00ed\u00ee\b\22\1\2\u00ee\u00f0\3"+
		"\2\2\2\u00ef\u00df\3\2\2\2\u00ef\u00e2\3\2\2\2\u00ef\u00e5\3\2\2\2\u00ef"+
		"\u00e7\3\2\2\2\u00ef\u00ea\3\2\2\2\u00f0#\3\2\2\2\u00f1\u00f2\7#\2\2\u00f2"+
		"\u00f3\b\23\1\2\u00f3%\3\2\2\2\u00f4\u00f5\7$\2\2\u00f5\u00f6\b\24\1\2"+
		"\u00f6\'\3\2\2\2\u00f7\u00f8\7\r\2\2\u00f8\u00fc\b\25\1\2\u00f9\u00fa"+
		"\7\16\2\2\u00fa\u00fc\b\25\1\2\u00fb\u00f7\3\2\2\2\u00fb\u00f9\3\2\2\2"+
		"\u00fc)\3\2\2\2\u00fd\u00fe\7\t\2\2\u00fe\u0106\b\26\1\2\u00ff\u0100\7"+
		"\n\2\2\u0100\u0106\b\26\1\2\u0101\u0102\7\13\2\2\u0102\u0106\b\26\1\2"+
		"\u0103\u0104\7\f\2\2\u0104\u0106\b\26\1\2\u0105\u00fd\3\2\2\2\u0105\u00ff"+
		"\3\2\2\2\u0105\u0101\3\2\2\2\u0105\u0103\3\2\2\2\u0106+\3\2\2\2\22\62"+
		"Gjvz\u0086\u009c\u00a7\u00b2\u00bd\u00c8\u00d3\u00d7\u00ef\u00fb\u0105";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}