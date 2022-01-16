package org.cos.practice.Entity

import lombok.*
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Getter
@Setter
@Builder
@Table(name = "COProducts")
@AllArgsConstructor
@NoArgsConstructor
@ToString
data class ProductEntity(
        @Id @Column(name = "pID") @GeneratedValue(strategy = GenerationType.IDENTITY) val pID: Long=0,
        @Column(name = "pName", length = 100) var pName: String = "",
        @Column(name = "pPrice") var pPrice: Int = 0,
        @Column(name = "pCntPerDay") var pCntPerDay: Int = 0,
        @Column(name = "pLastSellDate") var pLastSellDate: LocalDateTime? = null,
        @Column(name = "pIsShow") var pIsShow: Boolean = false
) : BaseTimeEntity()
{
    fun changeName(name: String){
        this.pName = name
    }

    fun changePrice(price: Int){
        this.pPrice = price
    }

    fun changeCntPerDay(cnt: Int){
        this.pCntPerDay = cnt
    }

    fun changeLastSellDate(date: LocalDateTime?){
        this.pLastSellDate = date
    }

    fun changeIsShow(isShow: Boolean){
        this.pIsShow = isShow
    }
}