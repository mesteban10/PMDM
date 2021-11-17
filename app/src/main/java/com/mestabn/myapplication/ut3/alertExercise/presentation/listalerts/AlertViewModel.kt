package com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts

import androidx.lifecycle.ViewModel
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertsUseCase

class AlertViewModel(private val getAlertsUseCase: GetAlertsUseCase): ViewModel() {
    fun getAlerts(): List<AlertViewState> {
        val alerts = getAlertsUseCase.execute()
        return alerts.map { alertModel -> AlertViewState(
            alertModel.id, alertModel.title, alertModel.datePublished, alertModel.summary
        )  }
    }
}
