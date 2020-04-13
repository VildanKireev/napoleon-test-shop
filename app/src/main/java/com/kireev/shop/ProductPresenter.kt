package com.kireev.shop

class ProductPresenter(
    private val view: ProductView
) {

    private val iphoneCase = Product(price = 123.5, discount = 30, productName = "iPhone Case")
    private val honorCase = Product(price = 56.7, discount = 10, productName = "Honor Case")
    private val samsungCase = Product(price = 98.7, discount = 20, productName = "Samsung Case")
    private val meizuCase = Product(price = 34.5, discount = 5, productName = "Meizu Case")



    fun pricePrint() {
        view.print(iphoneCase.getDiscountPrice())
    }

    fun productNamePrint() {
        view.print(iphoneCase.getProductName())
    }

    fun productNameAndPricePrint() {
        view.print(iphoneCase)
    }
}