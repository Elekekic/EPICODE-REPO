/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/

/* --> */

console.log('ESERCIZIO 1');

let numero1 = 23
let numero2 = 12

let valutazione;

if (numero1 < numero2) {
  valutazione = numero2 + ' è maggiore';
} else if (numero2 < numero1) {
  valutazione = numero1 + ' è maggiore';
}

console.log(valutazione)



/* ESERCIZIO 2
  Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/

/* -> */
console.log('ESERCIZIO 2');

let n5 = 5;
let risultato;

if (n5 !== 5) {
  risultato = 'not equal'
}

console.log(risultato)


/* ESERCIZIO 3
  Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero 
  fornito è perfettamente divisibile per 5 (suggerimento: usa l'operatore modulo)
*/

/* -> */
console.log('ESERCIZIO 3');

let n6 = 25;
let resto = n6 % 5;

if (resto === 0) {
  resto = 'divisibile per 5'
}

console.log(resto)

/* ESERCIZIO 4
  Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la 
  loro addizione/sottrazione sia uguale a 8.
*/

/* -> */
console.log('ESERCIZIO 4');

let a = 6;
let b = 2;
let somma;

if (a === 8 || b === 8) {
  somma = "uno dei due numeri è uguale ad" + 8;
} else if (a + b === 8) {
  somma = "la somma è uguale ad " + 8;
} else {
  somma = "la sottrazione è uguale ad " + 8;
}
console.log(somma);


/* ESERCIZIO 5
  Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
  C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita 
  (altrimenti la spedizione ha un costo fisso pari a 10).
  Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/

/* -> */
console.log('ESERCIZIO 5');

let totalShoppingCart = 49;


if (totalShoppingCart > 50) {
  console.log('spedizione è gratuita quindi utente spende ' + totalShoppingCart);
} else {
  console.log("spedizione non gratuita, addebito all'utente per il checkout è di " + (totalShoppingCart + 10));
}

/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo,
  determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
*/

/* -> */
console.log('ESERCIZIO 6');

let blackFriday = 0.8;
let totalShoppingCart2 = 80 * blackFriday;
let spedizione2 = 10;

if (totalShoppingCart2 >= 50) {
  console.log("Costo dell'ordine è di " + totalShoppingCart2);
} else {
  console.log("Costo dell'ordine è di " + (totalShoppingCart2 + spedizione));
}


/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/

/* -> */
console.log('ESERCIZIO 7');

let el = 3;
let en = 4;
let aa = 5;

if (el > en) {
  if (aa > el) {
    console.log(aa + ', ' + el + ', ' + en);
  } else {
    if (aa > en) {
      console.log(el + ', ' + aa + ', ' + en);
    } else {
      console.log(el + ', ' + en + ', ' + aa);
    }
  }
} else {
  if (aa > en) {
    console.log(aa + ', ' + en + ', ' + el);
  } else {
    if (aa > el) {
      console.log(el + ', ' + aa + ', ' + en);
    } else {
      console.log(en + ', ' + el + ', ' + aa);
    }
  }
}


/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/

/* -> */
console.log('ESERCIZIO 8');

let n10 = 10;
console.log(typeof 10);

/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/

/* -> */
console.log('ESERCIZIO 9');

n6 = 26;
let resto1 = n6 % 2;

if (resto1 === 0) resto1 = 'pari'
else resto1 = 'dispari'


console.log(resto1);



/* ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
*/
console.log('ESERCIZIO 10');


let val = 7
if (val < 5) {
  console.log("Meno di 5");
} else if (val < 10) {
  console.log("tra 5 e 9");
} else {
  console.log("Uguale a 10 o maggiore");
}



/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/


/* -> */
console.log('ESERCIZIO 11');

const me = {
  name: 'John',
  lastName: 'Doe',
  skills: ['javascript', 'html', 'css'],
}

me.city = 'Toronto'

console.log(me);

/* ESERCIZIO 12
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
*/

/* -> */
console.log('ESERCIZIO 12');


delete me.lastName;

console.log(me);

/* ESERCIZIO 13
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi nel codice per rimuovere l'ultimo elemento della proprietà "skills".
*/

/* -> */
console.log('ESERCIZIO 13');

delete me.skills [2];
console.log(me);

/* ESERCIZIO 14
  Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
*/

/* -> */
console.log('ESERCIZIO 14');

const newArray = []
newArray.push(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

console.log(newArray);

/* ESERCIZIO 15
  Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
*/

/* -> */
console.log('ESERCIZIO 15');

newArray [9] = 100;
console.log (newArray);



