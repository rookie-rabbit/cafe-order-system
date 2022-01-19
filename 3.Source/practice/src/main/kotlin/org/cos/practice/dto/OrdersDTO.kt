package org.cos.practice.dto

import org.cos.practice.entity.OrderStatus

class OrdersDTO (
        val orderId: Long = 0,
        val userEmail: String = "",
        val orderDisplayId: Long = 0,
        var orderStatus: OrderStatus = OrderStatus.PREPARING
){}