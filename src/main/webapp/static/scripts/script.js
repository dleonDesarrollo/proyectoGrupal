const title = document.getElementById("titulo");
const detalle = document.getElementById("detalle");

/* Funciones que manejan el despligue de diferentes pop-ups*/


function toggle() {
    let popup = document.getElementById("popup");
    popup.classList.toggle("active");
}


function showInfo(texto) {
    detalle.innerHTML = texto;
    let popupDetalle = document.getElementById("popup__detalle");
    popupDetalle.classList.add("active");
}

function cerrarVentana() {
    let popupDetalle = document.getElementById("popup__detalle");
    popupDetalle.classList.remove("active");
}