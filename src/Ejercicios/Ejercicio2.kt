package Ejercicios

/*Ejercicio 2
    El objetivo del programa es jugar piedra papel o tijeras contra la computadora y determinar quien ganó.
    Autor: Jorge Ortiz
    Fecha de creacion: 19/03
    Ultima modificacion: 19/03
 */

fun generarEleccionComputadora(): String {
    val opciones = listOf("piedra", "papel", "tijera")
    return opciones.random()
}

fun leerEleccionUsuario(): String{
    val eleccionUsuario= readln().lowercase()
    return eleccionUsuario
}

fun determinarResultado(eleccionUsuario: String, eleccionComputadora: String): String {
    return when {
        eleccionUsuario == eleccionComputadora -> "Es un empate"
        (eleccionUsuario == "piedra" && eleccionComputadora == "tijera") ||
                (eleccionUsuario == "papel" && eleccionComputadora == "piedra") ||
                (eleccionUsuario == "tijera" && eleccionComputadora == "papel") -> "Ganaste"
        else -> "Perdiste"
    }
}