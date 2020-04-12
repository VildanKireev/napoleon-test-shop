package com.kireev.shop

import org.junit.Test
import kotlin.math.round
import kotlin.math.roundToInt

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun example() {

        val iphoneCase = Product(price = 123.5, salePercent = 30)

        val pricePrinter: PricePrinter = PricePrinterImplementation()

        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
        pricePrinter.print(discountIphoneCasePrice)
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
    fun print(price: Double)
}

class PricePrinterImplementation : PricePrinter {

    override fun print(price: Double) {
        val priceRounded = round(price * 100) / 100
        when {
            priceRounded % 1.0 == 0.0 -> {
                println("${priceRounded.roundToInt()}₽")
            }
            else -> {
                println("$priceRounded₽")
            }
        }
    }

}
