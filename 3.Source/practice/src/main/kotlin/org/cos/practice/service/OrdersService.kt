package org.cos.practice.service

import org.cos.practice.dto.OrdersDTO
import org.cos.practice.entity.OrdersEntity

interface OrdersService {
    fun insert(dto : OrdersDTO) : Long
    fun read(order_id : Long) : OrdersDTO?
    fun modify(dto : OrdersDTO) : Long
    fun delete(order_id : Long) : Long

    fun dtoToEntity(dto : OrdersDTO) : OrdersEntity? {
        return OrdersEntity(dto.order_id, dto.user_email, dto.order_display_id, dto.order_is_completed)
    }

    fun entityToDTO(entity : OrdersEntity) : OrdersDTO? {
        return OrdersDTO(entity.order_id, entity.user_email, entity.order_display_id, entity.order_is_completed)
    }
}