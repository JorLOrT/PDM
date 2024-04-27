package com.example.ejercicio2

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.os.bundleOf

class FragmentEleccion : Fragment(R.layout.fragment_eleccion) {
    var cancion:String? = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val seekbar = view.findViewById<SeekBar>(R.id.seekbar)

        // Obtener el nombre de la canción seleccionada del fragmentPrincipal
        val valor = cancion
        val imagen = view.findViewById<ImageView>(R.id.imageView)

        var media_player: MediaPlayer
        var btnPlay: Button

        // Seleccionar el recurso de imagen en base al nombre de la canción
        val seleccionada = when(valor){
            "Tuca Donka" -> R.drawable.gato_lentes
            "Real no Fake" -> R.drawable.mapache
            "Caminar" -> R.drawable.perro_lentes
            else -> R.drawable.gato_lentes
        }

        // Seleccionar el recurso de audio en base al nombre de la canción
        val cancion = when(valor){
            "Tuca Donka" -> R.raw.tuca_donka
            "Real no Fake" -> R.raw.real_no_fake
            "Caminar" -> R.raw.caminar
            else -> R.raw.tuca_donka
        }

        view.findViewById<TextView>(R.id.titulo).text = valor
        // Mostrar la imagen de la canción
        imagen.setImageResource(seleccionada)


        //Se asigna la musica que se guardará dentro de la variable media player
        media_player = MediaPlayer.create(requireContext(),cancion)
        // Adaptando seekbar
        seekbar.progress = 0
        seekbar.max = media_player.duration
        //Se selecciona el botón por medio de su ID
        btnPlay = view.findViewById(R.id.btn_play)
        //Se le asigna un listener cuando se le haga clic
        btnPlay.setOnClickListener {
            //Comprueba si no se está reproduciendo el archivo
            if(!media_player.isPlaying){
                media_player.start()
            }else{
                //En caso se este reproduciendo, se le pausará
                media_player.pause()
            }
        }

        // Asignar funcinalidades a la barra de búsqueda
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, cambiado: Boolean) {
                if (cambiado) {
                    // al mover la posición del seekbar la canción irá a ese momento
                    media_player.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


        //Botón volver
        val btnVolver = view.findViewById<Button>(R.id.btn_volver)
        btnVolver.setOnClickListener {
            if(media_player.isPlaying){
                media_player.pause()
            }
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.ventana_cancion, FragmentPrincipal())
                addToBackStack("eleccion")
                commit()
            }
        }


    }

    companion object {
        private const val ELECCION = "cancion"  // Use a descriptive constant

        fun newInstance(cancion: String) = FragmentEleccion().apply {
            arguments = bundleOf(ELECCION to cancion)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cancion = it.getString(ELECCION)
        }
    }
}