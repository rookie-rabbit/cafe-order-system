package org.cos.practice.repository

import org.cos.practice.dto.CategoryDTO
import org.cos.practice.dto.FavoriteDTO
import org.cos.practice.entity.CategoryEntity
import org.cos.practice.entity.FavoriteEntity
import org.cos.practice.service.CategoryService
import org.cos.practice.service.FavoriteService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.Assert
import javax.transaction.Transactional

@SpringBootTest
class CategoryRepositoryTests() {
    @Autowired
    private lateinit var repository: CategoryRepository

    @Autowired
    private lateinit var service: CategoryService

//    @Test
//    fun insertDummies() {
//        val category = CategoryEntity(category_id = 1, category_name = "test")
//        repository.save(category)
//    }

//    @Test
//    fun readTest() {
//        val cid = 2L
//        val categoryObj: CategoryDTO? = service.read(cid)
//
//        Assert.isTrue(categoryObj?.category_id == cid)
//    }

    @Test
    fun deleteTest() {
        val cid = 1L
        val ret: Long = service.delete(cid)

        Assert.isTrue(cid == ret)
    }
}