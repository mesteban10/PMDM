package com.mestabn.myapplication.ut3.ex06.presentation.form

import android.view.View
import android.widget.CheckBox
import androidx.lifecycle.ViewModel
import com.mestabn.myapplication.R
import com.mestabn.myapplication.ut3.ex06.domain.UserModel
import com.mestabn.myapplication.ut3.ex06.domain.form.SavePLayerUseCase

class FormViewModel(private val savePLayerUseCase: SavePLayerUseCase): ViewModel() {


    private val ut03Ex06FormFragment : Ut03Ex06FormFragment = Ut03Ex06FormFragment()

    fun savePlayer() {
        val userModel = ut03Ex06FormFragment.savePlayer()
        savePLayerUseCase.execute(SavePLayerUseCase.Param(userModel.toString(), userModel.toString(), userModel.toString(), userModel.toString(), userModel.toString()))

    }



}