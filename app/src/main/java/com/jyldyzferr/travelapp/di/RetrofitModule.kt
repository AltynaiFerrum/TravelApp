package com.jyldyzferr.travelapp.di

import android.content.Context
import android.net.ConnectivityManager
import com.jyldyzferr.travelapp.data.cloud.service.BookingFetchService
import com.jyldyzferr.travelapp.data.cloud.service.BookingService
import com.jyldyzferr.travelapp.data.cloud.service.LoginService
import com.jyldyzferr.travelapp.data.cloud.service.TourService
import com.jyldyzferr.travelapp.data.cloud.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://parseapi.back4app.com/classes/"
private const val APPLICATION_ID = "jG5XFKJ8afK6qPmQe4UBHGhXHh0mwbGytxTCVtUL"
private const val REST_API_KEY = "CkMy1NVunB5IWvSs74pfMdRprYJKWHAUYV96MNQ1"
const val PARSE_BASE_URL = "https://parseapi.back4app.com"
const val CLIENT_KEY = "Jiof1zZVFsBy6nUAO87lGTJ6nrK4fkp0Bg9YuMqR"


@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addInterceptor(Interceptor { chain ->
                        val request = chain.request()
                            .newBuilder()
                            .addHeader(
                                name = "X-Parse-Application-Id",
                                value = APPLICATION_ID
                            )
                            .addHeader(
                                name = "X-Parse-REST-API-Key",
                                value = REST_API_KEY
                            )
                            .addHeader(
                                name = "Content-Type",
                                value = "application/json"
                            )
                            .build()
                        return@Interceptor chain.proceed(request = request)
                    })
                    .build()
            )
            .build()
    }

    @Provides
    fun provideLoginService(
        retrofit: Retrofit
    ): LoginService = retrofit.create(LoginService::class.java)

    @Provides
    fun provideUserService(
        retrofit: Retrofit
    ): UserService = retrofit.create(UserService::class.java)

    @Provides
    fun provideOshService(
        retrofit: Retrofit
    ): TourService = retrofit.create(TourService::class.java)

    @Provides
    fun provideBookingService(
        retrofit: Retrofit
    ): BookingService = retrofit.create(BookingService::class.java)

    @Provides
    fun provideBookingFetchService(
        retrofit: Retrofit
    ): BookingFetchService = retrofit.create(BookingFetchService::class.java)

    @Provides
    fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
        return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}