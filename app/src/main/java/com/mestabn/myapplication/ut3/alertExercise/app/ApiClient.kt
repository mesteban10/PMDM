package com.mestabn.myapplication.ut3.alertExercise.app

import com.mestabn.myapplication.ut3.alertExercise.data.AlertApiModel
import com.mestabn.myapplication.ut3.alertExercise.data.DescriptionAlertApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiClient {
   suspend fun getAlerts(): List<AlertApiModel>
   suspend fun getAlert(alertId: String): DescriptionAlertApiModel?
}

class MockApiAlerts : ApiClient {

    override suspend fun getAlerts(): List<AlertApiModel> =
        mutableListOf(
            AlertApiModel(
                "1", "Titulo 1", "Resumen alerta 1", "1", "2021-01-10"
            ),
            AlertApiModel(
                "2", "Titulo 2", "Resumen alerta 2", "1", "2021-01-09"
            ),
            AlertApiModel(
                "3", "Titulo 3", "Resumen alerta 3", "2", "2021-01-08"
            ),
            AlertApiModel(
                "4", "Titulo 4", "Resumen alerta 4", "2", "2021-01-07"
            ),
            AlertApiModel(
                "5", "Titulo 5", "Resumen alerta 5", "1", "2021-01-06"
            )
        )

    override suspend fun getAlert(alertId: String): DescriptionAlertApiModel {
        return DescriptionAlertApiModel(
            "1",
            "Titulo 1",
            "Resumen alerta 1",
            "1",
            "2021-01-10",
            "",
            "",
            "",
            mutableListOf()
        )

    }

}

class RetrofitApiAlerts : ApiClient {

    private val urlEndPoint: String = "https://plagricola.sitehub.es/api/public/"
    private var apiEndPoint: ApiEndPoint

    init {
        apiEndPoint = buildApiService()
    }

    private fun buildApiService(): ApiEndPoint = buildClient().create(ApiEndPoint::class.java)


    private fun buildClient(): Retrofit = Retrofit.Builder()
        .baseUrl(urlEndPoint)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    override suspend fun getAlerts(): List<AlertApiModel> {
        val response = apiEndPoint.getAlerts()
        return if (response.isSuccessful) {
            response.body()?.data ?: mutableListOf()

        } else {
            mutableListOf()
        }
    }

    override suspend fun getAlert(alertId: String): DescriptionAlertApiModel? {
        val response = apiEndPoint.getAlert(alertId)
        return if (response.isSuccessful) {
            response.body()?.data
        } else {
            null
        }
    }


}

