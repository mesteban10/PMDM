package com.mestabn.myapplication.ut3.alertExercise.domain

class GetAlertsUseCase(private val alertRepository: AlertRepository) {

    suspend fun execute(): List<AlertModel> {
        return alertRepository.getAlerts()
    }
}