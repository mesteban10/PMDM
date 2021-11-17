package com.mestabn.myapplication.ut3.alertExercise.data

import com.mestabn.myapplication.ut3.alertExercise.domain.AlertModel
import com.mestabn.myapplication.ut3.alertExercise.domain.AlertRepository

class AlertDataRepository(private val remoteSource: AlertRemoteSource) : AlertRepository {
    override fun getAlerts(): List<AlertModel> {
        return remoteSource.getAlerts()
    }

    override fun getAlert(alertId: Int): AlertModel? {
        return remoteSource.getAlert(alertId)
    }


}