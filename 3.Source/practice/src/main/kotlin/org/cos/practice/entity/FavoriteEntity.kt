package org.cos.practice.entity

import lombok.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FAVORITE")
data class FavoriteEntity(
    @Id
    @Column(name = "user_email")
    val user_email: String = "",

    @Column(name = "product_id")
    val product_id: Long = 0L
)