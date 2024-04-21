package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


/*
Autor: Jorge Ortiz
Fecha de creación: 21/04/2024
Fecha de ultima modificación: 21/04/2024
Interacción con Imágenes versión 2
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Extrae los textos de los strings
        val txtImagenes = resources.getStringArray(R.array.imagenes)
        // Asigna los elementos del layout
        val spinner = findViewById<Spinner>(R.id.spinnerImagenes)
        val btnIr = findViewById<Button>(R.id.btn_ir)

        // Comprobar si el spinner no es nulo antes de configurar el adaptador
        if(spinner != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, txtImagenes)
            spinner.adapter = adapter
        }

        btnIr.setOnClickListener {
            // Obtiene el valor seleccionado en el spinner
            val imagenElegida = spinner.selectedItem.toString()

            val intent = Intent(this, VentanaDos:: class.java)
            // Agregar el nombre de la imagen seleccionada como un extra al Intent
            intent.putExtra("Valor", imagenElegida)
            startActivity(intent)
        }

    }
}