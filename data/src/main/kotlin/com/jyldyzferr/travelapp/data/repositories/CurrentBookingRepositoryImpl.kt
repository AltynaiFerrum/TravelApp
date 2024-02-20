package com.jyldyzferr.travelapp.data.repositories

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.jyldyzferr.travelapp.data.cloud.service.BookingFetchService
import com.jyldyzferr.travelapp.data.cloud.service.BookingService
import com.jyldyzferr.travelapp.data.mappers.toDomain
import com.jyldyzferr.travelapp.domain.common.Result
import com.jyldyzferr.travelapp.domain.models.BookingBasketDomain
import com.jyldyzferr.travelapp.domain.models.BookingDomain
import com.jyldyzferr.travelapp.domain.models.UserDomain
import com.jyldyzferr.travelapp.domain.repositories.CurrentBookingRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.CancellationException
import javax.inject.Inject

private const val CURRENT_BOOKING_NAME = "current_user_name"

class CurrentBookingRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val service: BookingFetchService,
) : CurrentBookingRepository {

    private val sharedPreferences by lazy(LazyThreadSafetyMode.NONE) {
        context.getSharedPreferences(SETTINGS_SHARED_PREF_NAME, Context.MODE_PRIVATE)
    }

    override suspend fun fetchBookingById(id: String): Result<BookingDomain> {
        return try {
            val params = "{\"objectId\":\"$id\"}"
            val response = service.fetchBookingById(params)
            val user = response.results.first().toDomain()
            Result.Success(data = user)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("TravelApp", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }
//    override suspend fun fetchBookingById(id: String): List<BookingDomain> {
//        return try {
//            val params = "{\"objectId\":\"$id\"}"
//            val response = service.fetchBookingById(params)
//            val user = response.results.first().toDomain()
//            Result.Success(data = user)
//        } catch (e: CancellationException) {
//            throw e
//        } catch (e: Exception) {
//            Log.e("TravelApp", e.stackTraceToString())
//            Result.Error(message = e.message ?: e.stackTraceToString())
//        }    }

    override suspend fun fetchAllBooking(): Result<List<BookingDomain>> {
        return try {
            val userCloud = service.fetchAllBooking().results
            Result.Success(data = userCloud.map { it.toDomain() })
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e("TravelApp", e.stackTraceToString())
            Result.Error(message = e.message ?: e.stackTraceToString())
        }
    }

    override fun saveCurrentBooking(booking: BookingDomain) {
        val prefEditor = sharedPreferences.edit()
        prefEditor.putString(CURRENT_BOOKING_NAME, Gson().toJson(booking))
        prefEditor.apply()
    }
}