package com.mestabn.myapplication.ut3.alertExercise.domain

class GetAlertUseCase(private val alertRepository: AlertRepository) {

    fun execute(alertId: String): AlertModel? {
        return alertRepository.getAlert(alertId)
    }
}