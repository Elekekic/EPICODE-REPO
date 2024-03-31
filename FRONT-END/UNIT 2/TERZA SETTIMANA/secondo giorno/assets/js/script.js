let salva = document.getElementById("salva");
let elimina = document.getElementById("elimina");
let result = document.getElementById("result"); 
let nextPage = document.getElementById("Nextpage");


salva.addEventListener('click', function (e) {
    e.preventDefault();

    let inputValue = document.getElementById("exampleInputEmail1").value;
    localStorage.setItem("nome", inputValue);

    document.getElementById("exampleInputEmail1").value = "";

    result.innerHTML = `${inputValue}`; 
    
});


elimina.addEventListener('click', function (e) {
    e.preventDefault();

    localStorage.clear();
    result.innerHTML =""; 

})


function Nextpage() {

    window.location.href = "../secondPage.html"; 
}


