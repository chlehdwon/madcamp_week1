package com.example.madcamp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.ImageButton
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*

class ImageFullActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_full)

        supportActionBar?.hide()

        val imagePath = intent.getStringExtra("path")
        val imageName = intent.getStringExtra("name")

        supportActionBar?.setTitle(imageName)
        Glide.with(this)
            .load(imagePath)
            .into(findViewById(R.id.imageView))

        val dmButton : ImageButton = findViewById(R.id.btndm)
        dmButton.setOnClickListener {
            finish()

        }
    }

}