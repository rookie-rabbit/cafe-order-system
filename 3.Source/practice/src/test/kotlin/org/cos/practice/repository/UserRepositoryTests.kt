package org.cos.practice.repository

import org.cos.practice.dto.FavoriteDTO
import org.cos.practice.dto.UserDTO
import org.cos.practice.entity.Role
import org.cos.practice.entity.UserEntity
import org.cos.practice.repository.UserRepository
import org.cos.practice.service.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.util.Assert
import java.util.*

@SpringBootTest
class UserRepositoryTests {
    @Autowired
    private lateinit var repository: UserRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    private lateinit var service: UserService

    @Test
    fun insertDummies() {
        val user = UserEntity(
            userEmail = "user@nhn-commerce.com",
            userPassword = passwordEncoder.encode("1111"),
            userRole = Role.USER
        )
        repository.save(user)

        val admin = UserEntity(
            userEmail = "admin@nhn-commerce.com",
            userPassword = passwordEncoder.encode("1111"),
            userRole = Role.ADMIN
        )
        repository.save(admin)
    }

    @Test
    fun readTest() {
        val userEmail = "user@nhn-commerce.com"
        val userObj: UserDTO? = service.read(userEmail)

        println(userObj)
        Assertions.assertEquals(userObj?.userEmail, userEmail)
    }

    @Test
    fun deleteTest() {
        val userEmail: String = "user@nhn-commerce.com"
        val userRet: String = service.delete(userEmail)

        Assertions.assertEquals(userEmail, userRet)

        val adminEmail: String = "admin@nhn-commerce.com"
        val adminRet: String = service.delete(adminEmail)

        Assertions.assertEquals(adminEmail, adminRet)
    }
}