package com.example.volleyhelper

import android.os.Parcelable
import java.io.Serializable

data class Team(
    val teamName: String,
    val playerList: ArrayList<Player>,
    val score: Int
)
