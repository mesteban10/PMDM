package com.mestabn.myapplication.ut3.ex06.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mestabn.myapplication.R


class ListAdapter : RecyclerView.Adapter<ListViewHolder>() {


    private val dataSet = mutableListOf<PlayerListViewState>()


    fun setItems(items: List<PlayerListViewState>) {
        dataSet.clear()
        addItems(items.toMutableList())
    }

    private fun addItems(items: MutableList<PlayerListViewState>) {
        dataSet.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_form, parent, false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.render(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size
}