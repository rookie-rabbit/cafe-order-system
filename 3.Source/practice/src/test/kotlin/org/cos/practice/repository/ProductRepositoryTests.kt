package org.cos.practice.repository

import org.cos.practice.Entity.ProductEntity
import org.cos.practice.dto.ProductDTO
import org.cos.practice.service.ProductService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.Assert
import java.time.LocalDateTime
import javax.transaction.Transactional

//@DataJpaTest
//@ExtendWith(SpringExtension::class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
class ProductRepositoryTests (){
    @Autowired
    private lateinit var productRepository: ProductRepository

    @Autowired
    private lateinit var service: ProductService

    @Test
    @Transactional
    public fun insertDummies() {
        val product = ProductEntity(pID = 1, pName = "a", pPrice = 1, pCntPerDay = 1, pLastSellDate = LocalDateTime.now(), pIsShow = true)

        productRepository.save(product)
    }

    @Test
    fun readTest(){
        val pID = 10L
        val product = ProductDTO(pID=10, pName = "test", pPrice = 10, pCntPerDay = -1, pLastSellDate = LocalDateTime.now(), pIsShow = false)
        val productObj: ProductDTO? = service.read(pID)

        if(productObj == null)
         Assert.isTrue(false)
        else{
            Assert.isTrue(productObj.pID == 10L)
        }
    }

    @Test
    fun deleteTest(){
        val pID = 100L
        val ret:Long = service.delete(pID)

        Assert.isTrue(pID == ret)
    }
}