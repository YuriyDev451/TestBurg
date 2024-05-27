package com.gukunov.testburg.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.gukunov.testburg.R
import com.gukunov.testburg.databinding.ActivityMainBinding
import com.gukunov.testburg.databinding.RwItemBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel: BurgerListViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FoodListAdapter
    private val burgerListViewModel: BurgerListViewModel by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerAdapter()
        burgerListViewModel.getBurgerList()


        viewModel.burgers.observe(this, Observer {
            it?.let { it1 -> adapter.setData(it1) }
        })



    }


    private fun initRecyclerAdapter() {
        adapter = FoodListAdapter()
        binding.foodList.layoutManager = LinearLayoutManager(applicationContext)
        binding.foodList.adapter = adapter
}
}