package com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts

import com.mestabn.myapplication.ut3.alertExercise.domain.FileModel


data class AlertViewState(val id: String, val title: String, val date: String, val body: String, val files: List<FileModel>)