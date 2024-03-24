package Ejercicios

/*Ejercicio 2
    El objetivo del programa es jugar piedra papel o tijeras contra la computadora y determinar quien ganó.
    Autor: Jorge Ortiz
    Fecha de creacion: 19/03
    Ultima modificacion: 24/03
 */

// Función para generar una elección aleatoria para la computadora
fun generarEleccionComputadora(): String {
    val opciones = listOf("piedra", "papel", "tijera")
    return opciones.random()
}

// Función para leer la elección del usuario
fun leerEleccionUsuario(): String {
    var eleccionUsuario: String? = null

    while (eleccionUsuario == null) {
        // Se solicita al usuario que ingrese su elección
        print("Elige piedra, papel o tijera: ")
        val input = readLine()!!.lowercase()

        // Se valida la elección
        if (input in listOf("piedra", "papel", "tijera")) {
            eleccionUsuario = input
        } else {
            // Se muestra un mensaje de error si la elección no es válida
            println("Elección inválida. Por favor, elige piedra, papel o tijera.")
        }
    }

    return eleccionUsuario
}

// Función para determinar el resultado del juego
fun determinarResultado(eleccionUsuario: String, eleccionComputadora: String): String {
    return when {
        eleccionUsuario == eleccionComputadora -> "Es un empate"
        (eleccionUsuario == "piedra" && eleccionComputadora == "tijera") ||
                (eleccionUsuario == "papel" && eleccionComputadora == "piedra") ||
                (eleccionUsuario == "tijera" && eleccionComputadora == "papel") -> "Ganaste"
        else -> "Perdiste"
    }
}

// Función principal del programa
fun segundoEjercicio(){
    // Se muestra el encabezado
    println("\n Ejercicio 2: Piedra, Papel, Tijera")

    // Se genera la elección de la computadora
    val eleccionComputadora = generarEleccionComputadora()

    // Se lee la elección del usuario y se valida
    val eleccionUsuario = leerEleccionUsuario()

    // Se determina el resultado del juego
    val resultado = determinarResultado(eleccionUsuario, eleccionComputadora)

    // Se muestran los resultados
    println("La computadora eligió: $eleccionComputadora")
    println(resultado)
}