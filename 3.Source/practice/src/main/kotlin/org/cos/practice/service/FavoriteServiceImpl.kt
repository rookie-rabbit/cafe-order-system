package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.dto.FavoriteDTO
import org.cos.practice.entity.FavoriteEntity
import org.cos.practice.repository.FavoriteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class FavoriteServiceImpl @Autowired constructor(
    val repository: FavoriteRepository
) : FavoriteService {

    @Override
    override fun insert(dto: FavoriteDTO): String {
        val entity: FavoriteEntity = dtoToEntity(dto)!!
        repository.save(entity)
        return entity.userEmail
    }

    @Override
    override fun read(userEmail: String): FavoriteDTO? {
        val a = repository.findById(userEmail)
        return if (a.isPresent()) entityToDTO(a.get()) else null
    }

    @Override
    override fun delete(userEmail: String): String {
        return try {
            repository.deleteById(userEmail)
            userEmail
        } catch (ex: Exception) {
            ""
        }
    }
}