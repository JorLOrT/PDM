package Ejercicios

/*Ejercicio 4
    El objetivo del programa es realizar una calculadora básica que realice operaciones elementales elegidas desde un menú.
    Autor: Jorge Ortiz
    Fecha de creacion: 19/03
    Ultima modificacion: 19/03
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

fun operar(opcion:Int):Double{
    println("Ingresa el numero que deseas operar: ")
    val numeroIngresado1 = readln().toDouble()
    println("Ingresa el numero que deseas operar: ")
    var numeroIngresado2 = readln().toDouble()
    while (opcion == 4 && numeroIngresado2 == 0.0){
        println("No se puede dividir entre cero, ingresa otro numero: ")
        numeroIngresado2 = readln().toDouble()
    }
    when(opcion){
        1 -> return numeroIngresado1 + numeroIngresado2
        2 -> return numeroIngresado1 - numeroIngresado2
        3 -> return numeroIngresado1 * numeroIngresado2
        4 -> return numeroIngresado1 / numeroIngresado2
    }
    return 0.0
}
