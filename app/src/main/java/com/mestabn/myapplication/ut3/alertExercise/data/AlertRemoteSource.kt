package com.mestabn.myapplication.ut3.alertExercise.data

import com.mestabn.myapplication.ut3.alertExercise.app.ApiAlert
import com.mestabn.myapplication.ut3.alertExercise.domain.AlertModel

class AlertRemoteSource (private val apiClient: ApiAlert) {

    suspend fun getAlerts() : List<AlertModel>{
        val apiModels = apiClient.getAlerts()
        return apiModels.map { apimodel -> apimodel.toDomainModel()  }
    }

}