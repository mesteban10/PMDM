package com.mestabn.myapplication.ut3.ex06.presentation.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.mestabn.myapplication.R
import com.mestabn.myapplication.databinding.FragmentUt03Ex06FormBinding
import com.mestabn.myapplication.ut3.ex06.data.PlayerDataRepository
import com.mestabn.myapplication.ut3.ex06.data.PlayerFileLocalSource
import com.mestabn.myapplication.ut3.ex06.domain.form.SavePLayerUseCase

class Ut03Ex06FormFragment : Fragment() {

    private lateinit var binding: FragmentUt03Ex06FormBinding



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