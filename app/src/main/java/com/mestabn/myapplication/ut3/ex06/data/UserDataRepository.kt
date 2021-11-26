package com.mestabn.myapplication.ut3.ex06.data

import com.mestabn.myapplication.ut3.ex06.domain.UserModel
import com.mestabn.myapplication.ut3.ex06.domain.UserRepository

class AlertDataRepository(
    private val localSource: UserLocalSource,
) : UserRepository {
    override fun fetchAll(): List<UserModel> {
        return localSource.findAll()
    }

    override fun save(userName: String) {
        userName.map { elemet -> UserModel(it.ma) }
        val user = localSource.save(userName)
    }


}