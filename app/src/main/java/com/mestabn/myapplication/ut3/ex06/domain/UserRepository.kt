package com.mestabn.myapplication.ut3.ex06.domain

interface UserRepository {
    fun fetchAll(): List<UserModel>
    fun save(alertId: String)
}