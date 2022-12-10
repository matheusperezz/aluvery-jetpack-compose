package com.example.aluvery.model

import androidx.annotation.DrawableRes
import com.example.aluvery.R
import java.math.BigDecimal

class Product(
    val name: String,
    val price: BigDecimal,
    @DrawableRes val image: Int = R.drawable.placeholder,
    val description: String? = null
)