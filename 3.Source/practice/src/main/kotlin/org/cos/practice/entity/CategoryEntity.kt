package org.cos.practice.entity

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import javax.persistence.*

// @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode.
@Data
@Entity
@Builder
@Table(name = "CATEGORY")
@AllArgsConstructor
@NoArgsConstructor
data class CategoryEntity(
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val categoryId: Long = 0L,

    @Column(name = "category_name")
    var categoryName: String = ""
) {
    fun changeName(name: String) {
        this.categoryName = name
    }
}
