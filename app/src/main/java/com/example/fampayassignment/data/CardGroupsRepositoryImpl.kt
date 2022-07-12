package com.example.fampayassignment.data

import com.example.fampayassignment.utils.AppPrefs
import com.example.fampayassignment.utils.Resource
import com.example.lib.ApiService
import com.example.lib.models.CardGroupResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CardGroupsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val appPrefs: AppPrefs
) : CardGroupsRepository, BaseRepo() {

    override suspend fun fetchCardGroupsData(): Resource<CardGroupResponse?> = safeApiCall {
        apiService.fetchCardGroups()
    }

    override suspend fun saveCardStatus(isDismissed: Boolean) {
        appPrefs.saveCardStatus(isDismissed)
    }

}
