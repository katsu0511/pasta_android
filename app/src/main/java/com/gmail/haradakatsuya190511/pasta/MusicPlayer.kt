package com.gmail.haradakatsuya190511.pasta

import android.content.Context
import android.media.MediaPlayer

class MusicPlayer(context: Context) {

    private lateinit var fullPlayer: MediaPlayer
    private lateinit var pastaPlayer: MediaPlayer
    private val myContext: Context = context

    fun playFull() {
        if (!::fullPlayer.isInitialized) {
            fullPlayer = MediaPlayer.create(myContext, R.raw.full)
            fullPlayer.isLooping = false
        }
        fullPlayer.start()
    }

    fun pauseFull() {
        fullPlayer.pause()
    }

    fun stopFull() {
        fullPlayer.stop()
        fullPlayer.prepare()
    }

    fun forward() {
        if (fullPlayer.currentPosition > fullPlayer.duration - 5000) {
            fullPlayer.seekTo(fullPlayer.duration)
        } else {
            fullPlayer.seekTo(fullPlayer.currentPosition + 5000)
        }
    }

    fun rewind() {
        if (fullPlayer.currentPosition < 5000) {
            fullPlayer.seekTo(0)
        } else {
            fullPlayer.seekTo(fullPlayer.currentPosition - 5000)
        }
    }

    fun playPasta() {
        if (!::pastaPlayer.isInitialized || !pastaPlayer.isPlaying) {
            pastaPlayer = MediaPlayer.create(myContext, R.raw.pasta)
            pastaPlayer.isLooping = false
            pastaPlayer.start()
            if (::fullPlayer.isInitialized) {
                fullPlayer.setVolume(0.0F, 0.0F)
            }
            pastaPlayer.setOnCompletionListener {
                fullPlayer.setVolume(1.0F, 1.0F)
            }
        }
    }
}
