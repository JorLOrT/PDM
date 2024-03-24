package Ejercicios

fun menu(){
    println()
    println("===Menu===")
    println("1. Evaluacion empleados")
    println("2. Piedra, papel, tijera")
    println("3. Estadistica alumnos")
    println("4. Calculadora elemental")
    println("5. Adivina numero")
    println("0. Salir")
    println("\n Escriba el numero del ejercicio que desee ejecutar: ")
}

fun eleccionEjercicio(): Int{
    val eleccionMutable: Int
    //Se le pide al usuario que ingrese el ejercicio a realizar
    eleccionMutable = readln().toInt()
    if(eleccionMutable in 0 .. 5){
        when(eleccionMutable){
            //EJercicio 1: Evaluacion empleados
            1 ->     primerEjercicio()
            //Ejercicio 2: Piedra, papel, tijera
            2 ->     segundoEjercicio()
            //Ejercicio 3: Estadistica alumnos
            3 ->     tercerEjercicio()
            //Ejercicio 4: Calculadora elemental
            4 ->     cuartoEjercicio()
            //Ejercicio 5: Adivina numero
            5 ->     quintoEjercicio()
            //Salir
            0 ->     println("Saliendo del menu")
        }
    }
    else{
        throw NumberFormatException("Debe elegir un numero desde 0 hasta 5 incluido")
    }
    return eleccionMutable
}