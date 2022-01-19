package org.cos.practice.repository

import org.cos.practice.entity.ProductEntity
import org.cos.practice.dto.ProductDTO
import org.cos.practice.entity.ProductTemp
import org.cos.practice.service.ProductService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Rollback
import org.springframework.util.Assert
import java.time.LocalDateTime
import javax.transaction.Transactional

//@DataJpaTest
//@ExtendWith(SpringExtension::class)
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
@Rollback(value = false)
class ProductRepositoryTests @Autowired constructor(
    val repository: ProductRepository,
    val service: ProductService
) {

    @Test
    @Transactional
    fun `상품 더미 데이터 생성 테스트`() {
        // given
        val product = ProductEntity(
            productId = 1L,
            categoryId = 4L,
            productName = "따뜻한 아메리카노",
            productTemp = ProductTemp.HOT,
            productAvailable = true,
            productVisible = true,
            productFileImagePath = "sample_file_path"
        )
        // when
        repository.save(product)

        // then
        Assertions.assertEquals(product, repository.getById(1))
    }

    @Test
    fun `상품 데이터 조회 테스트`(){
        // given
        val productId: Long = 1L
        // when
        val product: ProductDTO? = service.findProductById(productId)

        // then
        if(product == null)
            Assertions.assertTrue(false)
        else{
            Assertions.assertEquals(product.productId, productId)
        }
    }

    @Test
    @Transactional
    fun `상품 데이터 수정 테스트`(){
        // given
        val product: ProductDTO? = service.findProductById(1L)

        // when
        if(product == null) Assertions.assertTrue(true)
        else {
            val prevStatus: Boolean = product.productAvailable
            product.productAvailable = !product.productAvailable
            val ret: Long = service.modify(product)

            // then
            Assertions.assertEquals(ret, product.productId)
            Assertions.assertNotEquals(prevStatus, product.productAvailable)
        }
    }

    @Test
    @Transactional
    fun `상품 데이터 삭제 테스트`(){
        // given
        val productId = 100L
        // when
        val deletedProductId:Long = service.delete(productId)

        // then
        if(deletedProductId == -1L) Assertions.assertTrue(true)
        else Assertions.assertEquals(productId, deletedProductId)
    }
}