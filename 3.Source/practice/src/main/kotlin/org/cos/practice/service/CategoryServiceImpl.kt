package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.dto.CategoryDTO
import org.cos.practice.entity.CategoryEntity
import org.cos.practice.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class CategoryServiceImpl @Autowired constructor(
    val repository: CategoryRepository
) : CategoryService {

    @Override
    override fun insert(dto: CategoryDTO): Long {
        val entity: CategoryEntity = dtoToEntity(dto)!!
        repository.save(entity)
        return entity.categoryId
    }

    @Override
    override fun read(categoryId: Long): CategoryDTO? {
        val a = repository.findById(categoryId)
        return if (a.isPresent()) entityToDTO(a.get()) else null
    }

    @Override
    override fun modify(dto: CategoryDTO): Long {
        var result = repository.findById(dto.categoryId)

        if (result.isPresent()) {
            val entity: CategoryEntity = result.get()
            entity.changeName(dto.categoryName)
            return entity.categoryId
        }

        return -1
    }

    @Override
    override fun delete(categoryId: Long): Long {
        return try {
            repository.deleteById(categoryId)
            categoryId
        } catch (ex: Exception) {
            -1
        }
    }
}