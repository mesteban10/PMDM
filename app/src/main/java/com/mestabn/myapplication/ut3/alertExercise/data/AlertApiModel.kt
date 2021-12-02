package com.mestabn.myapplication.ut3.alertExercise.data

import com.mestabn.myapplication.ut3.alertExercise.domain.AlertModel
import com.mestabn.myapplication.ut3.alertExercise.domain.FileModel

data class AlertApiModel(
    val alert_id: String,
    val title: String,
    val summary: String,
    val type: String,
    val date: String,

) {
    fun toDomainModel(): AlertModel = AlertModel(
        alert_id,
        title,
        type.toInt(),
        summary,
        date,
        "",
        "",
       mutableListOf()
    )
}

data class DescriptionAlertApiModel(
    val id: String,
    val alert_id: String,
    val title: String,
    val type: String,
    val date: String,
    val summary: String,
    val body: String,
    val source: String,
    val files: List<FileApiModel>
) {

    fun toDomainModel(): AlertModel = AlertModel(
        alert_id,
        title,
        type.toInt(),
        summary,
        date,
        body,
        source,
        files.map { fileApiModel -> fileApiModel.toModel() }
    )

}

data class FileApiModel(val id: String, val alert_id: String, val name: String, val url: String) {
    fun toModel(): FileModel = FileModel(name, url)
}