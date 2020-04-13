package com.kireev.shop

class Product(

    /**
     * Must be positive
     */
    private val price: Double,
    private val discount: Int,
    private val productName: String
) {

    /**
     * @return price with applied discount determined by [discount]
     *
     * If [discount] is more than 100 then product will have negative price
     * If [discount] is less than 0 then product price will be increased
     */
    fun getDiscountPrice(): Double = price * (1 - discount / 100.0)

    fun getProductName(): String = productName
}