package com.kireev.shop.presenter

import com.kireev.shop.model.Product
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProductView : MvpView {

    /**
     * Выводит цену в формате <price> ₽.
     * Если цена не имеет дробной части, то она будет напечатана как целое число
     * Если цена имеет дробную часть, то она будет округлена на 2 символа после "."
     */
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun print(price: Double)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun print(name: String)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun print(product: Product)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForLastName(visible: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForFirstName(visible: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForPatronymic(visible: Boolean)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showErrorForPhoneNumber(visible: Boolean)
}