package com.edu.lab_3

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.edu.lab_3.databinding.PetItemBinding
import com.edu.lab_3.databinding.ShelterItemBinding
import com.edu.lab_3.model.InterfaceAdapter
import com.edu.lab_3.model.Pet
import com.edu.lab_3.model.Shelter

class EntityAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items = ArrayList<InterfaceAdapter>()

    class ItemPetHolder(
        private val binding: PetItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(pet: InterfaceAdapter) = with(binding) {
            pet as Pet
            tvName.text = pet.name
            tvBreed.text = pet.breed
            tvAge.text = pet.age.toString()
        }
    }

    class ItemShelterHolder(
        private val binding: ShelterItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(shelter: InterfaceAdapter) = with(binding) {
            shelter as Shelter
            tvName.text = shelter.name
            tvAddress.text = shelter.address
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewBinding: ViewBinding
        return when (viewType) {
            InterfaceAdapter.PET_TYPE -> {
                viewBinding =
                    PetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemPetHolder(viewBinding)
            }
            InterfaceAdapter.SHELTER_TYPE -> {
                viewBinding =
                    ShelterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ItemShelterHolder(viewBinding)
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].getType()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (items[position].getType()) {
            InterfaceAdapter.PET_TYPE ->
                (holder as ItemPetHolder).bind(items[position])
            InterfaceAdapter.SHELTER_TYPE ->
                (holder as ItemShelterHolder).bind(items[position])
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setList(newItem: ArrayList<InterfaceAdapter>) {
        items = newItem
        notifyDataSetChanged()
    }
}