package com.mestabn.myapplication.ut3.ex06.data

import com.mestabn.myapplication.ut3.ex06.domain.UserModel

class PlayerMockLocalSource : UserLocalSource {
    override fun findAll(): List<UserModel> {
        return mutableListOf(
            UserModel("Pepe", "E.M", "Madrid", "Masculino", mutableListOf()),
            UserModel("Pepe", "E.M", "Madrid", "Masculino", mutableListOf())
        )
    }

    override fun save(user: UserModel) {
        UserModel("Pepe", "E.M", "Madrid", "Masculino", mutableListOf())
    }

}