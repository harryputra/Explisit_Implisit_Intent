package com.example.explisitimplisitintent

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TampilNilaiBundleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tampil_nilai)

        // Menampilkan data pada TextView di activity_tampil_nilai_bundle.xml
        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewAssignment: TextView = findViewById(R.id.textViewAssignment)
        val textViewMidterm: TextView = findViewById(R.id.textViewMidterm)
        val textViewFinalExam: TextView = findViewById(R.id.textViewFinalExam)

        // Menerima data dari Bundle
        val bundle = intent.extras
        val name = bundle?.getString("NAME")
        val assignment = bundle?.getDouble("ASSIGNMENT", 0.0)
        val midterm = bundle?.getDouble("MIDTERM", 0.0)
        val finalExam = bundle?.getDouble("FINALEXAM", 0.0)


        textViewName.text = "Nama Mahasiswa: $name"
        textViewAssignment.text = "Nilai Tugas: $assignment"
        textViewMidterm.text = "Nilai UTS: $midterm"
        textViewFinalExam.text = "Nilai UAS: $finalExam"
    }
}