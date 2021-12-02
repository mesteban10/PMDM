package com.mestabn.myapplication.ut3.ex06.presentation.form

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.mestabn.myapplication.R
import com.mestabn.myapplication.commons.serializer.GsonSerializer
import com.mestabn.myapplication.databinding.FragmentUt03Ex06FormBinding
import com.mestabn.myapplication.ut3.ex06.data.UserDataRepository
import com.mestabn.myapplication.ut3.ex06.data.UserFileLocalSource
import com.mestabn.myapplication.ut3.ex06.domain.form.SavePLayerUseCase

class Ut03Ex06FormFragment() : Fragment() {

    private lateinit var binding: FragmentUt03Ex06FormBinding

    private val savePlayerUseCase: SavePLayerUseCase = SavePLayerUseCase(
        UserDataRepository(
            (UserFileLocalSource(
                context, GsonSerializer(
                    Gson()
                )
            ))
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUt03Ex06FormBinding.inflate(inflater, container, false)
        return binding.root
    }


    companion object {
        fun createInstance() = Ut03Ex06FormFragment()
    }

}
