package com.example.growigh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class WelcomeActivity : AppCompatActivity() {


    private lateinit var feedsbtn : LinearLayout
    private lateinit var uploadImg : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        feedsbtn = findViewById(R.id.Feedsbtn)
        uploadImg = findViewById(R.id.UploadImg)

        feedsbtn.setOnClickListener {
            startActivity(Intent(this,FeedsActivity::class.java))
        }

        uploadImg.setOnClickListener {
            startActivity(Intent(this,UploadImageActivity::class.java))
        }
    }
}