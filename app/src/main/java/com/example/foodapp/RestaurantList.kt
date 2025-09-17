package com.example.foodapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter

data class Restaurante(
    val name: String,
    val image : String
)

@Composable
fun RestaurantList(){
    val restaurantes = listOf(
        Restaurante(
            "Burguer King",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/Burger_King_logo_%281999%E2%80%932020%29.svg/1012px-Burger_King_logo_%281999%E2%80%932020%29.svg.png"
        ),
        Restaurante(
            "McDonalds",
            "https://cdn-icons-png.flaticon.com/512/5977/5977588.png"
        ),
        Restaurante(
            "KFC",
            "https://cdn.iconscout.com/icon/free/png-256/free-kfc-icon-svg-download-png-226243.png"
        ),
        Restaurante(
            "Toks",
            "https://assets.galerias.com/v3/assets/blt1232874328ea9d91/bltb37e1539b08f69a0/6786ebc143dfa277144361cb/toks.png?branch=main_a"
        ),
        Restaurante(
            "Starbucks",
            "https://upload.wikimedia.org/wikipedia/sco/thumb/d/d3/Starbucks_Corporation_Logo_2011.svg/477px-Starbucks_Corporation_Logo_2011.svg.png"
        ),
        Restaurante(
            "Subway",
            "https://newsroom.subway.com/download/Subway+Choicemark.png"
        )
    )
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(restaurantes){ restaurante ->
            RestaurantItem(restaurante = restaurante)
        }
    }
}

@Composable
fun RestaurantItem(restaurante: Restaurante){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier.size(120.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            AsyncImage(
                model = restaurante.image,
                contentDescription = restaurante.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp))
            )
        }
        Text(
            text = restaurante.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}