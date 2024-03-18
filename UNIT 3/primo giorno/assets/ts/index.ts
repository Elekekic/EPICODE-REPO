// variabili globali
let inizioChiamataBtn = document.getElementById('inizioChiamataBtn') as HTMLElement | null
let creditoresiduoBtn = document.getElementById('creditoresiduoBtn') as HTMLElement | null
let fineChiamataBtn = document.getElementById('fineChiamataBtn') as HTMLElement | null
let azzerraChiamataBtn = document.getElementById('azzerraChiamataBtn') as HTMLElement | null 
let minutiTrascorsi: number; 
let interval:number = setInterval(() => this.sottraiCredito(), 1000);


//interface
interface Smartphone {
    credito: number; // credito residuo della SIM 
    numeroChiamate: number; // rappresenta il numero minuti di chiamate effetuati
    nome: string; // nome user
    cognome: string; // cognome user
    costo: number; // 0.20€ che vengono sotratti a ogni minuto
}


//classe
class User implements Smartphone {
    credito: number;
    numeroChiamate: number;
    nome: string;
    cognome: string;
    costo: number = 0.20;
  

    //constuctor
    constructor(_credito: number, _numeroChiamate: number, _nome: string, _cognome: string, _costo: number,) {
        this.credito = _credito;
        this.numeroChiamate = _numeroChiamate;
        this.nome = _nome;
        this.cognome = _cognome;
        this.costo = _costo;
    }

    // metodo per ricarica 
    ricarica(aggiungiCredito: number) {
        this.credito += aggiungiCredito;
        console.log(`Ricarica effetuata! Il suo credito è di ${this.credito}`);
    }

     // metodo per chiamata
     inizioChiamata() {
        interval;
        return console.log("Chiamata avviata!");
    }

    fineChiamata() {
        clearInterval(interval);
        return console.log("Chiamata terminata!");
    }

    sottraiCredito() {
        if (this.credito >= this.costo) {
            this.credito -= this.costo;
            console.log(`0.20€ sono stati sottratti dal credito`);
        } else {
            console.log("Credito insufficiente, si prega di fare una ricarica prima di chiamare");
            this.fineChiamata();
        }
    }

     // metodo per chiamata404
    chiamata404() {
            console.log(`Il suo credito residuo è di ${this.credito.toFixed(2)}€}`) // toFixed mi da due cifre decimali
        }


     // metodo per getNumeroChiamate
   /*  getNumeroChiamate() {
        return
    } */


     // metodo per azzerraChiamate
   /*  azzerraChiamate() {
        this.numeroChiamate = 0
        return console.log(`Le chiamate sono state azzerrate con successo!`)
    } */
}


inizioChiamataBtn?.addEventListener('click', () => persona1.inizioChiamata());
    fineChiamataBtn?.addEventListener('click', () => persona1.fineChiamata());

    const persona1 = new User(100, 0, "Elena", "Kekic", 0.20);
    console.log(persona1);