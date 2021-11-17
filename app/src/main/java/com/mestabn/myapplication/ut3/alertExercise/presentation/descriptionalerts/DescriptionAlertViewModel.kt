package com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts

import androidx.lifecycle.ViewModel
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertUseCase
import com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts.AlertViewState

class DescriptionAlertViewModel(private val getAlertUseCase: GetAlertUseCase) : ViewModel() {

    fun getAlert(alertId : Int): DescriptionAlertViewState {
        val alert = getAlertUseCase.execute(alertId)
       return alert
    }

}

