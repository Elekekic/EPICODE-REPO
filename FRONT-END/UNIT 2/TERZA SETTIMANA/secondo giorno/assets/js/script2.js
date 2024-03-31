// ternario
let timePassed = sessionStorage.getItem('seconds') ? parseInt(sessionStorage.getItem('seconds')) : 0;

const startTimer = () => {
    timePassed++;
    document.getElementById("contatore").innerText = timePassed + ' secondi di sessione aperta';
    sessionStorage.setItem('seconds', timePassed);

};

setInterval(startTimer, 1000);

function Previewspage() {
    window.location.href = "../index.html";
}
