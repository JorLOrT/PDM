package com.example.imagentoast
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


/*
Autor: Jorge Ortiz
Fecha de creación: 13/04/2024
Fecha de ultima modificación: 13/04/2024
Al hacer clic en la imagen aparece un Toast con un mensaje personalizado
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Se obtiene el id de la imagen
        val imgC:ImageView = findViewById(R.id.mapache)
        imgC.setOnClickListener {
            //Se crea el Toast
            Toast.makeText(applicationContext, "Pedro Mapache", Toast.LENGTH_SHORT).show()
        }
    }

}