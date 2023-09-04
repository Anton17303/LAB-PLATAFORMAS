package com.uvg.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uvg.lab5.ui.theme.Lab5Theme

class GALERIA : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab5Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MiGaleriaScreen()
                }
            }
        }
    }

    @Composable
    fun MiGaleriaScreen() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Mi Galería",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Aquí puedes agregar tus imágenes y textos personalizados
            // Puedes usar LazyColumn para mostrar una lista de elementos
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(10) { index ->
                    Image(
                        painter = painterResource(id = R.drawable.img), // Reemplaza con tu recurso de imagen
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp) // Personaliza el tamaño de la imagen
                            .clip(MaterialTheme.shapes.medium), // Agrega un borde redondeado
                        contentScale = ContentScale.Crop // Ajusta la escala de la imagen según tus necesidades
                    )
                    Image(
                        painter = painterResource(id = R.drawable.img_1), // Reemplaza con tu recurso de imagen
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp) // Personaliza el tamaño de la imagen
                            .clip(MaterialTheme.shapes.medium), // Agrega un borde redondeado
                        contentScale = ContentScale.Crop // Ajusta la escala de la imagen según tus necesidades
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Descripción de la imagen $index", // Reemplaza con tu texto
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Agrega la opción de Logout en algún lugar de la pantalla
            Button(
                onClick = {
                    // Implementa la lógica de Logout aquí
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Logout")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MiGaleriaScreenPreview() {
    Lab5Theme {
        GALERIA().MiGaleriaScreen()

    }
}

