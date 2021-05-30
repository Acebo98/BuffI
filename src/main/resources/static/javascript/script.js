window.onload = function() {
    var nombre_ejercicio = document.querySelector("#nombre-ejercicio");
    nombre_ejercicio.value = "Otros"; //Otros seleccionado al principio
}

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

    //Cambiamos el estado de isSelected
    ejercicios.forEach(ejer => {
        if (ejer.getAttribute("name") == nombre_ejercicio.value) {
            ejer.setAttribute("isSelected", true);
        } else {
            ejer.setAttribute("isSelected", false);
        }
    });
}