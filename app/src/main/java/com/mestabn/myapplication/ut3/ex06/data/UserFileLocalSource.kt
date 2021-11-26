package com.mestabn.myapplication.ut3.ex06.data

import android.content.Context
import com.mestabn.myapplication.commons.serializer.JsonSerializer
import com.mestabn.myapplication.ut3.ex06.domain.UserModel
import java.io.File

class UserFileLocalSource(
    private val context: Context,
    private val serializer: JsonSerializer
) : UserLocalSource {

    /**
     * Obtengo un listado completo de alertas.
     */
    override fun findAll(): List<UserModel> {
        val alerts: MutableList<UserModel> = mutableListOf()
        val file = getFile(USERS_FILENAME)
        val lines = file.readLines()
        lines.map { line ->
            val alertModel = serializer.fromJson(line, UserModel::class.java)
            alerts.add(alertModel)
        }
        return alerts
    }


    override fun save(user: UserModel) {
        val file = getFile(getUserDetailFileName(user.name))
        file.writeText(serializer.toJson(user, UserModel::class.java))
    }


    private fun getFile(fileName: String): File {
        val file = File(context.filesDir, fileName)
        if (!file.exists()) {
            file.createNewFile()
        }
        return file
    }

    companion object {
        const val USERS_FILENAME: String = "pmdm_users.txt"
        fun getUserDetailFileName(userName: String): String = "pmdm_detail_$userName.txt"
    }
}