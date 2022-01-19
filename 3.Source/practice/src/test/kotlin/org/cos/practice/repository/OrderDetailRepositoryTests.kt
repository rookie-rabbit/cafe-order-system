package org.cos.practice.repository

import org.cos.practice.dto.OrderDetailDTO
import org.cos.practice.entity.OrderDetailEntity
import org.cos.practice.service.OrderDetailService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import javax.transaction.Transactional

@SpringBootTest
class OrderDetailRepositoryTests @Autowired constructor(
        val orderDetailRepository: OrderDetailRepository,
        val service: OrderDetailService){

    @Test
    @Transactional
    @Rollback(false)
    fun insertDummies() {
        val orderDetail = OrderDetailEntity(orderDetailId = 1, orderId = 1, productId = 1, productCnt = 1)

        orderDetailRepository.save(orderDetail)
    }

    @Test
    fun readTest(){
        val orderDetailId = 1L
        val orderDetailObj: OrderDetailDTO? = service.read(orderDetailId)

        if(orderDetailObj == null)
            Assertions.assertTrue(false)
        else{
            Assertions.assertEquals(orderDetailObj.orderDetailId, orderDetailId)
        }
    }

    @Test
    fun deleteTest(){
        val orderDetailId = 1L
        val ret:Long = service.delete(orderDetailId)

        Assertions.assertEquals(orderDetailId, ret)
    }
}