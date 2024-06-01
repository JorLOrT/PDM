package com.example.practica6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class InfoFragment : Fragment(R.layout.fragment_info) {

    var nombre: String = "Juan"
    var edad: Int = 0
    var correo: String = "pepito@gmail.com"
    var imagen: String = "avatar_1"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments.let {bundle->
            nombre = bundle?.getString("nombre").toString()
            edad = bundle?.getInt("edad").toString().toInt()
            correo = bundle?.getString("correo").toString()
            imagen = bundle?.getString("imagen").toString()
        }

        val txtNombreU = view.findViewById<TextView>(R.id.txtNombreU)
        val txtEdadU = view.findViewById<TextView>(R.id.txtEdadU)
        val txtCorreo = view.findViewById<TextView>(R.id.txtCorreo)
        val imageView = view.findViewById<ImageView>(R.id.imageViewU)

        txtNombreU.text = nombre
        txtEdadU.text = "Edad: $edad"
        txtCorreo.text = "Correo: $correo"
        val eleccion = imagen
        when(eleccion){
            "avatar_1" -> imageView.setImageResource(R.drawable.avatar_1)
            "avatar_2" -> imageView.setImageResource(R.drawable.avatar_2)
            "avatar_3" -> imageView.setImageResource(R.drawable.avatar_3)
        }
    }
}