package com.example.fampayassignment.data

import com.example.fampayassignment.utils.Resource
import com.example.lib.models.CardGroupResponse
import kotlinx.coroutines.flow.Flow

interface CardGroupsRepository {

    suspend fun fetchCardGroupsData(): Resource<CardGroupResponse?>

    suspend fun saveCardStatus(isDismissed: Boolean)

}
