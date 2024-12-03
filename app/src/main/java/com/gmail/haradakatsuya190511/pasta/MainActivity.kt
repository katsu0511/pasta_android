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
        val stopButton = findViewById<ImageButton>(R.id.stop)
        val backwardButton = findViewById<ImageButton>(R.id.backward)
        val forwardButton = findViewById<ImageButton>(R.id.forward)
        val pastaButton = findViewById<Button>(R.id.pasta)
        var state = playButton.background.constantState

        playButton.setOnClickListener{
            if (state == ContextCompat.getDrawable(this, R.drawable.play)!!.constantState) {
                musicPlayer.playFull()
                playButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pause))
                stopButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.stop))
                backwardButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.backward))
                forwardButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.forward))
                state = ContextCompat.getDrawable(this, R.drawable.pause)!!.constantState
            } else {
                musicPlayer.pauseFull()
                playButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.play))
                state = ContextCompat.getDrawable(this, R.drawable.play)!!.constantState
            }
        }

        stopButton.setOnClickListener{
            musicPlayer.stopFull()
            playButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.play))
            stopButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.invalid_stop))
            backwardButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.invalid_backward))
            forwardButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.invalid_forward))
        }

        backwardButton.setOnClickListener{
            musicPlayer.backward()
        }

        forwardButton.setOnClickListener{
            musicPlayer.forward()
        }

        pastaButton.setOnClickListener{
            musicPlayer.playPasta()
        }
    }
}
