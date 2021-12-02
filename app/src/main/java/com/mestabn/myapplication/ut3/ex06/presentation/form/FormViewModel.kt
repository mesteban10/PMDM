package com.mestabn.myapplication.ut3.ex06.presentation.form

import android.annotation.SuppressLint
import android.view.View
import android.widget.CheckBox
import androidx.lifecycle.ViewModel
import com.mestabn.myapplication.R
import com.mestabn.myapplication.databinding.FragmentUt03Ex06FormBinding
import com.mestabn.myapplication.ut3.ex06.domain.UserModel
import com.mestabn.myapplication.ut3.ex06.domain.form.SavePLayerUseCase

class FormViewModel(private val savePLayerUseCase: SavePLayerUseCase) : ViewModel() {
    private lateinit var binding: FragmentUt03Ex06FormBinding

    private val ut03Ex06FormFragment: Ut03Ex06FormFragment = Ut03Ex06FormFragment()

    fun savePlayer() {
        binding.buttonSave.setOnClickListener {
            savePLayerUseCase.execute(
                SavePLayerUseCase.Param(
                    binding.namePersonForm.text.toString(),
                    binding.surnamePersonForm.text.toString(),
                    binding.comunityPersonForm.onItemSelectedListener.toString(),
                    onCheckboxRadioButtomClicked(binding.radioWoman, binding.radioMan).toString(),
                    emptyList()
                )
            )


            // clearAll()

        }
    }



 /*    private fun clearAll(){
         binding.namePersonForm.text =
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


}