package com.mestabn.myapplication.ut3.ex06.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mestabn.myapplication.databinding.FragmentUt03Ex06ListBinding

class Ut03Ex06ListFragment : Fragment() {

    private lateinit var binding: FragmentUt03Ex06ListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUt03Ex06ListBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        val TAG: String = Ut03Ex06FormFragment::class.java.simpleName
        fun createInstance() = Ut03Ex06ListFragment()
    }

}