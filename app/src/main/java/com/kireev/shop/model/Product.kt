package com.kireev.shop.model

class Product(

    /**
     * Должна быть положительной
     */
    private val price: Double,
    private val discount: Int,
    private val productName: String
) {

    /**
     * @return <discountPrice>, определяемую по [discount]
     *
     * Если [discount] больше 100, то товар будет иметь отрицательную цену
     * Если [discount] меньше 0, тогда цена товара будет увеличена
     */
    fun getDiscountPrice(): Double = price * (1 - discount / 100.0)

    fun getProductName(): String = productName
}