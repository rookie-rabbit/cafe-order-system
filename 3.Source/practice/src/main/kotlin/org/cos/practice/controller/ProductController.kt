package org.cos.practice.controller

import lombok.RequiredArgsConstructor
import org.cos.practice.Entity.ProductEntity
import org.cos.practice.dto.ProductDTO
import org.cos.practice.repository.ProductRepository
import org.cos.practice.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.security.Principal
import java.time.LocalDateTime
import javax.transaction.Transactional

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
class ProductController {
    @Autowired
    private lateinit var service: ProductService

    @GetMapping("/read/{pID}")
    fun read(@PathVariable pID: Long, model: Model) : ProductDTO?{
        return service.read(pID)
    }

    @PostMapping("/insert")
    @Transactional
    fun insert(dto: ProductDTO, principal: Principal, model: Model) : Long{
        model.addAttribute("roles", (principal as UsernamePasswordAuthenticationToken).authorities)
        return service.insert(dto)
    }

    @PostMapping("/modify")
    @Transactional
    fun modify(@RequestBody dto: ProductDTO, model: Model) : Long{
        return service.modify(dto)
    }

    @GetMapping("/delete/{pID}")
    @Transactional
    fun delete(@PathVariable pID: Long, model: Model): Long{
        return service.delete(pID)
    }
}