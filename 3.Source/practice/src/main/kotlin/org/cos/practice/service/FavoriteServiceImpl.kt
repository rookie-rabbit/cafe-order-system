package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.dto.FavoriteDTO
import org.cos.practice.entity.FavoriteEntity
import org.cos.practice.repository.FavoriteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class FavoriteServiceImpl : FavoriteService {

    @Autowired
    private lateinit var repository: FavoriteRepository

    @Override
    override fun insert(dto: FavoriteDTO): String {
        val entity: FavoriteEntity = dtoToEntity(dto)!!
        repository.save(entity)
        return entity.user_email
    }

    @Override
    override fun read(user_email: String): FavoriteDTO? {
        val a = repository.findById(user_email)
        return if (a.isPresent()) entityToDTO(a.get()) else null
    }

    @Override
    override fun delete(user_email: String): String {
        return try {
            repository.deleteById(user_email)
            user_email
        } catch (ex: Exception) {
            ""
        }
    }
}