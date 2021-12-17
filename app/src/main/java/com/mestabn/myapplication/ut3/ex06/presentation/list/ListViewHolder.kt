package com.mestabn.myapplication.ut3.ex06.presentation.list

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mestabn.myapplication.databinding.ItemListFormBinding

class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val bind = ItemListFormBinding.bind(view)

    @SuppressLint("SetTextI18n")
    fun render(playerViewState: PlayerListViewState) {
        bind.namePerson.text = playerViewState.name + playerViewState.surname
        bind.regionPerson.text = playerViewState.community
        bind.genderPerson.text = playerViewState.gender
        bind.firstDemarcationPerson.text = playerViewState.demarcation?.toString()



    }
}
