package org.cos.practice.dto

class OrderDetailDTO(
        val order_detail_id: Long = 0,
        val order_id: Long = 0,
        val product_id: Long = 0,
        val product_cnt: Int = 0
) {}