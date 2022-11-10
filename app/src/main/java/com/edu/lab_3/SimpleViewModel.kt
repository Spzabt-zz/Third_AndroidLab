package com.edu.lab_3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edu.lab_3.model.InterfaceAdapter
import com.edu.lab_3.model.Pet
import com.edu.lab_3.model.Shelter

class SimpleViewModel : ViewModel() {
    private val _entities = MutableLiveData<ArrayList<InterfaceAdapter>>()

    val entities: LiveData<ArrayList<InterfaceAdapter>> = _entities

    fun initList() {
        val list = ArrayList<InterfaceAdapter>()
        list.add(Pet(0, "Cat", "American Curl", 1))
        list.add(Shelter(1, "Shelter 1", "Address 1"))
        list.add(Pet(2, "Dog", "Bulldog", 2))
        list.add(Shelter(3, "Shelter 2", "Address 2"))
        list.add(Pet(4, "Cat", "American Shorthair", 4))
        list.add(Shelter(5, "Shelter 3", "Address 3"))
        _entities.value = list
    }
}
