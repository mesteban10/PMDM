package com.mestabn.myapplication.ut3.ex06.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mestabn.myapplication.R


class Ut03Ex06Adapter : RecyclerView.Adapter<Ut03Ex06ViewHolder>() {


    private val dataSet = mutableListOf<UserViewState>()


    fun setItems(items: List<UserViewState>) {
        dataSet.clear()
        addItems(items.toMutableList())
    }

    private fun addItems(items: MutableList<UserViewState>) {
        dataSet.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Ut03Ex06ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_form, parent, false)

        return Ut03Ex06ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Ut03Ex06ViewHolder, position: Int) {
        holder.render(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size
}