package com.mestabn.myapplication.ut3.ex06.data

import com.mestabn.myapplication.ut3.ex06.domain.UserModel

interface UserLocalSource {

   fun findAll(): List<UserModel>
    fun save(user: UserModel)

}