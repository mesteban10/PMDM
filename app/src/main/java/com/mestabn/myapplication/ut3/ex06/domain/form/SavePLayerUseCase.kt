package com.mestabn.myapplication.ut3.ex06.domain.form

import com.mestabn.myapplication.ut3.ex06.domain.DemarcationModel
import com.mestabn.myapplication.ut3.ex06.domain.PlayerRepository

class SavePLayerUseCase (private val playerRepository: PlayerRepository)
{

    fun execute(param: Param){
        playerRepository.save(param.toString())
    }

    data class Param(val name: String, val surname: String, val region: String, val gender: String, val demarcation: List<DemarcationModel>)
}