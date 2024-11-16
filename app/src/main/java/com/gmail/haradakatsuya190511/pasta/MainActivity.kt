package com.gmail.haradakatsuya190511.pasta

import android.media.SoundPool
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val soundPool = SoundPool.Builder().setMaxStreams(1).build()
        val full = soundPool.load(this, R.raw.full, 1)
        val playButton = findViewById<Button>(R.id.play)
        playButton.setOnClickListener{
            soundPool.play(full, 1.0f, 1.0f, 0, 0, 1.0f)
        }
    }
}
