package com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mestabn.myapplication.databinding.ViewItemAlertsBinding
import com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts.DescriptionAlertActivity

class AlertViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val bind = ViewItemAlertsBinding.bind(view)

    fun render(alertViewState: AlertViewState) {
        bind.titleAlert.text = alertViewState.title
        bind.dateAlert.text = alertViewState.date
        bind.descriptionAlert.text  = alertViewState.body
        itemView.setOnClickListener {
            itemView.context.startActivity(
                DescriptionAlertActivity.getIntent(
                    itemView.context,
                    alertViewState.id
                )
            )
        }
    }


}