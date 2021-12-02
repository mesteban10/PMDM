package com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlertViewModel(private val getAlertsUseCase: GetAlertsUseCase): ViewModel() {
    //Creamos la variable de forma pública para los observadores
    val alertViewState: LiveData<List<AlertViewState>>
        get() = _alertViewState


    //Variable que nos sirve para fijarnos en los cambios y notificar sus cambios
    private val _alertViewState: MutableLiveData<List<AlertViewState>> by lazy {
        MutableLiveData<List<AlertViewState>>()
    }

    fun loadAlerts() = viewModelScope.launch(Dispatchers.Main) {
        val alerts = getAlertsUseCase.execute()
        _alertViewState.value = alerts.map { AlertViewState(it.id, it.title, it.datePublished, it.summary, emptyList()) }
    }
}
