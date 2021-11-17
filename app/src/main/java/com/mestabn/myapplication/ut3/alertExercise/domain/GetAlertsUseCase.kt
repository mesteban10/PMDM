package com.mestabn.myapplication.ut3.alertExercise.domain

class GetAlertsUseCase(private val alertRepository: AlertRepository) {

    fun execute(): List<AlertModel> {
        return alertRepository.getAlerts()
    }
}