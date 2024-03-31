/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/


/* ESERCIZIO 1
 Elenca e descrivi i principali datatype in JavaScript. Prova a spiegarli come se volessi farli comprendere a un bambino.
*/
/*

I principali datatype in Javascript sono: 
1. String, serve ad indicare, messe sempre nelle virgolette, una sequenza di caratteri
2. Numeri, serve ad indicare, senza le virgolette, numeri interi o con la virgola (che viene scritta con il punto in Java) 
3. Booleani, serve ad indicare se qualcosa sia vero o falso a seconda di come lo vogliamo usare
4. Null, serve ad indicare appunto nulla 
5. Undefined, serve ad indicare quando un valore non ha niente, oppure non gli è stato dato niente come valore

*/


/* ESERCIZIO 2
 Crea una variable chiamata "myName" e assegna ad essa il tuo nome, sotto forma di stringa.
*/

/* --> */
let myName = 'Elena'; 
console.log (myName);

/* ESERCIZIO 3
 Scrivi il codice necessario ad effettuare un addizione (una somma) dei numeri 12 e 20.
*/

/* --> */
let numero1 = 12;
let numero2 = 20; 

console.log (numero1 + numero2 ); 


/* ESERCIZIO 4
 Crea una variable di nome "x" e assegna ad essa il numero 12.
*/

/* --> */

let x = 12; 

console.log (x);


/* ESERCIZIO 5
  Riassegna un nuovo valore alla variabile "myName" già esistente: il tuo cognome.
  Dimostra l'impossibilità di riassegnare un valore ad una variabile dichiarata con il costrutto const.
*/

/* Nel browser uscirà l'errore se tolgo i commenti */

myName = 'Kekic';
console.log (myName);

// const esercizio5 ='errore';
// esercizio5 = 'errore1';
// console.log (esercizio5);


/* ESERCIZIO 6
 Esegui una sottrazione tra i numeri 4 e la variable "x" appena dichiarata (che contiene il numero 12).
*/

/* --> */

numero1 = 12;
numero2 = 20;
let numero3 = 2; 
let numero4 =3; 

console.log (numero1 - numero2 - numero3 - numero4 - x );


/* ESERCIZIO 7
 Crea due variabili: "name1" e "name2". Assegna a name1 la stringa "john", e assegna a name2 la stringa "John" (con la J maiuscola!).
 Verifica che name1 sia diversa da name2 (suggerimento: è la stessa cosa di verificare che la loro uguaglianza sia falsa).
 EXTRA: verifica che la loro uguaglianza diventi true se entrambe vengono trasformate in lowercase (senza cambiare il valore di name2!).
*/

/* SCRIVI QUI LA TUA RISPOSTA */

let name1 = 'john'; 
let name2 ='John'; 
console.log (name1 == name2);

// EXTRA 

name2 = name2.toLowerCase();
console.log (name1===name2);

