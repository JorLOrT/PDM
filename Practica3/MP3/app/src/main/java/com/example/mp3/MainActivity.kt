package com.example.mp3

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.AbsSeekBar
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var media_player1:MediaPlayer
    lateinit var btnPlay: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        media_player1 = MediaPlayer.create(this,R.raw.remix_pedro)

        btnPlay = findViewById(R.id.btn_play)

        btnPlay.setOnClickListener {
            if(!media_player1.isPlaying){
                media_player1.start()
            }else{
                media_player1.pause()
            }
        }


    }

}