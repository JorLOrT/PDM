import Ejercicios.*
import java.util.*

fun main() {
    //EJercicio 1
    println("\n Ejercicio 1: Evaluacion Empleados")
    val puntuacion = leerPuntuacion()
    val salario = leerSalario()

    val nivelRendimiento = getNivelRendimiento(puntuacion)

    val dineroRecibido = calcularDineroRecibido(salario, puntuacion)

    println("Nivel de Rendimiento: $nivelRendimiento")
    println("Cantidad de Dinero Recibido: $dineroRecibido")

    //Ejercicio 2
    println("\n Ejercicio 2: Piedra, Papel, Tijera")
    val eleccionComputadora = generarEleccionComputadora()

    println("Elige piedra, papel o tijera:")
    val eleccionUsuario = leerEleccionUsuario()

    if (eleccionUsuario !in listOf("piedra", "papel", "tijera")) {
        println("Elección inválida. Por favor, elige piedra, papel o tijera.")
        return
    }

    val resultado = determinarResultado(eleccionUsuario, eleccionComputadora)

    println("La computadora eligió: $eleccionComputadora")
    println(resultado)

    //Ejercicio 3
    println("\n Ejercicio 3: Estadística Alumnos")
    println("Ingresa cuantos alumnos hay en el salon: ")
    val cantidadAlumnos: Int= readln().toInt()
    if (cantidadAlumnos > 0){
        val edades = LinkedList<Short>()
        var edadMaxima: Short = 0
        var edadMinima: Short = 200
        for (i in 1 .. cantidadAlumnos){
            print("Ingresa la edad del alumno: ")
            val edad: Short = readln().toShort()
            edadMaxima = encontrarEdadMaxima(edadMaxima, edad)
            edadMinima = encontrarEdadMinima(edadMinima, edad)
            edades.add(edad)
        }
        println("===EDADES===")
        println("Maximo: $edadMaxima")
        println("Minimo: $edadMinima")
        println("Todos: ")
        while (edades.isNotEmpty()){
            val edad = edades.poll()
            if(edades.isEmpty()){
                print(edad)
                break
            }
            print("$edad , ")
        }
        println()
    }
    else{
        println("La cantidad de alumnos debe ser positiva")
    }

    System.lineSeparator()
    //Ejercicio 4
    println("\n Ejercicio 4: Calculadora Elemental")

    do{
        try {
            mostrarMenu()
            val opcion = readln().toInt()
            var res: Double
            if(opcion in 1..4){
                res = operar(opcion)
                println("La respuesta es: $res")
            }
            else if(opcion == 5){
                println("Cerrando Calculadora")
                break
            }
            else{
                println("Opcion no valida, intenta de nuevo: ")
            }
        }catch (e: NumberFormatException) {
            println("Error: ${e.message}")
        }

    }while (true)

    //Ejercicio 5
    println("\n Ejercicio 5: Adivina el Numero")

    val numeroAleatorio = generarNumeroAleatorio()
    var intentos = 5
    var adivinado = false

    while (intentos > 0 && !adivinado) {
        val numeroUsuario = pedirNumeroUsuario()

        if (!validarNumero(numeroUsuario)) {
            println("El número debe estar entre 1 y 30.")
            continue
        }
        intentos--

        if (numeroUsuario == numeroAleatorio) {
            adivinado = true
        } else {
            darPista(numeroUsuario, numeroAleatorio)
        }
    }
    mostrarMensajeFinal(adivinado, intentos)


}
