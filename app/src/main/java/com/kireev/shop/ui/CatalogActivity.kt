package com.kireev.shop.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.kireev.shop.R
import com.kireev.shop.presenter.CatalogPresenter
import kotlinx.android.synthetic.main.catalog_layout.*

class CatalogActivity : BaseActivity(), CatalogView {

    private val presenter = CatalogPresenter()

    private val adapter = CategoryAdapter { category ->
        presenter.removeItem(category)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.catalog_layout)

        catalogProductButton.setOnClickListener {
            startActivity(Intent(this, ProductActivity::class.java))
        }

        categoryRv.layoutManager = LinearLayoutManager(this)
        categoryRv.adapter = adapter

        presenter.attachView(this)
        presenter.setData()
    }

    override fun setCategories(list: List<String>) {
        adapter.setData(list)
    }

    override fun removeItem(position: Int) {
        adapter.notifyItemRemoved(position)
    }
}