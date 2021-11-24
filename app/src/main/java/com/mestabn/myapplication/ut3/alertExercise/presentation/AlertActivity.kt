package com.mestabn.myapplication.ut3.alertExercise.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mestabn.myapplication.databinding.ActivityAlertBinding
import com.mestabn.myapplication.ut3.alertExercise.app.MockApiAlerts
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


    }

    /*
    private fun setupView() {
        bind.listAlerts.adapter = alertAdapter
        bind.listAlerts.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
*/

    //Función que deberia ejecutarse una vez, oncreate
    private fun setupViewStateObservers() {
        // Se crea el observador. Hay que indicar qué voy a recibir del observador.
        val alertObserver = Observer<List<AlertViewState>> { alerts ->
            // Actualiamos la UI con los datos recibidos desde el LiveData (Observer)
            renderUi(alerts)
        }
        // Observamos al LiveData declarado en el ViewModel
        viewModel.alertViewState.observe(this, alertObserver)
    }


    private fun renderUi(alerts: List<AlertViewState>) {

    }
}