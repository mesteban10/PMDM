package com.mestabn.myapplication.ut3.ex06.presentation.form

import android.os.Build
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.mestabn.myapplication.R
import com.mestabn.myapplication.commons.serializer.GsonSerializer
import com.mestabn.myapplication.databinding.FragmentUt03Ex06FormBinding
import com.mestabn.myapplication.ut3.ex06.data.PlayerDataRepository
import com.mestabn.myapplication.ut3.ex06.data.PlayerFileLocalSource
import com.mestabn.myapplication.ut3.ex06.domain.form.SavePlayerUseCase


class Ut03Ex06FormFragment : Fragment() {

    private lateinit var binding: FragmentUt03Ex06FormBinding

    private val viewModelForm: FormViewModel by lazy {
        FormViewModel(
            SavePlayerUseCase(
                PlayerDataRepository(
                    (PlayerFileLocalSource(
                        requireContext(),
                        GsonSerializer(Gson())
                    ))

                )
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUt03Ex06FormBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }


    fun setupView() {
        binding.buttonSave.setOnClickListener {
            viewModelForm.savePlayer(savePlayer())
            clearItems()
            Toast.makeText(requireContext(), "Nuevo Jugador añadido", Toast.LENGTH_SHORT).show()
        }

    }

    fun savePlayer(): List<SavePlayerUseCase.Param> {
        val name = binding.namePersonForm.text.toString()
        val surname = binding.surnamePersonForm.text.toString()
        val region = binding.comunityPersonForm.selectedItem.toString()
        val demarcation = onCheckboxClicked()
        val gender = onRadioButtomClicked()
        return mutableListOf(SavePlayerUseCase.Param(name, surname, region, gender, demarcation))
    }


    fun clearItems() {
        binding.namePersonForm.text?.clear()
        binding.surnamePersonForm.text?.clear()
        binding.selectGender.clearCheck()
        binding.checkboxLeading.isChecked = false
        binding.checkboxFender.isChecked = false
        binding.checkboxGoalie.isChecked = false
        binding.checkboxMidfielder.isChecked = false
    }

    private fun onRadioButtomClicked(): String {
        var gender: String = ""
        gender = if (binding.radioMan.isChecked) {
            "Hombre"
        } else {
            "Mujer"
        }
        return gender
    }


    private fun onCheckboxClicked(): List<String> {
        val listDemarcation = mutableListOf<String>()
        if (binding.checkboxGoalie.isChecked) {
            listDemarcation.add("Portero")
        }
        if (binding.checkboxFender.isChecked) {
            listDemarcation.add("Defensa")
        }
        if (binding.checkboxMidfielder.isChecked) {
            listDemarcation.add("Medio Centro")
        }
        if (binding.checkboxLeading.isChecked) {
            listDemarcation.add("Delantero")
        }
        return listDemarcation

    }


    companion object {
        fun createInstance() = Ut03Ex06FormFragment()
    }

}