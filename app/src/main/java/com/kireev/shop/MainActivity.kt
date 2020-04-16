package com.kireev.shop

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ProductView {

    private val productPresenter = ProductPresenter(this)
    private val shoppingCartPresenter = ShoppingCartPresenter(this)
    private val priceFormatter = PriceFormatter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shoppingCartPresenter.productNamesAndPricesWithTotalPricePrint()
    }

    override fun print(price: Double) {
        Toast.makeText(this, "Price: ${priceFormatter.formatPrice(price)}₽", Toast.LENGTH_LONG)
            .show()
        Log.d("Print", "Price: ${priceFormatter.formatPrice(price)}₽")
    }

    override fun print(name: String) {
        Toast.makeText(this, "Name: $name", Toast.LENGTH_LONG).show()
        Log.d("Print", "Name: $name")
    }

    override fun print(product: Product) {
        Toast.makeText(
            this,
            "${product.getProductName()}: ${priceFormatter.formatPrice(product.getDiscountPrice())}}₽",
            Toast.LENGTH_LONG
        ).show()
        Log.d(
            "Print",
            "${product.getProductName()}: ${priceFormatter.formatPrice(product.getDiscountPrice())}₽"
        )
    }
}
