package com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.mestabn.myapplication.R
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
    }

    private fun setupView() {
        setupViewBinding()
        setupViewToolbar()
        loadAlert()
    }

    private fun setupViewBinding() {
        setContentView(bind.root)
    }

    private fun setupViewToolbar() {
        setSupportActionBar(bind.viewCustomToolbar.toolbar)
        supportActionBar?.title = "Información"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add -> {
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_share -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, "SHARE")
                    type = "text/plain"
                }
                startActivity(Intent.createChooser(sendIntent, ""))
                true

            }

            R.id.action_settings -> {
                Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
                true
            }

            R.id.action_about -> {
                Toast.makeText(this, "Versión de app: 0.0.1", Toast.LENGTH_SHORT).show()
                true
            }

            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

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