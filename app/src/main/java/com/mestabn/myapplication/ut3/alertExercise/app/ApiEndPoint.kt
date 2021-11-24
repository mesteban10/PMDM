package com.mestabn.myapplication.ut3.alertExercise.app

import com.mestabn.myapplication.ut3.alertExercise.data.AlertApiModel
import com.mestabn.myapplication.ut3.alertExercise.data.DescriptionAlertApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoint {
    @GET("alerts")
    fun getAlerts(): Call<ApiResponse<List<AlertApiModel>>>

    @GET("alerts/{alert_id}")
    fun getAlert(@Path("alert_id") alertId: String): Call<ApiResponse<DescriptionAlertApiModel>>

}