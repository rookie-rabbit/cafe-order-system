package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.dto.OrderDetailDTO
import org.cos.practice.entity.OrderDetailEntity
import org.cos.practice.repository.OrderDetailRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrderDetailServiceImpl @Autowired constructor(
        val repository: OrderDetailRepository)
    : OrderDetailService{

    override fun insert(dto: OrderDetailDTO): Long {
        var entity : OrderDetailEntity = dtoToEntity(dto)!!
        repository.save(entity)
        return entity.orderDetailId
    }

    override fun read(orderDetailId: Long): OrderDetailDTO? {
        val ret = repository.findById(orderDetailId)
        return if(ret.isPresent()) entityToDTO(ret.get()) else null
    }

    override fun modify(dto: OrderDetailDTO): Long {
        return dto.orderDetailId
    }

    override fun delete(orderDetailId: Long): Long {
        try{
            repository.deleteById(orderDetailId)
            return orderDetailId
        }catch (ex: Exception){
            return -1
        }
    }
}