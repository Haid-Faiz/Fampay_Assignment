package com.example.fampayassignment.ui.card_groups

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fampayassignment.data.CardGroupsRepository
import com.example.fampayassignment.utils.Resource
import com.example.lib.models.CardGroupResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardGroupsViewModel @Inject constructor(
    private val cardGroupsRepo: CardGroupsRepository
) : ViewModel() {

    private var _cardGroups: MutableLiveData<Resource<CardGroupResponse?>> = MutableLiveData()
    val cardGroups: LiveData<Resource<CardGroupResponse?>> get() = _cardGroups

    init {
        fetchData()
    }

    fun fetchData() = viewModelScope.launch {
        _cardGroups.postValue(Resource.Loading())
        _cardGroups.postValue(cardGroupsRepo.fetchCardGroupsData())
    }
}
