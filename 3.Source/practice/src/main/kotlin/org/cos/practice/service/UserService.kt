package org.cos.practice.service

import org.cos.practice.entity.UserEntity
import org.cos.practice.dto.UserDTO

interface UserService {
    fun insert(dto : UserDTO) : String
    fun read(uID : String) : UserDTO?
    fun modify(dto : UserDTO) : String
    fun delete(uID : String) : String

    fun dtoToEntity(dto : UserDTO) : UserEntity? {
        return UserEntity(dto.uID, dto.uPW, dto.uRL)
    }

    fun entityToDTO(entity: UserEntity) : UserDTO?{
        return UserDTO(entity.uID, entity.uPW, entity.uRL)
    }
}