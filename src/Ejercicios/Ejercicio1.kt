package Ejercicios

/*Ejercicio 1
    El objetivo del programa es leer la puntuación del usuario y su salario mensual, calcular el dinero recibido y mostrar el nivel de rendimiento correspondiente.
    Autor: Jorge Ortiz
    Fecha de creacion: 17/03
    Ultima modificacion: 17/03
 */

fun leerPuntuacion(): Int {
    var puntuacion: Int? = null

    while (puntuacion == null) {
        try {
            print("Ingrese su puntuación (0-10): ")
            val input = readLine()!!.toInt()

            if (input in 0..10) {
                puntuacion = input
            } else {
                throw NumberFormatException("La puntuación debe estar entre 0 y 10")
            }
        } catch (e: NumberFormatException) {
            println("Error: ${e.message}")
        }
    }

    return puntuacion
}

fun leerSalario(): Double {
    var salario: Double? = null

    while (salario == null) {
        try {
            print("Ingrese su salario mensual: ")
            val input = readLine()!!.toDouble()

            if (input > 0) {
                salario = input
            } else {
                throw NumberFormatException("El salario debe ser un número positivo")
            }
        } catch (e: NumberFormatException) {
            println("Error: ${e.message}")
        }
    }

    return salario
}

fun getNivelRendimiento(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Error: Puntuación no válida"
    }
}

fun calcularDineroRecibido(salario: Double, puntuacion: Int): Double {
    return salario * (puntuacion / 10.0)
}
