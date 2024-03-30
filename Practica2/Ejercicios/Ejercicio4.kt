package Ejercicios

/*
    Ejercicio 4
    Figuras: Calcula el perimetro y area de la figura elegida
    Autor: Jorge Ortiz
    Fecha de creacion: 29/03
    Ultima modificacion: 30/03
 */

// Clase abstracta formas
abstract class Shape {
    abstract val area: Double
    abstract val perimeter: Double

    fun printResults() {
        println("Area: $area")
        println("Perimetro: $perimeter")
    }
}

// Sub clase cuadrado
class Square(private val side: Double) : Shape() {
    override val area: Double
        get() = side * side

    override val perimeter: Double
        get() = 4 * side
}

// Sub clase circulo
class Circle(private val radius: Double) : Shape() {
    override val area: Double
        get() = Math.PI * radius * radius

    override val perimeter: Double
        get() = 2 * Math.PI * radius
}

// Sub clase rectangulo
class Rectangle(private val length: Double, private val width: Double) : Shape() {
    override val area: Double
        get() = length * width

    override val perimeter: Double
        get() = 2 * (length + width)
}

fun cuartoEjercicio() {
    while (true) {
        println("\nElija la figura para la que desea calcular el área y perimetro:")
        println("1. Cuadrado")
        println("2. Círculo")
        println("3. Rectángulo")
        println("4. Salir")

        val option = readln().toIntOrNull()

        if (option == null) {
            println("Opción no valida. Debe ingresar un numero.")
            continue
        }

        when (option) {
            1 -> {
                println("Ingresa el valor del lado: ")
                val lado = readln().toDoubleOrNull()
                if (lado == null) {
                    println("Valor de lado no valido. Debe ingresar un numero.")
                    continue
                }
                val cuadrado = Square(lado)
                cuadrado.printResults()
            }
            2 -> {
                println("Ingresa el valor del radio: ")
                val radio = readln().toDoubleOrNull()
                if (radio == null) {
                    println("Valor de radio no valido. Debe ingresar un numero.")
                    continue
                }
                val circulo = Circle(radius = radio)
                circulo.printResults()
            }
            3 -> {
                println("Ingresa el valor del largo: ")
                val largo = readln().toDoubleOrNull()
                if (largo == null) {
                    println("Valor de largo no valido. Debe ingresar un numero.")
                    continue
                }
                println("Ingresa el valor del ancho: ")
                val ancho = readln().toDoubleOrNull()
                if (ancho == null) {
                    println("Valor de ancho no valido. Debe ingresar un numero.")
                    continue
                }
                val rectangulo = Rectangle(length = largo, width = ancho)
                rectangulo.printResults()
            }
            4 -> {
                println("Saliendo del programa.")
                break
            }
            else -> println("Opcion no valida. Intente nuevamente.")
        }
    }
}
