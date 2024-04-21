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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val txtCanciones = resources.getStringArray(R.array.canciones)
        // Asigna los elementos del layout
        val spinner = findViewById<Spinner>(R.id.spinnerCanciones)
        val btnIr = findViewById<Button>(R.id.btn_ir)

        if(spinner != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, txtCanciones)
            spinner.adapter = adapter
        }

        btnIr.setOnClickListener {
            // Obtiene el valor seleccionado en el spinner
            val cancionElegida = spinner.selectedItem.toString()

            val intent = Intent(this, CancionElegida:: class.java)
            intent.putExtra("Valor", cancionElegida)
            startActivity(intent)
        }


    }
}