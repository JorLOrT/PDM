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

        val valor = intent.getStringExtra("Valor")
        val imagen = findViewById<ImageView>(R.id.imageView)

        val seleccionada = when(valor){
            "Gato" -> R.drawable.gato_lentes
            "Mapache" -> R.drawable.mapache
            "Perro" -> R.drawable.perro_lentes
            else -> R.drawable.gato_lentes
        }

        imagen.setImageResource(seleccionada)

        val btnVolver = findViewById<Button>(R.id.btn_volver)
        btnVolver.setOnClickListener {
            finish()
        }

    }
}