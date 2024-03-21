package com.example.explisitimplisitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class NilaiActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextAssignment: EditText
    private lateinit var editTextMidterm: EditText
    private lateinit var editTextFinalExam: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var buttonCalculate2: Button
    private lateinit var buttonCalculate3: Button
    private lateinit var buttonCalculate4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai)

        // Inisialisasi komponen UI
        editTextName = findViewById(R.id.editTextName)
        editTextAssignment = findViewById(R.id.editTextAssignment)
        editTextMidterm = findViewById(R.id.editTextMidterm)
        editTextFinalExam = findViewById(R.id.editTextFinalExam)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        buttonCalculate2 = findViewById(R.id.buttonCalculate2)
        buttonCalculate3 = findViewById(R.id.buttonCalculate3)
        buttonCalculate4 = findViewById(R.id.buttonCalculate4)

        // Atur onClickListener untuk tombol "Hitung"
        buttonCalculate.setOnClickListener {
            // Panggil method untuk mengirim data ke TampilNilaiActivity menggunakan putExtra
            sendDataUsingIntent()
        }

        // Atur onClickListener untuk tombol "Kirim Bundle"
        buttonCalculate2.setOnClickListener {
            // Panggil method untuk mengirim data ke TampilNilaiActivity menggunakan Bundle
            sendDataUsingBundle()
        }

        // Atur onClickListener untuk tombol "Kirim Parcelable"
        buttonCalculate3.setOnClickListener {
            // Panggil method untuk mengirim data ke TampilNilaiActivity menggunakan Parcelable
            sendDataUsingParcelable()
        }
        // Atur onClickListener untuk tombol "Kirim Parcelable"
        // Atur onClickListener untuk tombol "Kirim Serializable"
        buttonCalculate4.setOnClickListener {
            // Panggil method untuk mengirim data ke TampilNilaiActivity menggunakan Serializable
            sendDataUsingSerializable()
        }
    }
    // Method untuk mengirim data ke TampilNilaiActivity menggunakan putExtra
    private fun sendDataUsingIntent() {
        // Mendapatkan nilai-nilai yang diinputkan oleh pengguna
        val name = editTextName.text.toString()
        val assignment = editTextAssignment.text.toString().toDoubleOrNull() ?: 0.0
        val midterm = editTextMidterm.text.toString().toDoubleOrNull() ?: 0.0
        val finalExam = editTextFinalExam.text.toString().toDoubleOrNull() ?: 0.0

        // Membuat intent untuk memanggil TampilNilaiActivity
        val intent = Intent(this, TampilNilaiIntentActivity::class.java)

        // Menyisipkan data ke dalam intent menggunakan putExtra
        intent.putExtra("NAME", name)
        intent.putExtra("ASSIGNMENT", assignment)
        intent.putExtra("MIDTERM", midterm)
        intent.putExtra("FINALEXAM", finalExam)

        // Memulai activity baru dengan intent yang telah dibuat
        startActivity(intent)
    }

    // Method untuk mengirim data ke TampilNilaiActivity menggunakan Bundle
    private fun sendDataUsingBundle() {
        // Mendapatkan nilai-nilai yang diinputkan oleh pengguna
        val name = editTextName.text.toString()
        val assignment = editTextAssignment.text.toString().toDoubleOrNull() ?: 0.0
        val midterm = editTextMidterm.text.toString().toDoubleOrNull() ?: 0.0
        val finalExam = editTextFinalExam.text.toString().toDoubleOrNull() ?: 0.0

        // Membuat Bundle untuk menyimpan data
        val bundle = Bundle()
        bundle.putString("NAME", name)
        bundle.putDouble("ASSIGNMENT", assignment)
        bundle.putDouble("MIDTERM", midterm)
        bundle.putDouble("FINALEXAM", finalExam)

        // Membuat intent untuk memanggil TampilNilaiActivity
        val intent = Intent(this, TampilNilaiBundleActivity::class.java)


        // Menyisipkan bundle ke dalam intent
        intent.putExtras(bundle)

        // Memulai activity baru dengan intent yang telah dibuat
        startActivity(intent)
    }

    // Method untuk mengirim data ke TampilNilaiActivity menggunakan Parcelable
    private fun sendDataUsingParcelable() {
        // Mendapatkan nilai-nilai yang diinputkan oleh pengguna
        val name = editTextName.text.toString()
        val assignment = editTextAssignment.text.toString().toDoubleOrNull() ?: 0.0
        val midterm = editTextMidterm.text.toString().toDoubleOrNull() ?: 0.0
        val finalExam = editTextFinalExam.text.toString().toDoubleOrNull() ?: 0.0

        // Membuat objek Nilai
        val nilai = Nilai(name, assignment, midterm, finalExam)

        // Membuat intent untuk memanggil TampilNilaiActivity
        val intent = Intent(this, TampilNilaiParcelableActivity::class.java)

        // Menyisipkan objek Mahasiswa ke dalam intent menggunakan Parcelable
        intent.putExtra("NILAI", nilai)

        // Memulai activity baru dengan intent yang telah dibuat
        startActivity(intent)
    }

    // Method untuk mengirim data ke TampilNilaiActivity menggunakan Serializable
    private fun sendDataUsingSerializable() {
        // Mendapatkan nilai-nilai yang diinputkan oleh pengguna
        val name = editTextName.text.toString()
        val assignment = editTextAssignment.text.toString().toDoubleOrNull() ?: 0.0
        val midterm = editTextMidterm.text.toString().toDoubleOrNull() ?: 0.0
        val finalExam = editTextFinalExam.text.toString().toDoubleOrNull() ?: 0.0

        // Membuat objek Mahasiswa
        val nilai = Nilai(name, assignment, midterm, finalExam)

        // Membuat intent untuk memanggil TampilNilaiActivity
        val intent = Intent(this, TampilNilaiSerializableActivity::class.java)

        // Menyisipkan objek Mahasiswa ke dalam intent menggunakan Serializable
        intent.putExtra("NILAI", nilai as Serializable)

        // Memulai activity baru dengan intent yang telah dibuat
        startActivity(intent)
    }
}