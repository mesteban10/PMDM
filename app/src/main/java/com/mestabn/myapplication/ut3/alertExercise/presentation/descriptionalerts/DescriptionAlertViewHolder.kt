package com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mestabn.myapplication.databinding.ActivityDescriptionAlertBinding

class DescriptionAlertViewHolder(view: View) : RecyclerView.ViewHolder(view) {


    private val bind = ActivityDescriptionAlertBinding.bind(view)

    fun render(descriptionAlertViewState: DescriptionAlertViewState) {
        bind.titleAlertDescription.text = descriptionAlertViewState.title
        bind.filesTitle.text = descriptionAlertViewState.titleFiles
        bind.filesContentTitle.text = descriptionAlertViewState.titleContent
        bind.contentFiles.text = descriptionAlertViewState.body


    }
}
