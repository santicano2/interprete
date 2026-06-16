grammar CosoScript;

@parser::header {
	import java.util.Map;
	import java.util.HashMap;
	import java.util.List;
	import java.util.ArrayList;
	import com.equipoc.cososcript.interprete.ast.*;
}

@parser::members {
	Map<String, Object> symbolTable = new HashMap<String, Object>();
}

// REGLAS SINTÁCTICAS
programa:
	{
		List<ASTNode> body = new ArrayList<ASTNode>();
	}
	(s {body.add($s.node);})* EOF
	{
		for (ASTNode n : body) {
			n.execute(symbolTable);
		}
	}
	;

s returns [ASTNode node]:
	declaracion {$node = $declaracion.node;}
	| asignacion {$node = $asignacion.node;}
	| mostrar {$node = $mostrar.node;}
	| condicional {$node = $condicional.node;}
	| repetir {$node = $repetir.node;}
	;

declaracion returns [ASTNode node]:
	COSO ID COLON t=tipo ASIGN exp=expresion PUNTO_COMA
	{$node = new VarDecl($ID.text, $t.tipoVar, $exp.node);}
	;

asignacion returns [ASTNode node]:
	ID ASIGN exp=expresion PUNTO_COMA
	{$node = new VarAssign($ID.text, $exp.node);}
	;

mostrar returns [ASTNode node]:
	MOSTRAR PAREN_IZQD exp=expresion PAREN_DER PUNTO_COMA
	{$node = new Println($exp.node);}
	;

condicional returns [ASTNode node]:
	SI PAREN_IZQD cond=expresion PAREN_DER
	{
		List<ASTNode> thenBody = new ArrayList<ASTNode>();
	}
	LLAVE_IZQD (s1=s {thenBody.add($s1.node);})* LLAVE_DER
	{
		List<ASTNode> elseBody = new ArrayList<ASTNode>();
	}
	(SINO LLAVE_IZQD (s2=s {elseBody.add($s2.node);})* LLAVE_DER)?
	{
		$node = new If($cond.node, thenBody, elseBody);
	}
	;

repetir returns [ASTNode node]:
	REPETIR
	{
		List<ASTNode> body = new ArrayList<ASTNode>();
	}
	LLAVE_IZQD (s1=s {body.add($s1.node);})* LLAVE_DER
	HASTA PAREN_IZQD cond=expresion PAREN_DER PUNTO_COMA
	{
		$node = new Repeat(body, $cond.node);
	}
	;

expresion returns [ASTNode node]:
	logica_o {$node = $logica_o.node;}
	;

logica_o returns [ASTNode node]:
	t1=logica_y {$node = $t1.node;}
	(O t2=logica_y {$node = new BinOp($node, "||", $t2.node);})*
	;

logica_y returns [ASTNode node]:
	t1=igualdad {$node = $t1.node;}
	(Y t2=igualdad {$node = new BinOp($node, "&&", $t2.node);})*
	;

igualdad returns [ASTNode node]:
	t1=comparacion {$node = $t1.node;}
	(op=(IGUAL | NO_IGUAL) t2=comparacion {$node = new BinOp($node, $op.text, $t2.node);})*
	;

comparacion returns [ASTNode node]:
	t1=aditiva {$node = $t1.node;}
	(op=(MENOR | MENOR_IGUAL | MAYOR | MAYOR_IGUAL) t2=aditiva {$node = new BinOp($node, $op.text, $t2.node);})*
	;

aditiva returns [ASTNode node]:
	t1=multiplicativa {$node = $t1.node;}
	(op=(MAS | MENOS) t2=multiplicativa {$node = new BinOp($node, $op.text, $t2.node);})*
	;

multiplicativa returns [ASTNode node]:
	t1=unaria {$node = $t1.node;}
	(op=(MULT | DIV) t2=unaria {$node = new BinOp($node, $op.text, $t2.node);})*
	;

unaria returns [ASTNode node]:
	(op=(NO | MENOS))? t1=postfija
	{
		if ($op != null) {
			$node = new UnOp($op.text, $t1.node);
		} else {
			$node = $t1.node;
		}
	}
	;

postfija returns [ASTNode node]:
	primaria {$node = $primaria.node;}
	;

primaria returns [ASTNode node]:
	numero {$node = $numero.node;}
	| cadena {$node = $cadena.node;}
	| ID {$node = new VarRef($ID.text);}
	| booleano {$node = $booleano.node;}
	| PAREN_IZQD exp=expresion PAREN_DER {$node = $exp.node;}
	;

numero returns [ASTNode node]:
	n=NUMERO
	{
		if ($n.text.contains(".")) {
			$node = new Literal(Double.parseDouble($n.text));
		} else {
			$node = new Literal(Integer.parseInt($n.text));
		}
	}
	;

cadena returns [ASTNode node]:
	c=CADENA
	{
		String val = $c.text;
		$node = new Literal(val.substring(1, val.length() - 1));
	}
	;

booleano returns [ASTNode node]:
	VERDADERO {$node = new Literal(Boolean.TRUE);}
	| FALSO {$node = new Literal(Boolean.FALSE);}
	;

tipo returns [String tipoVar]:
	ENTERO {$tipoVar = "entero";}
	| REAL {$tipoVar = "real";}
	| CADENA_TIPO {$tipoVar = "cadena";}
	| LOGICO_TIPO {$tipoVar = "logico";}
	;

// TOKENS - PALABRAS CLAVE
COSO: 'coso';
MOSTRAR: 'mostrar';
SI: 'si';
SINO: 'sino';
REPETIR: 'repetir';
HASTA: 'hasta';
ENTERO: 'entero';
REAL: 'real';
CADENA_TIPO: 'cadena';
LOGICO_TIPO: 'logico';
VERDADERO: 'verdadero';
FALSO: 'falso';

// TOKENS - OPERADORES ARITMÉTICOS
MAS: '+';
MENOS: '-';
MULT: '*';
DIV: '/';

// TOKENS - OPERADORES RELACIONALES
IGUAL: '==';
NO_IGUAL: '!=';
MENOR: '<';
MENOR_IGUAL: '<=';
MAYOR: '>';
MAYOR_IGUAL: '>=';

// TOKENS - OPERADORES LÓGICOS
Y: '&&';
O: '||';
NO: '!';

// TOKENS - ASIGNACIÓN
ASIGN: '=';

// TOKENS - SÍMBOLOS
PUNTO_COMA: ';';
COLON: ':';
PAREN_IZQD: '(';
PAREN_DER: ')';
LLAVE_IZQD: '{';
LLAVE_DER: '}';

// TOKENS - LITERALES
NUMERO: [0-9]+('.'[0-9]+)?;
CADENA: '"' (~["\r\n\\] | '\\' .)* '"';

// TOKENS - IDENTIFICADORES
ID: [a-zA-Z_][a-zA-Z0-9_]*;

// TOKENS - ESPACIOS Y COMENTARIOS
WS: [ \t\r\n]+ -> skip;
COMENTARIO: '//' ~[\r\n]* -> skip;
