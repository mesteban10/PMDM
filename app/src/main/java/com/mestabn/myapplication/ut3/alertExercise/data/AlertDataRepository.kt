package com.mestabn.myapplication.ut3.alertExercise.data

import com.mestabn.myapplication.ut3.alertExercise.domain.AlertModel
import com.mestabn.myapplication.ut3.alertExercise.domain.AlertRepository

class AlertDataRepository(private val remoteSource: AlertRemoteSource) : AlertRepository {
    override suspend fun getAlerts(): List<AlertModel> {
        return remoteSource.getAlerts()
    }

    override suspend fun getAlert(alertId: String): AlertModel? {
        return remoteSource.getAlert(alertId)
    }




}