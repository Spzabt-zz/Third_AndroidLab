package com.edu.lab_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.edu.lab_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: SimpleViewModel
    private lateinit var entityAdapter: EntityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[SimpleViewModel::class.java]

        entityAdapter = EntityAdapter()
        viewModel.initList()
        viewModel.entities.observe(this) {
            entityAdapter.setList(it)
        }

        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = EntityAdapter()
        (binding.rv.adapter as EntityAdapter).setList(viewModel.entities.value!!)
    }
}