package com.mestabn.myapplication.ut3.ex02.domain

class GetUserUseCase(private val repository: UserRepository) {

    fun execute(): List<UserModel> = repository.fetchUsers()
}