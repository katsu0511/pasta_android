package com.gmail.haradakatsuya190511.pasta

import android.content.Context
import android.media.MediaPlayer

class MusicPlayer(context: Context) {

    private lateinit var fullPlayer: MediaPlayer
    private lateinit var pastaPlayer: MediaPlayer
    private val myContext: Context = context

    fun playFull() {
        fullPlayer = MediaPlayer.create(myContext, R.raw.full)
        fullPlayer.isLooping = false
        fullPlayer.start()
    }

    fun pauseFull() {
        fullPlayer.pause()
    }

    fun stopFull() {
        fullPlayer.stop()
        fullPlayer.reset()
        fullPlayer.release()
    }

    fun playPasta() {
        if (!::pastaPlayer.isInitialized || !pastaPlayer.isPlaying) {
            pastaPlayer = MediaPlayer.create(myContext, R.raw.pasta)
            pastaPlayer.isLooping = false
            pastaPlayer.start()
            if (::fullPlayer.isInitialized) {
                fullPlayer.setVolume(0.0F, 0.0F)
            }
        }
    }
}
