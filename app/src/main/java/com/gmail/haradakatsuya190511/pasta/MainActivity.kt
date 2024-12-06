package com.gmail.haradakatsuya190511.pasta

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val musicPlayer: MusicPlayer = MusicPlayer(this@MainActivity)
    private val seekBar: SeekBar = findViewById(R.id.seek_bar);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton = findViewById<ImageButton>(R.id.play)
        val stopButton = findViewById<ImageButton>(R.id.stop)
        val backwardButton = findViewById<ImageButton>(R.id.backward)
        val forwardButton = findViewById<ImageButton>(R.id.forward)
        val pastaButton = findViewById<Button>(R.id.pasta)
        var state = playButton.background.constantState
        stopButton.isEnabled = false
        backwardButton.isEnabled = false
        forwardButton.isEnabled = false

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seek: SeekBar, progress: Int, fromUser: Boolean) {
                seek.progress = musicPlayer.getCurrentPosition()
            }

            override fun onStartTrackingTouch(seek: SeekBar) {

            }

            override fun onStopTrackingTouch(seek: SeekBar) {

            }
        })

        playButton.setOnClickListener{
            if (state == ContextCompat.getDrawable(this, R.drawable.play)!!.constantState) {
                musicPlayer.playFull()
                playButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pause))
                stopButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.stop))
                backwardButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.backward))
                forwardButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.forward))
                state = ContextCompat.getDrawable(this, R.drawable.pause)!!.constantState
                stopButton.isEnabled = true
                backwardButton.isEnabled = true
                forwardButton.isEnabled = true
            } else {
                musicPlayer.pauseFull()
                playButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.play))
                state = ContextCompat.getDrawable(this, R.drawable.play)!!.constantState
            }
        }

        stopButton.setOnClickListener{
            if (stopButton.isEnabled) {
                musicPlayer.stopFull()
                playButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.play))
                stopButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.invalid_stop))
                backwardButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.invalid_backward))
                forwardButton.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.invalid_forward))
                state = ContextCompat.getDrawable(this, R.drawable.play)!!.constantState
                stopButton.isEnabled = false
                backwardButton.isEnabled = false
                forwardButton.isEnabled = false
            }
        }

        backwardButton.setOnClickListener{
            if (backwardButton.isEnabled) {
                musicPlayer.backward()
            }
        }

        forwardButton.setOnClickListener{
            if (forwardButton.isEnabled) {
                musicPlayer.forward()
            }
        }

        pastaButton.setOnClickListener{
            musicPlayer.playPasta()
        }
    }
}
