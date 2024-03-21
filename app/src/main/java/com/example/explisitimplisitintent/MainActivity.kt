package com.example.explisitimplisitintent

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi CardView dari layout XML
        val cardViewProfile: CardView = findViewById(R.id.cardViewProfile)
        val cardViewWebsite: CardView = findViewById(R.id.cardViewWebsite)
        val cardViewContactUs: CardView = findViewById(R.id.cardViewContactUs)
        val cardViewNilai: CardView = findViewById(R.id.cardViewNilai)

        // Atur onClickListener untuk CardView
        cardViewProfile.setOnClickListener {
            // Panggil method untuk membuka website
            panggilIntent2(RegistrasiActivity::class.java);
        }

        cardViewWebsite.setOnClickListener {
            // Panggil method untuk membuka website
            openWebsite()
        }


        // Atur onClickListener untuk CardView
        cardViewContactUs.setOnClickListener {
            // Panggil method untuk membuka website
            telpon("+6285720518234")
        }

        // Atur onClickListener untuk CardView
        cardViewNilai.setOnClickListener {
            // Panggil method untuk membuka website
            panggilIntent();
        }
    }

    // Method untuk membuka website
    private fun openWebsite() {
        // URL website yang ingin dibuka
        val websiteUrl = "https://www.polman-bandung.ac.id"

        // Buat intent untuk membuka website
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl))

        // Mulai intent
        startActivity(intent)
    }

    private fun telpon(phoneNumber: String) {
        // Buat intent untuk melakukan panggilan
        val callIntent = Intent(Intent.ACTION_DIAL)

        // Atur URI dengan nomor telepon yang diberikan
        callIntent.data = Uri.parse("tel:$phoneNumber")

        // Mulai intent
        startActivity(callIntent)
    }

    // Method untuk memanggil CallActivity2
    private fun panggilIntent() {
        // Buat intent untuk memanggil CallActivity2
        val intent = Intent(this, NilaiActivity::class.java)

        // Mulai intent
        startActivity(intent)
    }
    // Method untuk memanggil CallActivity2
    private fun panggilIntent2(activity: Class<out Activity>) {
        // Buat intent untuk memanggil CallActivity2
        val intent = Intent(this, activity)

        // Mulai intent
        startActivity(intent)
    }
}