package com.example.cardapiodigital.ui.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cardapiodigital.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recebe os dados da Intent
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val price = intent.getDoubleExtra("price", 0.0)
        val imageResId = intent.getIntExtra("imageResId", 0)

        // Referências das Views
        val imageView = findViewById<ImageView>(R.id.itemImage)
        val nameView = findViewById<TextView>(R.id.itemTitle)
        val descriptionView = findViewById<TextView>(R.id.itemDescription)
        val priceView = findViewById<TextView>(R.id.itemPrice)

        // Atualiza Views com os dados recebidos
        if (imageResId != 0) {
            imageView.setImageResource(imageResId)
        }
        nameView.text = name ?: ""
        descriptionView.text = description ?: ""
        priceView.text = "R$ %.2f".format(price)
    }
}
