package org.cos.practice.repository

import org.cos.practice.entity.OrderDetailEntity
import org.springframework.data.jpa.repository.JpaRepository

interface OrderDetailRepository : JpaRepository<OrderDetailEntity, Long> {
}