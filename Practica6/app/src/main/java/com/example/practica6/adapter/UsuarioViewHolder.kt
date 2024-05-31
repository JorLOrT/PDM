package com.example.practica6.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practica6.R
import com.example.practica6.Usuario

class UsuarioViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val viewNombre = itemView.findViewById<TextView>(R.id.txtNombre)
    private val viewEdad = itemView.findViewById<TextView>(R.id.txtEdad)
    private val viewCorreo = itemView.findViewById<TextView>(R.id.txtCorreo)
    val imagen = itemView.findViewById<ImageView>(R.id.image_view)
    fun render(item:Usuario){
        viewNombre.text = item.nombre
        viewEdad.text = item.edad.toString()
        viewCorreo.text = item.email
        imagen.setImageResource(R.drawable.ic_launcher_foreground)
    }
}