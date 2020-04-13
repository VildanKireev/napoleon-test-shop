package com.kireev.shop

import org.junit.Test
import kotlin.math.round
import kotlin.math.roundToInt

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ShopTest {

    @Test
    fun productTest() {
        val iphoneCase = Product(price = 123.5, salePercent = 30)
        val pricePrinter: PricePrinter = ConsolePricePrinter()
        pricePrinter.printProductPrice(iphoneCase)
    }

    @Test
    fun shoppingCartTest() {
        val iphoneCase = Product(price = 123.5, salePercent = 30)
        val honorCase = Product(price = 56.7, salePercent = 10)
        val samsungCase = Product(price = 98.7, salePercent = 20)
        val meizuCase = Product(price = 34.5, salePercent = 5)
        val productList: List<Product> = listOf(iphoneCase, honorCase, samsungCase, meizuCase)
        val shoppingCart = ShoppingCart(productList)
        val pricePrinter: PricePrinter = ConsolePricePrinter()
        pricePrinter.printTotalPrice(shoppingCart)
    }
}

class Product(

    /**
     * Must be positive
     */
    private val price: Double,
    private val salePercent: Int
) {

    /**
     * @return price with applied discount determined by [salePercent]
     *
     * If [salePercent] is more than 100 then product will have negative price
     * If [salePercent] is less than 0 then product price will be increased
     */
    fun calcDiscountPrice(): Double = price * (1 - salePercent / 100.0)
}

interface PricePrinter {

    /**
     * Outputs price in <Price>P format.
     * If price have not fractional part then it will be printed as integer
     * If price have fractional part then it will be rounded for 2 symbols after "."
     */
    fun printProductPrice(product: Product)

    fun printTotalPrice(shoppingCart: ShoppingCart)
}

class ConsolePricePrinter : PricePrinter {

    override fun printProductPrice(product: Product) {
        println("Цена за единицу товара: ${format(product.calcDiscountPrice())}")
    }

    override fun printTotalPrice(shoppingCart: ShoppingCart) {
        shoppingCart.products.forEach(::printProductPrice)
        println("Итоговая цена за все товары: ${format(shoppingCart.calcTotalDiscountPrice())}")
    }

    private fun format(price: Double): String {
        val discountPriceRounded = round(price * 100) / 100
        return when {
            discountPriceRounded % 1.0 == 0.0 -> {
                "${discountPriceRounded.roundToInt()}₽"
            }
            else -> {
                "${discountPriceRounded}₽"
            }
        }
    }
}

class ShoppingCart(val products: List<Product> = emptyList()) {

    fun calcTotalDiscountPrice(): Double {
        return products.map { product -> product.calcDiscountPrice() }.sum()
    }
}
