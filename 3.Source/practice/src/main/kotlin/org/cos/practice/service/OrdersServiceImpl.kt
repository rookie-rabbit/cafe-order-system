package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.dto.OrdersDTO
import org.cos.practice.entity.OrdersEntity
import org.cos.practice.repository.OrderDetailRepository
import org.cos.practice.repository.OrdersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrdersServiceImpl @Autowired constructor(
        val repository: OrdersRepository)
    : OrdersService{

    @Override
    override fun insert(dto: OrdersDTO): Long {
        var entity : OrdersEntity = dtoToEntity(dto)!!
        repository.save(entity)
        return entity.orderId
    }

    @Override
    override fun read(orderId: Long): OrdersDTO? {
        val ret = repository.findById(orderId)
        return if(ret.isPresent) entityToDTO(ret.get()) else null
    }

    override fun modify(dto: OrdersDTO): Long {
        var result = repository.findById(dto.orderId)

        if(result.isPresent()){
            val entity : OrdersEntity = result.get();
            entity.changeIsComplete(dto.orderIsCompleted)
            return entity.orderId
        }

        return -1;
    }

    override fun delete(orderId: Long): Long {
        try{
            repository.deleteById(orderId)
            return orderId
        }catch (ex: Exception){
            return -1
        }
    }
}