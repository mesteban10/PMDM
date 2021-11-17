package com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mestabn.myapplication.R

class AlertsAdapter : RecyclerView.Adapter<AlertViewHolder>() {


    private val dataSet = mutableListOf<AlertViewState>()


    fun setItems(items: List<AlertViewState>) {
        dataSet.clear()
        addItems(items.toMutableList())
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