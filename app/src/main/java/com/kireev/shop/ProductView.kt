package com.kireev.shop

interface ProductView {

    /**
     * Outputs price in <Price>P format.
     * If price have not fractional part then it will be printed as integer
     * If price have fractional part then it will be rounded for 2 symbols after "."
     */
    fun print(price: Double)

    fun print(name: String)

    fun print(product: Product)
}