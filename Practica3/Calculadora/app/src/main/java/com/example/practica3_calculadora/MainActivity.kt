package com.example.practica3_calculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

/*
Autor: Jorge Ortiz
Fecha de creación: 13/04/2024
Fecha de ultima modificación: 13/04/2024
La aplicación es una calculadora Simple
 */

class MainActivity : AppCompatActivity() {

    val suma = "+"
    val resta = "-"
    val multiplicacion = "*"
    val division = "/"
    val porcentaje = "%"


    // Variable que almacena el operador actual seleccionado (+, -, *, /, %)
    var operacionActual = ""

    // Variables para almacenar el primer y segundo número ingresados
    var primerNumero: Double = Double.NaN
    var segundoNumero: Double = Double.NaN
    // Referencias a los TextViews para mostrar el número temporal y el resultado
    lateinit var tvTemp:TextView
    lateinit var tvResult:TextView

    // Formateador para mostrar números con decimales
    lateinit var formatoDecimal: DecimalFormat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Inicializar el formateador para los números
        formatoDecimal = DecimalFormat("#.#####")
        tvTemp = findViewById(R.id.tvTemp)
        tvResult = findViewById(R.id.tvResult)

    }

    // Maneja los clics en los botones de operadores (+, -, *, /, %)
    fun cambiarOperador(b: View){
        // Verificar si hay un número en tvTemp o existe un número previo
        if(tvTemp.text.toString().isNotEmpty() || primerNumero.toString() != "NaN"){
            calcular()
            val boton: Button = b as Button
            val operador = boton.text.toString().trim() // Convertir texto del botón a cadena y quitar espacios

            // Establecer la operación actual según el texto del botón (manejar casos especiales para dividir y multiplicar)
            operacionActual = when (operador) {
                "÷" -> "/"
                "X" -> "*"
                else -> operador
            }

            tvResult.text   = formatoDecimal.format(primerNumero) + operacionActual
            tvTemp.text = ""
        }
    }

    // Realiza el cálculo basado en la operación actual
    fun calcular(){
        try {
            // Verificar si hay un número previo
            if(primerNumero.toString()!= "NaN"){
                // Si el número temporal está vacío, usar el número del TextView de resultado
                if(tvTemp.text.toString().isEmpty()){
                    tvTemp.text = tvResult.text.toString()
                }
                segundoNumero = tvTemp.text.toString().toDouble()
                tvTemp.text = "" // Limpiar número temporal

                // Realizar cálculo basado en la operación actual
                when(operacionActual){
                    "+" -> primerNumero = (primerNumero + segundoNumero)
                    "-" -> primerNumero = (primerNumero - segundoNumero)
                    "*" -> primerNumero = (primerNumero * segundoNumero)
                    "/" -> primerNumero = (primerNumero / segundoNumero)
                    "%" -> primerNumero = (primerNumero % segundoNumero)
                }

            } else{
                // Si no hay número previo, usar el número temporal como primer número
                primerNumero = tvTemp.text.toString().toDouble()
            }
        }catch (e:Exception){}
    }

    // Maneja los clics en los botones borrar y limpiar
    fun borrar(b:View){
        val boton: Button = b as Button
        val textoBoton = boton.text.toString().trim()
        // Maneja el botón borrar (⌫)

        if(textoBoton == "⌫"){
            if(tvTemp.text.toString().isNotEmpty()){
                var datosActuales: CharSequence = tvTemp.text.toString()
                // Eliminar el último caracter del número temporal
                tvTemp.text = datosActuales.subSequence(0,datosActuales.length-1)
            }else{
                // Si el número temporal está vacío, reiniciar todo
                primerNumero = Double.NaN
                segundoNumero = Double.NaN
                tvTemp.text = ""
                tvResult.text = ""
            }
        }
        else if(textoBoton =="Clear"){
            // Manejar botón limpiar
            primerNumero = Double.NaN
            segundoNumero = Double.NaN
            tvTemp.text = ""
            tvResult.text = ""
        }
    }
    fun seleccionarNumero(b: View){
        val boton:Button = b as Button
        if(tvTemp.text.toString()=="0") tvTemp.text = ""
        tvTemp.text = tvTemp.text.toString() + boton.text.toString()
    }

    fun igual(b:View){
        calcular()
        tvResult.text = formatoDecimal.format(primerNumero)
        operacionActual = ""
    }

}