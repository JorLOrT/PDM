package com.example.ejercicioimagenes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf

class FragmentImagenes : Fragment(R.layout.fragment_imagenes) {

    var titulo:String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        titulo = requireArguments().getString(TITULO)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Obtener la referencia a la imagen del layout
        val imagen = view.findViewById<ImageView>(R.id.imageView)
        val btnAtras = view.findViewById<Button>(R.id.btn_volver)

        // Seleccionar el recurso de imagen en base al nombre recibido
        val seleccionada = when(titulo){
            "Gato" -> R.drawable.gato_lentes
            "Mapache" -> R.drawable.mapache
            "Perro" -> R.drawable.perro_lentes
            else -> R.drawable.gato_lentes
        }
        // Establecer la imagen en el ImageView
        imagen.setImageResource(seleccionada)

        btnAtras.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_imagenes, Fragment1())
                commit()
            }
        }
    }

    companion object{
        private val TITULO = ""
        fun newInstance(titulo:String) = FragmentImagenes().apply {
            arguments = bundleOf(TITULO to titulo)
        }
    }

}