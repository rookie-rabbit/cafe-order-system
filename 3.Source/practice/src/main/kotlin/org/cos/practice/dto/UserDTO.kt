package org.cos.practice.dto

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class UserDTO (
    val user_email: String = "",
    val user_password: String = "",
    val user_is_admin: Boolean = false
){}