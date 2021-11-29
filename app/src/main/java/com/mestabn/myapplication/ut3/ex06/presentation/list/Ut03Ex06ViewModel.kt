package com.mestabn.myapplication.ut3.ex06.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mestabn.myapplication.ut3.ex06.domain.list.GetUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Ut03Ex06ViewModel(private val getAlertsUseCase: GetUserUseCase): ViewModel() {

    //Creamos la variable de forma pública para los observadores
    val alertViewState: LiveData<List<UserViewState>>
        get() = _alertViewState


    //Variable que nos sirve para fijarnos en los cambios y notificar sus cambios
    private val _alertViewState: MutableLiveData<List<UserViewState>> by lazy {
        MutableLiveData<List<UserViewState>>()
    }

    fun loadAlerts() = viewModelScope.launch(Dispatchers.Main) {
        val users = getAlertsUseCase.execute()
        _alertViewState.value = users.map { UserViewState(it.name, it.surnames, it.community, it.gender) }
    }

}