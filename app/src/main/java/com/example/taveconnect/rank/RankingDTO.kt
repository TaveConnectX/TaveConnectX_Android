package com.example.taveconnect.rank

data class RankingDTO(
    val name: String,
    val picture: String,
    val ranking: Int,
    val defeat: Int,
    val draw: Int,
    val victory: Int
    )