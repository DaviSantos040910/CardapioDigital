package com.example.cardapiodigital.data

import androidx.annotation.DrawableRes

data class Item(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    @DrawableRes val imageResId: Int
)