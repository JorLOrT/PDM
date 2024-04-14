package com.example.imagentoast

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val imgC:ImageView = findViewById(R.id.mapache)
        imgC.setOnClickListener {
            Toast.makeText(applicationContext, "Pedro Mapache", Toast.LENGTH_SHORT).show()
        }
    }

}