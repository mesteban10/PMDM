package com.mestabn.myapplication.ut3.ex02.presentation

import androidx.lifecycle.ViewModel
import com.mestabn.myapplication.ut3.ex02.domain.GetUserUseCase
import com.mestabn.myapplication.ut3.ex02.domain.UserModel

class Ut02Ex02ViewModel(private val useCase: GetUserUseCase) : ViewModel() {

    fun getUsers() : List<UserViewState>{
        val users = useCase.execute()
        return users.map { userModel -> UserViewState(
            userModel.id, "${userModel.name} ${userModel.surname}",
            userModel.age.toString()
        )  }
    }
}