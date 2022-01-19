package org.cos.practice.security

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootTest
class PasswordTests {
    @Autowired
    private val passwordEncoder: PasswordEncoder? = null

    @Test
    fun testEncode() {
        val password = "1111"
        val enPw = passwordEncoder!!.encode(password)
        println("enPw: $enPw")
        val matchResult = passwordEncoder.matches(password, enPw)
        println("matchResult: $matchResult")
    }
}