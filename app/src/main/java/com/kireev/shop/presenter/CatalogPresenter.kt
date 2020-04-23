package com.kireev.shop.presenter

import com.kireev.shop.ui.CatalogView
import moxy.MvpPresenter

class CatalogPresenter : MvpPresenter<CatalogView>() {

    val list = mutableListOf(
        "Телевизоры",
        "Телефоны",
        "Планшеты",
        "Часы",
        "Компьютеры",
        "Ноутбуки"
    )

    fun setData() {
        viewState.setCategories(list)
    }

    fun removeItem(category: String) {
        val position = list.indexOf(category)
        list.remove(category)
        viewState.removeItem(position)
    }

}