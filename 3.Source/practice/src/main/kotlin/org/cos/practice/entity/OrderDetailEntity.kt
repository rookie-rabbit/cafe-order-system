package org.cos.practice.entity

import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import javax.persistence.*

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDER_DETAIL")
data class OrderDetailEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "order_detail_id") val order_detail_id: Long,
        @Column(name = "order_id") val order_id: Long,
        @Column(name = "product_id") val product_id: Long,
        @Column(name = "product_cnt") val product_cnt: Int
): BaseTimeEntity() {
}