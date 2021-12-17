package com.mestabn.myapplication.ut3.ex06.domain.list

import com.mestabn.myapplication.ut3.ex06.domain.PlayerModel
import com.mestabn.myapplication.ut3.ex06.domain.PlayerRepository

class GetPlayerUseCase(private val playerRepository: PlayerRepository) {

    suspend fun execute(): List<PlayerModel> {
        return playerRepository.fetchAll()

    }
}