package com.example.explisitimplisitintent

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {

    // Variabel yang telah didefinisikan
    private val correctUsername = "admin"
    private val correctEmail = "admin@admin.com"
    private val correctPassword = "admin1234"

    // Properti untuk EditText
    private lateinit var editTextUsername: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText

    // SharedPreferences
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextUsername = findViewById(R.id.editTextUsername)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPassword = findViewById(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        // Inisialisasi SharedPreferences
        sharedPreferences = getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)

        // Cek status login
        if (isLoggedIn()) {
            // Jika sudah login, langsung ke MainActivity
            goToMainActivity()
            return
        }

        buttonLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val username = editTextUsername.text.toString()
        val email = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()

        if (username == correctUsername && email == correctEmail && password == correctPassword) {
            // Login berhasil
            // Simpan status login ke SharedPreferences
            saveLoginStatus(true)
            Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
            // Lanjut ke aktivitas selanjutnya, misalnya MainActivity
            // Membuat intent untuk memanggil TampilNilaiActivity
//            val intent = Intent(this, MainActivity::class.java)
//            // Memulai activity baru dengan intent yang telah dibuat
//            startActivity(intent)

            goToMainActivity()
        } else {
            // Login gagal
            Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
        }
    }
    private fun isLoggedIn(): Boolean {
        // Mendapatkan nilai status login dari SharedPreferences
        return sharedPreferences.getBoolean("isLoggedIn", false)
    }

    private fun saveLoginStatus(isLoggedIn: Boolean) {
        // Simpan status login ke SharedPreferences
        sharedPreferences.edit().putBoolean("isLoggedIn", isLoggedIn).apply()
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Menutup LoginActivity agar tidak bisa kembali dengan tombol back
    }


}