package org.cos.practice.dto

import org.cos.practice.entity.Role

class UserDTO(
    val user_email: String = "",
    val user_password: String = "",
    val user_role: Role = Role.USER
)