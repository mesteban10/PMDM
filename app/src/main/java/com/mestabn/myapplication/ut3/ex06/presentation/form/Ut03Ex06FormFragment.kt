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

    @SuppressLint("WrongConstant")
    fun savePlayer() {
        val name = binding.namePersonForm.text?.get(1)
        val surname = binding.surnamePersonForm.text.toString()
        val region = binding.comunityPersonForm.onItemSelectedListener.toString()
        val gender = onCheckboxRadioButtomClicked(binding.radioWoman, binding.radioMan).toString()
        val demarcation = onCheckboxClicked(binding.demarcationOptions).toString()
        binding.buttonSave.setOnClickListener {
            savePlayerUseCase.execute(
                SavePLayerUseCase.Param(
                    name,
                    surname,
                    region,
                    demarcation,
                    gender
                )
            )

           // clearAll()

        }
    }

   /* private fun clearAll(){
        binding.namePersonForm.text.toString() = " "
        val surname = binding.surnamePersonForm.text.toString()
        val region = binding.comunityPersonForm.onItemSelectedListener.toString()
        val gender = onCheckboxRadioButtomClicked(binding.radioWoman, binding.radioMan).toString()
        val demarcation = onCheckboxClicked(binding.demarcationOptions).toString()
    }*/

    private fun onCheckboxRadioButtomClicked(view: View, view2: View) {
        if (view is CheckBox) {
            val checkedMan: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_goalie -> {
                    if (checkedMan) {
                        binding.radioMan.text
                    } else {
                        binding.radioWoman.text
                    }
                }

            }
        }
    }

    private fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_goalie -> {
                    if (checked) {
                        binding.checkboxGoalie.text
                    }
                }
                R.id.checkbox_fender -> {
                    if (checked) {
                        binding.checkboxFender.text
                    }
                }
                R.id.checkbox_leading -> {
                    if (checked) {
                        binding.checkboxLeading.text
                    }
                }
                R.id.checkbox_midfielder -> {
                    if (checked) {
                        binding.checkboxMidfielder.text
                    }

                }
            }
        }
    }

    companion object {
        fun createInstance() = Ut03Ex06FormFragment()
    }

}
