package com.example.fampayassignment.di

import com.example.fampayassignment.data.CardGroupsRepository
import com.example.fampayassignment.data.CardGroupsRepositoryImpl
import com.example.lib.ApiClient
import com.example.lib.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesApiClient(): ApiClient = ApiClient()

    @Provides
    @Singleton
    fun providesApiService(apiClient: ApiClient): ApiService = apiClient
        .retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun providesCardGroupsRepository(apiService: ApiService): CardGroupsRepository {
        return CardGroupsRepositoryImpl(apiService = apiService)
    }

}