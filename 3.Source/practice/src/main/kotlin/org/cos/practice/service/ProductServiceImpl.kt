package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.Entity.ProductEntity
import org.cos.practice.dto.ProductDTO
import org.cos.practice.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class ProductServiceImpl : ProductService{

    @Autowired
    private lateinit var repository: ProductRepository

    @Override
    override fun insert(dto: ProductDTO): Long {
        var entity : ProductEntity = dtoToEntity(dto)!!;
        repository.save(entity);
        return entity.pID;
    }

    @Override
    override fun read(pID: Long): ProductDTO? {
        val a = repository.findById(pID)
        return if(a.isPresent()) entityToDTO(a.get()) else null
    }

    override fun modify(dto: ProductDTO): Long {
        var result = repository.findById(dto.pID)

        if(result.isPresent()){
            val entity : ProductEntity = result.get();
            entity.changeName(dto.pName)
            entity.changePrice(dto.pPrice)
            entity.changeCntPerDay(dto.pCntPerDay)
            entity.changeLastSellDate(dto.pLastSellDate)
            entity.changeIsShow(dto.pIsShow)
            return entity.pID
        }

        return -1;
    }

    override fun delete(pID: Long): Long {
        try{
            repository.deleteById(pID)
            return pID
        }catch (ex: Exception){
            return -1
        }
    }


}