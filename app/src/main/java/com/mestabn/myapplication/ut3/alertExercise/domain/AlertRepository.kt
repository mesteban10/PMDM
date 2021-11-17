package com.mestabn.myapplication.ut3.alertExercise.domain

interface AlertRepository {
    fun getAlerts(): List<AlertModel>
}