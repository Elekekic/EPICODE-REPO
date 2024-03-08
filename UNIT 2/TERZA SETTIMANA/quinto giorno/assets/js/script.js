let baseURL = 'https://striveschool-api.herokuapp.com/api/product/';
let API_KEY = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWViMTliODJkN2IxMTAwMTkwZTc3MmEiLCJpYXQiOjE3MDk5MDYzNjAsImV4cCI6MTcxMTExNTk2MH0.9-L70LjfWKyObLgfGXgki_R8ZNINVwNH00qKduzgwM0";
let data = [];

function init() {
  addProduct();
  stampaCard();
}

const addProduct = async () => {
  try {
    let response = await fetch(baseURL, {
      method: 'GET',
      headers: {
        Authorization: API_KEY,
        'Content-Type': 'application/json'
      }
    });

    data = await response.json();
    console.log('Product added:', data);

  } catch (error) {
    console.log('Error adding product:', error);
  }
};

addProduct();



let box = document.getElementById('box');
const stampaCard = async () => {
  try {
    await addProduct();
    wait.style.display = 'none';

    data.forEach((item) => {
      box.innerHTML = `
          <div class="card" style="width: 18rem;">
            <img src=${item.imageUrl} class="card-img-top" alt="...">
               <div class="card-body">
                 <h5 class="card-title fs-4 mt-2">${item.name}</h5>
                 <p class="card-text">${item.description}</p>
                 <a href="https://" class="btn btn-info">Scopri di più </a>
                 <a href="#" class="btn btn-outline-dark">Modifica </a>
               </div>
           </div>`
    });
  } catch (error) {
    console.log('Errore durante la stampa delle carte:', error);
  }
}

stampaCard();

window.addEventListener('load', init);
