package com.example.cardapiodigital.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cardapiodigital.R
import com.example.cardapiodigital.data.Item
import com.example.cardapiodigital.databinding.ActivityHomeBinding
import com.example.cardapiodigital.adapter.CategoryPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val itemList = listOf(
        Item(1, "Pizza Margherita", "Tomate, mozzarella, manjericão", 29.90,"Pratos Principais",R.drawable.exemplo_prato),
        Item(2, "Burger Clássico", "Carne, queijo, alface, tomate", 25.50,"Pratos Principais",R.drawable.exemplo_prato),
        Item(3, "Salada Caesar", "Alface, croutons, molho caesar", 19.90,"Entradas", R.drawable.exemplo_prato),
        Item(4, "Sorvete", "Sorvete sabor chocolate", 12.00, "Sobremesas",R.drawable.exemplo_prato)
        // adicione mais...
    )


    private val categories = itemList.map { it.category }.distinct()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)

        val pagerAdapter = CategoryPagerAdapter(this, categories, itemList)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = categories[position]
        }.attach()
    }
}
