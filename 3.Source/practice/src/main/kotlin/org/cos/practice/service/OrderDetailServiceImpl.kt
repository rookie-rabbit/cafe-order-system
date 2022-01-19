package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.dto.OrderDetailDTO
import org.cos.practice.entity.OrderDetailEntity
import org.cos.practice.repository.OrderDetailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrderDetailServiceImpl : OrderDetailService{
    @Autowired
    private lateinit var repository: OrderDetailRepository
    
    override fun insert(dto: OrderDetailDTO): Long {
        var entity : OrderDetailEntity = dtoToEntity(dto)!!
        repository.save(entity)
        return entity.order_detail_id
    }

    override fun read(order_detail_id: Long): OrderDetailDTO? {
        val a = repository.findById(order_detail_id)
        return if(a.isPresent()) entityToDTO(a.get()) else null
    }

    override fun modify(dto: OrderDetailDTO): Long {
        return dto.order_detail_id
    }

    override fun delete(order_detail_id: Long): Long {
        try{
            repository.deleteById(order_detail_id)
            return order_detail_id
        }catch (ex: Exception){
            return -1
        }
    }
}