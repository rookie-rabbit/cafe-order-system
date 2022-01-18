package org.cos.practice.security

import org.cos.practice.entity.UserEntity
import org.cos.practice.repository.UserRepository
import org.cos.practice.service.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder

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
//            val user = UserEntity(uID = "user$i@nhn-commerce.com", uPW = passwordEncoder.encode("1111"), uRL = 1)
//            userRepository.save(user)
//        }
//        val admin = UserEntity(uID = "admin@nhn-commerce.com", uPW = passwordEncoder.encode("1111"), uRL = 2)
//        userRepository.save(admin)
//    }

    @Test
    fun deleteTest() {
        for (i in 1..9) {
            val uID: String = "user$i@nhn-commerce.com"
            val ret: String = service.delete(uID)

            Assert.isTrue(uID.equals(ret))
        }
        val uID: String = "admin@nhn-commerce.com"
        val ret: String = service.delete(uID)

        Assert.isTrue(uID.equals(ret))
    }
}