package com.example.fampayassignment.data

import com.example.fampayassignment.utils.Resource
import com.example.lib.models.CardGroupResponse

interface CardGroupsRepository {

    suspend fun fetchCardGroupsData(): Resource<CardGroupResponse?>
}
