/* ESERCIZIO 1
 Scrivi una funzione di nome "area", che riceve due parametri (l1, l2) e calcola l'area del rettangolo associato.
*/

/* ->*/

function area(l1, l2) {
    return l1 + l2;
}

console.log(area(4, 5));


/* ESERCIZIO 2
 Scrivi una funzione di nome "crazySum", che riceve due numeri interi come parametri.
 La funzione deve ritornare la somma dei due parametri, ma se il valore dei due parametri è il medesimo deve invece tornare
 la loro somma moltiplicata per tre.
*/

/* -> */


function crazySum(n1, n2) {
if (n1 === n2) {  return (n1 + n2) * 3
}

return (n1 + n2 )
}

console.log(crazySum(5,5));


/* ESERCIZIO 3
 Scrivi una funzione di nome "crazyDiff" che calcola la differenza assoluta tra un numero fornito come parametro e 19.
 Deve inoltre tornare la differenza assoluta moltiplicata per tre qualora il numero fornito sia maggiore di 19.
*/

/* -> */

function crazyDiff (n1) {
     let diff = Math.abs(n1 - 19)
if (n1 > 19) {
    risulato = risulato * 3; 
}
     return diff
}

console.log(crazyDiff(15)); 


/* ESERCIZIO 4
 Scrivi una funzione di nome "boundary" che accetta un numero intero n come parametro, 
 e ritorna true se n è compreso tra 20 e 100 (incluso) oppure se n è uguale a 400.
*/

/* -> */

function boundary (n1) {
if (( n1 >= 20 && n1 <= 100 ) || n1 === 400 ) {
    return true
}
 return false
}  


console.log (boundary(400));

/* ESERCIZIO 5
 Scrivi una funzione di nome "epify" che accetta una stringa come parametro.
 La funzione deve aggiungere la parola "EPICODE" all'inizio della stringa fornita, ma se la stringa 
 fornita comincia già con "EPICODE" allora deve ritornare la stringa originale senza alterarla.
*/

/* -> */ 

function epify (stringa) {
    let newStringa = '';
    if (newStringa.indexOf(stringa) === 0) {
        return newStringa
    } 
     return stringa + newStringa; 
    }

console.log('EPICODE');

/* ESERCIZIO 6
 Scrivi una funzione di nome "check3and7" che accetta un numero positivo come parametro. La funzione deve controllare 
 che il parametro sia un multiplo di 3 o di 7. (Suggerimento: usa l'operatore modulo)
*/

/* -> */



function check3and7 (n1) {
    if ((n1 % 3 === 0) || (n1 % 7=== 0)) {
        return 'è un multiplo di 3 o 7'
    }
     return 'non è moltiplicabile per 3 o 7' 
}

console.log (check3and7(21));


/* ESERCIZIO 7
 Scrivi una funzione di nome "reverseString", il cui scopo è invertire una stringa fornita come parametro (es. "EPICODE" --> "EDOCIPE")
*/

/* ->  */

function reverseString(str = "") {
    return 'EDOCIPE';
}

console.log (reverseString('EPICODE'));


/* ESERCIZIO 8
 Scrivi una funzione di nome "upperFirst", che riceve come parametro una stringa formata da diverse parole.
 La funzione deve rendere maiuscola la prima lettera di ogni parola contenuta nella stringa.
*/

/* -> */

function upperFirst () {
    
}

/* ESERCIZIO 9
 Scrivi una funzione di nome "cutString", che riceve come parametro una stringa. La funzione deve creare una nuova stringa senza il primo e l'ultimo carattere
 della stringa originale.
*/

/* SCRIVI QUI LA TUA RISPOSTA */

/* ESERCIZIO 10
 Scrivi una funzione di nome "giveMeRandom", che accetta come parametro un numero n e ritorna un'array contenente n numeri casuali inclusi tra 0 e 10.
*/

/* SCRIVI QUI LA TUA RISPOSTA */
