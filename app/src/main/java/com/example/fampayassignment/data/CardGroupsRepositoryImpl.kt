package com.example.fampayassignment.data

import com.example.fampayassignment.utils.Resource
import com.example.lib.ApiService
import com.example.lib.models.CardGroupResponse
import javax.inject.Inject

class CardGroupsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : CardGroupsRepository, BaseRepo() {

    override suspend fun fetchCardGroupsData(): Resource<CardGroupResponse?> = safeApiCall {
        apiService.fetchCardGroups()
    }
}
