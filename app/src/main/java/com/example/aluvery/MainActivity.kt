package com.example.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aluvery.extensions.toBrazilianCurrency
import com.example.aluvery.model.Product
import com.example.aluvery.ui.theme.AluveryTheme
import com.example.aluvery.ui.theme.Purple500
import com.example.aluvery.ui.theme.Teal200
import java.math.BigDecimal

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}


@Composable
fun App() {
    AluveryTheme {
        Surface {
            // ProductItem()
            // ProductsSection()
            Column(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Spacer(modifier = Modifier)
                ProductsSection()
                ProductsSection()
                ProductsSection()
                Spacer(modifier = Modifier)
            }
        }
    }
}

@Composable
fun ProductItem(product: Product) {

    Surface(
        Modifier.padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 5.dp
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 350.dp)
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
                    painter = painterResource(id = product.image),
                    contentDescription = "Imagem do produto",
                    modifier = Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(shape = CircleShape)
                        .align(BottomCenter),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(
                Modifier.padding(16.dp)
            ) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilianCurrency(),
                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400)
                )
            }
        }

    }

}

@Composable
fun ProductItemScrollable() {

    Surface(
        Modifier.padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 5.dp
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 250.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
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
                Modifier
                    .padding(16.dp)
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


            Text(
                text = LoremIpsum(30).values.first(),
                modifier = Modifier
                    .background(Purple500)
                    .padding(16.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color.White
            )
        }

    }


}

@Composable
fun ProductsSection() {

    Column {
        Text(
            text = "Promoções",
            Modifier.padding(start = 16.dp, end = 16.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(Modifier)

            ProductItem(
                Product(
                    name = "Burger",
                    price = BigDecimal("14.99"),
                    image = R.drawable.burger
                )
            )

            ProductItemScrollable()

            ProductItem(
                Product(
                    name = "Fries",
                    price = BigDecimal("8.99"),
                    image = R.drawable.fries
                )
            )

            ProductItem(
                Product(
                    name = "Pizza",
                    price = BigDecimal("21.99"),
                    image = R.drawable.pizza
                )
            )
        }
    }


}

@Preview(showSystemUi = true)
@Composable
fun AppPreview() {
    App()
}

@Preview(showBackground = true)
@Composable
fun ProductItemPreview() {

    val product = Product(
        name = LoremIpsum(50).values.first(),
        price = BigDecimal("15.99"),
    )
    ProductItem(product)

}

@Preview(showBackground = true)
@Composable
fun ProductItemScrollablePreview() {

    Surface(
        Modifier.padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 5.dp
    ) {
        Column(
            Modifier
                .heightIn(250.dp, 250.dp)
                .width(200.dp)
                .verticalScroll(rememberScrollState())
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
                Modifier
                    .padding(16.dp)
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


            Text(
                text = LoremIpsum(30).values.first(),
                modifier = Modifier
                    .background(Purple500)
                    .padding(16.dp),
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                color = Color.White
            )
        }

    }


}

@Preview(showBackground = true)
@Composable
fun ProductsSectionPreview() {

    ProductsSection()

}
