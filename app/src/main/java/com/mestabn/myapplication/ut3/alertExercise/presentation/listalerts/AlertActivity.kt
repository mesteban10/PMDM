package com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mestabn.myapplication.databinding.ActivityAlertBinding
import com.mestabn.myapplication.ut3.alertExercise.app.RetrofitApiAlerts
import com.mestabn.myapplication.ut3.alertExercise.data.AlertDataRepository
import com.mestabn.myapplication.ut3.alertExercise.data.AlertRemoteSource
import com.mestabn.myapplication.ut3.alertExercise.domain.GetAlertsUseCase

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
        setContentView(bind.root)
        getAlerts()
        setupView()
    }



    private fun setupView() {
        bind.listAlerts.adapter = alertAdapter
        bind.listAlerts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun getAlerts() {
        Thread {
            val alerts = viewModel.getAlerts()
            runOnUiThread {
                alertAdapter.setItems(alerts)
            }
        }.start()
    }


}