package com.example.pocketdiary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class loginpage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_loginpage)

        val registerText = findViewById<TextView>(R.id.registerLinkText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val forgotPasswordText = findViewById<TextView>(R.id.forgotPasswordText)

        // Navigate to Forgot Password screen
        forgotPasswordText.setOnClickListener {
            startActivity(Intent(this, forgotpassword::class.java))
        }

        // Login action
        loginButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        // Navigate to Register screen
        registerText.setOnClickListener {
            startActivity(Intent(this, registerpage::class.java))
            finish()
        }
    }
}
