package com.example.explisitimplisitintent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TampilNilaiIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampil_nilai_intent)

        // Menampilkan data pada TextView di activity_tampil_nilai_intent.xml
        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewAssignment: TextView = findViewById(R.id.textViewAssignment)
        val textViewMidterm: TextView = findViewById(R.id.textViewMidterm)
        val textViewFinalExam: TextView = findViewById(R.id.textViewFinalExam)

        // Menerima data dari Intent
        val name = intent.getStringExtra("NAME")
        val assignment = intent.getDoubleExtra("ASSIGNMENT", 0.0)
        val midterm = intent.getDoubleExtra("MIDTERM", 0.0)
        val finalExam = intent.getDoubleExtra("FINALEXAM", 0.0)

        textViewName.text = "Nama Mahasiswa: $name"
        textViewAssignment.text = "Nilai Tugas: $assignment"
        textViewMidterm.text = "Nilai UTS: $midterm"
        textViewFinalExam.text = "Nilai UAS: $finalExam"
    }
}