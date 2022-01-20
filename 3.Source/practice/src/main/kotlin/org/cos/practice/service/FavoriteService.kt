package org.cos.practice.service

import org.cos.practice.dto.FavoriteDTO
import org.cos.practice.entity.FavoriteEntity

interface FavoriteService {
    fun insert(dto: FavoriteDTO): String
    fun read(userEmail: String): FavoriteDTO?
    fun delete(userEmail: String): String
    fun dtoToEntity(dto: FavoriteDTO): FavoriteEntity {
        return FavoriteEntity(dto.userEmail, dto.productIdList)
    }

    fun entityToDTO(entity: FavoriteEntity): FavoriteDTO {
        return FavoriteDTO(entity.userEmail, entity.productIdList)
    }
}