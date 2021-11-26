package com.mestabn.myapplication.ut3.ex06.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.mestabn.myapplication.R
import com.mestabn.myapplication.databinding.ActivityUt03Ex06Binding


class Ut03Ex06Activity : AppCompatActivity() {

    private val binding: ActivityUt03Ex06Binding by lazy {
        ActivityUt03Ex06Binding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()

    }

    fun setupView(){
        setupViewBinding()
        setupFragment()
    }


    fun setupViewBinding() {
        setContentView(binding.root)

    }




    private fun addFragment(layoutId: Int, fragment: Fragment, tag: String) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(layoutId, fragment, tag)
        fragmentTransition.commit()
    }

    private fun replaceFragment(layoutId: Int, fragment: Fragment) {
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(layoutId, fragment)
        fragmentTransition.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    private fun setupFragment(){
        setupViewToolbarForm()
        addFragment(binding.form.id, Ut03Ex06FormFragment.createInstance(), "1")
    }

    private fun setupViewToolbarForm() {
        setSupportActionBar(binding.viewCustomToolbar.toolbar)
        supportActionBar?.title = "Form"
    }

    private fun setupViewToolbarList() {
        setSupportActionBar(binding.viewCustomToolbar.toolbar)
        supportActionBar?.title = "Listado"
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_change_fragment -> {
                val fragment = supportFragmentManager.findFragmentByTag("1")
                when(fragment){
                    null ->  replaceFragment(binding.containerFragment.id, Ut03Ex06ListFragment.createInstance())

                    else -> replaceFragment(binding.containerFragment.id, Ut03Ex06FormFragment.createInstance())
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
}