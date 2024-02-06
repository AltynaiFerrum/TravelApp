package com.jyldyzferr.travelapp.presentation.app

import android.app.Application
import com.jyldyzferr.travelapp.di.BASE_URL
import com.jyldyzferr.travelapp.di.CLIENT_KEY
import com.parse.BuildConfig.APPLICATION_ID
import com.parse.Parse
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TravelApp: Application() {
    override fun onCreate() {
        super.onCreate()
        Parse.enableLocalDatastore(this)
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(APPLICATION_ID)
                .clientKey(CLIENT_KEY)
                .server(BASE_URL)
                .build()
        )
    }
}