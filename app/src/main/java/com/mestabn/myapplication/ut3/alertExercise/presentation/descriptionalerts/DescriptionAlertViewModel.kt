package com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertUseCase
import com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts.AlertViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DescriptionAlertViewModel(private val getAlertUseCase: GetAlertUseCase) : ViewModel() {

    val alertViewState: LiveData<AlertViewState>
        get() = _alertViewState

    private val _alertViewState: MutableLiveData<AlertViewState> by lazy {
        MutableLiveData<AlertViewState>()
    }

    fun loadAlert(alertId: String) =
        viewModelScope.launch(Dispatchers.Main) {
            val alert = getAlertUseCase.execute(alertId)
            if (alert != null) {
                _alertViewState.value = AlertViewState(
                    alert.id,
                    alert.title,
                    alert.datePublished,
                    alert.body,
                    alert.files
                )
            }

        }
}





