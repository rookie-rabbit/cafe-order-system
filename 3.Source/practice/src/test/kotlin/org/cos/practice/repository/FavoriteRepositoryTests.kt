package org.cos.practice.repository

import org.cos.practice.dto.FavoriteDTO
import org.cos.practice.entity.FavoriteEntity
import org.cos.practice.service.FavoriteService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FavoriteRepositoryTests @Autowired constructor(
    val repository: FavoriteRepository,
    val service: FavoriteService
) {


    @Test
    fun insertDummies() {
        val favorite = FavoriteEntity(userEmail = "user1@nhn-commerce.com", productIdList = mutableListOf("1","2"))
        repository.save(favorite)
    }

    @Test
    fun readTest() {
        val userEmail = "user1@nhn-commerce.com"
        val favoriteObj: FavoriteDTO? = service.read(userEmail)
        Assertions.assertTrue(favoriteObj?.productIdList?.size == 2)
        Assertions.assertEquals(favoriteObj?.userEmail, userEmail)
    }

    @Test
    fun deleteTest() {
        val userEmail = "user1@nhn-commerce.com"
        val ret: String = service.delete(userEmail)

        Assertions.assertEquals(userEmail, ret)
    }
}