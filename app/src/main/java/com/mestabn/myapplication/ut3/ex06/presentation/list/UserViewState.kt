package com.mestabn.myapplication.ut3.ex06.presentation.list

import com.mestabn.myapplication.ut3.ex06.domain.DemarcationModel

data class UserViewState (var name: String, val surname: String, val community: String, val gender: String, val demarcation : List<DemarcationModel>)