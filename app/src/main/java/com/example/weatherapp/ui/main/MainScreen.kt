package com.example.weatherapp.ui.main

import android.graphics.drawable.shapes.Shape
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.sharp.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.R

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MainScreen() {

    Column(
        Modifier.background(
            color = Color(0xFF6da7f1)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
                .shadow(
                    elevation = 6.dp,           // Shadow size
                    shape = RoundedCornerShape(26.dp), // Rounded corners
                    clip = false
                )
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF4e83c5),
                            Color(0xFF275CA0),
                            Color(0xFF275CA0),
                        ),
                    ),
                    shape = RoundedCornerShape(26.dp)
                )
        ) {

            Row(
                Modifier.padding(20.dp)
            ) {
                Column(
                    Modifier
                        .weight(1f)
                        .fillMaxWidth()

                ) {
                    Text("Berlin, Germany", color = Color.White
                    , fontSize = 18.sp)
                    Text("Berlin, Germany", color = Color.White,
                        fontSize = 14.sp)
                }
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .background(
                            color = Color(0xFFFFFFFF).copy(alpha = 0.25f),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .padding(5.dp)
                        .size(24.dp)
                )
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier
                        .background(
                            color = Color(0xFFFFFFFF).copy(alpha = 0.25f),
                            shape = RoundedCornerShape(6.dp)
                        )
                        .padding(5.dp)
                        .size(24.dp)
                )


            }

        }
        Row() {

        }

        Column(
            Modifier.fillMaxSize()
        ) { }

    }
}