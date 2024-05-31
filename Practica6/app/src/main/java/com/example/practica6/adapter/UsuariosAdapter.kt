package com.example.practica6.adapter

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.practica6.R
import com.example.practica6.Usuario

class UsuariosAdapter(var items:MutableList<Usuario>): RecyclerView.Adapter<UsuarioViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_usuario, parent, false)
        return UsuarioViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    // para dibujar las veces necesarias
    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val item = items[position]
        holder.render(item)
    }

    fun addUsuario(usuario: Usuario){
        items.add(0,usuario)
        notifyItemInserted(0)
    }

    fun deleteUsuario(index:Int){
        items.removeAt(index)
        notifyItemRemoved(index)
    }

    fun editUsuario(index: Int, usuario: Usuario){
        items[index] = usuario
        notifyItemChanged(index)
    }

}