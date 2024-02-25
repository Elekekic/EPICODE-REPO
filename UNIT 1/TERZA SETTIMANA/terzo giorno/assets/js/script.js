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
    newTaskInput.addEventListener("keypress", function(event) {
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

        todoList.appendChild(li);
        newTaskInput.value = "";

        // richiamo la funzione per far si che ad ogni click del button con il cestino, si eliminerà dalla ul__
        taskCompletata();
        // Aggiorna il localStorage con la lista delle task
        aggiornaLocalStorage();
    }
}

const taskCompletata = () => {
    let buttons = document.querySelectorAll(".delete");
    buttons.forEach(button => {
        button.addEventListener("click", function () {
            this.parentNode.remove();
            // Aggiorna il localStorage dopo l'eliminazione di una task
            aggiornaLocalStorage();
        });
    });
}



const aggiornaLocalStorage = () => {
    localStorage.setItem("todoList", todoList.innerHTML); // Salva la lista delle task nel localStorage
}

const ripristinaLista = () => {
    const lista = localStorage.getItem("todoList"); // Ottieni la lista delle task dal localStorage
    if (lista) {
        todoList.innerHTML = lista; // Ripristina la lista delle task dalla memoria locale
        taskCompletata(); // Aggiungi gli eventi ai pulsanti di eliminazione per le nuove task
    }
}



