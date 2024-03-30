import Ejercicios.eleccionEjercicio
import Ejercicios.menu

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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