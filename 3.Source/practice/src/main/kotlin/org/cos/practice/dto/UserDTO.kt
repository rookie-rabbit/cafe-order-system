package org.cos.practice.dto

import org.cos.practice.entity.Role

class UserDTO(
    val userEmail: String = "",
    val userPassword: String = "",
    val userRole: Role = Role.USER
)