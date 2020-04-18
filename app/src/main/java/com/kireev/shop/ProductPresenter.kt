package com.kireev.shop

import moxy.MvpPresenter

class ProductPresenter : MvpPresenter<ProductView>() {

    private val iphoneCase = Product(price = 123.5, discount = 30, productName = "iPhone Case")
    private val honorCase = Product(price = 56.7, discount = 10, productName = "Honor Case")
    private val samsungCase = Product(price = 98.7, discount = 20, productName = "Samsung Case")
    private val meizuCase = Product(price = 34.5, discount = 5, productName = "Meizu Case")

    private val model = CreateOrderModel()

    private fun checkSymbols(text: String): Boolean = text.length < 3

    fun pricePrint() {
        viewState.print(iphoneCase.getDiscountPrice())
    }

    fun productNamePrint() {
        viewState.print(iphoneCase.getProductName())
    }

    fun productNameAndPricePrint() {
        viewState.print(iphoneCase)
    }
}