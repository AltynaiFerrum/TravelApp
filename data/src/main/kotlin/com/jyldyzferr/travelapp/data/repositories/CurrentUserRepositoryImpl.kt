package com.jyldyzferr.travelapp.data.repositories

import android.content.Context
import com.google.gson.Gson
import com.jyldyzferr.travelapp.domain.models.UserDomain
import com.jyldyzferr.travelapp.domain.repositories.CurrentUserRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

private const val SETTINGS_SHARED_PREF_NAME = "settings_file"
private const val IS_ONBOARDING_PASSED_NAME = "is_onboarding_passed"
private const val CURRENT_USER_NAME = "current_user_name"


class CurrentUserRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : CurrentUserRepository {

    private val sharedPreferences by lazy(LazyThreadSafetyMode.NONE) {
        context.getSharedPreferences(SETTINGS_SHARED_PREF_NAME, Context.MODE_PRIVATE)
    }

    override fun saveCurrentUser(user: UserDomain) {
        val prefEditor = sharedPreferences.edit()
        prefEditor.putString(CURRENT_USER_NAME, Gson().toJson(user))
        prefEditor.apply()
    }

    override fun fetchCurrentUser(): UserDomain {
        return try{
            val json = sharedPreferences.getString(CURRENT_USER_NAME, String()) ?: String()
            Gson().fromJson(json, UserDomain::class.java)
        } catch (e: Exception){
            UserDomain.unknown
        }
    }

    override fun clearCurrentUser() {
        val prefEditor = sharedPreferences.edit()
        prefEditor.putString(CURRENT_USER_NAME, String())
        prefEditor.apply()
    }


    override fun isOnboardingPassed(): Boolean {
        return sharedPreferences.getBoolean(IS_ONBOARDING_PASSED_NAME, false)
    }

    override fun setOnboardingShowed() {
        sharedPreferences.edit()
            .putBoolean(IS_ONBOARDING_PASSED_NAME, true)
            .apply()
    }

    override fun clearOnboarding() {
        sharedPreferences.edit()
            .putBoolean(IS_ONBOARDING_PASSED_NAME, false)
            .apply()
    }
}
