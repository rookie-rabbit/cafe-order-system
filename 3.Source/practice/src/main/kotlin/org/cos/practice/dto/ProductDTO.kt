package org.cos.practice.dto

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class ProductDTO (
        val pID: Long=0,
        val pName: String = "",
        val pPrice: Int = 0,
        val pCntPerDay: Int = 0,
        val pLastSellDate: LocalDateTime? = null,
        val pIsShow: Boolean = false
){}