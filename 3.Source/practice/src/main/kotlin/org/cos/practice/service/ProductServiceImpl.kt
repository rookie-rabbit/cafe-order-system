package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.entity.ProductEntity
import org.cos.practice.dto.ProductDTO
import org.cos.practice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class ProductServiceImpl @Autowired constructor(
    val repository: ProductRepository
) : ProductService {

    @Override
    override fun insert(product: ProductDTO): Long {
        val entity: ProductEntity = dtoToEntity(product)!!
        repository.save(entity)
        return entity.productId
    }

    @Override
    override fun findProductById(productId: Long): ProductDTO? {
        val product = repository.findById(productId)
        return if (product.isPresent) entityToDTO(product.get()) else null
    }

    override fun modify(product: ProductDTO): Long {
        val result = repository.findById(product.productId)

        if (result.isPresent) {
            val entity: ProductEntity = result.get();
            entity.productName = product.productName
            entity.categoryId = product.categoryId
            entity.productTemp = product.productTemp
            entity.productVisible = product.productVisible
            entity.productAvailable = product.productAvailable
            entity.productFileImagePath = product.productFileImagePath
            return entity.productId
        }
        return -1;
    }

    override fun delete(productId: Long): Long {
        return try {
            repository.deleteById(productId)
            productId
        } catch (ex: Exception) {
            -1
        }
    }
}