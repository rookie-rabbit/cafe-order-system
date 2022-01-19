package org.cos.practice.service

import org.cos.practice.entity.UserEntity
import org.cos.practice.dto.UserDTO

interface UserService {
    fun insert(dto: UserDTO): String
    fun read(user_email: String): UserDTO?
    fun modify(dto: UserDTO): String
    fun delete(user_email: String): String

    fun dtoToEntity(dto: UserDTO): UserEntity? {
        return UserEntity(dto.userEmail, dto.userPassword, dto.userRole)
    }

    fun entityToDTO(entity: UserEntity): UserDTO? {
        return UserDTO(entity.userEmail, entity.userPassword, entity.userRole)
    }
}