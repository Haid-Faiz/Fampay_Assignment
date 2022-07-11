package com.example.fampayassignment.ui.card_groups

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import android.os.Bundle
import com.example.fampayassignment.databinding.ActivityMainBinding
import com.example.fampayassignment.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CardGroupsViewModel by viewModels()
    private lateinit var cardGroupsAdapter: CardGroupsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUI()
        setUpObserver()
    }

    private fun setUpObserver() {
        viewModel.cardGroups.observe(this) {

            when (it) {
                is Resource.Success -> binding.apply {
                    it.data?.cardGroups
                    cardGroupsAdapter.submitList(it.data?.cardGroups)
                }
                is Resource.Error -> binding.apply {

                }
                is Resource.Loading -> binding.apply {

                }
            }
        }
    }

    private fun setUpUI() = binding.apply {
        cardGroupsAdapter = CardGroupsAdapter()
        rvCardGroups.adapter = cardGroupsAdapter
    }
}