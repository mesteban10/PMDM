package com.mestabn.myapplication.ut3.alertExercise.domain

interface AlertRepository {
    suspend fun getAlerts(): List<AlertModel>
    suspend fun getAlert(alertId : String): AlertModel?
}