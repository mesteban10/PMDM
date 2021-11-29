package com.mestabn.myapplication.ut3.alertExercise.app

import com.mestabn.myapplication.ut3.alertExercise.data.AlertApiModel
import com.mestabn.myapplication.ut3.alertExercise.data.DescriptionAlertApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {
    @GET("alerts")
    suspend fun getAlerts(): Response<ApiResponse<List<AlertApiModel>>>

    @GET("alerts/{alert_id}")
    suspend fun getAlert(@Path("alert_id") alertId: String): Response<ApiResponse<DescriptionAlertApiModel>>

}