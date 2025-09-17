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
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import coil3.decode.DataSource

data class Category(
    val name : String,
    val image : String
)

@Composable
fun CategoryList(){
    val categories = listOf(
        Category(
            name = "Comida Rapida",
            image = "https://img.pikbest.com/png-images/20240830/fast-food-vector-art--7c-white-background-graphic-design_10772929.png!sw800"
        ),
        Category(
            name = "Italiana",
            image = "https://png.pngtree.com/png-clipart/20240629/original/pngtree-3d-food-and-italian-flag-food-icons-illustration-vector-png-image_15439337.png"
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