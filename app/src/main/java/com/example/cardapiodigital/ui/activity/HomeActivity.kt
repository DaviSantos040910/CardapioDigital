package com.example.cardapiodigital.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cardapiodigital.R
import com.example.cardapiodigital.adapter.ItemAdapter
import com.example.cardapiodigital.data.DummyData
import com.example.cardapiodigital.data.Item
import com.example.cardapiodigital.ui.activity.DetailActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(DummyData.itemList) { selectedItem ->
            openDetail(selectedItem)
        }
    }

    private fun openDetail(item: Item) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("name", item.name)
            putExtra("description", item.description)
            putExtra("price", item.price)
            putExtra("imageResId", item.imageResId)
        }
        startActivity(intent)
    }
}
