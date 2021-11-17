package com.mestabn.myapplication.ut3.ex02.data

import com.mestabn.myapplication.ut3.ex02.domain.UserModel
import com.mestabn.myapplication.ut3.ex02.domain.UserRepository

class UserDataRepository : UserRepository {
    override fun fetchUsers(): List<UserModel> = mutableListOf(
        UserModel(1, "Name01", "Surname01", 1),
        UserModel(2, "Name01", "Surname01", 1),
        UserModel(3, "Name01", "Surname01", 1),
        UserModel(4, "Name01", "Surname01", 1),
        UserModel(5, "Name01", "Surname01", 1),
        UserModel(6, "Name01", "Surname01", 1),
        UserModel(7, "Name01", "Surname01", 1),
        UserModel(8, "Name01", "Surname01", 1),
        UserModel(9, "Name01", "Surname01", 1),
        UserModel(10, "Name01", "Surname01", 1),
        UserModel(11,"Name01", "Surname01", 1),
        UserModel(12, "Name01", "Surname01", 1),
        UserModel(13, "Name01", "Surname01", 1),
        UserModel(14, "Name01", "Surname01", 1),
        UserModel(15, "Name01", "Surname01", 1)
    )

    }
