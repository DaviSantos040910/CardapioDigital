package com.example.cardapiodigital.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cardapiodigital.R
import com.example.cardapiodigital.adapter.ItemAdapter
import com.example.cardapiodigital.data.Item
import com.example.cardapiodigital.ui.activity.DetailActivity

class CategoryFragment : Fragment() {

    companion object {
        private const val ARG_CATEGORY = "category"
        private const val ARG_ITEMS = "items"

        fun newInstance(category: String, items: ArrayList<Item>) = CategoryFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_CATEGORY, category)
                putParcelableArrayList(ARG_ITEMS, items)
            }
        }
    }

    private lateinit var category: String
    private lateinit var itemList: List<Item>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = arguments?.getString(ARG_CATEGORY) ?: ""
        itemList = arguments?.getParcelableArrayList(ARG_ITEMS) ?: emptyList()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_category, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        //val filteredItems = itemList.filter { it.category == category }
        val filteredItems = itemList // <-- remove o filtro só pra testar

        adapter = ItemAdapter(filteredItems) { item ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("itemName", item.name)
            intent.putExtra("itemDescription", item.description)
            intent.putExtra("itemPrice", item.price)
            intent.putExtra("itemImage", item.imageResId)
            startActivity(intent)
        }
        recyclerView.adapter = adapter

        return view
    }
}
