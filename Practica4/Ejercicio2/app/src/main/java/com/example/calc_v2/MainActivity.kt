package com.example.calc_v2

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.lang.NumberFormatException

/*
Autor: Jorge Ortiz
Fecha de creación: 21/04/2024
Fecha de ultima modificación: 21/04/2024
Calculadora versión 2
 */

class MainActivity : AppCompatActivity() {

    // Variables para almacenar los números (pueden ser nulos)
    var primerNumero: Double? = 0.0
    var segundoNumero: Double? = 0.0
    // Referencia al TextView que muestra el resultado
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Encontrar y asignar el TextView del resultado
        result = findViewById<TextView>(R.id.resultado)

        findViewById<Button>(R.id.button8).setOnClickListener { verificar("+") }
        findViewById<Button>(R.id.button9).setOnClickListener { verificar("-") }
        findViewById<Button>(R.id.button10).setOnClickListener { verificar("*") }
        findViewById<Button>(R.id.button11).setOnClickListener { verificar("/") }

        // Recuperar el estado del resultado si la actividad se recreó
        if (savedInstanceState != null){
            result.text = savedInstanceState.getString("resultado", "")
        }


    }
    // Guardar el texto del resultado
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putString("resultado", result.text.toString())
        super.onSaveInstanceState(outState, outPersistentState)
    }

    // Función para verificar la operación y realizar el cálculo
    fun verificar(operador: String){
        val primerNumeroText = findViewById<EditText>(R.id.primer_numero).text.toString()
        val segundoNumeroText = findViewById<EditText>(R.id.segundo_numero).text.toString()
        // Convertir el primer número a Double si es posible
        if (primerNumeroText.isNotEmpty()) {
            primerNumero = try {
                primerNumeroText.toDouble()
            } catch (e: NumberFormatException) {
                null
            }
        } else {
            // Mostrar un mensaje de error si el primer número está vacío
            Toast.makeText(applicationContext, "Ocurrió un error", Toast.LENGTH_SHORT).show()
        }
        // Convertir el segundo número a Double si es posible y si el primero ya se convirtió
        if(segundoNumeroText.isNotEmpty() && primerNumero != null){
            segundoNumero = try{
                findViewById<EditText>(R.id.segundo_numero).text.toString().toDouble()
            }catch (e:NumberFormatException){
                null
            }
            // Realizar la operación si ambos números son válidos
            if(segundoNumero != null){
                realizarOperacion(operador)
            }

        }
        // Limpiar las variables para la siguiente operación
        segundoNumero = null
        primerNumero = null
    }
    // Función para realizar la operación matemática según el operador
    private fun realizarOperacion(operador: String) {
        if (primerNumero != null && segundoNumero != null) {
            val resultado: Double = when (operador) {
                "+" -> primerNumero!! + segundoNumero!!
                "-" -> primerNumero!! - segundoNumero!!
                "*" -> primerNumero!! * segundoNumero!!
                "/" -> primerNumero!! / segundoNumero!!
                else -> 0.0
            }
            // Actualizar el primer número con el resultado para la siguiente operación
            primerNumero = resultado
            actualizarResultado()
        }
    }
    // Mostrar el resultado en el TextView si existe, sino dejarlo vacío
    private fun actualizarResultado() {
        if (primerNumero != null) {
            result.text = primerNumero.toString()
        } else {
            result.text = ""
        }
    }

}