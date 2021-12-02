package com.mestabn.myapplication.ut3.ex02.presentation

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mestabn.myapplication.R
import com.mestabn.myapplication.databinding.ViewItemUt02Ex02Binding

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val bind = ViewItemUt02Ex02Binding.bind(view)


    fun render(userViewState: UserViewState) {
        bind.labelAge.text = userViewState.fullName
        bind.labelAge.text = userViewState.age
    }
}