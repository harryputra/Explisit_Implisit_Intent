package com.example.explisitimplisitintent

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class RegistrasiActivity : AppCompatActivity() {

    private lateinit var editTextName: EditText
    private lateinit var editTextAddress: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var datePicker: DatePicker
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var spinnerDepartment: Spinner
    private lateinit var checkBoxHobby1: CheckBox
    private lateinit var checkBoxHobby2: CheckBox
    private lateinit var checkBoxHobby3: CheckBox
    private lateinit var checkBoxHobby4: CheckBox
    private lateinit var buttonSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrasi)

        // Inisialisasi komponen UI
        editTextName = findViewById(R.id.editTextName)
        editTextAddress = findViewById(R.id.editTextAddress)
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber)
        datePicker = findViewById(R.id.datePicker)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        spinnerDepartment = findViewById(R.id.spinnerDepartment)
        checkBoxHobby1 = findViewById(R.id.checkBoxHobby1)
        checkBoxHobby2 = findViewById(R.id.checkBoxHobby2)
        checkBoxHobby3 = findViewById(R.id.checkBoxHobby3)
        checkBoxHobby4 = findViewById(R.id.checkBoxHobby4)
        buttonSave = findViewById(R.id.buttonSave)

        // Inisialisasi data untuk Spinner
        val departments = arrayOf("Informatika", "Sistem Informasi", "Manajemen Bisnis", "Akuntansi")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, departments)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerDepartment.adapter = adapter

        // Handle action saat tombol Simpan diklik
        buttonSave.setOnClickListener {
            kirimData();
        }
    }

    private fun kirimData() {
        // Mengambil data yang diinputkan oleh pengguna
        val name = editTextName.text.toString()
        val address = editTextAddress.text.toString()
        val phoneNumber = editTextPhoneNumber.text.toString()
        val day = datePicker.dayOfMonth
        val month = datePicker.month + 1 // Bulan dimulai dari 0
        val year = datePicker.year
        val gender = if (radioGroupGender.checkedRadioButtonId == R.id.radioButtonMale) "Laki-laki" else "Perempuan"
        val department = spinnerDepartment.selectedItem.toString()
        val hobbies = mutableListOf<String>()
        if (checkBoxHobby1.isChecked) hobbies.add("Jalan-jalan")
        if (checkBoxHobby2.isChecked) hobbies.add("Makan")
        if (checkBoxHobby3.isChecked) hobbies.add("Main Game")
        if (checkBoxHobby4.isChecked) hobbies.add("Membaca")

        // Membuat objek Mahasiswa
        val mahasiswa = Mahasiswa(name, address, phoneNumber, "$day/$month/$year", gender, department, hobbies)

        // Mengirim data menggunakan Parcelable
        val intent = Intent(this, DisplayDataActivity::class.java)
        intent.putExtra("MAHASISWA", mahasiswa as Parcelable)
        startActivity(intent)
    }
}