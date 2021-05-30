//Recorremos los ejercicios y les aplicamos el evento
var ejercicios = document.querySelectorAll("#div-ejercicios-elegir > .item-ejercicio");
ejercicios.forEach(ejercicio => {
    ejercicio.addEventListener("click", seleccionarEjercicio);
});

//Input donde se guardará el valor
var nombre_ejercicio = document.querySelector("#nombre-ejercicio");

//Seleccionamos el ejercicio
function seleccionarEjercicio(e) {
    let ejercicio = e.target;
    nombre_ejercicio.value = ejercicio.getAttribute("name");
}