package com.example.pocketdiary

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Create or get SharedPreferences
        val sharedPref = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        // Get saved values, or use default
        val isFirstInstall = sharedPref.getBoolean("isFirstInstall", true)
        val isLoggedOut = sharedPref.getBoolean("isLoggedOut", false)

        // Delay for 3.5 seconds
        Handler(Looper.getMainLooper()).postDelayed({

            if (isFirstInstall) {
                // First time: go to privacy page
                startActivity(Intent(this, privacypage::class.java))

                // Save that it's no longer first install
                sharedPref.edit().putBoolean("isFirstInstall", false).apply()

            } else if (isLoggedOut) {
                // User logged out: go to login page
                startActivity(Intent(this, loginpage::class.java))

            } else {
                // Normal case: go to main page
                startActivity(Intent(this, MainActivity::class.java))
            }

            finish() // Close splash screen

        }, 3500)
    }
}
