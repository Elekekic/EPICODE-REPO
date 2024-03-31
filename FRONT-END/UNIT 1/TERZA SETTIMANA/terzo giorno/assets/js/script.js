// mi vado a prendere l'input e lo chiamo in una variabile 
const newTaskInput = document.getElementById("new_task");

// mi vado a prendere la ul e la chiamo in una variabile 
const todoList = document.getElementById("todo_list");

// mi vado a prendere il button e lo chiamo in una variabile 
const button = document.getElementById("button");


// funzione dove metto dentro altre funzioni che mi serviranno al caricamento della pagina 
const init = () => {
    // button che al suo click mi andrà a mettere il valore dell'input nella lista
    button.addEventListener("click", aggiungiTask);

    //Ho messo questo giusto per non andare sempre a cliccare il button 
    newTaskInput.addEventListener("keypress", function (event) {
        // Verifica se il tasto premuto è il tasto "Invio" 
        if (event.key === "Enter") {
            aggiungiTask();
        }
    });

    // Ripristina la lista delle task salvata nel localStorage al caricamento della pagina
    ripristinaLista();
}

// la finestra ascolterà al suo caricamento la funzione init
window.addEventListener("load", init);


// funzione che se nell'input non scrivo niente, mi mette un alert 
// mentre, se scrivo qualcosa mi appende il suo valore nella ul come li. Rimettendo poi il valore all'input come stringa vuota 
const aggiungiTask = () => {
    if (newTaskInput.value === '') {
        alert('Inserisci una task :)');
    } else {
        let li = document.createElement("li");
        li.innerHTML =
            `<div class="task">
                <p id="task_name">
                    ${newTaskInput.value} 
                </p>
                <button class="delete">
                     <span class="material-symbols-outlined">
                         delete
                     </span>
                </button>
            </div>`;

        // appende la lista nella ul
        todoList.appendChild(li);
        // resetta il valore dell'input a vuoto
        newTaskInput.value = "";

        // richiamo la funzione per far si che al click del cestino, si eliminerà dalla ul 
        taskCompletata();
        // Aggiorna il localStorage con la lista delle task
        aggiornaLocalStorage();
    }
}


// funzione che mi permette di eliminare una task dalla lista
const taskCompletata = () => {

    //creo variabile che mi prende in una Nodelist tutti gli elementi con la classe "delete"
    let buttons = document.querySelectorAll(".delete");
    // per ogni button presente nella ul, se essa viene cliccata si eliminerà
    buttons.forEach(button => {
        button.addEventListener("click", function () {
            // "this" = button , "parentNode" = elemento padre del pulsante, cioè todoList (ul) 
            // "remove" = rimuove tutto il contenuto all'interno del div "task"
            this.parentNode.remove();
            // Aggiorna il localStorage dopo l'eliminazione di una task
            aggiornaLocalStorage();
        });
    });
}


// funzione che mi permette si salvare la lista attualmente presente nella ul nel LocalStorage
const aggiornaLocalStorage = () => {
    localStorage.setItem("todoList", todoList.innerHTML); // memorizza i dati con la chiave "todoList" e il contenuto HTML dell'elemento todoList
}

/* funzione che recupera i dati salvati precedentemente sopra. 
 Se nel localStorage è presente una lista delle task salvata precedentemente, 
 questa funzione imposta il contenuto HTML dell'elemento todoList con il contenuto
 recuperato dal localStorage, ripristinando così la lista delle task sulla pagina. 
 Poi, chiama anche la funzione TaskCompletata per aggiungere gli eventi al button con il cestino */

const ripristinaLista = () => {
    const lista = localStorage.getItem("todoList"); // Ottieni la lista delle task dal localStorage
    if (lista) {
        todoList.innerHTML = lista; // Ripristina la lista delle task dalla memoria locale
        taskCompletata(); // Aggiungi gli eventi ai pulsanti di eliminazione per le nuove task
    }
}



