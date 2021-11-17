package com.mestabn.myapplication.ut3.alertExercise.presentation.descriptionalerts

import com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts.AlertViewHolder
import com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts.AlertViewState


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mestabn.myapplication.R

class DescriptionAlertAdapter : RecyclerView.Adapter<AlertViewHolder>() {


    private val dataSet = AlertViewState("","","","")


    fun setItems(item: AlertViewState) {
        dataSet.
        addItems(item)
    }

    private fun addItems(items: MutableList<AlertViewState>) {
        dataSet.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlertViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_alerts, parent, false)

        return AlertViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlertViewHolder, position: Int) {
        holder.render(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size
}