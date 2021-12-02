package com.mestabn.myapplication.ut3.ex06.domain.list

import com.mestabn.myapplication.ut3.ex06.domain.UserModel
import com.mestabn.myapplication.ut3.ex06.domain.PlayerRepository

class GetPlayerUseCase(private val playerRepository: PlayerRepository) {

    fun execute(): List<UserModel> {
        return playerRepository.fetchAll()

    }
}