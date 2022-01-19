package org.cos.practice.dto

class OrdersDTO (
        val order_id: Long = 0,
        val user_email: String = "",
        val order_display_id: Long = 0,
        var order_is_completed: Boolean = false
){}