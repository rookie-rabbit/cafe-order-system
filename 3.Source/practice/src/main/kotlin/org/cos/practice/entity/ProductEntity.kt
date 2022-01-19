package org.cos.practice.entity

import com.fasterxml.jackson.databind.annotation.JsonNaming
import lombok.*
import javax.persistence.*

@Entity
@Data
@Builder
@Table(name = "PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
data class ProductEntity(
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val productId: Long,

    @Column(name = "product_name", length = 100)
    var productName: String = "",
    @Column(name = "category_id")
    var categoryId: Long,

    @Enumerated(EnumType.STRING)
    @Column(name = "product_temp")
    var productTemp: ProductTemp = ProductTemp.ICE,
    @Column(name = "product_visible")
    var productVisible: Boolean = false,
    @Column(name = "product_available")
    var productAvailable: Boolean = false,
    @Column(name = "product_file_image_path")
    var productFileImagePath: String? = null

) : BaseTimeEntity()

enum class ProductTemp {
    HOT, ICE
}