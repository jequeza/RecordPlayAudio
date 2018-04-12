package edu.rvc.student.recordplayaudio

import android.app.Activity
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.provider.MediaStore
import android.content.Intent
import android.media.MediaPlayer

class MainActivity: AppCompatActivity () {
    private val request = 1
    private lateinit var url1: Uri
    // coding180.com
    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate (savedInstanceState)
        setContentView (R.layout.activity_main)

        val button1 = findViewById (R.id.button1) as Button
        button1.setOnClickListener {
            val intent = Intent (MediaStore.Audio.Media.RECORD_SOUND_ACTION)
            startActivityForResult (intent, request)
        }

        val button2 = findViewById (R.id.button2) as Button
        button2.setOnClickListener {
            val mediaPlayer = MediaPlayer.create (this, url1)
            mediaPlayer.start ()
        }
    }

    override fun onActivityResult (requestCode: Int, resultCode: Int, data: Intent) {
        if (resultCode == Activity.RESULT_OK && requestCode == request) {
            url1 = data.data
        }
    }
}
