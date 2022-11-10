package com.edu.lab_3.model

data class Shelter(
    val id: Int = 0,
    val name: String? = null,
    val address: String? = null
) : InterfaceAdapter {
    override fun getType(): Int {
        return InterfaceAdapter.SHELTER_TYPE
    }
}