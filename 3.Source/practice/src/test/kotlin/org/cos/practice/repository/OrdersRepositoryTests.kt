package org.cos.practice.repository

import org.cos.practice.dto.OrdersDTO
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
class OrdersRepositoryTests {
    @Autowired
    private lateinit var ordersRepository: OrdersRepository

    @Autowired
    private lateinit var service: OrdersService

    @Test
    @Transactional
    @Rollback(false)
    public fun insertDummies() {
        val order = OrdersEntity(order_id = 1, user_email = "a@a.a", order_display_id = 1, order_is_completed = false)

        ordersRepository.save(order)
    }

    @Test
    fun readTest(){
        val order_id: Long = 1L
        val ordersObj: OrdersDTO? = service.read(order_id)

        if(ordersObj == null)
            assertTrue(false)
        else{
            assertEquals(ordersObj.order_id, order_id)
        }
    }

    @Test
    fun modifyTest(){
        val order_id: Long = 1L
        val ordersObj: OrdersDTO? = service.read(order_id)
        if(ordersObj != null) {
            val prevStatus: Boolean = ordersObj.order_is_completed
            ordersObj.order_is_completed = !prevStatus
            val ret: Long = service.modify(ordersObj)

            Assertions.assertEquals(ret, order_id)
            Assertions.assertNotEquals(prevStatus, ordersObj.order_is_completed)
        }else
            Assertions.assertNotNull(ordersObj)
    }
    @Test
    fun deleteTest(){
        val order_id: Long = 1L
        val ret:Long = service.delete(order_id)

        assertEquals(order_id, ret)
    }
}