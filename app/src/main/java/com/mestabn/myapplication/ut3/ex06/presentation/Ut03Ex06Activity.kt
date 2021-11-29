package com.mestabn.myapplication.ut3.ex06.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.mestabn.myapplication.R
import com.mestabn.myapplication.commons.serializer.GsonSerializer
import com.mestabn.myapplication.databinding.ActivityUt03Ex06Binding
import com.mestabn.myapplication.ut3.ex06.data.PlayerMockLocalSource
import com.mestabn.myapplication.ut3.ex06.data.UserDataRepository
import com.mestabn.myapplication.ut3.ex06.data.UserFileLocalSource
import com.mestabn.myapplication.ut3.ex06.data.UserLocalSource
import com.mestabn.myapplication.ut3.ex06.domain.form.SavePLayerUseCase
import com.mestabn.myapplication.ut3.ex06.domain.list.GetUserUseCase
import com.mestabn.myapplication.ut3.ex06.presentation.form.FormViewModel
import com.mestabn.myapplication.ut3.ex06.presentation.form.Ut03Ex06FormFragment
import com.mestabn.myapplication.ut3.ex06.presentation.list.UserViewState
import com.mestabn.myapplication.ut3.ex06.presentation.list.Ut03Ex06Adapter
import com.mestabn.myapplication.ut3.ex06.presentation.list.Ut03Ex06ListFragment
import com.mestabn.myapplication.ut3.ex06.presentation.list.Ut03Ex06ViewModel


class Ut03Ex06Activity : AppCompatActivity() {

    private val binding: ActivityUt03Ex06Binding by lazy {
        ActivityUt03Ex06Binding.inflate(layoutInflater)
    }

    private val bind :  Ut03Ex06ListFragment =  Ut03Ex06ListFragment()


    private val viewModelFormFragment: FormViewModel by lazy {
        FormViewModel(
            SavePLayerUseCase(
                UserDataRepository(
                    UserFileLocalSource(
                        applicationContext,
                        GsonSerializer(
                            Gson()
                        )
                    )
                )
            )
        )
    }

    private val viewModelListFragment: Ut03Ex06ViewModel = Ut03Ex06ViewModel(
        GetUserUseCase(
            UserDataRepository(
                PlayerMockLocalSource()
            )
        )
    )

    private val userAdapter = Ut03Ex06Adapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()

    }

    fun setupView() {
        setupViewBinding()
        setupFragment()
        saveDataPlayer()
      //  getPlayers()
    }


    fun setupViewBinding() {
        setContentView(binding.root)
    }

    private fun setupFragment() {
        setupViewToolbarForm()
        addFragment(Ut03Ex06FormFragment.createInstance(), "1")
    }

    private fun setupViewToolbarForm() {
        setSupportActionBar(binding.toolbar)
    }


    private fun addFragment(fragment: Fragment, tag: String) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(binding.containerFragment.id, fragment, tag)
        fragmentTransition.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun updateToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    @SuppressLint("WrongConstant")
    private fun saveDataPlayer() {
        Thread {
            viewModelFormFragment.savePlayer()
            runOnUiThread {
                Toast.makeText(this, "datas", 5000).show()
            }
        }
    }

    private fun getPlayers(){
        bind.setupView()
        val userObserver = Observer<List<UserViewState>> {
            userAdapter.setItems(it)
            Log.d("@dev", "$it")
        }
        // Observamos al LiveData declarado en el ViewModel
        viewModelListFragment.alertViewState.observe(this, userObserver)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_change_fragment -> {
                when (val fragment = supportFragmentManager) {
                    fragment.findFragmentByTag("1") -> replaceFragment(
                        binding.containerFragment.id,
                        Ut03Ex06FormFragment.createInstance()
                    )
                    else -> replaceFragment(
                        binding.containerFragment.id,
                        Ut03Ex06ListFragment.createInstance()
                    )
                }

                true
            }

            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun replaceFragment(layoutId: Int, fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(layoutId, fragment)
        fragmentTransition.commit()
    }

}