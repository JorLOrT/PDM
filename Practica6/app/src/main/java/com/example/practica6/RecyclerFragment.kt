package com.example.practica6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica6.adapter.UsuariosAdapter

class RecyclerFragment : Fragment(R.layout.fragment_recycler) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view)
    }

    fun initRecyclerView(view: View){
        val usersRecycler = view.findViewById<RecyclerView>(R.id.recycler_widget)
        usersRecycler.layoutManager = LinearLayoutManager(context)
        usersRecycler.adapter = UsuariosAdapter(UsuarioProvider.lista_usuarios)
    }
}