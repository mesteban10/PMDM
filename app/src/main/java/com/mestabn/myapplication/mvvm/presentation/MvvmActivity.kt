package com.mestabn.myapplication.mvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.mestabn.myapplication.R


/**
 * La actividad solo obtiene datos del ViewModel
 */
class MvvmActivity : AppCompatActivity() {

    private val viewModel: MvvmViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm)
        render()
    }

    private fun render(){
        val mvvmModel = viewModel.getAllMvvm()
    }
}