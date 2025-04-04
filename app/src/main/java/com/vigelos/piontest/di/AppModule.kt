package com.vigelos.piontest.di

import com.google.gson.GsonBuilder
import com.vigelos.piontest.data.api.ApiService
import com.vigelos.piontest.data.model.Section
import com.vigelos.piontest.data.repository.NewFeedJsonRepo
import com.vigelos.piontest.utils.SectionDeserializer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): Retrofit{

        val gson = GsonBuilder()
            .registerTypeAdapter(Section::class.java, SectionDeserializer())
            .create()

        return Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Akaizz/static/master/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: ApiService): NewFeedJsonRepo {
        return NewFeedJsonRepo(apiService)
    }
}