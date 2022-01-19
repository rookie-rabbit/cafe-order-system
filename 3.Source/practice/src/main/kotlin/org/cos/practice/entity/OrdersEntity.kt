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
        @Column(name = "user_email") val userEmail: String,
        @Column(name = "order_display_id") val orderDisplayId: Long,
        @Column(name = "order_is_completed") var orderIsCompleted: Boolean
) : BaseTimeEntity(){
    fun changeIsComplete(isCompleted: Boolean){
        this.orderIsCompleted = isCompleted
    }
}