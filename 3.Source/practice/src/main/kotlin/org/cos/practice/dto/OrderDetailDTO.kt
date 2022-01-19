package org.cos.practice.dto

class OrderDetailDTO(
        val orderDetailId: Long = 0,
        val orderId: Long = 0,
        val productId: Long = 0,
        val productCnt: Int = 0
) {}