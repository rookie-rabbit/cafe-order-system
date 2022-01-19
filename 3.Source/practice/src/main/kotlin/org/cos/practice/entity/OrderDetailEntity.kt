package org.cos.practice.entity

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_DETAIL")
data class OrderDetailEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "order_detail_id") val orderDetailId: Long,
        @Column(name = "orderId") val orderId: Long,
        @Column(name = "product_id") val productId: Long,
        @Column(name = "product_cnt") val productCnt: Int
): BaseTimeEntity() {
}