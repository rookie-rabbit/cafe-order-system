package org.cos.practice.repository

import org.cos.practice.dto.CategoryDTO
import org.cos.practice.dto.FavoriteDTO
import org.cos.practice.entity.CategoryEntity
import org.cos.practice.entity.FavoriteEntity
import org.cos.practice.service.CategoryService
import org.cos.practice.service.FavoriteService
import org.junit.jupiter.api.Assertions
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

    @Test
    fun insertDummies() {
        val category = CategoryEntity(categoryId = 1L, categoryName = "test")
        repository.save(category)
    }

    @Test
    fun readTest() {
        val categoryId = 1L
        val categoryObj: CategoryDTO? = service.read(categoryId)

        Assertions.assertEquals(categoryObj?.categoryId, categoryId)
    }

    @Test
    fun deleteTest() {
        val categoryId = 1L
        val ret: Long = service.delete(categoryId)

        Assertions.assertEquals(categoryId, ret)
    }
}