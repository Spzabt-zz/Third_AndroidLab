package com.edu.lab_3.model

interface InterfaceAdapter {
    fun getType(): Int

    companion object {
        const val PET_TYPE: Int = 1
        const val SHELTER_TYPE: Int = 2
    }
}