package org.cos.practice.service

import org.cos.practice.dto.OrdersDTO
import org.cos.practice.entity.OrdersEntity

interface OrdersService {
    fun insert(dto : OrdersDTO) : Long
    fun read(orderId : Long) : OrdersDTO?
    fun modify(dto : OrdersDTO) : Long
    fun delete(orderId : Long) : Long

    fun dtoToEntity(dto : OrdersDTO) : OrdersEntity? {
        return OrdersEntity(dto.orderId, dto.userEmail, dto.orderDisplayId, dto.orderStatus)
    }

    fun entityToDTO(entity : OrdersEntity) : OrdersDTO? {
        return OrdersDTO(entity.orderId, entity.userEmail, entity.orderDisplayId, entity.orderStatus)
    }
}