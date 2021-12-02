package com.mestabn.myapplication.mvvm.presentation

import androidx.lifecycle.ViewModel
import com.mestabn.myapplication.mvvm.domain.GetMvvmUseCase


/**
 * Guarda el estado de la clase y la vista, llama al caso de uso para obener la info
 */

//Pasamos caso de uso por constructor
class MvvmViewModel(private val getMvvmUseCase: GetMvvmUseCase ) : ViewModel() {

    fun getAllMvvm() = getMvvmUseCase.execute("1")
}