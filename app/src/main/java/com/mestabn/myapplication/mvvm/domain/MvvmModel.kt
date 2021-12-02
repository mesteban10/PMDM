package com.mestabn.myapplication.mvvm.domain

import java.util.*


/**
 * Clase que almacena estados
 */


/**
 * Un modelo puede contener mas modelos
 */
data class MvvmModel(
    val id: Int,
    val title: String,
    val description: String,
    val mvvmDetailsModel: MvvmDetailsModel,
    val photoModel: List<PhotoModel>
)

data class MvvmDetailsModel(val longDescription: String, val startDate: Date)

data class PhotoModel(val url: String, val description: String)