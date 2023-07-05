package com.example.growigh

import android.annotation.SuppressLint
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide

class UploadImageActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var upload_image: CardView
    private var selectedImageBitmap: Bitmap? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_image)

        upload_image = findViewById(R.id.upload_image)
        upload_image.setOnClickListener {
            Toast.makeText(this,"No functionality", Toast.LENGTH_SHORT).show()
        }


        imageView = findViewById(R.id.imageView)
        findViewById<View>(R.id.cardView2).setOnClickListener {
            openGalleryForImage()
        }

        findViewById<View>(R.id.close).setOnClickListener {
            imageView.setImageResource(R.drawable.ic_launcher_background)
            selectedImageBitmap = null
        }
    }

    private fun openGalleryForImage() {
        getContent.launch("image/*")

    }
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            selectedImageBitmap = MediaStore.Images.Media.getBitmap(contentResolver, uri)
            Glide.with(this).load(selectedImageBitmap).into(imageView)
        }
    }
}