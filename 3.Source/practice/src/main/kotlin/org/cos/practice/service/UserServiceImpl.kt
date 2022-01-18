package org.cos.practice.service

import lombok.RequiredArgsConstructor
import org.cos.practice.entity.UserEntity
import org.cos.practice.dto.UserDTO
import org.cos.practice.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class UserServiceImpl : UserService{

    @Autowired
    private lateinit var repository: UserRepository

    @Override
    override fun insert(dto: UserDTO): String {
        val entity : UserEntity = dtoToEntity(dto)!!
        repository.save(entity)
        return entity.uID
    }

    @Override
    override fun read(uID: String): UserDTO? {
        val a = repository.findById(uID)
        return if(a.isPresent()) entityToDTO(a.get()) else null
    }

    override fun modify(dto: UserDTO): String {
        val result = repository.findById(dto.uID)

        if(result.isPresent()){
            val entity : UserEntity = result.get();
            entity.changePassword(dto.uPW)
            return entity.uID
        }
        return "";
    }

    @Override
    override fun delete(uID: String): String {
        try{
            repository.deleteById(uID)
            return uID
        }catch (ex: Exception){
            return ""
        }
    }
}