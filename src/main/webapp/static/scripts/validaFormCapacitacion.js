const rut = document.getElementById("rut");
const lugar = document.getElementById("lugar");
const dia = document.getElementById("dia");
const hora = document.getElementById("hora");
const duracion = document.getElementById("duracion");
const asistentes = document.getElementById("asistentes");

/*funciones llaman los diferentes tipos de validaciones segun el campo*/
function validaRut() {
    if (checkIsEmpty(rut, "El rut es obligatorio (*)")) return;
    if (!long(rut, 8, 10, "El rut ingresado es incorrecto")) return;
    return true;
}

function validaLugar() {
    if (checkIsEmpty(lugar, "Describa lugar de la capacitacion")) return;
}

function validaDia() {
    if (dia.value == "Seleccionar") {
        invalido(dia, "Seleccione dia de capacitacion");
    } else {
        valido(dia);
        return false;
    }
}

function validaHora() {
    if (checkIsEmpty(hora, "Ingrese horario")) return;
}

function validaDuracion() {
    if (cantidadRango(duracion, 10, 60)) return;
}

function validaAsistentes() {
    if (cantidadRango(asistentes, 10, 1000)) return;
}

/*confirma el campo vacio y delega mensaje correspondiente al error*/
function checkIsEmpty(campo, mensaje) {
    if (isEmpty(campo.value.trim())) {
        invalido(campo, mensaje);
        return true;
    } else {
        valido(campo);
        return false;
    }
}

/*valida si el campo es vacio*/
function isEmpty(campo) {
    if (campo == "") {
        return true;
    } else {
        return false;
    }
}

/*verifica el largo de caracteres de un campo*/
function long(campo, minLength, maxLength, mensaje) {
    if (campo.value.length >= minLength && campo.value.length <= maxLength) {
        valido(campo);
        return true;
    } else {
        invalido(campo, mensaje);
        return false;
    }
}

/*verifica que el valor corresponde al rango permitido*/
function cantidadRango(campo, min, max) {
    if (campo.value >= min && campo.value <= max) {
        valido(campo);
        return true;
    } else {
        invalido(campo, "Cantidad debe ser entre " + min + " y " + max);
        return false;
    }
}

/*funciones para manipular mensajes delegados en elementos html y estilos de las validaciones*/
function valido(campo) {

    campo.nextElementSibling.innerHTML = "";
}

function invalido(campo, mensaje) {

    campo.nextElementSibling.innerHTML = mensaje;
}