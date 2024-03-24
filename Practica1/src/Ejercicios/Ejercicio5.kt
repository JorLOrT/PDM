package Ejercicios

/*Ejercicio 5
    El objetivo del programa es jugar a adivinar el número en 5 intentos, mientras la máquina va dando pistas sobre el número a adivinar.
    Autor: Jorge Ortiz
    Fecha de creacion: 19/03
    Ultima modificacion: 24/03
 */

//Función para generar un número aleatorio entre 1 y 30
fun generarNumeroAleatorio(): Int {
    return (1..30).random()
}

//Función para pedir al usuario que introduzca un número.
fun pedirNumeroUsuario(): Int {
    var numero: Int? = null

    // Bucle para leer un número hasta que se introduzca un valor entero válido entre 1 y 30.
    while (numero == null) {
        print("Introduce un número (entre 1 y 30): ")
        try {
            val input = readln().toInt()
            if (input in 1..30) {
                numero = input
            } else {
                throw NumberFormatException("El número debe estar entre 1 y 30.")
            }
        } catch (e: NumberFormatException) {
            println("Error: ${e.message}")
        }
    }

    return numero
}

//Función para dar una pista al usuario sobre el número a adivinar.
fun darPista(numeroUsuario: Int, numeroAleatorio: Int) {
    if (numeroUsuario < numeroAleatorio) {
        println("El número a adivinar es mayor.")
    } else {
        println("El número a adivinar es menor.")
    }
}

//Funcion para mostrar un mensaje al usuario indicando si ha adivinado el número o no.
fun mostrarMensajeFinal(adivinado: Boolean, intentos: Int) {
    if (adivinado) {
        val intentosRestantes = 5 - intentos + 1
        println("Adivinaste el número en $intentosRestantes intentos.")
    } else {
        println("Te quedaste sin intentos.")
    }
}

//Funcion principal del programa.
fun quintoEjercicio() {
    println("\n Ejercicio 5: Adivina el Número")
    //Almacena el numero aleatorio
    val numeroAleatorio = generarNumeroAleatorio()
    //Inicializa los intentos
    var intentos = 5
    //Inicializa la variable que determina si se acerto  o no
    var adivinado = false

    while (intentos > 0 && !adivinado) {
        val numeroUsuario = pedirNumeroUsuario()
        //Si el numero introducido es correcto
        if (numeroUsuario == numeroAleatorio) {
            adivinado = true
        } else {
            //Restar un intento
            intentos--
            darPista(numeroUsuario, numeroAleatorio)
        }
    }
    //Llamado de la funcion mostrarMensajeFinal
    mostrarMensajeFinal(adivinado, intentos)
}