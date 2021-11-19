package com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts

import androidx.lifecycle.ViewModel
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertUseCase

class DescriptionAlertViewModel(private val getAlertUseCase: GetAlertUseCase) : ViewModel() {

    fun getAlert(alertId: String): DescriptionAlertViewState? {

        val alert = getAlertUseCase.execute(alertId)
        alert?.let {
            return DescriptionAlertViewState(it.id, it.title, it.body )
        }
        return null
    }
}

