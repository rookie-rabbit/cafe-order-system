package org.cos.practice.service

import org.cos.practice.entity.ProductEntity
import org.cos.practice.dto.ProductDTO

interface ProductService {
    fun insert(product : ProductDTO) : Long
    fun findProductById(productId : Long) : ProductDTO?
    fun modify(product : ProductDTO) : Long
    fun delete(productId : Long) : Long

    fun dtoToEntity(product : ProductDTO) : ProductEntity? {
        return ProductEntity(product.productId, product.productName, product.categoryId,
            product.productTemp , product.isProductVisible(), product.isProductAvailable(),
            product.productFileImagePath)
    }

    fun entityToDTO(productEntity : ProductEntity) : ProductDTO? {
        return productEntity.productName?.let {
            ProductDTO(productEntity.productId, it, productEntity.categoryId,
                productEntity.productTemp, productEntity.productVisible,
                productEntity.productAvailable, productEntity.productFileImagePath)
        }
    }
}