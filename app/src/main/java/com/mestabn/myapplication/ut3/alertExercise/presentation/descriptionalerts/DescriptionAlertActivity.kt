package com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.mestabn.myapplication.databinding.ActivityDescriptionAlertBinding
import com.mestabn.myapplication.ut3.alertExercise.app.MockApiAlerts
import com.mestabn.myapplication.ut3.alertExercise.app.RetrofitApiAlerts
import com.mestabn.myapplication.ut3.alertExercise.data.AlertDataRepository
import com.mestabn.myapplication.ut3.alertExercise.data.AlertRemoteSource
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertUseCase

class DescriptionAlertActivity : AppCompatActivity() {

    private val bind: ActivityDescriptionAlertBinding by lazy {
        ActivityDescriptionAlertBinding.inflate(layoutInflater)
    }

    private val viewModelDescriptionAlert: DescriptionAlertViewModel = DescriptionAlertViewModel(
        GetAlertUseCase(
            AlertDataRepository(
                AlertRemoteSource(RetrofitApiAlerts())
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
        loadAlert()
    }

    private fun setupView() {
        setContentView(bind.root)
    }

    private fun loadAlert() = Thread {

        val alert = viewModelDescriptionAlert.getAlert(getAlertId())
        runOnUiThread {
            if (alert != null) {
                bind.titleAlertDescription.text = alert.title
                bind.fileOne.text = alert.files[0].name
                bind.fileOne.visibility = View.VISIBLE
                bind.secondFile.visibility = View.GONE
                bind.contentFilesDescription.text =
                    HtmlCompat.fromHtml(alert.body, HtmlCompat.FROM_HTML_MODE_LEGACY);
            }
        }
    }.start()

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