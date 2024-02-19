/* mi servono: 
1 griglie di 10 righe e 9 colonne contenenti i div necessari (1 a 10,11 a 20,ecc..)
2 creare un button che generi numeri random (math random) tra 1 e 90 
3 evidenziare nella tombola il numero selezionato 
4 verificare che il numero estratto non sia già uscito 

quindi: 
tante function, if/else per verificare che i numeri estratti non si ripetano, if/else per dire che il numero estratto diventi colorato dietro, 
*/
const numeroPescato = document.getElementById("numeroPescato");
const tabella = document.getElementById("tabella");
const button = document.getElementById("button"); 
const NumeriEstratti = []; // per metterci i numeri pescati 
const NumeriUsati = []; // per metterci i numeri già pescati

window.addEventListener("load", Gioca); 


function Gioca() {
    for (let i = 1; i < 91; i++) {
        const div = document.createElement('div');
        const span = document.createElement('span');
        span.innerText = i;
        div.setAttribute("id", `numero-${i}`);
        div.classList.add("cella");
        div.appendChild(span);
        tabella.appendChild(div);
        NumeriEstratti.push(i);
    }
}

button.addEventListener('click', function() {
    pescaNumero();
});

function pescaNumero() {
    let coloraCasella = Math.floor((Math.random() * 90) + 1);
    console.log(coloraCasella);
    if (NumeriUsati.includes(coloraCasella)) {
        coloraCasellaNumero();
    } else {
        numerocoloraCasellato.innerText = `Numero estratto: ${coloraCasella}`;
        NumeriUsati.push(coloraCasella);
        colora(coloraCasella);
    }
}

function colora(coloraCasella) {
    const tabellone = document.querySelectorAll('.cella');
    for (let i = 0; i < tabellone.length; i++) {
        if (parseInt(tabellone[i].innerText) === coloraCasella) {
            tabellone[i].classList.add('numeroPescato');
        }
    }
}