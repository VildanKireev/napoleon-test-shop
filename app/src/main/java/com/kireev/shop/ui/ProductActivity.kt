package com.kireev.shop.ui

import android.content.Intent
import android.os.Bundle
import com.kireev.shop.R
import kotlinx.android.synthetic.main.product_layout.*

class ProductActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_layout)

        productShoppingCartButton.setOnClickListener {
            startActivity(Intent(this, ShoppingCartActivity::class.java))
        }

        productBackButton.setOnClickListener {
            finish()
        }
    }
}