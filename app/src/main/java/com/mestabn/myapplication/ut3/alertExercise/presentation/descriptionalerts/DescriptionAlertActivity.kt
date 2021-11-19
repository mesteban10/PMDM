package com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mestabn.myapplication.databinding.ActivityDescriptionAlertBinding
import com.mestabn.myapplication.ut3.alertExercise.app.RetrofitApiAlerts
import com.mestabn.myapplication.ut3.alertExercise.data.AlertDataRepository
import com.mestabn.myapplication.ut3.alertExercise.data.AlertRemoteSource
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertUseCase

class DescriptionAlertActivity : AppCompatActivity() {

    private val bind: ActivityDescriptionAlertBinding by lazy {
        ActivityDescriptionAlertBinding.inflate(layoutInflater)
    }

    private val viewModel: DescriptionAlertViewModel = DescriptionAlertViewModel(
        GetAlertUseCase(
            AlertDataRepository(
                AlertRemoteSource(RetrofitApiAlerts())
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        loadAlerts()
    }

    private fun setupView() {
        setContentView(bind.root)
    }

    private fun loadAlerts(){
        Thread {
            val viewState = viewModel.getAlert(getAlertId())
            runOnUiThread {
                bind.titleAlertDescription.text = viewState?.title
                bind.contentFiles.text = viewState?.body
                bind.filesTitle.text =
            }
        }.start()


    }

    private fun getAlertId(): String {
        return intent.extras!!.getString(KEY_ALERT_ID, "0")
    }

    companion object {
        private val KEY_ALERT_ID = "key_alert_id"

        fun getIntent(context: Context, alertId: String): Intent {
            val intent = Intent(context, DescriptionAlertActivity::class.java)
            intent.putExtra(KEY_ALERT_ID, alertId)
            return intent
        }
    }
}