package com.kireev.shop.presenter

import kotlin.math.round
import kotlin.math.roundToInt

class PriceFormatter {

    fun formatPrice(price: Double): String {
        val priceRounded = round(price * 100) / 100
        return when {
            priceRounded % 1.0 == 0.0 -> {
                "${priceRounded.roundToInt()}"
            }
            else -> {
                "$priceRounded"
            }
        }
    }
}