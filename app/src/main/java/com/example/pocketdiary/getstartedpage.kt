package com.example.pocketdiary

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class getstartedpage : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_getstartedpage)


        //val back = findViewById<ImageView>(R.id.backArrow)
        val getstarted = findViewById<Button>(R.id.GetStartedButton)



        getstarted.setOnClickListener{
            startActivity(Intent(this,loginpage::class.java))
        }


    }
}