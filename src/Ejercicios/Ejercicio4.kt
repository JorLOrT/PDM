package Ejercicios

/*Ejercicio 4
    El objetivo del programa es realizar una calculadora básica que realice operaciones elementales elegidas desde un menú.
    Autor: Jorge Ortiz
    Fecha de creacion: 19/03
    Ultima modificacion: 24/03
 */

fun mostrarMenu(){
    println("==Menu==")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicacion")
    println("4. Division")
    println("5. Salir")
    println("\n Seleccione la operacion que desee realizar: ")
}

fun leerOpcion(): Int {
    var opcion: Int? = null
    //Se solicita el ingreso de la opcion
    while (opcion == null) {
        try {
            val input = readln().toInt()
            if (input in 1..5) {
                opcion = input
            } else {
                throw NumberFormatException("Opción no válida. Ingrese un número del 1 al 5.")
            }
        } catch (e: NumberFormatException) {
            println("Error: ${e.message}")
        }
    }

    return opcion
}

//Funcion para leer el numero.
fun leerNumero(): Double {
    var numero: Double? = null
    //Se solicita el ingreso de los numeros
    while (numero == null) {
        try {
            print("Ingrese un número: ")
            val input = readln().toDouble()
            numero = input
        } catch (e: NumberFormatException) {
            println("Error: ${e.message}")
        }
    }

    return numero
}

// Funcion para realizar la operacion matemática según la opcion elegida y la lista de numeros.
fun operar(opcion: Int, numeros: List<Double>): Double {
    return when (opcion) {
        1 -> numeros.sum()
        2 -> numeros.reduce { acc, d -> acc - d }
        3 -> numeros.reduce { acc, d -> acc * d }
        4 -> if (numeros.contains(0.0)) Double.NaN else numeros.reduce { acc, d -> acc / d }
        else -> 0.0
    }
}

//Funcion para conocer la cantidad de numeros a operar
fun leerNumeros(opcion: Int): List<Double> {
    val numeros = mutableListOf<Double>()
    // Si la opcion es una operacion binaria o con más de dos números, se lee la cantidad de números a operar.
    if (opcion in 1..4) {
        print("Ingrese la cantidad de números a operar (2 para operaciones binarias, más de 2 para operaciones con más de dos números): ")
        val cantidadNumeros = readln().toInt()
        // Se lee cada número y se agrega a la lista.
        for (i in 1..cantidadNumeros) {
            numeros.add(leerNumero())
        }
    }

    return numeros
}

//Funcion principal del programa
fun cuartoEjercicio() {
    println("\n Ejercicio 4: Calculadora Elemental")

    do {
        mostrarMenu()
        val opcion = leerOpcion()
        // Si la opción es 5, se cierra la calculadora.
        if (opcion == 5) {
            println("Cerrando calculadora.")
            break
        }

        val numeros = leerNumeros(opcion)

        val resultado = operar(opcion, numeros)
        // Se imprime el resultado de la operación según la opción elegida.
        when (opcion) {
            1 -> println("La suma de ${numeros.joinToString(" + ")} es: $resultado")
            2 -> println("La resta de ${numeros.joinToString(" - ")} es: $resultado")
            3 -> println("La multiplicación de ${numeros.joinToString(" * ")} es: $resultado")
            4 -> if (resultado.isNaN()) {
                println("No se puede dividir por cero.")
            } else {
                println("La división de ${numeros.joinToString(" / ")} es: $resultado")
            }
        }

    } while (true)
}

