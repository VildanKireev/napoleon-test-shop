package com.kireev.shop.model

/**
 * Модель для создания заказа
 */
data class CreateOrderModel(
    var lastName: String = "",

    var firstName: String = "",

    var patronymic: String = "",

    var phoneNumber: String = ""
)