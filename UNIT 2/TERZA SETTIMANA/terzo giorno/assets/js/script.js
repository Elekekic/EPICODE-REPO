 let containerCard = document.getElementById("containerCard"); 
let list = [];
let ripristinaLibri = [];


const readData = async () => {
    //metodo trovato guardando video yt
    try {
        let response = await fetch('https://striveschool-api.herokuapp.com/books');
        let data = await response.json();
        list = data; 
        /* console.log(list); funziona !! */
        stampa(data);
    } catch (err) {
        console.log('Errore nel recupero dei dati: ', err);
        /* funziona anche l'errore dato in console */
    }
}

/* funzione per stamparmi i vari libri con la card di bootstrap */
function stampa(list) {
    for (let i = 0; i < list.length; i++) {
        let card = document.createElement("div");
        card.classList.add("card");
        card.style.width = "14rem";
       /*  card.style.padding = "1rem"; */
        card.style.margin = "1rem";
        card.innerHTML = ` 
            <img src="${list[i].img}" class="card-img-top h-50">
            <div class="card-body d-flex flex-column"> 
                <h5 class="card-title">${list[i].title}</h5> 
                <p class="card-text bg-dark border rounded text-white text-center w-25">${list[i].category}</p>
                <p class="card-text fs-1">${list[i].price}&euro;</p>
                <a href="#" class="btn btn-success mt-4" id="buttonCompra">Compra ora</a>
                <a href="#" class="btn btn-danger mt-2" id="buttonScarta">Scarta</a>
            </div>`;

        containerCard.appendChild(card);
    }
}

readData(); 

let buttonScarta = document.getElementById("buttonScarta");
let buttonCompra = document.getElementById("buttonCompra");

function aggiornaInterfaccia() {
    containerCard.innerHTML = "";
    stampa(list);
}

containerCard.addEventListener("click", function(e) {
e.preventDefault();

    if (this.target.id === "buttonScarta") {
        const index = this.target.getAttribute("data-index");
        list.splice(index, 1);
        aggiornaInterfaccia();
    }
});