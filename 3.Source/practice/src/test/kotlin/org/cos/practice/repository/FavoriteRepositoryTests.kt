package org.cos.practice.repository

import org.cos.practice.dto.FavoriteDTO
import org.cos.practice.entity.FavoriteEntity
import org.cos.practice.service.FavoriteService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.Assert
import javax.transaction.Transactional

@SpringBootTest
class FavoriteRepositoryTests() {
    @Autowired
    private lateinit var repository: FavoriteRepository

    @Autowired
    private lateinit var service: FavoriteService

//    @Test
//    fun insertDummies() {
//        val favorite = FavoriteEntity(user_email = "user1@nhn-commerce.com", product_id = 1)
//        repository.save(favorite)
//    }

    @Test
    fun readTest(){
        val email = "user1@nhn-commerce.com"
        val favoriteObj: FavoriteDTO? = service.read(email)

        Assert.isTrue(favoriteObj?.user_email == email)
    }

//    @Test
//    fun deleteTest(){
//        val email = "user1@nhn-commerce.com"
//        val ret:String = service.delete(email)
//
//        Assert.isTrue(email == ret)
//    }
}