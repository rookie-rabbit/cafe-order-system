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
    @Id
    @Column(name = "user_email", length = 100)
    val user_email: String = "",

    @Column(name = "user_password", length = 100)
    var user_password: String = "",

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    val user_role: Role = Role.USER

) : BaseTimeEntity() {
    fun changePassword(name: String) {
        this.user_password = name
    }
}

enum class Role{
    USER, ADMIN
}