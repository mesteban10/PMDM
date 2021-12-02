package com.mestabn.myapplication.ut3.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.mestabn.myapplication.R
import com.mestabn.myapplication.databinding.ActivityUt02Ex02Binding
import com.mestabn.myapplication.ut3.ex02.data.UserDataRepository
import com.mestabn.myapplication.ut3.ex02.domain.GetUserUseCase

class Ut02Ex02Activity : AppCompatActivity() {

    private val viewModel = Ut02Ex02ViewModel(GetUserUseCase(UserDataRepository()))

    private val userAdapter = UserAdapter()

    private val bind : ActivityUt02Ex02Binding by lazy {
        ActivityUt02Ex02Binding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inicia el primer elemento de la vista
        setContentView(bind.root)
        //exampleInflateView()
        setupView()
        exampleRecycleView()
    }

    private fun setupView() {
        bind.listUsers.adapter = userAdapter
        bind.listUsers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun exampleInflateView(){
        val view : View = layoutInflater.inflate(R.layout.view_item_ut02_ex02, bind.root, false) //Una vez creada la vista, si quiero que la meta en bind.root(false)
        //Accedemos al frameLayout
        bind.wrapContent.addView(view)
    }

    private fun exampleRecycleView(){
            val users = viewModel.getUsers()
            userAdapter.setItems(users)
    }
}