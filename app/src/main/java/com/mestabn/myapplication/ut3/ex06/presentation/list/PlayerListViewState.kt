package com.mestabn.myapplication.ut3.ex06.presentation.list


data class PlayerListViewState(
    var name: String,
    val surname: String,
    val community: String,
    val gender: String,
    val demarcation: List<String>?
)