package com.kireev.shop

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductView {

    private val shoppingCartPresenter = ShoppingCartPresenter()
    private val priceFormatter = PriceFormatter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        shoppingCartPresenter.attachView(this)

        setListeners()
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
