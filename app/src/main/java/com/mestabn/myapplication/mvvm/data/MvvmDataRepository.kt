package com.mestabn.myapplication.mvvm.data

import com.mestabn.myapplication.mvvm.domain.MvvmModel
import com.mestabn.myapplication.mvvm.domain.MvvmRepository


/**
 * Implementacion del repositorio
 * Desde aqui accedemos a acceso a datos o a PSP
 */
class MvvmDataRepository : MvvmRepository{
    override fun getMvvm(): MvvmModel {
        TODO("Not yet implemented")
    }

    override fun saveMvvm(mvvmModel: MvvmModel) {
        TODO("Not yet implemented")
    }

    override fun removeMvvm(id: String) {
        TODO("Not yet implemented")
    }

    override fun getMvvmAll(): List<MvvmModel> {
        TODO("Not yet implemented")
    }
}