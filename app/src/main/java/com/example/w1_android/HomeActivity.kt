package com.example.w1_android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    // Logging Tag
    private val TAG = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Refer UI
        val logoutButton = findViewById<Button>(R.id.LogoutButton)

        logoutButton.setOnClickListener {
            // Kembali ke Login Page
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Menghentikan aktivitas saat ini
            Log.i(TAG, "Logout berhasil")
            }

        }
}