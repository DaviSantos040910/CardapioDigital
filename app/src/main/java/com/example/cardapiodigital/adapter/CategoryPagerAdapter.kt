package com.example.cardapiodigital.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cardapiodigital.data.Item
import com.example.cardapiodigital.ui.fragment.CategoryFragment

class CategoryPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val categories: List<String>,
    private val itemList: List<Item>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = categories.size

    override fun createFragment(position: Int): Fragment {
        val category = categories[position]
        val filteredItems = ArrayList(itemList.filter { it.category == category }) // filtro correto
        return CategoryFragment.newInstance(category, filteredItems)
    }

}
