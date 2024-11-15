package com.gmail.haradakatsuya190511.pasta

import android.media.SoundPool
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.gmail.haradakatsuya190511.pasta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val soundPool = SoundPool.Builder()
            .setMaxStreams(1)
            .build()
        val soundId = soundPool.load(this, R.raw.full, 1)
        var soundButton = findViewById<Button>(R.id.play)
        soundButton.setOnClickListener{
            soundPool.play(soundId, 1.0f, 1.0f, 0, 0, 1.0f)
        }
    }
}
