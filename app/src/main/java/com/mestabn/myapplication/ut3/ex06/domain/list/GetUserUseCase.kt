package com.mestabn.myapplication.ut3.ex06.domain.list

import com.mestabn.myapplication.ut3.ex06.domain.UserModel
import com.mestabn.myapplication.ut3.ex06.domain.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {

    fun execute(): List<UserModel> {
        return userRepository.fetchAll()

    }
}