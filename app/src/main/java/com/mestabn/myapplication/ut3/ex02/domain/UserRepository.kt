package com.mestabn.myapplication.ut3.ex02.domain

interface UserRepository {

    fun fetchUsers(): List<UserModel>
}