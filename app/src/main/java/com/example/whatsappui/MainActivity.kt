package com.example.whatsappui

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import android.window.OnBackInvokedDispatcher
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var Img_Add_Chat:ImageView
    lateinit var btnProfile:Button
    lateinit var btnStatus:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Img_Add_Chat = findViewById(R.id.Img_Add_Chat)
        btnProfile = findViewById(R.id.btnProfile)
        btnStatus = findViewById(R.id.btnStatus)
    }

    override fun onStart() {
        super.onStart()
        Img_Add_Chat.setOnClickListener {
            val intent = Intent(this, SelectContact::class.java)
            startActivity(intent)
        }

        btnProfile.setOnClickListener {
            startActivity(Intent(this,Profile::class.java))
        }

        btnStatus.setOnClickListener {
            startActivity(Intent(this,status::class.java))
        }
    }

}