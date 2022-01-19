package org.cos.practice.repository

import org.cos.practice.dto.OrdersDTO
import org.cos.practice.entity.OrderStatus
import org.cos.practice.entity.OrdersEntity
import org.cos.practice.service.OrdersService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.junit.jupiter.api.Assertions.*
import org.springframework.test.annotation.Rollback
import javax.transaction.Transactional

@SpringBootTest
class OrdersRepositoryTests @Autowired constructor(
        val ordersRepository: OrdersRepository,
        val service: OrdersService){

    @Test
    @Transactional
    @Rollback(false)
    fun insertDummies() {
        val order = OrdersEntity(orderId = 1, userEmail = "a@a.a", orderDisplayId = 1, orderStatus = OrderStatus.PREPARING)

        ordersRepository.save(order)
    }

    @Test
    fun readTest(){
        val orderId: Long = 1L
        val ordersObj: OrdersDTO? = service.read(orderId)

        if(ordersObj == null)
            assertTrue(false)
        else{
            assertEquals(ordersObj.orderId, orderId)
        }
    }

    @Test
    fun modifyTest(){
        val orderId: Long = 1L
        val ordersObj: OrdersDTO? = service.read(orderId)
        if(ordersObj != null) {
            val prevStatus: OrderStatus = ordersObj.orderStatus
            if(prevStatus == OrderStatus.PREPARING)
                ordersObj.orderStatus = OrderStatus.COMPLETED
            else
                ordersObj.orderStatus = OrderStatus.PREPARING

            val ret: Long = service.modify(ordersObj)

            Assertions.assertEquals(ret, orderId)
            Assertions.assertNotEquals(prevStatus, ordersObj.orderStatus)
        }else
            Assertions.assertNotNull(ordersObj)
    }
    @Test
    fun deleteTest(){
        val orderId: Long = 1L
        val ret:Long = service.delete(orderId)

        assertEquals(orderId, ret)
    }
}