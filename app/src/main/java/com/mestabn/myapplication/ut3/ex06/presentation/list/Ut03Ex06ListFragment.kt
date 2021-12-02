package com.mestabn.myapplication.ut3.ex06.presentation.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.mestabn.myapplication.commons.serializer.GsonSerializer
import com.mestabn.myapplication.databinding.FragmentUt03Ex06ListBinding
import com.mestabn.myapplication.ut3.ex06.data.PlayerDataRepository
import com.mestabn.myapplication.ut3.ex06.data.PlayerFileLocalSource
import com.mestabn.myapplication.ut3.ex06.domain.list.GetPlayerUseCase
import com.mestabn.myapplication.ut3.ex06.presentation.form.Ut03Ex06FormFragment

class Ut03Ex06ListFragment(private val context: AppCompatActivity) : Fragment() {

    private lateinit var binding: FragmentUt03Ex06ListBinding



    private val viewModel: Ut03Ex06ViewModel = Ut03Ex06ViewModel(
        GetPlayerUseCase(
            PlayerDataRepository(
                PlayerFileLocalSource(context, GsonSerializer(Gson()))
            )
        )
    )


    private val userAdapter = Ut03Ex06Adapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUt03Ex06ListBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun setupView() {
        binding.listUsersForm.adapter = userAdapter
        binding.listUsersForm.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun setupViewStateObservers() {
        // Se crea el observador. Hay que indicar qué voy a recibir del observador.
        val alertObserver = Observer<List<UserViewState>> {
            renderUi(it)
        }
        // Observamos al LiveData declarado en el ViewModel
        viewModel.alertViewState.observe(this, alertObserver)
    }


    private fun renderUi(alerts: List<UserViewState>) {
        userAdapter.setItems(alerts)
    }

    companion object {
        val TAG: String = Ut03Ex06FormFragment::class.java.simpleName
        fun createInstance() = Ut03Ex06ListFragment(AppCompatActivity())
    }

}