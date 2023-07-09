package com.example.taveconnect.game

data class GameStartData(
    val difficulty: String,
    val gameIdx: Int,
    val list: List<List<Int>>,
    val turn: Int
)