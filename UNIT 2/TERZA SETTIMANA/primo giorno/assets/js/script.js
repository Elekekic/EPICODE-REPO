class User {
    constructor(_firstName, _lastName, _age, _location) {
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.age = _age;
        this.location = _location;
    }

    comparaEta(user) {
        if (this.age > user.age) {
            console.log(`${this.firstName} è più vecchia di ${user.firstName}`);
        } else {
            console.log(`${user.firstName} è più vecchia di ${this.firstName}`);
        }
    }

}



const user1 = new User("Elena", "Kekic", "19", "Trieste");
console.log(user1);

const user2 = new User("Laura", "Kekic", "36", "Firenze");
console.log(user2);



user1.comparaEta(user2)

/* -------------------------------------------------------------- */

class Pet {
    constructor(_petName, _ownerName, _species, _breed) {
        this.petName = _petName;
        this.ownerName = _ownerName;
        this.species = _species;
        this.breed = _breed;
    }
    stessoPadrone(padrone1) {
        if (this.ownerName == padrone1.ownerName) {
            return true
        } else {
           return false
        }
    }

}



let button = document.getElementById("aggiungi");
let tbody = document.getElementById("result");


button.addEventListener("click", e => {
    e.preventDefault();

    let pet1 = new Pet(
        document.getElementById("petName1").value,
        document.getElementById("ownerName1").value,
        document.getElementById("species1").value,
        document.getElementById("breed1").value
    );

    let pet2 = new Pet(
        document.getElementById("petName2").value,
        document.getElementById("ownerName2").value,
        document.getElementById("species2").value,
        document.getElementById("breed2").value
    );

    stampaRisultato(pet1, pet2);

})

const stampaRisultato = (pet1, pet2) => {
    let cella = document.createElement('td');
    if (pet1.stessoPadrone(pet2)) {
        cella.innerText = `${pet1.petName} e ${pet2.petName} hanno lo stesso padrone`;

    } else {
        cella.innerText = `${pet1.petName} e ${pet2.petName} non hanno lo stesso padrone`;
    }
    tbody.appendChild(cella);
}
