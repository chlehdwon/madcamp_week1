package com.example.madcamp

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import de.hdodenhof.circleimageview.CircleImageView

class CallActivity: AppCompatActivity(){
    private lateinit var CallName: TextView
    private lateinit var CallImg: CircleImageView
    private lateinit var ExitButton: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insta_call)
        supportActionBar?.hide()

        val name = intent.getStringExtra("name")
        val url = intent.getStringExtra("url")
        supportActionBar?.title = name

        ExitButton = findViewById(R.id.close_button)
        CallName = findViewById(R.id.call_name)
        CallImg = findViewById(R.id.call_img)

        CallName.setText(name)
        Glide.with(this).load(url).error(R.drawable.madcamp).into(CallImg)

        ExitButton.setOnClickListener{
            finish()
        }
    }
}
