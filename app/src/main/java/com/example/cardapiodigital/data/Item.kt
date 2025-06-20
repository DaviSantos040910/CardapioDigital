package com.example.cardapiodigital.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val category: String,
    @DrawableRes val imageResId: Int

): Parcelable