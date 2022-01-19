package org.cos.practice.entity

import lombok.*
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDERS")
@ToString
data class OrdersEntity (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "order_id") val order_id: Long,
        @Column(name = "user_email") val user_email: String,
        @Column(name = "order_display_id") val order_display_id: Long,
        @Column(name = "order_is_completed") var order_is_completed: Boolean
) : BaseTimeEntity(){
    fun changeIsComplete(isCompleted: Boolean){
        this.order_is_completed = isCompleted
    }
}