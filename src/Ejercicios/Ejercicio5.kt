package Ejercicios

/*Ejercicio 5
    El objetivo del programa es jugar a adivinar el número en 5 intentos, mientras la máquina va dando pistas sobre el número a adivinar.
    Autor: Jorge Ortiz
    Fecha de creacion: 19/03
    Ultima modificacion: 19/03
 */

fun generarNumeroAleatorio(): Int {
    return (1..30).random()
}

fun pedirNumeroUsuario(): Int {
    print("Introduce un número: ")
    return readln().toInt()
}

fun validarNumero(numero: Int): Boolean {
    return numero in 1..30
}

fun darPista(numeroUsuario: Int, numeroAleatorio: Int) {
    if (numeroUsuario < numeroAleatorio) {
        println("El número a adivinar es mayor.")
    } else {
        println("El número a adivinar es menor.")
    }
}

fun mostrarMensajeFinal(adivinado: Boolean, intentos: Int) {
    if (adivinado) {
        val intentosRestantes = 5 - intentos
        println("Adivinaste el número en $intentosRestantes intentos.")
    } else {
        println("Te quedaste sin intentos.")
    }
}