package org.cos.practice.service

import org.cos.practice.dto.OrderDetailDTO
import org.cos.practice.entity.OrderDetailEntity

interface OrderDetailService {
    fun insert(dto : OrderDetailDTO) : Long
    fun read(order_detail_id : Long) : OrderDetailDTO?
    fun modify(dto : OrderDetailDTO) : Long
    fun delete(order_detail_id : Long) : Long

    fun dtoToEntity(dto : OrderDetailDTO) : OrderDetailEntity? {
        return OrderDetailEntity(dto.order_detail_id, dto.order_id, dto.product_id, dto.product_cnt)
    }

    fun entityToDTO(entity : OrderDetailEntity) : OrderDetailDTO? {
        return OrderDetailDTO(entity.order_detail_id, entity.order_id, entity.product_id, entity.product_cnt)
    }
}