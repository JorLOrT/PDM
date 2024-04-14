package com.example.mp3

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


/*
Autor: Jorge Ortiz
Fecha de creación: 13/04/2024
Fecha de ultima modificación: 13/04/2024
La aplicación es un reproductor de MP3 Simple que reproduce y para una canción
 */
class MainActivity : AppCompatActivity() {

    lateinit var media_player1:MediaPlayer
    lateinit var btnPlay: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //Se asigna la musica que se guardará dentro de la variable media player
        media_player1 = MediaPlayer.create(this,R.raw.remix_pedro)
        //Se selecciona el botón por medio de su ID
        btnPlay = findViewById(R.id.btn_play)
        //Se le asigna un listener cuando se le haga clic
        btnPlay.setOnClickListener {
            //Comprueba si no se está reproduciendo el archivo
            if(!media_player1.isPlaying){
                media_player1.start()
            }else{
                //En caso se este reproduciendo, se le pausará
                media_player1.pause()
            }
        }
    }
}