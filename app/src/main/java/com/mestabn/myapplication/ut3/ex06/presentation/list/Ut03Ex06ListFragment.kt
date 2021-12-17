package com.mestabn.myapplication.ut3.ex06.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

class Ut03Ex06ListFragment : Fragment() {

    private lateinit var binding: FragmentUt03Ex06ListBinding


    private val viewModelList: ListViewModel by lazy {
        ListViewModel(
            GetPlayerUseCase(
                PlayerDataRepository(
                    PlayerFileLocalSource(requireContext(), GsonSerializer(Gson()))
                )
            )
        )
    }


    private val playerAdapter = ListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUt03Ex06ListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewRecycler()
        setupViewStateObservers()
        viewModelList.loadPlayers()
    }

    private fun setupViewRecycler() {
        binding.listUsersForm.adapter = playerAdapter
        binding.listUsersForm.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun setupViewStateObservers() {
        val playerObserver = Observer<List<PlayerListViewState>> {
            playerAdapter.setItems(it)
        }
        viewModelList.playerViewState.observe(requireActivity(), playerObserver)
    }


    companion object {
        fun createInstance() = Ut03Ex06ListFragment()
    }

}