package com.example.cardapiodigital.data

import com.example.cardapiodigital.R

object DummyData {
    val itemList = listOf(
        Item(
            id = 1,
            name = "Pizza Margherita",
            description = "Molho de tomate, mussarela, manjericão fresco.",
            price = 35.90,
            category = "Pratos Principais",
            imageResId = R.drawable.pizza
        ),
        Item(
            id = 2,
            name = "Hambúrguer Artesanal",
            description = "Pão brioche, carne 180g, cheddar, bacon e cebola caramelizada.",
            price = 29.90,
            category = "Pratos Principais",
            imageResId = R.drawable.burger
        ),
        Item(
            id = 3,
            name = "Salada Caesar",
            description = "Alface romana, croutons, parmesão e molho caesar.",
            price = 22.00,
            category = "Entradas",
            imageResId = R.drawable.salada
        ),
        Item(
            id = 4,
            name = "Suco Natural",
            description = "Suco de laranja natural, sem adição de açúcar.",
            price = 7.50,
            category = "Bebidas",
            imageResId = R.drawable.suco
        ),
        Item(
            id = 5,
            name = "Brownie com Sorvete",
            description = "Brownie de chocolate com uma bola de sorvete de creme.",
            price = 14.50,
            category = "Sobremesas",
            imageResId = R.drawable.brownie
        )
    )
}
