package com.gmail.haradakatsuya190511.pasta

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val musicPlayer: MusicPlayer = MusicPlayer(this@MainActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton = findViewById<Button>(R.id.play)
        playButton.setOnClickListener{
            if (playButton.text == "＞") {
                musicPlayer.playFull()
                playButton.setText(R.string.pause)
            } else {
                musicPlayer.pauseFull()
                playButton.setText(R.string.play)
            }
        }

        val stopButton = findViewById<Button>(R.id.stop)
        stopButton.setOnClickListener{
            musicPlayer.stopFull()
            playButton.setText(R.string.play)
        }

        val forwardButton = findViewById<Button>(R.id.forward)
        forwardButton.setOnClickListener{
            musicPlayer.forward()
        }

        val rewindButton = findViewById<Button>(R.id.rewind)
        rewindButton.setOnClickListener{
            musicPlayer.rewind()
        }

        val pastaButton = findViewById<Button>(R.id.pasta)
        pastaButton.setOnClickListener{
            musicPlayer.playPasta()
        }
    }
}
