package com.example.gamerinfoapp.di

import com.example.gamerinfoapp.data.remote.GamesApi
import com.example.gamerinfoapp.data.repository.GameRepositoryImpl
import com.example.gamerinfoapp.domain.repository.GameRepository
import com.example.gamerinfoapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): GamesApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GamesApi::class.java)
    }

    @Provides
    @Singleton
    fun providesGameRepository(
        api: GamesApi
    ): GameRepository {
        return GameRepositoryImpl(api = api)
    }

}