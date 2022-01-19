package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.entity.UserEntity
import org.cos.practice.dto.UserDTO
import org.cos.practice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserServiceImpl @Autowired constructor(
    val repository: UserRepository
) : UserService {

    @Override
    override fun insert(dto: UserDTO): String {
        val entity: UserEntity = dtoToEntity(dto)!!
        repository.save(entity)
        return entity.userEmail
    }

    @Override
    override fun read(userEmail: String): UserDTO? {
        val a = repository.findById(userEmail)
        return if (a.isPresent()) entityToDTO(a.get()) else null
    }

    override fun modify(dto: UserDTO): String {
        val result = repository.findById(dto.userEmail)

        if (result.isPresent()) {
            val entity: UserEntity = result.get()
            entity.changePassword(dto.userPassword)
            return entity.userEmail
        }
        return ""
    }

    @Override
    override fun delete(userEmail: String): String {
        return try {
            repository.deleteById(userEmail)
            userEmail
        } catch (ex: Exception) {
            ""
        }
    }
}