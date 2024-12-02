package com.gmail.haradakatsuya190511.pasta

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val musicPlayer: MusicPlayer = MusicPlayer(this@MainActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton = findViewById<ImageButton>(R.id.play)
        playButton.setOnClickListener{
            if (playButton.background.constantState == ContextCompat.getDrawable(this, R.drawable.play)!!.constantState) {
                musicPlayer.playFull()
                playButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pause));
            } else {
                musicPlayer.pauseFull()
                playButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.play));
            }
        }

        val stopButton = findViewById<ImageButton>(R.id.stop)
        stopButton.setOnClickListener{
            musicPlayer.stopFull()
            playButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.play));
        }

        val forwardButton = findViewById<ImageButton>(R.id.forward)
        forwardButton.setOnClickListener{
            musicPlayer.forward()
        }

        val rewindButton = findViewById<ImageButton>(R.id.rewind)
        rewindButton.setOnClickListener{
            musicPlayer.rewind()
        }

        val pastaButton = findViewById<Button>(R.id.pasta)
        pastaButton.setOnClickListener{
            musicPlayer.playPasta()
        }
    }
}
