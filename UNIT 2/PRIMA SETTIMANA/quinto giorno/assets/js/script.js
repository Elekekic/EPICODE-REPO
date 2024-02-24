const navChange = document.getElementById('nav'); 
const buttonChange = document.getElementById('buttons'); 
const lettereM = document.querySelectorAll('#lettere > g'); 
const M = document.getElementById('M > g'); 
console.log(M);
console.log(lettereM.length);


/* lettereM.forEach((gElement, i) => {
    setTimeout(() => {
        gElement.style.fill = 'transparent';
    }, i * 400); 
}); */

/* lettereM.forEach(function(lettera) {
    setInterval(function() {
        alternareVisibilita(lettera);
    }, 200);
});
 */



for (let i = 0; i < lettereM.length; i++ ) {

let numeroRandom = Math.floor(Math.random() * lettereM.length); 

 lettereM[numeroRandom]
 setTimeout(() => {
    alternareVisibilita(lettereM[numeroRandom])
}, i * 10);

}

window.addEventListener('scroll', function() {
    const scrollVerticale = window.scrollY; 

    const scrollIntercettazione = 439; 


    if (scrollVerticale > scrollIntercettazione) {
     navChange.style.backgroundColor = 'white';
     buttonChange.style.backgroundColor ="#1a8917"
    } else {
       navChange.style.backgroundColor = '';  
       buttonChange.style.backgroundColor = ''; 
    }
    window.addEventListener('beforeunload', () => {
        window.scrollTo(0, 0);
        });
}); 


function alternareVisibilita(lettera) {
    if (lettera.style.fill === 'black') {
        lettera.style.fill = 'transparent';
    } else {
        lettera.style.fill = 'black';
    }
}






