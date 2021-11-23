package com.example.listas_jorge_carlos_parra

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable
fun Vista2(img: String, title: String, info: String) {
    @Composable
    fun CargarImagen(img: String) {
        Image(
            painter = rememberImagePainter(img),
            contentDescription = "Imagen",
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .height(300.dp),
            contentScale = ContentScale.FillWidth
        )
    }

    @Composable
    fun ColocarTexto(title: String, info: String){
        Column(Modifier.padding(8.dp)) {
            Text(text = title, style = typography.h3)
            Text(text = info)
        }
    }

    Box(
        Modifier.fillMaxSize(),
    ){
        Column() {
            CargarImagen(img = img)
            ColocarTexto(title = title, info = info)
        }
    }
}