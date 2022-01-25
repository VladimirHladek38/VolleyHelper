package com.example.volleyhelper

data class Player(
    val name: String,
    val hitCount: Int,
    val aceCount: Int,
    val blockCount: Int,
    val blockOutCount: Int,
    val outCount: Int,
    val serveErrorCount: Int,
    val netErrorCount: Int,
    val passErrorCount: Int
)
