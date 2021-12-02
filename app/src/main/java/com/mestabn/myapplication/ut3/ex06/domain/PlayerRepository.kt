package com.mestabn.myapplication.ut3.ex06.domain

interface PlayerRepository {
    fun fetchAll(): List<UserModel>
    fun save(player: UserModel)
}