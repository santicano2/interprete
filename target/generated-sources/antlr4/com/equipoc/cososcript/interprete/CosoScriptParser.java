// Generated from CosoScript.g4 by ANTLR 4.4
package com.equipoc.cososcript.interprete;
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
		RULE_programa = 0, RULE_sentencia = 1, RULE_declaracion = 2, RULE_asignacion = 3, 
		RULE_mostrar = 4, RULE_condicional = 5, RULE_repetir = 6, RULE_expresion = 7, 
		RULE_logica_o = 8, RULE_logica_y = 9, RULE_igualdad = 10, RULE_comparacion = 11, 
		RULE_aditiva = 12, RULE_multiplicativa = 13, RULE_unaria = 14, RULE_postfija = 15, 
		RULE_primaria = 16, RULE_numero = 17, RULE_cadena = 18, RULE_booleano = 19, 
		RULE_tipo = 20;
	public static final String[] ruleNames = {
		"programa", "sentencia", "declaracion", "asignacion", "mostrar", "condicional", 
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

	public CosoScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public TerminalNode EOF() { return getToken(CosoScriptParser.EOF, 0); }
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
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
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COSO) | (1L << MOSTRAR) | (1L << SI) | (1L << REPETIR) | (1L << ID))) != 0)) {
				{
				{
				setState(42); sentencia();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48); match(EOF);
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

	public static class SentenciaContext extends ParserRuleContext {
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
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).enterSentencia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CosoScriptListener ) ((CosoScriptListener)listener).exitSentencia(this);
		}
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentencia);
		try {
			setState(55);
			switch (_input.LA(1)) {
			case COSO:
				enterOuterAlt(_localctx, 1);
				{
				setState(50); declaracion();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(51); asignacion();
				}
				break;
			case MOSTRAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(52); mostrar();
				}
				break;
			case SI:
				enterOuterAlt(_localctx, 4);
				{
				setState(53); condicional();
				}
				break;
			case REPETIR:
				enterOuterAlt(_localctx, 5);
				{
				setState(54); repetir();
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
		public TerminalNode ID() { return getToken(CosoScriptParser.ID, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode COLON() { return getToken(CosoScriptParser.COLON, 0); }
		public TerminalNode PUNTO_COMA() { return getToken(CosoScriptParser.PUNTO_COMA, 0); }
		public TerminalNode ASIGN() { return getToken(CosoScriptParser.ASIGN, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); match(COSO);
			setState(58); match(ID);
			setState(59); match(COLON);
			setState(60); tipo();
			setState(63);
			_la = _input.LA(1);
			if (_la==ASIGN) {
				{
				setState(61); match(ASIGN);
				setState(62); expresion();
				}
			}

			setState(65); match(PUNTO_COMA);
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
			setState(67); match(ID);
			setState(68); match(ASIGN);
			setState(69); expresion();
			setState(70); match(PUNTO_COMA);
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
			setState(72); match(MOSTRAR);
			setState(73); match(PAREN_IZQD);
			setState(74); expresion();
			setState(75); match(PAREN_DER);
			setState(76); match(PUNTO_COMA);
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
		public SentenciaContext sentencia;
		public List<SentenciaContext> entonces = new ArrayList<SentenciaContext>();
		public List<SentenciaContext> sino = new ArrayList<SentenciaContext>();
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_IZQD() { return getToken(CosoScriptParser.PAREN_IZQD, 0); }
		public TerminalNode LLAVE_IZQD(int i) {
			return getToken(CosoScriptParser.LLAVE_IZQD, i);
		}
		public List<TerminalNode> LLAVE_IZQD() { return getTokens(CosoScriptParser.LLAVE_IZQD); }
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
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
			setState(78); match(SI);
			setState(79); match(PAREN_IZQD);
			setState(80); expresion();
			setState(81); match(PAREN_DER);
			setState(82); match(LLAVE_IZQD);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COSO) | (1L << MOSTRAR) | (1L << SI) | (1L << REPETIR) | (1L << ID))) != 0)) {
				{
				{
				setState(83); ((CondicionalContext)_localctx).sentencia = sentencia();
				((CondicionalContext)_localctx).entonces.add(((CondicionalContext)_localctx).sentencia);
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89); match(LLAVE_DER);
			setState(99);
			_la = _input.LA(1);
			if (_la==SINO) {
				{
				setState(90); match(SINO);
				setState(91); match(LLAVE_IZQD);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COSO) | (1L << MOSTRAR) | (1L << SI) | (1L << REPETIR) | (1L << ID))) != 0)) {
					{
					{
					setState(92); ((CondicionalContext)_localctx).sentencia = sentencia();
					((CondicionalContext)_localctx).sino.add(((CondicionalContext)_localctx).sentencia);
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98); match(LLAVE_DER);
				}
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

	public static class RepetirContext extends ParserRuleContext {
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_IZQD() { return getToken(CosoScriptParser.PAREN_IZQD, 0); }
		public TerminalNode LLAVE_IZQD() { return getToken(CosoScriptParser.LLAVE_IZQD, 0); }
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
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
			setState(101); match(REPETIR);
			setState(102); match(LLAVE_IZQD);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COSO) | (1L << MOSTRAR) | (1L << SI) | (1L << REPETIR) | (1L << ID))) != 0)) {
				{
				{
				setState(103); sentencia();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109); match(LLAVE_DER);
			setState(110); match(HASTA);
			setState(111); match(PAREN_IZQD);
			setState(112); expresion();
			setState(113); match(PAREN_DER);
			setState(114); match(PUNTO_COMA);
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
			setState(116); logica_o();
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
			setState(118); logica_y();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==O) {
				{
				{
				setState(119); match(O);
				setState(120); logica_y();
				}
				}
				setState(125);
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
			setState(126); igualdad();
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Y) {
				{
				{
				setState(127); match(Y);
				setState(128); igualdad();
				}
				}
				setState(133);
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
			setState(134); comparacion();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IGUAL || _la==NO_IGUAL) {
				{
				{
				setState(135);
				_la = _input.LA(1);
				if ( !(_la==IGUAL || _la==NO_IGUAL) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(136); comparacion();
				}
				}
				setState(141);
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
			setState(142); aditiva();
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOR) | (1L << MENOR_IGUAL) | (1L << MAYOR) | (1L << MAYOR_IGUAL))) != 0)) {
				{
				{
				setState(143);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOR) | (1L << MENOR_IGUAL) | (1L << MAYOR) | (1L << MAYOR_IGUAL))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(144); aditiva();
				}
				}
				setState(149);
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
			setState(150); multiplicativa();
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MAS || _la==MENOS) {
				{
				{
				setState(151);
				_la = _input.LA(1);
				if ( !(_la==MAS || _la==MENOS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(152); multiplicativa();
				}
				}
				setState(157);
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
			setState(158); unaria();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MULT || _la==DIV) {
				{
				{
				setState(159);
				_la = _input.LA(1);
				if ( !(_la==MULT || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(160); unaria();
				}
				}
				setState(165);
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
			setState(167);
			_la = _input.LA(1);
			if (_la==MENOS || _la==NO) {
				{
				setState(166);
				_la = _input.LA(1);
				if ( !(_la==MENOS || _la==NO) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(169); postfija();
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
			setState(171); primaria();
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
			setState(181);
			switch (_input.LA(1)) {
			case NUMERO:
				enterOuterAlt(_localctx, 1);
				{
				setState(173); numero();
				}
				break;
			case CADENA:
				enterOuterAlt(_localctx, 2);
				{
				setState(174); cadena();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(175); match(ID);
				}
				break;
			case VERDADERO:
			case FALSO:
				enterOuterAlt(_localctx, 4);
				{
				setState(176); booleano();
				}
				break;
			case PAREN_IZQD:
				enterOuterAlt(_localctx, 5);
				{
				setState(177); match(PAREN_IZQD);
				setState(178); expresion();
				setState(179); match(PAREN_DER);
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
			setState(183); match(NUMERO);
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
			setState(185); match(CADENA);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_la = _input.LA(1);
			if ( !(_la==VERDADERO || _la==FALSO) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ENTERO) | (1L << REAL) | (1L << CADENA_TIPO) | (1L << LOGICO_TIPO))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u00c2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\7\2.\n\2\f\2\16\2\61\13\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3:\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\7\7W\n\7\f\7\16\7Z\13\7\3\7\3\7\3\7\3\7\7\7`\n\7\f\7\16\7c\13\7"+
		"\3\7\5\7f\n\7\3\b\3\b\3\b\7\bk\n\b\f\b\16\bn\13\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\n\7\n|\n\n\f\n\16\n\177\13\n\3\13\3\13\3\13"+
		"\7\13\u0084\n\13\f\13\16\13\u0087\13\13\3\f\3\f\3\f\7\f\u008c\n\f\f\f"+
		"\16\f\u008f\13\f\3\r\3\r\3\r\7\r\u0094\n\r\f\r\16\r\u0097\13\r\3\16\3"+
		"\16\3\16\7\16\u009c\n\16\f\16\16\16\u009f\13\16\3\17\3\17\3\17\7\17\u00a4"+
		"\n\17\f\17\16\17\u00a7\13\17\3\20\5\20\u00aa\n\20\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00b8\n\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\26\2\2\27\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*\2\t\3\2\23\24\3\2\25\30\3\2\17\20\3\2\21\22\4\2\20\20\33"+
		"\33\3\2\r\16\3\2\t\f\u00c1\2/\3\2\2\2\49\3\2\2\2\6;\3\2\2\2\bE\3\2\2\2"+
		"\nJ\3\2\2\2\fP\3\2\2\2\16g\3\2\2\2\20v\3\2\2\2\22x\3\2\2\2\24\u0080\3"+
		"\2\2\2\26\u0088\3\2\2\2\30\u0090\3\2\2\2\32\u0098\3\2\2\2\34\u00a0\3\2"+
		"\2\2\36\u00a9\3\2\2\2 \u00ad\3\2\2\2\"\u00b7\3\2\2\2$\u00b9\3\2\2\2&\u00bb"+
		"\3\2\2\2(\u00bd\3\2\2\2*\u00bf\3\2\2\2,.\5\4\3\2-,\3\2\2\2.\61\3\2\2\2"+
		"/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\2\2\3\63\3\3"+
		"\2\2\2\64:\5\6\4\2\65:\5\b\5\2\66:\5\n\6\2\67:\5\f\7\28:\5\16\b\29\64"+
		"\3\2\2\29\65\3\2\2\29\66\3\2\2\29\67\3\2\2\298\3\2\2\2:\5\3\2\2\2;<\7"+
		"\3\2\2<=\7%\2\2=>\7\36\2\2>A\5*\26\2?@\7\34\2\2@B\5\20\t\2A?\3\2\2\2A"+
		"B\3\2\2\2BC\3\2\2\2CD\7\35\2\2D\7\3\2\2\2EF\7%\2\2FG\7\34\2\2GH\5\20\t"+
		"\2HI\7\35\2\2I\t\3\2\2\2JK\7\4\2\2KL\7\37\2\2LM\5\20\t\2MN\7 \2\2NO\7"+
		"\35\2\2O\13\3\2\2\2PQ\7\5\2\2QR\7\37\2\2RS\5\20\t\2ST\7 \2\2TX\7!\2\2"+
		"UW\5\4\3\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2"+
		"[e\7\"\2\2\\]\7\6\2\2]a\7!\2\2^`\5\4\3\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2"+
		"ab\3\2\2\2bd\3\2\2\2ca\3\2\2\2df\7\"\2\2e\\\3\2\2\2ef\3\2\2\2f\r\3\2\2"+
		"\2gh\7\7\2\2hl\7!\2\2ik\5\4\3\2ji\3\2\2\2kn\3\2\2\2lj\3\2\2\2lm\3\2\2"+
		"\2mo\3\2\2\2nl\3\2\2\2op\7\"\2\2pq\7\b\2\2qr\7\37\2\2rs\5\20\t\2st\7 "+
		"\2\2tu\7\35\2\2u\17\3\2\2\2vw\5\22\n\2w\21\3\2\2\2x}\5\24\13\2yz\7\32"+
		"\2\2z|\5\24\13\2{y\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\23\3\2\2"+
		"\2\177}\3\2\2\2\u0080\u0085\5\26\f\2\u0081\u0082\7\31\2\2\u0082\u0084"+
		"\5\26\f\2\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2"+
		"\u0085\u0086\3\2\2\2\u0086\25\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008d"+
		"\5\30\r\2\u0089\u008a\t\2\2\2\u008a\u008c\5\30\r\2\u008b\u0089\3\2\2\2"+
		"\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\27"+
		"\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0095\5\32\16\2\u0091\u0092\t\3\2\2"+
		"\u0092\u0094\5\32\16\2\u0093\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093"+
		"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\31\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u009d\5\34\17\2\u0099\u009a\t\4\2\2\u009a\u009c\5\34\17\2\u009b\u0099"+
		"\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\33\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a5\5\36\20\2\u00a1\u00a2\t\5"+
		"\2\2\u00a2\u00a4\5\36\20\2\u00a3\u00a1\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\35\3\2\2\2\u00a7\u00a5\3\2\2"+
		"\2\u00a8\u00aa\t\6\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab"+
		"\3\2\2\2\u00ab\u00ac\5 \21\2\u00ac\37\3\2\2\2\u00ad\u00ae\5\"\22\2\u00ae"+
		"!\3\2\2\2\u00af\u00b8\5$\23\2\u00b0\u00b8\5&\24\2\u00b1\u00b8\7%\2\2\u00b2"+
		"\u00b8\5(\25\2\u00b3\u00b4\7\37\2\2\u00b4\u00b5\5\20\t\2\u00b5\u00b6\7"+
		" \2\2\u00b6\u00b8\3\2\2\2\u00b7\u00af\3\2\2\2\u00b7\u00b0\3\2\2\2\u00b7"+
		"\u00b1\3\2\2\2\u00b7\u00b2\3\2\2\2\u00b7\u00b3\3\2\2\2\u00b8#\3\2\2\2"+
		"\u00b9\u00ba\7#\2\2\u00ba%\3\2\2\2\u00bb\u00bc\7$\2\2\u00bc\'\3\2\2\2"+
		"\u00bd\u00be\t\7\2\2\u00be)\3\2\2\2\u00bf\u00c0\t\b\2\2\u00c0+\3\2\2\2"+
		"\21/9AXael}\u0085\u008d\u0095\u009d\u00a5\u00a9\u00b7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}