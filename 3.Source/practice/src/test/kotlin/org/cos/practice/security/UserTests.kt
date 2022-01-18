package org.cos.practice.security

import org.cos.practice.repository.UserRepository
import org.cos.practice.service.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.util.Assert

@SpringBootTest
class UserTests {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    private lateinit var service: UserService

//    @Test
//    fun insertDummies() {
//        for (i in 1..9) {
//            val user = UserEntity(user_email = "user$i@nhn-commerce.com", user_password = passwordEncoder.encode("1111"), user_is_admin = false)
//            userRepository.save(user)
//        }
//        val admin = UserEntity(user_email = "admin@nhn-commerce.com", user_password = passwordEncoder.encode("1111"), user_is_admin = true)
//        userRepository.save(admin)
//    }

    @Test
    fun deleteTest() {
        for (i in 1..9) {
            val user_email: String = "user$i@nhn-commerce.com"
            val ret: String = service.delete(user_email)

            Assert.isTrue(user_email.equals(ret))
        }
        val user_email: String = "admin@nhn-commerce.com"
        val ret: String = service.delete(user_email)

        Assert.isTrue(user_email.equals(ret))
    }
}