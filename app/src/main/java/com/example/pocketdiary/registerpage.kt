package com.example.pocketdiary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class registerpage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registerpage)

        val logintext = findViewById<TextView>(R.id.loginLinkText)
        val registerbutton = findViewById<Button>(R.id.registerButton)

        registerbutton.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }


        logintext.setOnClickListener{
            startActivity(Intent(this,loginpage::class.java))
            finish()
        }

    }
}