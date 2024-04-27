package com.example.ejercicioimagenes

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class Fragment1 : Fragment(R.layout.fragment_1) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Extrae los textos de los strings
        val txtImagenes = resources.getStringArray(R.array.imagenes)
        // Asigna los elementos del layout
        val spinner = view.findViewById<Spinner>(R.id.spinnerImagenes)
        val btnIr = view.findViewById<Button>(R.id.btn_ir)

        // Comprobar si el spinner no es nulo antes de configurar el adaptador
        if(spinner != null){
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, txtImagenes)
            spinner.adapter = adapter
        }

        btnIr.setOnClickListener {
            // Obtiene el valor seleccionado en el spinner
            val imagenElegida = spinner.selectedItem.toString()
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_1, FragmentImagenes.newInstance(imagenElegida))
                addToBackStack("titulo")
                commit()
            }
        }

    }

}