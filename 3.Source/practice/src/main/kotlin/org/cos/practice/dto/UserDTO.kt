package org.cos.practice.dto

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class UserDTO (
    val uID: String = "",
    val uPW: String = "",
    val uRL: Int = 0
){}