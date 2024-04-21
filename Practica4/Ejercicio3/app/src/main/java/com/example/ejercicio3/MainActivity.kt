package com.example.ejercicio3

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    /*
    Autor: Jorge Ortiz
    Fecha de creación: 21/04/2024
    Fecha de ultima modificación: 21/04/2024
    Reproductor de Música versión 2
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val txtCanciones = resources.getStringArray(R.array.canciones)
        // Asigna los elementos del layout
        val spinner = findViewById<Spinner>(R.id.spinnerCanciones)
        val btnIr = findViewById<Button>(R.id.btn_ir)

        // Se comprueba si el Spinner no es nulo antes de configurar el adaptador
        if(spinner != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, txtCanciones)
            spinner.adapter = adapter
        }

        btnIr.setOnClickListener {
            // Obtiene el valor seleccionado en el spinner
            val cancionElegida = spinner.selectedItem.toString()

            val intent = Intent(this, CancionElegida:: class.java)
            // Se agrega el nombre de la canción seleccionada como un extra al Intent
            intent.putExtra("Valor", cancionElegida)
            startActivity(intent)
        }


    }
}