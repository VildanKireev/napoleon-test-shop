package com.kireev.shop.presenter

import com.kireev.shop.model.CreateOrderModel
import com.kireev.shop.model.Product
import moxy.MvpPresenter

class ProductPresenter : MvpPresenter<ProductView>() {

    private val iphoneCase = Product(
        price = 123.5,
        discount = 30,
        productName = "iPhone Case"
    )
    private val honorCase = Product(
        price = 56.7,
        discount = 10,
        productName = "Honor Case"
    )
    private val samsungCase = Product(
        price = 98.7,
        discount = 20,
        productName = "Samsung Case"
    )
    private val meizuCase = Product(
        price = 34.5,
        discount = 5,
        productName = "Meizu Case"
    )

    private val model = CreateOrderModel()

    fun checkLastName(text: String) {
        if (!checkSymbols(text)) model.lastName = text
        viewState.showErrorForLastName(checkSymbols(text))
    }

    fun checkFirstName(text: String) {
        if (!checkSymbols(text)) model.firstName = text
        viewState.showErrorForFirstName(checkSymbols(text))
    }

    fun checkPatronymic(text: String) {
        if (!checkSymbols(text)) model.patronymic = text
        viewState.showErrorForPatronymic(checkSymbols(text))
    }

    fun checkPhoneNumber(text: String) {
        if (checkNumber(text)) model.phoneNumber = text
        viewState.showErrorForPhoneNumber(!checkNumber(text))
    }

    private fun checkSymbols(text: String): Boolean = text.length < 3

    private fun checkNumber(text: String): Boolean = Regex("(\\+7|8)\\d{10}").matches(text)

    fun pricePrint() {
        viewState.print(iphoneCase.getDiscountPrice())
    }

    fun productNamePrint() {
        viewState.print(iphoneCase.getProductName())
    }

    fun productNameAndPricePrint() {
        viewState.print(iphoneCase)
    }
}