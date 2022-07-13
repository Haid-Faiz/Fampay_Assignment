package com.example.fampayassignment.ui.card_groups

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.example.fampayassignment.databinding.ActivityMainBinding
import com.example.fampayassignment.utils.Resource
import com.example.fampayassignment.utils.showSnackBar
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
                    cardGroupsAdapter.submitList(it.data?.cardGroups)
                    progressBar.isGone = true
                    rvCardGroups.isGone = false
                    swipeRefreshLayout.isRefreshing = false
                    errorLayout.root.isGone = true
                }
                is Resource.Error -> binding.apply {
                    progressBar.isGone = true
                    rvCardGroups.isGone = true
                    swipeRefreshLayout.isRefreshing = false
                    root.showSnackBar(it.errorMessage)
                    errorLayout.root.isGone = false
                }
                is Resource.Loading -> binding.apply {
                    errorLayout.root.isGone = true
                }
            }
        }
    }

    private fun setUpUI() = binding.apply {

        cardGroupsAdapter = CardGroupsAdapter()
        rvCardGroups.adapter = cardGroupsAdapter
        rvCardGroups.setHasFixedSize(true)

        swipeRefreshLayout.setOnRefreshListener {
            viewModel.fetchData()
            swipeRefreshLayout.isRefreshing = true
        }

        errorLayout.btnRetry.setOnClickListener {
            viewModel.fetchData()
        }
    }
}
