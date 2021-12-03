package com.mestabn.myapplication.ut3.ex06.presentation

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mestabn.myapplication.R
import com.mestabn.myapplication.databinding.ActivityUt03Ex06Binding
import com.mestabn.myapplication.ut3.alertExercise.presentation.listalerts.AlertsAdapter
import com.mestabn.myapplication.ut3.ex06.presentation.form.Ut03Ex06FormFragment
import com.mestabn.myapplication.ut3.ex06.presentation.list.ListAdapter
import com.mestabn.myapplication.ut3.ex06.presentation.list.Ut03Ex06ListFragment


class Ut03Ex06Activity : AppCompatActivity() {

    private val binding: ActivityUt03Ex06Binding by lazy {
        ActivityUt03Ex06Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()

    }


    fun setupView() {
        setupViewBinding()
        setupToolbar()
        setupFragment()

    }

    fun setupViewBinding() {
        setContentView(binding.root)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
    }

    private fun setupFragment() {
        updateToolbarTitle("Formulario")
        addFragment(Ut03Ex06FormFragment.createInstance(), "1")
    }

    private fun addFragment(fragment: Fragment, tag: String) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(binding.containerFragment.id, fragment, tag)
        fragmentTransition.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.fragment_menu, menu)
        return true
    }

    private fun updateToolbarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_change_fragment -> {
                if (supportActionBar?.title == "Formulario") {
                    replaceFragment(
                        binding.containerFragment.id,
                        Ut03Ex06ListFragment.createInstance()
                    )
                    updateToolbarTitle("Listado")
                } else {
                    replaceFragment(
                        binding.containerFragment.id,
                        Ut03Ex06FormFragment.createInstance()
                    )
                    updateToolbarTitle("Formulario")

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