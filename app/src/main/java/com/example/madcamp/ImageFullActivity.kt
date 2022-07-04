package com.example.madcamp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.jackandphantom.androidlikebutton.AndroidLikeButton
import kotlinx.android.synthetic.main.activity_image_full.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Calendar.getInstance

class ImageFullActivity : AppCompatActivity() {
    private lateinit var likeButton: AndroidLikeButton
    private lateinit var saveButton: AndroidLikeButton


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

        likeButton = findViewById(R.id.likebtn)
//        likeButton.setCurrentlyLiked(true)

        likeButton.setOnLikeEventListener(object : AndroidLikeButton.OnLikeEventListener {
            override fun onLikeClicked(androidLikeButton: AndroidLikeButton) {
                likebtn.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
                Toast.makeText(this@ImageFullActivity, "Liked", Toast.LENGTH_SHORT).show()
            }
            override fun onUnlikeClicked(androidLikeButton: AndroidLikeButton) {
                likebtn.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
                Toast.makeText(this@ImageFullActivity, "Unliked", Toast.LENGTH_SHORT).show()
            }
        })

        saveButton = findViewById(R.id.savebtn)

        saveButton.setOnLikeEventListener(object : AndroidLikeButton.OnLikeEventListener {
            override fun onLikeClicked(androidLikeButton: AndroidLikeButton) {
                savebtn.setBackgroundResource(R.drawable.ic_baseline_bookmark_24)
                Toast.makeText(this@ImageFullActivity, "Saved", Toast.LENGTH_SHORT).show()
            }
            override fun onUnlikeClicked(androidLikeButton: AndroidLikeButton) {
                savebtn.setBackgroundResource(R.drawable.ic_baseline_bookmark_border_24)
                Toast.makeText(this@ImageFullActivity, "Unsaved", Toast.LENGTH_SHORT).show()
            }
        })
    }


}