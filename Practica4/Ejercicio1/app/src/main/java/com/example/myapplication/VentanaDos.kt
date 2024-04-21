package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class VentanaDos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ventana_dos)

        // Recuperar el valor de la imagen enviada desde la actividad anterior
        val valor = intent.getStringExtra("Valor")
        // Obtener la referencia a la imagen del layout
        val imagen = findViewById<ImageView>(R.id.imageView)

        // Seleccionar el recurso de imagen en base al nombre recibido
        val seleccionada = when(valor){
            "Gato" -> R.drawable.gato_lentes
            "Mapache" -> R.drawable.mapache
            "Perro" -> R.drawable.perro_lentes
            else -> R.drawable.gato_lentes
        }
        // Establecer la imagen en el ImageView
        imagen.setImageResource(seleccionada)

        val btnVolver = findViewById<Button>(R.id.btn_volver)
        btnVolver.setOnClickListener {
            // Finalizar la actividad actual
            finish()
        }

    }
}