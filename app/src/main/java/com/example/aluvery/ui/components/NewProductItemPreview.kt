package com.example.aluvery.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aluvery.ui.theme.Purple40
import com.example.aluvery.ui.theme.Purple500
import com.example.aluvery.ui.theme.Purple80

@Preview(showBackground = true)
@Composable
fun NewProductItemPreview() {
    Surface(
        Modifier.padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 5.dp
    ) {
        Row(
            Modifier
                .height(200.dp)
                .width(350.dp)
        ) {
            val imageSize = 100.dp
            Column {
                Box(
                    Modifier
                        .fillMaxHeight()
                        .width(imageSize)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Purple40, Purple80
                                )
                            )
                        )
                ) {

//                    Image(
//                        painter = painterResource(id = R.drawable.ic_launcher_background),
//                        contentDescription = "",
//                        modifier = Modifier
//                            .size(imageSize)
//                            .align(Alignment.Center)
//                            .offset(x = imageSize / 2)
//                            .clip(shape = CircleShape)
//                            .border(BorderStroke(2.dp, Purple500), shape = CircleShape)
//                    )
                }
            }

            Spacer(modifier = Modifier.width(imageSize / 2))

            Column(
                Modifier.fillMaxHeight()
            ) {
                Text(
                    text = LoremIpsum(50).values.first(),
                    textAlign = TextAlign.Center ,
                    modifier = Modifier
                        .padding(32.dp)
                        .wrapContentHeight()
                    ,
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}