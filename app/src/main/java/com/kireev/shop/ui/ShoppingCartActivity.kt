package com.kireev.shop.ui

import android.content.Intent
import android.os.Bundle
import com.kireev.shop.R
import kotlinx.android.synthetic.main.shopping_cart_layout.*

class ShoppingCartActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_cart_layout)

        shoppingCartCheckoutButton.setOnClickListener {
            startActivity(Intent(this, CheckoutActivity::class.java))
        }

        shoppingCartBackButton.setOnClickListener {
            finish()
        }
    }
}