package com.example.explisitimplisitintent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DisplayDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)

        // Mendapatkan data Mahasiswa dari intent
        val mahasiswa = intent.getParcelableExtra<Mahasiswa>("MAHASISWA")

        // Menampilkan data Mahasiswa
        val textViewName = findViewById<TextView>(R.id.textViewName)
        val textViewAddress = findViewById<TextView>(R.id.textViewAddress)
        val textViewPhoneNumber = findViewById<TextView>(R.id.textViewPhoneNumber)
        val textViewBirthDate = findViewById<TextView>(R.id.textViewBirthDate)
        val textViewGender = findViewById<TextView>(R.id.textViewGender)
        val textViewDepartment = findViewById<TextView>(R.id.textViewDepartment)
        val textViewHobbies = findViewById<TextView>(R.id.textViewHobbies)

        textViewName.text = "Nama: ${mahasiswa?.name}"
        textViewAddress.text = "Alamat: ${mahasiswa?.address}"
        textViewPhoneNumber.text = "No Telpon: ${mahasiswa?.phoneNumber}"
        textViewBirthDate.text = "Tanggal Lahir: ${mahasiswa?.birthDate}"
        textViewGender.text = "Jenis Kelamin: ${mahasiswa?.gender}"
        textViewDepartment.text = "Jurusan: ${mahasiswa?.department}"
        textViewHobbies.text = "Hobi: ${mahasiswa?.hobbies?.joinToString()}"
    }
}