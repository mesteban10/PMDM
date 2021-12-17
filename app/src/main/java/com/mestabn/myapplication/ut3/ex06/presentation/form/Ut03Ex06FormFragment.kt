package com.mestabn.myapplication.ut3.ex06.presentation.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding.actionSave.setOnClickListener {
          viewModelForm.savePlayer(savePlayer())
            clearItems()

        }

    }
    private fun savePlayer(): SavePlayerUseCase.Param {
        val name = binding.inputName.text.toString()
        val surname = binding.inputSurname.text.toString()
        val region = binding.listCommunity.selectedItem.toString()
        val demarcation = onCheckboxClicked()
        val gender = onRadioButtomClicked()
        return SavePlayerUseCase.Param(name, surname, region, gender, demarcation)
    }



    private fun clearItems() {
        binding.inputName.text?.clear()
        binding.inputSurname.text?.clear()
        binding.selectGender.clearCheck()
        binding.optionLeading.isChecked = false
        binding.optionFender.isChecked = false
        binding.optionGoalie.isChecked = false
        binding.optionMidfielder.isChecked = false
    }

    private fun onRadioButtomClicked(): String {
        var gender: String = ""
        gender = if (binding.optionMan.isChecked) {
           getString(R.string.label_man)
        } else {
            getString(R.string.label_woman)
        }
        return gender
    }


    private fun onCheckboxClicked(): List<String> {
        val listDemarcation = mutableListOf<String>()
        if (binding.optionGoalie.isChecked) {
            listDemarcation.add(getString(R.string.label_goalie))
        }
        if (binding.optionFender.isChecked) {
            listDemarcation.add(getString(R.string.label_fender))
        }
        if (binding.optionMidfielder.isChecked) {
            listDemarcation.add(getString(R.string.label_midfielder))
        }
        if (binding.optionLeading.isChecked) {
            listDemarcation.add(getString(R.string.label_leading))
        }
        return listDemarcation

    }


    companion object {
        fun createInstance() = Ut03Ex06FormFragment()
    }

}