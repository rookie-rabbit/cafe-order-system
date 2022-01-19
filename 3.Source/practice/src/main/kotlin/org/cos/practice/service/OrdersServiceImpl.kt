package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.dto.OrdersDTO
import org.cos.practice.entity.OrdersEntity
import org.cos.practice.repository.OrdersRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class OrdersServiceImpl : OrdersService{
    @Autowired
    private lateinit var repository: OrdersRepository

    @Override
    override fun insert(dto: OrdersDTO): Long {
        var entity : OrdersEntity = dtoToEntity(dto)!!
        repository.save(entity)
        return entity.order_id
    }

    @Override
    override fun read(order_id: Long): OrdersDTO? {
        val a = repository.findById(order_id)
        return if(a.isPresent()) entityToDTO(a.get()) else null
    }

    override fun modify(dto: OrdersDTO): Long {
        var result = repository.findById(dto.order_id)

        if(result.isPresent()){
            val entity : OrdersEntity = result.get();
            entity.changeIsComplete(dto.order_is_completed)
            return entity.order_id
        }

        return -1;
    }

    override fun delete(order_id: Long): Long {
        try{
            repository.deleteById(order_id)
            return order_id
        }catch (ex: Exception){
            return -1
        }
    }
}