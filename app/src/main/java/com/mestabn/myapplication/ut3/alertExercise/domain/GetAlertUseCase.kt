package com.mestabn.myapplication.ut3.alertExercise.domain

class GetAlertUseCase(private val alertRepository: AlertRepository) {

    fun execute(alertId: Int): AlertModel? {
        return alertRepository.getAlert(alertId)
    }
}