package Ejercicios

fun menu(){
    println()
    println("===Menu===")
    println("1. Cuenta bancaria")
    println("2. Producto y descuento")
    println("3. Sistema de gestión de empleados")
    println("4. Figuras")
    println("5. Sistema de gestión de biblioteca")
    println("6. Sistema de alquiler de vehículos")
    println("0. Salir")
    println("\n Escriba el numero del ejercicio que desee ejecutar: ")
}

fun eleccionEjercicio(): Int{
    val eleccionMutable: Int
    //Se le pide al usuario que ingrese el ejercicio a realizar
    eleccionMutable = readln().toInt()
    if(eleccionMutable in 0 .. 5){
        when(eleccionMutable){
            //EJercicio 1: Cuenta bancaria
            1 ->     primerEjercicio()
            //Ejercicio 2: Producto y descuento
            2 ->     segundoEjercicio()
            //Ejercicio 3: Sistema de gestión de empleados
            3 ->     tercerEJercicio()
            //Ejercicio 4: Figuras
            4 ->     cuartoEjercicio()
            //Ejercicio 5: Sistema de gestión de biblioteca
            //5 ->     quintoEjercicio()
            //Ejercicio 6: Sistema de alquiler de vehículoso
            //6 ->     sextoEjercicio()
            //Salir
            0 ->     println("Saliendo del menu")
        }
    }
    else{
        throw NumberFormatException("Debe elegir un numero desde 0 hasta 5 incluido")
    }
    return eleccionMutable
}