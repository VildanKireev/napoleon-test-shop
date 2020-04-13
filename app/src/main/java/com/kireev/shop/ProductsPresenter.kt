package com.kireev.shop

class ProductsPresenter(
    val view: ProductsView
) {

    private val iphoneCase = Product(price = 123.5, salePercent = 30, productName = "iPhone Case")
    private val honorCase = Product(price = 56.7, salePercent = 10, productName = "Honor Case")
    private val samsungCase = Product(price = 98.7, salePercent = 20, productName = "Samsung Case")
    private val meizuCase = Product(price = 34.5, salePercent = 5, productName = "Meizu Case")

    private val products: List<Product> = listOf(iphoneCase, honorCase, samsungCase, meizuCase)

    fun pricePrint() {
        //view.print(iphoneCase.calcDiscountPrice())
        /*products.forEach { product ->
            view.print(product.calcDiscountPrice())
        }*/
        products.forEach {
            view.print(products.sumByDouble(Product::calcDiscountPrice))
        }
    }

    fun productNamePrint() {
        view.print(iphoneCase.getProductName())
        /*products.forEach { product ->
            view.print(product.getProductName())
        }*/
    }

    fun productNameAndPricePrint() {
        view.print(iphoneCase)
        /*products.forEach { product ->
            view.print(product)
        }*/
    }
}