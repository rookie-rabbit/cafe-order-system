package org.cos.practice.dto

import lombok.*
import org.cos.practice.entity.ProductTemp

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
class ProductDTO(
    val productId: Long = 0L,
    val productName: String = "",
    val categoryId: Long = 0L,
    val productTemp: ProductTemp = ProductTemp.ICE,
    val productVisible: Boolean = false,
    var productAvailable: Boolean = false,
    val productFileImagePath: String? = null
) {
    fun isProductVisible(): Boolean {
        return this.productVisible
    }

    fun isProductAvailable(): Boolean {
        return this.productAvailable
    }
}