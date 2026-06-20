grammar CosoScript;

// REGLAS SINTÁCTICAS
programa: sentencia* EOF;

sentencia: declaracion
         | asignacion
         | mostrar
         | condicional
         | repetir
         ;

declaracion: COSO ID COLON tipo (ASIGN expresion)? PUNTO_COMA;

asignacion: ID ASIGN expresion PUNTO_COMA;

mostrar: MOSTRAR PAREN_IZQD expresion PAREN_DER PUNTO_COMA;

condicional: SI PAREN_IZQD expresion PAREN_DER
             LLAVE_IZQD entonces+=sentencia* LLAVE_DER
             (SINO LLAVE_IZQD sino+=sentencia* LLAVE_DER)?;

repetir: REPETIR LLAVE_IZQD sentencia* LLAVE_DER
         HASTA PAREN_IZQD expresion PAREN_DER PUNTO_COMA;

expresion: logica_o;

logica_o: logica_y (O logica_y)*;

logica_y: igualdad (Y igualdad)*;

igualdad: comparacion ((IGUAL | NO_IGUAL) comparacion)*;

comparacion: aditiva ((MENOR | MENOR_IGUAL | MAYOR | MAYOR_IGUAL) aditiva)*;

aditiva: multiplicativa ((MAS | MENOS) multiplicativa)*;

multiplicativa: unaria ((MULT | DIV) unaria)*;

unaria: (NO | MENOS)? postfija;

postfija: primaria;

primaria: numero
        | cadena
        | ID
        | booleano
        | PAREN_IZQD expresion PAREN_DER
        ;

numero: NUMERO;

cadena: CADENA;

booleano: VERDADERO | FALSO;

tipo: ENTERO | REAL | CADENA_TIPO | LOGICO_TIPO;

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
