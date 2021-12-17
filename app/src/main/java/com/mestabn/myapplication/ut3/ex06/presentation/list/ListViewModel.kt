package com.mestabn.myapplication.ut3.ex06.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mestabn.myapplication.ut3.ex06.domain.list.GetPlayerUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel(private val getplayersUseCase: GetPlayerUseCase) : ViewModel() {

    val playerViewState: LiveData<List<PlayerListViewState>>
        get() = _playersViewState


    private val _playersViewState: MutableLiveData<List<PlayerListViewState>> by lazy {
        MutableLiveData<List<PlayerListViewState>>()
    }

    fun loadPlayers() = viewModelScope.launch(Dispatchers.IO) {
        val players = getplayersUseCase.execute()
        _playersViewState.postValue(players.map {
            PlayerListViewState(
                it.name,
                it.surnames,
                it.community,
                it.gender,
                it.demarcation,
            )
        })
    }

}
