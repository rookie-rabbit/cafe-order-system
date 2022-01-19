package org.cos.practice.service

import org.cos.practice.dto.FavoriteDTO
import org.cos.practice.entity.FavoriteEntity

interface FavoriteService {
    fun insert(dto: FavoriteDTO): String
    fun read(userEmail: String): FavoriteDTO?
    //    fun modify(dto : FavoriteDTO) : String
    fun delete(userEmail: String): String

    fun dtoToEntity(dto: FavoriteDTO): FavoriteEntity? {
        return FavoriteEntity(dto.userEmail, dto.productId)
    }

    fun entityToDTO(entity: FavoriteEntity): FavoriteDTO? {
        return FavoriteDTO(entity.userEmail, entity.productId)
    }
}