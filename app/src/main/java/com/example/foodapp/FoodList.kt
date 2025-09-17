package com.example.foodapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

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
            "https://thumbs.dreamstime.com/b/cheeseburger-americano-de-la-hamburguesa-cl%C3%A1sica-perfecta-de-la-hamburguesa-aislado-en-la-reflexi%C3%B3n-blanca-59054909.jpg",
            5.0,
            "$50.00"
        ),
        Comida(
            "Pizza",
            "https://static.vecteezy.com/system/resources/previews/045/383/391/non_2x/a-cheesy-delicious-pizza-with-tasty-pepperoni-on-a-transparent-background-png.png",
            4.1,
            "$100.00"
        ),
        Comida(
            "Tacos",
            "https://www.polloregio.com/wp-content/uploads/2022/08/2022_Pollo_Regio_August00208-Edit-1-1024x682.png",
            4.8,
            "$72.00"
        ),
        Comida(
            "Caramel Macchiato",
            "https://as1.ftcdn.net/jpg/05/22/52/30/1000_F_522523019_X6V9jVuyzeWzc4ksN2pzcm2HbNSXjUTl.jpg",
            5.0,
            "$98.00",
        ),
        Comida(
            "Sundae",
            "https://www.pngall.com/wp-content/uploads/13/Sundae-PNG-Image.png",
            4.3,
            "$75.00"
        ),
        Comida(
            "Chilaquiles",
            "https://uvn-brightspot.s3.amazonaws.com/assets/vixes/imj/elgranchef/c/chilaquilesgrandes.jpg",
            5.0,
            "$120.00"
        )
    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.heightIn(max = 500.dp)
    ) {
        items(comidas){ comida ->
            FoodItem(comida = comida)
        }
    }
}

@Composable
fun FoodItem(comida: Comida){
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
                .background(Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
            ){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(comida.image)
                    .allowRgb565(false)
                    .build(),
                contentDescription = comida.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()

            )
            Text(
                text = comida.price,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(top = 8.dp, end = 8.dp)
                    .background(Color(0xFFE55D5D), RoundedCornerShape(12.dp))
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            )
                }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = "Calificacion",
                    tint = Color(0xFFFFA500),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "${comida.rating} ${comida.name}",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}