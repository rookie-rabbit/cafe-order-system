package org.cos.practice.service

import org.cos.practice.dto.OrderDetailDTO
import org.cos.practice.entity.OrderDetailEntity

interface OrderDetailService {
    fun insert(dto : OrderDetailDTO) : Long
    fun read(orderDetailId : Long) : OrderDetailDTO?
    fun modify(dto : OrderDetailDTO) : Long
    fun delete(orderDetailId : Long) : Long

    fun dtoToEntity(dto : OrderDetailDTO) : OrderDetailEntity? {
        return OrderDetailEntity(dto.orderDetailId, dto.orderId, dto.productId, dto.productCnt)
    }

    fun entityToDTO(entity : OrderDetailEntity) : OrderDetailDTO? {
        return OrderDetailDTO(entity.orderDetailId, entity.orderId, entity.productId, entity.productCnt)
    }
}