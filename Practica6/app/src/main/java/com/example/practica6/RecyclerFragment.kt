package com.example.practica6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practica6.adapter.UsuariosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RecyclerFragment : Fragment(R.layout.fragment_recycler) {

    private lateinit var userAdapter:UsuariosAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView(view)
        eventos(view)
    }

    private fun eventos(view: View) {
        val btnAgregar = view.findViewById<FloatingActionButton>(R.id.btnAgregar)
        btnAgregar.setOnClickListener(){
            val usuario1 = Usuario("Pepito", 80, "pepito80@gmail.com", "avatar_1")
            userAdapter.addUsuario(usuario1)
        }
    }

    fun initRecyclerView(view: View){
        val usersRecycler = view.findViewById<RecyclerView>(R.id.recycler_widget)
        userAdapter = UsuariosAdapter(UsuarioProvider.lista_usuarios) { user -> onItemSelected(user) }
        usersRecycler.layoutManager = LinearLayoutManager(context)
        usersRecycler.adapter = userAdapter

    }

    private fun onItemSelected(usuario: Usuario){
        val resultadoClic = bundleOf("nombre" to usuario.nombre, "edad" to usuario.edad, "correo" to usuario.email, "imagen" to usuario.imagen)
        view?.findNavController()?.navigate(R.id.action_recyclerFragment_to_infoFragment, resultadoClic)
    }
}