package com.mestabn.myapplication.ut3.ex06.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mestabn.myapplication.ut3.ex06.domain.list.GetPlayerUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut03Ex06ViewModel(private val getUsersUseCase: GetPlayerUseCase): ViewModel() {

    val alertViewState: LiveData<List<UserViewState>>
        get() = _usersViewState


    private val _usersViewState: MutableLiveData<List<UserViewState>> by lazy {
        MutableLiveData<List<UserViewState>>()
    }

    fun loadAlerts() = viewModelScope.launch(Dispatchers.Main) {
        val users = getUsersUseCase.execute()
        _usersViewState.value = users.map { UserViewState(it.name, it.surnames, it.community, it.gender, it.demarcation) }
    }

}
