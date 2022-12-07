package com.example.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyFirstComposable() {
    Column() {
        Text(text = "Meu Primeiro Texto")
        Text(text = "Meu segundo texto")
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    Column {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
    }
}

@Preview(showBackground = true)
@Composable
fun RowPreview() {
    Row {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    Box {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomLayoutPreview() {
    Column(
        Modifier
        .background(color = Color.Blue)
        .padding(all = 8.dp)
        .fillMaxHeight()
        .fillMaxWidth()
    ) {
        Text(text = "Texto 1")
        Text(text = "Texto 2")
        Row(modifier = Modifier
            .padding(16.dp)
            .background(Color.Green)
            .fillMaxWidth()
        ) {
            Text(text = "Texto 3")
            Text(text = "Texto 4")
        }
        Box(modifier = Modifier
            .padding(16.dp)
            .background(Color.Red)
        ) {
            Row(modifier = Modifier
                .padding(16.dp)
                .background(Color.Cyan)
                .fillMaxWidth()
            ) {
                Text(text = "Texto 5")
                Text(text = "Texto 6")
            }
            Column(modifier = Modifier
                .padding(16.dp)
                .background(Color.Yellow)
            ) {
                Text(text = "Texto 7")
                Text(text = "Texto 8")
            }
        }
    }

}