package com.mestabn.myapplication.ut3.ex06.presentation.form

import android.annotation.SuppressLint
import android.view.View
import android.widget.CheckBox
import androidx.lifecycle.ViewModel
import com.mestabn.myapplication.R
import com.mestabn.myapplication.databinding.FragmentUt03Ex06FormBinding
import com.mestabn.myapplication.ut3.ex06.domain.form.SavePlayerUseCase


class FormViewModel(private val savePLayerUseCase: SavePlayerUseCase) : ViewModel() {
    fun savePlayer(param: SavePlayerUseCase.Param) {
        savePLayerUseCase.execute(param)
    }


}