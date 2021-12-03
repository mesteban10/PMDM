package com.mestabn.myapplication.ut3.ex06.domain

import com.mestabn.myapplication.ut3.ex06.domain.form.SavePlayerUseCase

interface PlayerRepository {
    suspend fun fetchAll(): List<PlayerModel>
    fun save(players: List<PlayerModel>)
}