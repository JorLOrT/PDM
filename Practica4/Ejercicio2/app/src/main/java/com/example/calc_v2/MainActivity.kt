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

class MainActivity : AppCompatActivity() {

    var primerNumero: Double? = 0.0
    var segundoNumero: Double? = 0.0
    lateinit var result: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        result = findViewById<TextView>(R.id.resultado)

        findViewById<Button>(R.id.button8).setOnClickListener { verificar("+") }
        findViewById<Button>(R.id.button9).setOnClickListener { verificar("-") }
        findViewById<Button>(R.id.button10).setOnClickListener { verificar("*") }
        findViewById<Button>(R.id.button11).setOnClickListener { verificar("/") }

        if (savedInstanceState != null){
            result.text = savedInstanceState.getString("resultado", "")
        }


    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putString("resultado", result.text.toString())
        super.onSaveInstanceState(outState, outPersistentState)
    }


    fun verificar(operador: String){
        val primerNumeroText = findViewById<EditText>(R.id.primer_numero).text.toString()
        val segundoNumeroText = findViewById<EditText>(R.id.segundo_numero).text.toString()

        if (primerNumeroText.isNotEmpty()) {
            primerNumero = try {
                primerNumeroText.toDouble()
            } catch (e: NumberFormatException) {
                null
            }
        } else {
            Toast.makeText(applicationContext, "Ocurrió un error", Toast.LENGTH_SHORT).show()
        }
        if(segundoNumeroText.isNotEmpty() && primerNumero != null){
            segundoNumero = try{
                findViewById<EditText>(R.id.segundo_numero).text.toString().toDouble()
            }catch (e:NumberFormatException){
                null
            }

            if(segundoNumero != null){
                realizarOperacion(operador)
            }

        }
        segundoNumero = null
        primerNumero = null
    }

    private fun realizarOperacion(operador: String) {
        if (primerNumero != null && segundoNumero != null) {
            val resultado: Double = when (operador) {
                "+" -> primerNumero!! + segundoNumero!!
                "-" -> primerNumero!! - segundoNumero!!
                "*" -> primerNumero!! * segundoNumero!!
                "/" -> primerNumero!! / segundoNumero!!
                else -> 0.0
            }

            primerNumero = resultado
            actualizarResultado()
        }
    }

    private fun actualizarResultado() {
        if (primerNumero != null) {
            result.text = primerNumero.toString()
        } else {
            result.text = ""
        }
    }

}