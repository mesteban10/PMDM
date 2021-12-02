package com.mestabn.myapplication.ut3.ex06.presentation.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.mestabn.myapplication.R
import com.mestabn.myapplication.databinding.FragmentUt03Ex06FormBinding

class Ut03Ex06FormFragment : Fragment() {

    private lateinit var binding: FragmentUt03Ex06FormBinding

    //private val savePlayerUseCase: SavePLayerUseCase =
    //    SavePLayerUseCase(UserDataRepository((UserFileLocalSource(this, Js))))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUt03Ex06FormBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun savePlayer() {
        val name = binding.namePersonForm.text
        val surname = binding.surnamePersonForm.text
        val region = binding.comunityPersonForm.onItemSelectedListener
        val demarcation = onCheckboxClicked(binding.demarcationOptions)
        //savePlayerUseCase.Param("name", "suername")
    }

    fun onViewCreate() {

    }

    private fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_goalie -> {
                    if (checked) {
                        //savePlayerUseCase
                    }
                }
                R.id.checkbox_fender -> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }
                R.id.checkbox_leading -> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }
                R.id.checkbox_leading -> {
                    if (checked) {
                        // Cheese me
                    } else {
                        // I'm lactose intolerant
                    }
                }

                // TODO: Veggie sandwich
            }
        }
    }

    companion object {
        fun createInstance() = Ut03Ex06FormFragment()
    }

}