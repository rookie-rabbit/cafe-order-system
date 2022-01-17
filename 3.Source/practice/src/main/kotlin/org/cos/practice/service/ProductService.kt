package org.cos.practice.service

import org.cos.practice.entity.ProductEntity
import org.cos.practice.dto.ProductDTO

interface ProductService {
    fun insert(dto : ProductDTO) : Long
    fun read(pID : Long) : ProductDTO?
    fun modify(dto : ProductDTO) : Long
    fun delete(pID : Long) : Long

    fun dtoToEntity(dto : ProductDTO) : ProductEntity? {
        return ProductEntity(dto.pID, dto.pName, dto.pPrice, dto.pCntPerDay, dto.pLastSellDate, dto.pIsShow)
    }

    fun entityToDTO(entity : ProductEntity) : ProductDTO? {
        return ProductDTO(entity.pID, entity.pName, entity.pPrice, entity.pCntPerDay, entity.pLastSellDate, entity.pIsShow)
    }
}