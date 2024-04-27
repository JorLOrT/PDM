package com.example.ejercicio2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge

class FragmentPrincipal : Fragment(R.layout.fragment_principal) {

    /*
    Autor: Jorge Ortiz
    Fecha de creación: 21/04/2024
    Fecha de ultima modificación: 21/04/2024
    Reproductor de Música versión 2
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txtCanciones = resources.getStringArray(R.array.canciones)
        // Asigna los elementos del layout
        val spinner = view.findViewById<Spinner>(R.id.spinnerCanciones)
        val btnIr = view.findViewById<Button>(R.id.btn_ir)

        // Se comprueba si el Spinner no es nulo antes de configurar el adaptador
        if(spinner != null){
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, txtCanciones)
            spinner.adapter = adapter
        }

        btnIr.setOnClickListener {
            // Obtiene el valor seleccionado en el spinner
            val cancionElegida = spinner.selectedItem.toString()

            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentPrincipal, FragmentEleccion.newInstance(cancionElegida))
                addToBackStack("eleccion")
                commit()
            }
        }

    }


}