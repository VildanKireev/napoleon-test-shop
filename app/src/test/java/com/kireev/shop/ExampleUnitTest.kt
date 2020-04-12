package com.kireev.shop

import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun example() {

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

        val iphoneCase = Product(price = 123.5, salePercent = 30)
        val samsungCase = Product(price = 300.5, salePercent = 99)

        val pricePrinter: PricePrinter = CleanKotlinPricePrinter()

        val discountIphoneCasePrice = iphoneCase.calcDiscountPrice()
        val formattedIphoneCasePrice = pricePrinter.print(discountIphoneCasePrice)
        println(formattedIphoneCasePrice)

        val discountSamsungCasePrice = samsungCase.calcDiscountPrice()
        pricePrinter.print(discountSamsungCasePrice)
    }
}

interface PricePrinter {

    /**
     * Outputs price in <Price>P format.
     * If price have not fractional part then it will be printed as integer
     * If price have fractional part then it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)
}

class CleanKotlinPricePrinter : PricePrinter {

    override fun print(price: Double) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
