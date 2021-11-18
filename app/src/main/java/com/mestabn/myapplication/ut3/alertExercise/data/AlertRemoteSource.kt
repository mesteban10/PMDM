package com.mestabn.myapplication.ut3.alertExercise.data

import com.mestabn.myapplication.ut3.alertExercise.app.ApiClient
import com.mestabn.myapplication.ut3.alertExercise.domain.AlertModel

class AlertRemoteSource (private val apiAlert: ApiClient) {

    fun getAlerts() : List<AlertModel>{
        val apiModels = apiAlert.getAlerts()
        return apiModels.map { apimodel -> apimodel.toDomainModel()  }
    }

    fun getAlert(alertId : String): AlertModel?{
        val alertApiModel = apiAlert.getAlert(alertId)
        if (alertApiModel != null) {
            return alertApiModel.toDomainModel()
        }
        return null
    }

}