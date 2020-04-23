package com.kireev.shop.model

class ShoppingCart(
    private val products: List<Product> = emptyList()
) {
    fun getTotalDiscountPrice(): Double {
        return products.map { product -> product.getDiscountPrice() }.sum()
    }
}