package com.mestabn.myapplication.ut3.ex06.data

import com.mestabn.myapplication.ut3.ex06.domain.PlayerModel
import com.mestabn.myapplication.ut3.ex06.domain.PlayerRepository

class PlayerDataRepository(
    private val localSource: PlayerLocalSource,
) : PlayerRepository {
    override suspend fun fetchAll(): List<PlayerModel> {
        return localSource.findAll()
    }

    override fun save(players: List<PlayerModel>)  {
        localSource.save(players)
    }


}