package com.mestabn.myapplication.ut3.alertExercise.presentation

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mestabn.myapplication.R

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    companion object {
        private val KEY_USER_ID = "key_user_id"

        fun getIntent(context: Context, alertId: String): Intent {
            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra(KEY_USER_ID, alertId)
            return intent
        }
    }
}