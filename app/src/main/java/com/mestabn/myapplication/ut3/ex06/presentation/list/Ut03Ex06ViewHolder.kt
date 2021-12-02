package com.mestabn.myapplication.ut3.ex06.presentation.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mestabn.myapplication.databinding.ItemListFormBinding
import com.mestabn.myapplication.ut3.ex06.presentation.list.UserViewState

class Ut03Ex06ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val bind = ItemListFormBinding.bind(view)

    fun render(userViewState: UserViewState) {
        bind.namePerson.text = userViewState.name
        bind.regionPerson.text =userViewState.community
        bind.genderPerson.text  = userViewState.gender


        }
    }
