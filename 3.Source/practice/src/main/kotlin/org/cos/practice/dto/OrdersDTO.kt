package org.cos.practice.dto

class OrdersDTO (
        val orderId: Long = 0,
        val userEmail: String = "",
        val orderDisplayId: Long = 0,
        var orderIsCompleted: Boolean = false
){}