package com.kireev.shop

class ShoppingCartPresenter(
    private val view: ProductView
) {

    private val iphoneCase = Product(price = 123.5, discount = 30, productName = "iPhone Case")
    private val honorCase = Product(price = 56.7, discount = 10, productName = "Honor Case")
    private val samsungCase = Product(price = 98.7, discount = 20, productName = "Samsung Case")
    private val meizuCase = Product(price = 34.5, discount = 5, productName = "Meizu Case")

    private val products: List<Product> = listOf(iphoneCase, honorCase, samsungCase, meizuCase)

    fun pricesPrint() {
        products.forEach { product ->
            view.print(product.getDiscountPrice())
        }
    }

    fun productNamesPrint() {
        products.forEach { product ->
            view.print(product.getProductName())
        }
    }

    fun productNamesAndPricesPrint() {
        products.forEach { product ->
            view.print(product)
        }
    }

    fun totalPricePrint() {
        products.forEach { _ ->
            view.print(products.sumByDouble(Product::getDiscountPrice))
        }
    }

    fun productNamesAndPricesWithTotalPricePrint() {
        products.forEach { product ->
            view.print(product)
        }
        view.print(products.sumByDouble(Product::getDiscountPrice))
    }
}