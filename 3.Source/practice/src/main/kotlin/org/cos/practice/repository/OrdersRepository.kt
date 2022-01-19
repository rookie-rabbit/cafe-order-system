package org.cos.practice.repository

import org.cos.practice.entity.OrdersEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrdersRepository : JpaRepository<OrdersEntity, Long>{
}