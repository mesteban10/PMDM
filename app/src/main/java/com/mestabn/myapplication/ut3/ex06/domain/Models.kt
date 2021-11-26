package com.mestabn.myapplication.ut3.ex06.domain

data class UserModel(
    val name: String,
    val surnames: String,
    val community: String,
    val gender: String,
    val demarcation: List<DemarcationModel>


)

data class DemarcationModel(val name: String)
