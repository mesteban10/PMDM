package com.mestabn.myapplication.ut3.ex06.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.mestabn.myapplication.databinding.FragmentUt03Ex06ListBinding
import com.mestabn.myapplication.ut3.ex06.presentation.form.Ut03Ex06FormFragment

class Ut03Ex06ListFragment : Fragment() {

    private lateinit var binding: FragmentUt03Ex06ListBinding

    private val userAdapter = Ut03Ex06Adapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUt03Ex06ListBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun setupView() {
        binding.listUsersForm.adapter = userAdapter
        binding.listUsersForm.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    companion object {
        val TAG: String = Ut03Ex06FormFragment::class.java.simpleName
        fun createInstance() = Ut03Ex06ListFragment()
    }

}