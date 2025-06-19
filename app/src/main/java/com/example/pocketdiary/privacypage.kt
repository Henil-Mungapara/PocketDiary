package com.example.pocketdiary

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class privacypage : AppCompatActivity() {

    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var continueButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_privacypage)

        // Handling system bars padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        checkBox1 = findViewById(R.id.checkbox1)
        checkBox2 = findViewById(R.id.checkbox2)
        continueButton = findViewById(R.id.continueButton)
        val back = findViewById<ImageView>(R.id.backArrow);

        back.setOnClickListener{
            finish()
        }

        // Disable button initially and set grey background
        continueButton.isEnabled = false
        continueButton.setBackgroundColor(Color.parseColor("#4F7C82"))

        // Checkbox listener logic
        val updateButtonState = {
            val bothChecked = checkBox1.isChecked && checkBox2.isChecked
            continueButton.isEnabled = bothChecked
            if (bothChecked) {
                continueButton.setBackgroundColor(Color.parseColor("#0B2E33"))
            } else {
                continueButton.setBackgroundColor(Color.parseColor("#4F7C82"))
            }
        }

        checkBox1.setOnCheckedChangeListener { _, _ -> updateButtonState() }
        checkBox2.setOnCheckedChangeListener { _, _ -> updateButtonState() }

        // Button click - go to GetStartedActivity
        continueButton.setOnClickListener {
            val intent = Intent(this@privacypage, getstartedpage::class.java)
            startActivity(intent)
            finish()
        }
    }
}
