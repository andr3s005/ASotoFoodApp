package com.example.foodapp

import androidx.compose.runtime.Composable


data class Comida(
    val name : String,
    val image : String,
    val rating : Double,
    val price : String
)

@Composable
fun FoodList(){
    val comidas = listOf(
        Comida(
            "Hamburguesa",
            "",
            5.0,
            "$50.00"
        )
    )
}