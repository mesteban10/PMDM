package com.mestabn.myapplication.ut3.ex06.presentation.form

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mestabn.myapplication.ut3.ex06.domain.form.SavePlayerUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class FormViewModel(private val savePLayerUseCase: SavePlayerUseCase) : ViewModel() {

    fun savePlayer(param: SavePlayerUseCase.Param) {
        viewModelScope.launch(Dispatchers.IO) {
            savePLayerUseCase.execute(param)
        }

    }

}


