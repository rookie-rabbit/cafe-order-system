package org.cos.practice.service

import org.cos.practice.dto.CategoryDTO
import org.cos.practice.entity.CategoryEntity

interface CategoryService {
    fun insert(dto: CategoryDTO): Long
    fun read(cid: Long): CategoryDTO?
    fun modify(dto : CategoryDTO) : Long
    fun delete(cid: Long): Long

    fun dtoToEntity(dto: CategoryDTO): CategoryEntity? {
        return CategoryEntity(dto.category_id, dto.category_name)
    }

    fun entityToDTO(entity: CategoryEntity): CategoryDTO? {
        return CategoryDTO(entity.category_id, entity.category_name)
    }
}