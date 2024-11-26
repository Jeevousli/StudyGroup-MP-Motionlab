package com.example.w1_android

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private val TAG = "LoginActivity"
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val passwordEditText = findViewById<TextInputLayout>(R.id.Password)
        val usernameEditText = findViewById<TextInputLayout>(R.id.Username)
        val loginButton = findViewById<Button>(R.id.button)
        loginButton.setOnClickListener{
            val username = usernameEditText.editText?.text.toString()
            val password = passwordEditText.editText?.text.toString()
            if(username !== "Aca" || password !== "Admin") {
                // Validasi input
                Toast.makeText(this, "Username atau password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "Login gagal: Field kosong.")
            } else if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username atau password tidak boleh kosong", Toast.LENGTH_SHORT).show()
                Log.e(TAG, "Login gagal: Field kosong.")
            } else {
                Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()
            }
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    this,
                    "Username atau password tidak boleh kosong",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e(TAG, "Login gagal: Field kosong.")
            } else {
                val gotohome = Intent(this, HomeActivity::class.java)
                startActivity(gotohome)
                finish()
                Log.e(TAG, "Login berhasil")
            }
        }
    }
}