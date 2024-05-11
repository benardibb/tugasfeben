package com.benardi.btnjc.models

import androidx.annotation.DrawableRes

data class Laptop(
    val brand: String,
    val model: String,
    val processor: String,
    val ramSizeGB: Int,
    val storageSizeGB: Int,
    val screenSizeInches: Double,
    val priceUSD: Double,
    @DrawableRes val imageResId: Int
)
