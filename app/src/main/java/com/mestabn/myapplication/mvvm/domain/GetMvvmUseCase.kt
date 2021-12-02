package com.mestabn.myapplication.mvvm.domain


/**
 * Un caso de uso solo realiza una accion, solo debe tener un metodo
 */

class GetMvvmUseCase(val mvvmRepository: MvvmRepository) {

    //Meto el repositorio dentro del caso de uso
    fun execute(paramsIn: String) : MvvmModel{
        val model = mvvmRepository.getMvvm()
        return model
    }



}