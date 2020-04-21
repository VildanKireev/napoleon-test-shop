package com.kireev.shop.ui

import android.content.Intent
import android.os.Bundle
import com.kireev.shop.R
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

        catalogProductButton.setOnClickListener {
            startActivity(Intent(this, ProductActivity::class.java))
        }
    }
}