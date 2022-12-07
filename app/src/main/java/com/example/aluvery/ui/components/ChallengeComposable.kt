package com.example.aluvery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ChallengeComposable() {

    Row {
        Box(modifier = Modifier
            .width(100.dp)
            .height(150.dp)
            .background(Color.Blue)
        )
        Column(Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .padding(16.dp)
                ,
                text = "Teste 1"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                ,
                text = "Teste 2"
            )
        }

    }

}