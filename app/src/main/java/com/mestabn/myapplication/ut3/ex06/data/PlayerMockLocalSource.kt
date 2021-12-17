package com.mestabn.myapplication.ut3.ex06.data

import com.mestabn.myapplication.ut3.ex06.domain.PlayerModel

class PlayerMockLocalSource : PlayerLocalSource {
    override suspend fun findAll(): List<PlayerModel> {
        return mutableListOf(
            PlayerModel("Pepe", "E.M", "Madrid", "Masculino", mutableListOf()),
            PlayerModel("Pepe", "E.M", "Madrid", "Masculino", mutableListOf())
        )
    }

    override  fun save(player: PlayerModel)  {
        PlayerModel("Pepe", "E.M", "Madrid", "Masculino", mutableListOf())
    }

}