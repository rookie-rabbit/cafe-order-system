package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.entity.UserEntity
import org.cos.practice.dto.UserDTO
import org.cos.practice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserServiceImpl : UserService {

    @Autowired
    private lateinit var repository: UserRepository

    @Override
    override fun insert(dto: UserDTO): String {
        val entity: UserEntity = dtoToEntity(dto)!!
        repository.save(entity)
        return entity.user_email
    }

    @Override
    override fun read(user_email: String): UserDTO? {
        val a = repository.findById(user_email)
        return if (a.isPresent()) entityToDTO(a.get()) else null
    }

    override fun modify(dto: UserDTO): String {
        val result = repository.findById(dto.user_email)

        if (result.isPresent()) {
            val entity: UserEntity = result.get()
            entity.changePassword(dto.user_password)
            return entity.user_email
        }
        return ""
    }

    @Override
    override fun delete(user_email: String): String {
        return try {
            repository.deleteById(user_email)
            user_email
        } catch (ex: Exception) {
            ""
        }
    }
}