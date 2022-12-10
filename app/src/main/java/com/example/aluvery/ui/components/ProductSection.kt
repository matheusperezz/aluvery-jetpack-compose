package com.example.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aluvery.R.drawable
import com.example.aluvery.model.Product
import java.math.BigDecimal

@Composable
fun ProductsSection(
    title: String,
    products: List<Product>
) {

    Column {
        Text(
            text = title,
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

            for (product in products){
                ProductItem(product = product)
            }

            Spacer(Modifier)


        }
    }


}

@Preview(showBackground = true)
@Composable
private fun ProductsSectionPreview() {

    ProductsSection("Promoções", sampleProducts)

}

val sampleProducts = listOf(

    Product(
        name = "Teste",
        price = BigDecimal("39.99"),
        description = "a"
    ),

    Product(
        name = "Fries",
        price = BigDecimal("8.99"),
        image = drawable.fries
    ),

    Product(
        name = "Pizza",
        price = BigDecimal("21.99"),
        image = drawable.pizza
    )
)