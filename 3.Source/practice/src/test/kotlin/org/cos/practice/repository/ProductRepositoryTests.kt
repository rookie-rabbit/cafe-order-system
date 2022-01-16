package org.cos.practice.repository

import org.cos.practice.Entity.ProductEntity
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import javax.transaction.Transactional

//@DataJpaTest
//@ExtendWith(SpringExtension::class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
class ProductRepositoryTests (){
    @Autowired
    private lateinit var productRepository: ProductRepository

    @Test
    @Transactional
    public fun insertDummies() {
        val product = ProductEntity(pID = 1, pName = "a", pPrice = 1, pCntPerDay = 1, pLastSellDate = LocalDateTime.now(), pIsShow = true)

        productRepository.save(product)
    }
}