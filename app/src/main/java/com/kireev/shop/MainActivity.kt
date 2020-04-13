package com.kireev.shop

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ProductsView {

    private val presenter = ProductsPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.pricePrint()
    }

    override fun print(price: Double) {
        Toast.makeText(this, "Price: $price", Toast.LENGTH_LONG).show()
        Log.d("Print", "Price: $price")
    }

    override fun print(name: String) {
        Toast.makeText(this, "Name: $name", Toast.LENGTH_LONG).show()
        Log.d("Print", "Price: $name")
    }

    override fun print(product: Product) {
        Toast.makeText(
            this,
            "${product.getProductName()} : ${product.calcDiscountPrice()}",
            Toast.LENGTH_LONG
        ).show()
        Log.d("Print", "${product.getProductName()} : ${product.calcDiscountPrice()}")
    }
}
