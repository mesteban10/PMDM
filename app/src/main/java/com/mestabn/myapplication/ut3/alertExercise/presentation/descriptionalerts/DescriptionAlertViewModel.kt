package com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DescriptionAlertViewModel(private val getAlertUseCase: GetAlertUseCase) : ViewModel() {

    fun getAlert(alertId: String): DescriptionAlertViewState? {
        viewModelScope.launch(Dispatchers.IO) {
            val alert = getAlertUseCase.execute(alertId)
            alert?.let {
                return DescriptionAlertViewState(it.id, it.title, it.title, it.title, it.body)
            }
        }
    }
}

