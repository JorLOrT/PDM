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

    // Se usa unit cuando no retorna nada la función Lambda
    fun render(item:Usuario, onClickListener: (Usuario) -> Unit){
        viewNombre.text = item.nombre
        viewEdad.text = item.edad.toString()
        viewCorreo.text = item.email
        val eleccion = item.imagen
        when(eleccion){
            "avatar_1" -> imagen.setImageResource(R.drawable.avatar_1)
            "avatar_2" -> imagen.setImageResource(R.drawable.avatar_2)
            "avatar_3" -> imagen.setImageResource(R.drawable.avatar_3)
        }
        itemView.setOnClickListener{
            onClickListener(item)
        }
    }
}