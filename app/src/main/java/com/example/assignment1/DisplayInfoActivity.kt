package com.example.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_info)

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val userInfo = intent.getStringExtra("userInfo")

        val userInfoTextView: TextView = findViewById(R.id.tv_user_info)
        userInfoTextView.text = userInfo

        val backButton: Button = findViewById(R.id.btn_back)
        backButton.setOnClickListener {
            finish() // This will close the current activity and go back to the previous one
        }
    }
}