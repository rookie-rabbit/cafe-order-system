package org.cos.practice.entity

import lombok.Getter
import lombok.NoArgsConstructor
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
@Getter
@NoArgsConstructor
abstract class BaseTimeEntity {
    @CreatedDate
    @Column(name = "regDate", updatable=false)
    private val regDate: LocalDateTime? = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "modifiedDate")
    private val modifiedDate: LocalDateTime? = LocalDateTime.now();
}