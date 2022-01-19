package org.cos.practice.entity

import lombok.*
import javax.persistence.*

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDERS")
@ToString
data class OrdersEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "order_id") val orderId: Long,
        @Column(name = "user_email") val userEmail: String = "",
        @Column(name = "order_display_id") val orderDisplayId: Long,
        @Column(name = "order_status") @Enumerated(EnumType.STRING) var orderStatus: OrderStatus = OrderStatus.PREPARING
) : BaseTimeEntity(){
    fun changeStatus(status: OrderStatus){
        this.orderStatus = status
    }
}

enum class OrderStatus{
    PREPARING, // 준비중
    COMPLETED // 완료
}