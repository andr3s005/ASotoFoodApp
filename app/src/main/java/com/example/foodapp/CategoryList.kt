package com.example.foodapp

import android.graphics.ImageDecoder
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class Category(
    val name : String,
    val image : String
)

@Composable
fun CategoryList(){
    val categories = listOf(
        Category(
            name = "Comida Rapida",
            image = "https://openclipart.org/image/2000px/289282"
        ),
        Category(
            name = "Italiana",
            image = "https://images.vexels.com/media/users/3/220598/isolated/preview/a13e4b43b618b66cc5782a819a81f393-spaghetti-italian-cuisine-flat.png"
        ),
        Category(
            name = "China",
            image = "https://www.pngplay.com/wp-content/uploads/15/Chinese-Food-Box-PNG-Clipart-Background.png"
        ),
        Category(
            name = "Mexicana",
            image = "https://static.vecteezy.com/system/resources/thumbnails/006/601/767/small_2x/mexico-flag-with-waving-effect-official-proportion-vector.jpg"
        ),
        Category(
            name = "Panaderia",
            image = "https://cdn-icons-png.flaticon.com/512/7627/7627796.png"
        ),
        Category(
            name = "Café",
            image = "https://cdn-icons-png.flaticon.com/512/8230/8230211.png"
        )
    )

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories){ category ->
            CategoryItem(category = category)
        }
    }
}

@Composable
fun CategoryItem(category: Category){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier.size(64.dp),
            shape = CircleShape
        ) {
            AsyncImage(
                model = category.image,
                contentDescription = category.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFFFA500))
            )
        }
        Text(
            text = category.name,
            fontSize = 12.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}