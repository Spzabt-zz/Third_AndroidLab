package com.edu.lab_3.model

data class Pet(
    val id: Int = 0,
    val name: String? = null,
    val breed: String? = null,
    val age: Int = 0
) : InterfaceAdapter {
    override fun getType(): Int {
        return InterfaceAdapter.PET_TYPE
    }
}