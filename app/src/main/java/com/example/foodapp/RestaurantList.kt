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
import coil.compose.AsyncImage
data class Restaurante(
    val name: String,
    val image : String
)

@Composable
fun RestaurantList(){
    val restaurantes = listOf(
        Restaurante(
            "Burguer King",
            "https://www.pixartprinting.it/blog/wp-content/uploads/2021/03/logo-1999-min.jpg"
        ),
        Restaurante(
            "McDonalds",
            "https://hipfonts.com/wp-content/uploads/2022/08/McDonalds-logo-cover.jpg"
        ),
        Restaurante(
            "KFC",
            "https://cdn.produkto.io/photos/2025/05/24/kfc-logo-2006.webp"
        ),
        Restaurante(
            "Toks",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRj4Lkp29GKsWYnnUeUImyw7Esifh16p5w9g&s"
        ),
        Restaurante(
            "Starbucks",
            "https://static.vecteezy.com/system/resources/previews/044/625/960/non_2x/starbucks-logotype-on-white-background-starbucks-corporation-logo-american-coffee-company-chain-of-coffee-houses-popular-drinks-beverage-take-with-you-cafe-editorial-free-vector.jpg"
        ),
        Restaurante(
            "Subway",
            "https://gkpb.com.br/wp-content/uploads/2016/08/simbolo-subway-blog-gkpb.jpg"
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