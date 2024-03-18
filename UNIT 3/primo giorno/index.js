var _this = this;
// variabili globali
var inizioChiamataBtn = document.getElementById('inizioChiamataBtn');
var creditoresiduoBtn = document.getElementById('creditoresiduoBtn');
var fineChiamataBtn = document.getElementById('fineChiamataBtn');
var azzerraChiamataBtn = document.getElementById('azzerraChiamataBtn');
var minutiTrascorsi;
var interval = setInterval(function () { return _this.inizioChiamata(); }, 1000);
//classe
var User = /** @class */ (function () {
    //constuctor
    function User(_credito, _numeroChiamate, _nome, _cognome, _costo) {
        this.costo = 0.20;
        this.credito = _credito;
        this.numeroChiamate = _numeroChiamate;
        this.nome = _nome;
        this.cognome = _cognome;
        this.costo = _costo;
    }
    // metodo per ricarica 
    User.prototype.ricarica = function (aggiungiCredito) {
        this.credito += aggiungiCredito;
        console.log("Ricarica effetuata! Il suo credito \u00E8 di ".concat(this.credito));
    };
    // metodo per chiamata
    User.prototype.inizioChiamata = function () {
        interval;
        return console.log("Chiamata avviata!");
    };
    User.prototype.fineChiamata = function () {
        clearInterval(interval);
        return console.log("Chiamata terminata!");
    };
    User.prototype.sottraiCredito = function () {
        if (this.credito >= this.costo) {
            this.credito -= this.costo;
            console.log("0.20\u20AC sono stati sottratti dal credito");
        }
        else {
            console.log("Credito insufficiente, si prega di fare una ricarica prima di chiamare");
            this.fineChiamata();
        }
    };
    // metodo per chiamata404
    User.prototype.chiamata404 = function () {
        console.log("Il suo credito residuo \u00E8 di ".concat(this.credito.toFixed(2), "\u20AC}")); // toFixed mi da due cifre decimali
    };
    return User;
}());
inizioChiamataBtn === null || inizioChiamataBtn === void 0 ? void 0 : inizioChiamataBtn.addEventListener('click', function () { return persona1.inizioChiamata(); });
fineChiamataBtn === null || fineChiamataBtn === void 0 ? void 0 : fineChiamataBtn.addEventListener('click', function () { return persona1.fineChiamata(); });
var persona1 = new User(100, 0, "Elena", "Kekic", 0.20);
console.log(persona1);
