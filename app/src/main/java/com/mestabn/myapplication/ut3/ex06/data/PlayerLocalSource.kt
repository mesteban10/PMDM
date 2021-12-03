package com.mestabn.myapplication.ut3.ex06.data

import com.mestabn.myapplication.ut3.ex06.domain.PlayerModel

interface PlayerLocalSource {

   suspend fun findAll(): List<PlayerModel>
    fun save(players: List<PlayerModel>)

}