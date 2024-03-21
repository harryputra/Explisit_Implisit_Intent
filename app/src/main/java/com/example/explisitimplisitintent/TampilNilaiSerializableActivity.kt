package com.example.explisitimplisitintent

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TampilNilaiSerializableActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampil_nilai_serializable)

        // Menerima data dari Intent
        val nilai = intent.getSerializableExtra("NILAI") as Nilai

        // Menampilkan data pada TextView di activity_tampil_nilai_serializable.xml
        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewAssignment: TextView = findViewById(R.id.textViewAssignment)
        val textViewMidterm: TextView = findViewById(R.id.textViewMidterm)
        val textViewFinalExam: TextView = findViewById(R.id.textViewFinalExam)

        textViewName.text = "Nama Mahasiswa: ${nilai.name}"
        textViewAssignment.text = "Nilai Tugas: ${nilai.assignment}"
        textViewMidterm.text = "Nilai UTS: ${nilai.midterm}"
        textViewFinalExam.text = "Nilai UAS: ${nilai.finalExam}"

    }
}