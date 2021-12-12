package com.mestabn.myapplication.ut3.ex06.presentation.form

import android.annotation.SuppressLint
import android.view.View
import android.widget.CheckBox
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mestabn.myapplication.R
import com.mestabn.myapplication.databinding.FragmentUt03Ex06FormBinding
import com.mestabn.myapplication.ut3.ex06.domain.form.SavePlayerUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okhttp3.Dispatcher


class FormViewModel(private val savePLayerUseCase: SavePlayerUseCase) : ViewModel() {

    fun savePlayer(param: List<SavePlayerUseCase.Param>) {
        viewModelScope.launch(Dispatchers.Main){
            savePLayerUseCase.execute(param)
        }

    }


}