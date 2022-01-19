package org.cos.practice.repository

import org.cos.practice.dto.OrderDetailDTO
import org.cos.practice.entity.OrderDetailEntity
import org.cos.practice.service.OrderDetailService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.util.Assert
import javax.transaction.Transactional

@SpringBootTest
class OrderDetailRepositoryTests {
    @Autowired
    private lateinit var orderDetailRepository: OrderDetailRepository

    @Autowired
    private lateinit var service: OrderDetailService

    @Test
    @Transactional
    @Rollback(false)
    public fun insertDummies() {
        val orderDetail = OrderDetailEntity(order_detail_id = 1, order_id = 1, product_id = 1, product_cnt = 1)

        orderDetailRepository.save(orderDetail)
    }

    @Test
    fun readTest(){
        val order_detail_id = 1L
        val orderDetailObj: OrderDetailDTO? = service.read(order_detail_id)

        if(orderDetailObj == null)
            Assertions.assertTrue(false)
        else{
            Assertions.assertEquals(orderDetailObj.order_detail_id, order_detail_id)
        }
    }

    @Test
    fun deleteTest(){
        val order_detail_id = 1L
        val ret:Long = service.delete(order_detail_id)

        Assertions.assertEquals(order_detail_id, ret)
    }
}