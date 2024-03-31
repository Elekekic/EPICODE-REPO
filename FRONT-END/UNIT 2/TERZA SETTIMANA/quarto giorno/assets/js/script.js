/* deve prendere le foto mountains dall'API */
let btnLoad = document.getElementById('btnLoad');
/* Deve prendere le foto sunsets dall'API */
let btnSecondary = document.getElementById('btnSecondary');

let query = 'people';
let data = [];

let API_KEY = "TXAl4tsq0AH939vI13rKvpyMo7xSgfkSwtTUiEnLKjjvEI0zqABAVoL5";

/* endpoint c */
const baseURL = 'https://api.pexels.com/v1/search?query=';

/* mountains , sunsets */

const init = () => {
    research(query);
}

let inputBtn = document.getElementById('button-addon2');
let input = document.getElementById('input');



const research = async (query) => {
    try {
        let read = await fetch(baseURL + query, {
            method: 'GET',
            headers: {
                Authorization: API_KEY
            }
        }
        );
        data = await read.json();

    } catch (err) {
        console.log('Errore nel recupero dei dati: ', err);
        /* funziona anche l'errore dato in console */
    }

}

let container = document.querySelector('.innerCards');
const load = (queryUtente) => {
    container.innerHTML = ""; 
    query = queryUtente;
    research(query);
    stampaCard(query); 
}

inputBtn.addEventListener("click", function (e) {
    e.preventDefault();
    container.innerHTML = "";
    query = input.value;
    console.log(query);
    stampaCard();
});

const stampaCard = async () => {
    let divRow = document.createElement('div');
    divRow.setAttribute('class', 'row row-cols-4');
    try {
        await research(query); 

        data.photos.forEach((photo, i) => {
            let cardHTML = document.createElement('div');
            cardHTML.innerHTML = `
            <div class="">
                <div class="card mb-4 shadow-sm">
                    <img src="${data.photos[i].src.small}" class="bd-placeholder-img card-img-top" style="height: 28vh" />
                    <div class="card-body">
                        <h5 class="card-title">${photo.photographer}</h5>
                        <p class="card-text">${photo.photographer_url}</p>
                        <div class="d-flex justify-content-between align-items-center">
                            <div class="btn-group">
                                <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                            </div>
                            <small class="text-muted">${photo.id}</small>
                        </div>
                    </div>
                </div>
            </div>`;
            divRow.appendChild(cardHTML);

        });

        container.appendChild(divRow); // Aggiungi la riga al contenitore
    } catch (error) {
        console.error('Errore durante la stampa delle carte:', error);
    }
}

stampaCard();

addEventListener("load", init);

/* for (let i = 0; i < photos.length; i++) {
    let img = photos[i].src.original 
} */

