package com.example.pocketdiary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomitem: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomitem = findViewById(R.id.bottom_navigation)

        // Show HomeFragment by default
        loadFragment(homeFragment())

        bottomitem.setOnItemSelectedListener { menuItem ->

            val fragment: Fragment

            if (menuItem.itemId == R.id.nav_home) {
                fragment = homeFragment()
            } else if (menuItem.itemId == R.id.nav_diary) {
                fragment = diaryFragment()
            } else if (menuItem.itemId == R.id.nav_chart) {
                fragment = chartFragment()
            } else if (menuItem.itemId == R.id.nav_report) {
                fragment = reportFragment()
            } else if (menuItem.itemId == R.id.nav_profile) {
                fragment = profileFragment()
            } else {
                fragment = homeFragment()
            }

            loadFragment(fragment)
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
