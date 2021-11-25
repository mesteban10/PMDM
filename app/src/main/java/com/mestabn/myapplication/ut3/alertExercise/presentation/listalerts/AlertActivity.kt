package com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mestabn.myapplication.R
import com.mestabn.myapplication.databinding.ActivityAlertBinding
import com.mestabn.myapplication.databinding.ActivityDescriptionAlertBinding
import com.mestabn.myapplication.ut3.alertExercise.app.MockApiAlerts
import com.mestabn.myapplication.ut3.alertExercise.app.RetrofitApiAlerts
import com.mestabn.myapplication.ut3.alertExercise.data.AlertDataRepository
import com.mestabn.myapplication.ut3.alertExercise.data.AlertRemoteSource
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertUseCase
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertsUseCase
import com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts.DescriptionAlertViewModel

class AlertActivity : AppCompatActivity() {

    private val viewModel: AlertViewModel = AlertViewModel(
        GetAlertsUseCase(
            AlertDataRepository(
                AlertRemoteSource(RetrofitApiAlerts())
            )
        )
    )

    private val alertAdapter = AlertsAdapter()

    private val bind: ActivityAlertBinding by lazy {
        ActivityAlertBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }


    private fun setupView() {
        setupViewBinding()
        setupViewRecycler()
        setupViewToolbar()
        getAlerts()
    }

    private fun setupViewBinding() {
        setContentView(bind.root)
    }

    private fun setupViewRecycler() {
        bind.listAlerts.adapter = alertAdapter
        bind.listAlerts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun setupViewToolbar() {
        setSupportActionBar(bind.viewCustomToolbar.toolbar)
        supportActionBar?.title = "Avisos"
    }

    private fun getAlerts() {
        Thread {
            val alerts = viewModel.getAlerts()
            runOnUiThread {
                alertAdapter.setItems(alerts)
            }
        }.start()
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


}


