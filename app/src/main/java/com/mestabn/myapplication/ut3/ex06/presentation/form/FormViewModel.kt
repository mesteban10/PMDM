package com.mestabn.myapplication.ut3.ex06.presentation.form

import android.view.View
import android.widget.CheckBox
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mestabn.myapplication.R
import com.mestabn.myapplication.databinding.FragmentUt03Ex06FormBinding
import com.mestabn.myapplication.ut3.ex06.domain.form.SavePLayerUseCase
import com.mestabn.myapplication.ut3.ex06.presentation.list.UserViewState
import kotlinx.coroutines.Dispatchers

class FormViewModel(private val savePLayerUseCase: SavePLayerUseCase) {

    private lateinit var binding: FragmentUt03Ex06FormBinding

    val playerViewState: LiveData<UserViewState>
        get() = _playerViewState

    private val _playerViewState: MutableLiveData<UserViewState> by lazy {
        MutableLiveData<UserViewState>()
    }

    /*
    fun loadAlert(alertId: String) =
        viewModelScope.launch(Dispatchers.Main) {
            val alert = savePLayerUseCase.execute(
                (SavePLayerUseCase.Param(
                    binding.namePersonForm.text.toString(),
                    binding.surnamePersonForm.text.toString(),
                    binding.comunityPersonForm.onItemSelectedListener.toString(),
                    binding.selectGender.textAlignment.toString(),
                    emptyList()
                )
                        )
            )
            if (alert != null) {
                _playerViewState.value = UserViewState(
                    alert.,
                    alert.title,
                    alert.datePublished,
                    alert.body,
                    alert.files
                )
            }

        }

*/
    fun savePlayer() {
        val name = binding.namePersonForm.text
        val surname = binding.surnamePersonForm.text
        val region = binding.comunityPersonForm.onItemSelectedListener
        val gender = binding.selectGender.textAlignment
        val demarcation = onCheckboxClicked(binding.demarcationOptions)
        binding.buttonSave.setOnClickListener {
            val player = savePLayerUseCase.execute(
                SavePLayerUseCase.Param(
                    name.toString(),
                    surname.toString(),
                    demarcation.toString(),
                    region.toString(),
                    emptyList()
                )
            )

        }
    }

    private fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.checkbox_goalie -> {
                    if (checked) {

                    }
                }
                R.id.checkbox_fender -> {
                    if (checked) {

                    } else {

                    }
                }
                R.id.checkbox_leading -> {
                    if (checked) {

                    } else {

                    }
                }
                R.id.checkbox_leading -> {
                    if (checked) {

                    } else {

                    }
                }

            }
        }
    }
}