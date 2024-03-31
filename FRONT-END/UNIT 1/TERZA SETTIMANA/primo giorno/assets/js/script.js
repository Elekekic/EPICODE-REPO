/* ESERCIZIO 1
       Scrivi una funzione per cambiare il titolo della pagina in qualcos'altro
    */

const changeTitle = () => {
    document.getElementsByTagName('h1')[0].innerText = 'COMPITO S3/D1'
}

changeTitle();


/* ESERCIZIO 2
 Scrivi una funzione per aggiungere al titolo della pagina una classe "myHeading"
*/

const addClassToTitle = () => {
    document.getElementsByTagName('h1')[0].className = "myHeading"
}
addClassToTitle();


/* ESERCIZIO 3
 Scrivi una funzione che cambi il testo dei p figli di un div
*/

const changePcontent = () => {
    let nuovoP = document.querySelectorAll('div p')
    for (let i = 0; i < nuovoP.length; i++) {
        nuovoP[i].innerText = 'ho cambiato tutti i p';
    }
}
changePcontent();


/* ESERCIZIO 4
 Scrivi una funzione che cambi la proprietà href di ogni 
 link (tranne quello nel footer) con il valore https://www.google.com
*/

const changeUrls = () => {
    const newLink = "https://www.google.com";
    document.querySelector('a').href = newLink;
    document.querySelectorAll(`footer a:not([href="${newLink}"])`);
    
}

changeUrls();


/* ESERCIZIO 5
 Scrivi una funzione che aggiunga un nuovo elemento lista alla seconda lista non ordinata
*/

const addToTheSecond = () => {
    let li = document.createElement('li');
    li.innerText = ('4rd (testo aggiunto)');
    let b = document.getElementById('secondList')
    b.appendChild(li);

};

addToTheSecond();

/* ESERCIZIO 6
 Scrivi una funzione che aggiunga un paragrafo al primo div
*/

const addParagraph = () => {
    document.querySelector('div').innerHTML += '<p> paragrafo aggiunto <p> '
}

addParagraph();


/* ESERCIZIO 7
 Scrivi una funzione che faccia scomparire la prima lista non ordinata
*/

const hideFirstUl = () => {
    const a = document.getElementById("firstList");
    a.setAttribute('style', 'display: none');

}

hideFirstUl();


/* ESERCIZIO 8 
 Scrivi una funzione che renda verde il background di ogni lista non ordinata
*/

const paintItGreen = () => {
    const element = document.getElementById("secondList");
    element.style.backgroundColor = "green";
}

paintItGreen();


/* ESERCIZIO 9
 Scrivi una funzione che rimuova l'ultima lettera dall'h1 ogni volta che l'utente lo clicca
*/

const makeItClickable = () => {
    const heading1 = document.getElementById("heading1");
    heading1.addEventListener("click", function () {
        const contenuto = heading1.textContent;
        heading1.textContent = contenuto.slice(0, -1);
    })

}

makeItClickable();

/* ESERCIZIO 10
 Crea una funzione che, al click sul footer, riveli l'URL del link interno come contenuto di un alert()
*/

const revealFooterLink = () => {
    let footerLink = document.getElementById('linkinterno');

    const alertLink = () => {
        alert(`https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Client-side_web_APIs/Manipulating_documents`);
    }

    footerLink.addEventListener('click', alertLink);
}

revealFooterLink();



/* ESERCIZIO 11
 Crea una funzione che crei una tabella nell'elemento con id "tableArea". 
 La tabella avrà 5 elementi e questa struttura: immagine, nome prodotto, 
 quantità, prezzo
*/
const tabella = document.getElementById("tableArea");

const generateTable = () => {
    const table = document.createElement("table");
    const tr = document.createElement("tr");

    const cella4 = document.createElement("th");
    cella4.innerText = ("Immagine ");
    const cella1 = document.createElement("th");
    cella1.innerText = ("Nome prodotto ");
    const cella2 = document.createElement("th");
    cella2.innerText = ("Quantità ");
    const cella3 = document.createElement("th");
    cella3.innerText = ("Prezzo ");



    table.appendChild(tr);

    tr.appendChild(cella4);
    tr.appendChild(cella1);
    tr.appendChild(cella2);
    tr.appendChild(cella3);

    tabella.appendChild(table);
}

generateTable();

/* ESERCIZIO 12
 Crea una funzione che aggiunga una riga alla tabella
  precedentemente creata e fornisca i dati necessari come parametri
*/

const addRow = () => {
    const tbody = document.createElement("tbody");

    const riga4 = document.createElement("td");
    const img = document.createElement("img");
    img.id = "img";
    img.src = "assets/img/iphone.avif";
    riga4.appendChild(img);
    const riga1 = document.createElement("td");
    riga1.innerText = ("Iphone 13")
    const riga2 = document.createElement("td");
    riga2.innerText = (" 245 pezzi")
    const riga3 = document.createElement("td");
    riga3.innerHTML = ("<p> 600 € <p>")

    tbody.appendChild(riga4);
    tbody.appendChild(riga1);
    tbody.appendChild(riga2);
    tbody.appendChild(riga3);

    tabella.appendChild(tbody);

}

addRow();

/* ESERCIZIO 14
Crea una funzione che nasconda le immagini della tabella quando eseguita
*/

/*const hideAllImages = () => {
    const img = document.getElementById("img");
    img.style.display = "none";
}

hideAllImages(); */

/* EXTRA ESERCIZIO 15
Crea una funzione che cambi il colore del h2 con id "changeMyColor" con un colore random ad ogni click ricevuto
*/

const changeColorWithRandom = () => {
    const h2 = document.getElementById("changeMyColori");

    const randomColor = () => {
        let lettere = ['0', '1', '2', '3' , '4', '5', '6' , '7', '8' , '9' , 'A', 'B', 'C', 'D', 'E', 'F'];
        let color = '#';

        for (let i = 0; i < 6; i++) {
            color += lettere[Math.floor(Math.random() * lettere.length)];
        }
        return color;

    }

    h2.addEventListener('click', function() {
        const getColor = randomColor(); 
        h2.style.color = getColor; 
    });
}

changeColorWithRandom(); 