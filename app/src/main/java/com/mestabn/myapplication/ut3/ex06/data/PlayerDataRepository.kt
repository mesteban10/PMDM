package com.mestabn.myapplication.ut3.ex06.data

import com.mestabn.myapplication.ut3.ex06.domain.UserModel
import com.mestabn.myapplication.ut3.ex06.domain.PlayerRepository

class PlayerDataRepository(
    private val localSource: PlayerLocalSource,
) : PlayerRepository {
    override fun fetchAll(): List<UserModel> {
        return localSource.findAll()
    }

    override fun save(alertId: String) {
        TODO("Not yet implemented")
    }

    /* override fun save(userName: String) {
         userName.map { elemet -> UserModel(it.ma) }
         val user = localSource.save(userName)
     }*/


}