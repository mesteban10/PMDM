package com.mestabn.myapplication.ut3.ex06.domain.form

import com.mestabn.myapplication.ut3.ex06.domain.UserModel
import com.mestabn.myapplication.ut3.ex06.domain.UserRepository

class SavePLayerUseCase (private val userRepository: UserRepository)
{

    fun execute(param: Param){
        userRepository.save(param)
    }

    data class Param(val name: String, val surname: String, val region: String, val gender :String, val demarcation: String)
}