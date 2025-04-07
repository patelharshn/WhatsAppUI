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
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var tabs: TabLayout
    lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        tabs = findViewById(R.id.my_tabs)
        viewPager = findViewById(R.id.my_viewPager)

        viewPager.adapter = MyVPAdapter(this)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Chats"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.baseline_chat_24)
                }

                1 -> {
                    tab.text = "Status"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.whatsapp_status)
                }

                2 -> {
                    tab.text = "Profile"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.baseline_person_24)
                }
                3->{
                    tab.text = "Calls"
                    tab.icon = ContextCompat.getDrawable(this, R.drawable.baseline_local_phone_24)
                }
            }
        }.attach()
    }

}