package org.cos.practice.repository

import org.cos.practice.entity.FavoriteEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FavoriteRepository : JpaRepository<FavoriteEntity, String> {
}