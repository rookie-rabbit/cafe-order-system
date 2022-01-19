package org.cos.practice.service

import org.cos.practice.dto.FavoriteDTO
import org.cos.practice.entity.FavoriteEntity

interface FavoriteService {
    fun insert(dto: FavoriteDTO): String
    fun read(user_email: String): FavoriteDTO?

    //    fun modify(dto : FavoriteDTO) : String
    fun delete(user_email: String): String

    fun dtoToEntity(dto: FavoriteDTO): FavoriteEntity? {
        return FavoriteEntity(dto.user_email, dto.product_id)
    }

    fun entityToDTO(entity: FavoriteEntity): FavoriteDTO? {
        return FavoriteDTO(entity.user_email, entity.product_id)
    }
}