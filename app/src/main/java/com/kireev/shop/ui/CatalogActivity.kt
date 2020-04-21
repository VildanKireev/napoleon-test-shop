package com.kireev.shop.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.kireev.shop.R
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

        Log.d(tag, savedInstanceState.toString())
        val savedInt = savedInstanceState?.getInt(SAVE_STATE_INT)
        Log.d(tag, "saved $savedInt")

        catalogCheckoutButton.setOnClickListener {
            val intent = Intent(this, CheckoutActivity::class.java).apply {
                putExtra(PRODUCT_ID, 1000)
            }
            startActivityForResult(intent, REQUEST_AUTH)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(SAVE_STATE_INT, 89)
        super.onSaveInstanceState(outState)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (REQUEST_AUTH == requestCode) {
            val isUserAuth = data?.extras?.getBoolean(IS_USER_AUTH)
            Log.d(tag, isUserAuth.toString())
        }
    }

    companion object {
        const val PRODUCT_ID = "PRODUCT_ID"
        const val REQUEST_AUTH: Int = 10
        const val IS_USER_AUTH = "IS_USER_AUTH"
        const val SAVE_STATE_INT = "SAVE_STATE_INT"
    }
}