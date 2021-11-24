package com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mestabn.myapplication.ut3.alertExercise.domain.AlertModel
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertUseCase
import com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts.AlertViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DescriptionAlertViewModel(private val getAlertUseCase: GetAlertUseCase) : ViewModel() {

    fun getAlert(alertId: String): AlertModel? {
       return getAlertUseCase.execute(alertId)

    }
}

