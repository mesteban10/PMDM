package com.mestabn.myapplication.ut3.ex06.data

import android.content.Context
import com.mestabn.myapplication.commons.serializer.JsonSerializer
import com.mestabn.myapplication.ut3.ex06.domain.PlayerModel
import kotlinx.coroutines.Dispatchers
import java.io.File

class PlayerFileLocalSource(
    private val context: Context,
    private val serializer: JsonSerializer
) : PlayerLocalSource {

    private val playerFile: File by lazy { getFile() }

    override suspend fun findAll(): List<PlayerModel> {
        val players: MutableList<PlayerModel> = mutableListOf()
        val fileLines = playerFile.readLines()
        fileLines.map { file ->
            val playerModel = serializer.fromJson(file, PlayerModel::class.java)
            players.add(playerModel)
        }
        return players
    }


    override fun save(players: List<PlayerModel>) {
        players.map { customerModel ->
            playerFile.appendText(
                serializer.toJson(
                    customerModel,
                    PlayerModel::class.java
                ) + System.lineSeparator()
            )
        }
    }


    private fun getFile(): File {
        val file = File(context.filesDir, PLAYERS_FILENAME)
        if (!file.exists()) {
            file.createNewFile()
        }
        return file
    }

    companion object {
        const val PLAYERS_FILENAME: String = "pmdm_players.txt"
        fun getplayerDetailFileName(playerName: String): String = "pmdm_detail_$playerName.txt"
    }
}