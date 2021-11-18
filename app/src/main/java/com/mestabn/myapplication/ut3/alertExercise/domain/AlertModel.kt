package com.mestabn.myapplication.ut3.alertExercise.domain

import com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts.DescriptionAlertViewState

data class AlertModel(
    val id: String,
    val title: String,
    val type: Int,
    val summary: String,
    val datePublished: String,
    val body: String,
    val source: String,
    val files: List<FileModel>
)
