package com.example.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
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
import com.example.aluvery.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                NewProductItem()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ProductItem() {

    Surface(
        Modifier.padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 5.dp
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 300.dp)
                .width(200.dp)
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageSize)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Purple500, Teal200
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "Imagem do produto",
                    modifier = Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(BottomCenter)
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(
                Modifier.padding(16.dp)
            ) {
                Text(
                    text = LoremIpsum(50).values.first(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "R$ 14,99",
                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun NewProductItem() {
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
            Column() {
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

                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "",
                        modifier = Modifier
                            .size(imageSize)
                            .align(Center)
                            .offset(x = imageSize / 2)
                            .clip(shape = CircleShape)
                            .border(BorderStroke(2.dp, Purple500), shape = CircleShape)
                    )
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

