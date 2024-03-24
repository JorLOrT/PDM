package Ejercicios

import java.util.*

/*Ejercicio 3
    El objetivo del programa es encontrar a los alumnos de mayor y menor edad. Luego imprimir esas edad y las del resto de alumnos.
    Autor: Jorge Ortiz
    Fecha de creacion: 19/03
    Ultima modificacion: 24/03
 */
fun encontrarEdadMaxima(edadMaxima: Short, edad: Short): Short{
    if(edadMaxima < edad){
        return edad
    }
    return edadMaxima
}

fun encontrarEdadMinima(edadMinima: Short, edad: Short): Short{
    if(edadMinima > edad){
        return edad
    }
    return edadMinima
}
// Función para leer la edad de un alumno.
fun leerEdadAlumno(): Short {
    var edad: Short? = null

    while (edad == null) {
        try {
            print("Ingresa la edad del alumno: ")
            val input = readln().toShort()
            // Valida que la edad sea un número entero positivo.
            if (input > 0) {
                edad = input
            } else {
                // Se muestra un mensaje de error si la edad no es válida
                throw NumberFormatException("La edad debe ser un número positivo")
            }
        } catch (e: NumberFormatException) {
            println("Error: ${e.message}")
        }
    }

    return edad
}

// Función principal del programa.
fun tercerEjercicio() {
    println("\n Ejercicio 3: Estadística Alumnos")

    // Se solicita la cantidad de alumnos
    print("Ingresa cuantos alumnos hay en el salon: ")
    var cantidadAlumnos: Int? = null

    while (cantidadAlumnos == null) {
        try {
            val input = readln().toInt()

            if (input > 0) {
                cantidadAlumnos = input
            } else {
                throw NumberFormatException("La cantidad de alumnos debe ser un número positivo")
            }
        } catch (e: NumberFormatException) {
            println("Error: vuelve a ingresar cuantos alumnos hay en el salon ")
        }
    }

    // Se crea una lista para almacenar las edades
    val edades = LinkedList<Short>()

    // Se inicializan las variables de edad máxima y mínima
    var edadMaxima: Short = 0
    var edadMinima: Short = 200

    // Se lee la edad de cada alumno
    for (i in 1..cantidadAlumnos) {
        val edad = leerEdadAlumno()

        // Se actualiza la edad máxima y mínima
        edadMaxima = encontrarEdadMaxima(edadMaxima, edad)
        edadMinima = encontrarEdadMinima(edadMinima, edad)

        // Se agrega la edad a la lista
        edades.add(edad)
    }

    // Se imprime la información de las edades
    println("===EDADES===")
    println("Máximo: $edadMaxima")
    println("Mínimo: $edadMinima")
    println("Todas: ")

    // Se imprime cada edad de la lista
    while (edades.isNotEmpty()) {
        val edad = edades.poll()
        if (edades.isEmpty()) {
            print(edad)
            break
        }
        print("$edad, ")
    }

    println()
}