package Ejercicios

/*Ejercicio 3
    El objetivo del programa es encontrar a los alumnos de mayor y menor edad. Luego imprimir esas edad y las del resto de alumnos.
    Autor: Jorge Ortiz
    Fecha de creacion: 19/03
    Ultima modificacion: 19/03
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