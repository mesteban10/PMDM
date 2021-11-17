package com.mestabn.myapplication.ut3.ex02.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mestabn.myapplication.R

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private val dataSet : MutableList<UserViewState> = mutableListOf()

    /**
     * Función que establece los items que queremos visualizar.
     */
    fun setItems(items: List<UserViewState>) {
        dataSet.clear()
        dataSet.addAll(items.toMutableList())
    }


    /**
     * Función que añade nuevos items a los ya existentes.
     */
    fun addItems(items: MutableList<UserViewState>) {
        dataSet.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item_ut02_ex02, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
       holder.render(dataSet[position])
    }


        override fun getItemCount(): Int = dataSet.size


}