package Ejercicios

/*Ejercicio 1
    El objetivo del programa es leer la puntuación del usuario y su salario mensual, calcular el dinero recibido y mostrar el nivel de rendimiento correspondiente.
    Autor: Jorge Ortiz
    Fecha de creacion: 17/03
    Ultima modificacion: 24/03
 */

fun leerPuntuacion(): Int {
    var puntuacion: Int? = null

    while (puntuacion == null) {
        try {
            // Se solicita al usuario que ingrese su puntuación
            print("Ingrese su puntuación (0-10): ")
            val input = readLine()!!.toInt()
            // Se valida la puntuación
            if (input in 0..10) {
                puntuacion = input
            } else {
                // Se muestra un mensaje de error si la puntuación no es válida
                throw NumberFormatException("La puntuación debe estar entre 0 y 10")
            }
        } catch (e: NumberFormatException) {
            // Se muestra un mensaje de error si se produce una excepción
            println("Error: ${e.message}")
        }
    }

    return puntuacion
}
// Función para leer el salario del usuario
fun leerSalario(): Double {
    var salario: Double? = null

    while (salario == null) {
        try {
            // Se solicita al usuario que ingrese su salario
            print("Ingrese su salario mensual: ")
            val input = readLine()!!.toDouble()
            // Se valida el salario
            if (input > 0) {
                salario = input
            } else {
                // Se muestra un mensaje de error si el salario no es válido
                throw NumberFormatException("El salario debe ser un número positivo")
            }
        } catch (e: NumberFormatException) {
            // Se muestra un mensaje de error si se produce una excepción
            println("Error: ${e.message}")
        }
    }

    return salario
}
// Función para obtener el nivel de rendimiento a partir de la puntuación
fun getNivelRendimiento(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Error: Puntuación no válida"
    }
}
// Función para calcular el dinero recibido a partir del salario y la puntuación
fun calcularDineroRecibido(salario: Double, puntuacion: Int): Double {
    return salario * (puntuacion / 10.0)
}

// Función principal del programa.
fun primerEjercicio(){
    // Se muestra elencabezado
    println("\n Ejercicio 1: Evaluacion Empleados")
    // Se lee la puntuación y el salario del usuario
    val puntuacion = leerPuntuacion()
    val salario = leerSalario()

    val nivelRendimiento = getNivelRendimiento(puntuacion)

    val dineroRecibido = calcularDineroRecibido(salario, puntuacion)
    // Se muestran los resultados
    println("Nivel de Rendimiento: $nivelRendimiento")
    println("Cantidad de Dinero Recibido: $dineroRecibido")
}