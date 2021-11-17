package com.mestabn.myapplication.ut3.alertExercise.presentation

import androidx.lifecycle.ViewModel
import com.mestabn.myapplication.ut3.alertExercise.domain.AlertModel
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertsUseCase
import com.mestabn.myapplication.ut3.ex02.domain.GetUserUseCase
import com.mestabn.myapplication.ut3.ex02.presentation.UserViewState

class AlertViewModel(private val getAlertsUseCase: GetAlertsUseCase): ViewModel() {
    fun getAlerts(): List<AlertViewState> {
        val alerts = getAlertsUseCase.execute()
        return alerts.map { alertModel -> AlertViewState(
            alertModel.id, alertModel.title, alertModel.datePublished, alertModel.summary
        )  }
    }
}
