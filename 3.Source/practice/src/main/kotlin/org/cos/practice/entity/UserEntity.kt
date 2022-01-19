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
    val userEmail: String = "",

    @Column(name = "user_password", length = 100)
    var userPassword: String = "",

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    val userRole: Role = Role.USER

) : BaseTimeEntity() {
    fun changePassword(name: String) {
        this.userPassword = name
    }
}

enum class Role{
    USER, ADMIN
}