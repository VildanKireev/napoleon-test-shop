package com.kireev.shop

class Product(

    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int,
    private val productName: String
) {

    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 then product will have negative price
     * If [salePercent] is less than 0 then product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)

    fun getProductName(): String = productName
}