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

    /**
     * Obtengo un listado completo de alertas.
     */
    override suspend fun findAll(): List<PlayerModel> = with(Dispatchers.IO) {
        val alerts: MutableList<PlayerModel> = mutableListOf()
        val file = getFile(playerS_FILENAME)
        val lines = file.readLines()
        lines.map { line ->
            val alertModel = serializer.fromJson(line, PlayerModel::class.java)
            alerts.add(alertModel)
        }
        return alerts
    }


    override fun save(player: PlayerModel) {
        val file = getFile(getplayerDetailFileName(player.name))
        file.writeText(serializer.toJson(player, PlayerModel::class.java))
    }


    private fun getFile(fileName: String): File {
        val file = File(context.filesDir, fileName)
        if (!file.exists()) {
            file.createNewFile()
        }
        return file
    }

    companion object {
        const val playerS_FILENAME: String = "pmdm_players.txt"
        fun getplayerDetailFileName(playerName: String): String = "pmdm_detail_$playerName.txt"
    }
}