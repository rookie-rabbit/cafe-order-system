package org.cos.practice.repository

import org.cos.practice.dto.FavoriteDTO
import org.cos.practice.dto.UserDTO
import org.cos.practice.entity.Role
import org.cos.practice.entity.UserEntity
import org.cos.practice.repository.UserRepository
import org.cos.practice.service.UserService
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

//    @Test
//    fun insertDummies() {
//        val user = UserEntity(
//            user_email = "user@nhn-commerce.com",
//            user_password = passwordEncoder.encode("1111"),
//            user_role = Role.USER
//        )
//        repository.save(user)
//
//        val admin = UserEntity(
//            user_email = "admin@nhn-commerce.com",
//            user_password = passwordEncoder.encode("1111"),
//            user_role = Role.ADMIN
//        )
//        repository.save(admin)
//    }

    @Test
    fun readTest(){
        val email = "user@nhn-commerce.com"
        val userObj: UserDTO? = service.read(email)

        println(userObj)
        Assert.isTrue(userObj?.user_email == email)
    }

//    @Test
//    fun deleteTest() {
//        val user_email: String = "user2@nhn-commerce.com"
//        val user_ret: String = service.delete(user_email)
//
//        Assert.isTrue(user_email.equals(user_ret))
//
//        val admin_email: String = "admin2@nhn-commerce.com"
//        val admin_ret: String = service.delete(admin_email)
//
//        Assert.isTrue(admin_email.equals(admin_ret))
//    }
}