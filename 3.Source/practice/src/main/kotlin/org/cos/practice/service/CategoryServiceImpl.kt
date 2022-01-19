package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.dto.CategoryDTO
import org.cos.practice.entity.CategoryEntity
import org.cos.practice.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class CategoryServiceImpl : CategoryService {

    @Autowired
    private lateinit var repository: CategoryRepository

    @Override
    override fun insert(dto: CategoryDTO): Long {
        val entity: CategoryEntity = dtoToEntity(dto)!!
        repository.save(entity)
        return entity.category_id
    }

    @Override
    override fun read(cid: Long): CategoryDTO? {
        val a = repository.findById(cid)
        return if (a.isPresent()) entityToDTO(a.get()) else null
    }

    @Override
    override fun modify(dto: CategoryDTO): Long {
        var result = repository.findById(dto.category_id)

        if (result.isPresent()) {
            val entity: CategoryEntity = result.get()
            entity.changeName(dto.category_name)
            return entity.category_id
        }

        return -1;
    }

    @Override
    override fun delete(cid: Long): Long {
        return try {
            repository.deleteById(cid)
            cid
        } catch (ex: Exception) {
            -1
        }
    }
}