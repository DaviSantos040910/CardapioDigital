package com.example.cardapiodigital.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.cardapiodigital.R
import com.example.cardapiodigital.adapter.CategoryPagerAdapter
import com.example.cardapiodigital.data.Item
import com.example.cardapiodigital.databinding.ActivityHomeBinding
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

    private lateinit var allCategories: List<String>
    private var filteredItems: List<Item> = itemList.toList()
    private var selectedCategories: MutableSet<String> = mutableSetOf()

    private lateinit var pagerAdapter: CategoryPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)

        allCategories = itemList.map { it.category }.distinct()
        selectedCategories.addAll(allCategories)

        setupViewPager(filteredItems)

        binding.searchEditText.addTextChangedListener { text ->
            val query = text.toString().trim()
            filterItems(query)
        }

        binding.filterButton.setOnClickListener {
            showFilterDialog()
        }
    }



    private fun setupViewPager(items: List<Item>) {
        val categories = items.map { it.category }.distinct()
        pagerAdapter = CategoryPagerAdapter(this, categories, items)
        binding.viewPager.adapter = pagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = categories[position]
        }.attach()
        binding.viewPager.startAnimation(
            AnimationUtils.loadAnimation(this, R.anim.layout_fade)
        )

    }

    private fun filterItems(query: String) {
        filteredItems = itemList.filter {
            it.name.contains(query, ignoreCase = true) && selectedCategories.contains(it.category)
        }
        setupViewPager(filteredItems)
    }

    private fun showFilterDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_filter, null)
        val checkboxContainer = dialogView.findViewById<LinearLayout>(R.id.category_checkboxes)

        checkboxContainer.removeAllViews()
        val checkboxes = mutableMapOf<String, CheckBox>()

        allCategories.forEach { category ->
            val checkbox = CheckBox(this).apply {
                text = category
                isChecked = selectedCategories.contains(category)
            }
            checkboxContainer.addView(checkbox)
            checkboxes[category] = checkbox
        }

        AlertDialog.Builder(this)
            .setTitle("Escolha as categorias")
            .setView(dialogView)
            .setPositiveButton("Aplicar") { _, _ ->
                selectedCategories.clear()
                selectedCategories.addAll(checkboxes.filter { it.value.isChecked }.keys)
                filterItems(binding.searchEditText.text.toString())
            }
            .setNegativeButton("Cancelar", null)
            .show()
    }
}
