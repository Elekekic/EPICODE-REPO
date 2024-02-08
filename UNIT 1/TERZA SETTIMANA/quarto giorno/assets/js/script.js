// Genera<ione della griglia 
// mettiamo il giorno
const now = new Date();
const getMonth = now.getMonth(); // variabile che verrà usata più di uan volta (globale) 
// console.log(now); // se l'è presa 

const appointments = []; // mi creo il mio array per adesso vuoto

//Devo mettermi io i mesi per evitare che escano in inglese, l'oggetto Date() restituisce il numero del mese da 0 a 11.
const monthNames = [
    'Gennaio',
    'Febbraio',
    'Marzo',
    'Aprile',
    'Maggio',
    'Giugno',
    'Luglio',
    'Agosto',
    'Settembre',
    'Ottobre',
    'Novembre',
    'Dicembre'
];

// Scriviamo il nome del mese nell'h1 dell'HTML 

const printCurrentMonthInH1 = () => {
    const title = document.querySelector('h1');
    const currentMonth = monthNames[getMonth]; // con il numero trovato sopra pesco nel mio array il mese corrispondetne
    title.innerText = currentMonth;
}

printCurrentMonthInH1();

// Dobbiamo calcolare il numero dei giorni del mese trovato, per genferare la griglia dell'array 
// primo giorno del mese successivo al mese trovato e poi ottenere il giorno prima che sarà l'ultimo giorno del mese in corso
// il numero dell'ultimo giorno del mese in corso corrisponderà al numero di giorno totali

const dayInThisMonth = () => {
    const lastDayInTheMonth = new Date(getYear, getMonth + 1, 0)// il primo è l'anno, il secondo è il mese, il terzo è il giorno; (2024, marzo +1,0);
    // scrivendo 0 vado a prendere l'ultimo giorno del mese prima, non il giorno 0 del mese corrente
    const numberOfTheDay = lastDayInTheMonth.getDate();
    return numberOfTheDay;
}

dayInThisMonth();

// Ho bisogno di eliminare la classe selected, se presente, altrimenti quando clicco su un giorno, il giorno precedente rimane selezionato
const unSelectAllDay = () => {
    const previousSelected = document.querySelector('.selected');
    if (previousSelected) {
        previousSelected.classList.remove('selected');
    }
}


// Funzione per gestire la sezione meetingday
const changeMeetingDaySection = (indexOfTheDay) => {
    const rightSpan = document.getElementById('newMeetingDay');
    rightSpan.classList.add('hasDay');
    rightSpan.innerText = indexOfTheDay + 1;
}


const createDays = (numberOfDays) => {
    const calendarDiv = document.getElementById('calendar');
    // Ciclando il numero di giorni creo e appendo i div corrispondenti al numero di giorni nel contenitore padre calendar
    for (let i = 0; i < numberOfDays; i++) {
        const dayCellDiv = document.createElement('div');
        dayCellDiv.classList.add('day');
        // Rendiamo il div del giorno cliccabile
        dayCellDiv.addEventListener('click', function () {
            unSelectAllDays();
            dayCellDiv.classList.add('selected');
            // adesso deve comparire la sezione meetingday, con gli eventuali impegni del giorno
            changeMeetingDaySection(i);
        });
    }
}