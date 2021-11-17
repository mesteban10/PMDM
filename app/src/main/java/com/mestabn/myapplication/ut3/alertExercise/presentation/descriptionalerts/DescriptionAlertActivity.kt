package com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mestabn.myapplication.R

class DescriptionAlertActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description_alert)
        getAlertId()
    }

    private fun getAlertId(): String {
        return intent.extras!!.getString(KEY_USER_ID, "0")
    }

    companion object {
        private val KEY_USER_ID = "key_user_id"

        fun getIntent(context: Context, alertId: String): Intent {
            val intent = Intent(context, DescriptionAlertActivity::class.java)
            intent.putExtra(KEY_USER_ID, alertId)
            return intent
        }
    }
}