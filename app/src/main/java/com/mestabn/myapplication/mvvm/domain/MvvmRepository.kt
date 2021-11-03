package com.mestabn.myapplication.mvvm.domain



interface MvvmRepository {
    fun getMvvm() : MvvmModel
    fun saveMvvm(mvvmModel: MvvmModel)
    fun removeMvvm(id:String)
    fun getMvvmAll(): List<MvvmModel>
}