package org.cos.practice.Entity

import lombok.*
import javax.persistence.*

@Entity
@Getter
@Setter
@Builder
@Table(name = "COUser")
@AllArgsConstructor
@NoArgsConstructor
@ToString
data class UserEntity(
    @Id @Column(name = "uID", length = 100) val uID: String = "",
    @Column(name = "uPW", length = 100) var uPW: String = "",
    @Column(name = "uRL") val uRL: Int = 1
)
{
    fun changePassword(name: String){
        this.uPW = name
    }
}