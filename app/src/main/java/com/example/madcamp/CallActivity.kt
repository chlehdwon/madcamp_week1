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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class CallActivity: AppCompatActivity(){
    private lateinit var CallName: TextView
    private lateinit var ExitButton: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.insta_call)
        supportActionBar?.hide()

        val name = intent.getStringExtra("name")

        supportActionBar?.title = name

        ExitButton = findViewById(R.id.close_button)
        CallName = findViewById(R.id.dialog_name)
        CallName.setText(name)

        ExitButton.setOnClickListener{
            finish()
        }
    }
}
