package org.cos.practice.entity

import lombok.*
import javax.persistence.*

@Entity
@Getter
@Setter
@Builder
@Table(name = "USER")
@AllArgsConstructor
@NoArgsConstructor
@ToString
data class UserEntity(
    @Id @Column(name = "user_email", length = 100) val user_email: String = "",
    @Column(name = "user_password", length = 100) var user_password: String = "",
    @Column(name = "user_is_admin") val user_is_admin: Boolean = false
) {
    fun changePassword(name: String) {
        this.user_password = name
    }
}