package com.mestabn.myapplication.ut3.ex06.domain.form

import com.mestabn.myapplication.ut3.ex06.domain.PlayerRepository
import com.mestabn.myapplication.ut3.ex06.domain.PlayerModel

class SavePlayerUseCase(private val playerRepository: PlayerRepository) {

    fun execute(param: List<Param>) {
        playerRepository.save(param.map { param -> param.toModel()  })

    }

    data class Param(
        val name: String,
        val surname: String,
        val region: String,
        val gender: String,
        val demarcation: List<String>
    ) {
        fun toModel() =
            PlayerModel(
                name,
                surname,
                region,
                gender,
                demarcation
            )
    }
}
