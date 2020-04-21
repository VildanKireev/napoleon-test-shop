package com.kireev.shop.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.kireev.shop.*
import com.kireev.shop.ui.CatalogActivity.Companion.IS_USER_AUTH
import com.kireev.shop.ui.CatalogActivity.Companion.PRODUCT_ID
import com.kireev.shop.ui.CatalogActivity.Companion.REQUEST_AUTH
import kotlinx.android.synthetic.main.activity_main.*

class CheckoutActivity : BaseActivity(), ProductView {

    private val shoppingCartPresenter = ShoppingCartPresenter()
    private val priceFormatter = PriceFormatter()
    private var isAuth: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productID = intent.extras?.getInt(PRODUCT_ID, -1)
        Log.d(tag, productID.toString())

        shoppingCartPresenter.attachView(this)

        setListeners()

        checkoutPay.setOnClickListener {
            isAuth = true
            setResult(REQUEST_AUTH, Intent().apply {
                putExtra(IS_USER_AUTH, isAuth)
            })
        }
    }

    private fun setListeners() {

        checkoutLastName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                shoppingCartPresenter.checkLastName(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutFirstName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                shoppingCartPresenter.checkFirstName(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutPatronymic.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                shoppingCartPresenter.checkPatronymic(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        checkoutPhone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                shoppingCartPresenter.checkPhoneNumber(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
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

    override fun showErrorForLastName(visible: Boolean) {
        checkoutLastName.showError(visible)
    }

    override fun showErrorForFirstName(visible: Boolean) {
        checkoutFirstName.showError(visible)
    }

    override fun showErrorForPatronymic(visible: Boolean) {
        checkoutPatronymic.showError(visible)
    }

    override fun showErrorForPhoneNumber(visible: Boolean) {
        checkoutPhone.showError(visible)
    }

    private fun EditText.showError(visible: Boolean) {
        val drawable = if (visible) R.drawable.ic_error
        else 0

        this.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable, 0)
    }
}
