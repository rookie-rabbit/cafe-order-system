package org.cos.practice.dto

class FavoriteDTO(
    val userEmail: String = "",
    val productIdList: MutableList<String> = mutableListOf()
)