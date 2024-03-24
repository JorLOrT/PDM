
import Ejercicios.eleccionEjercicio
import Ejercicios.menu

fun main() {
    var eleccion:Int = 1
    do {
        try {
            menu()
            eleccion = eleccionEjercicio()
        }catch (e: NumberFormatException){
            println("Error: debe escribir un numero")
        }
    }
    while (eleccion!=0)
}
