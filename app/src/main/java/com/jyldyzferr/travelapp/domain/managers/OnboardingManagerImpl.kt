package com.jyldyzferr.travelapp.domain.managers

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


private val ONBOARDING_SHARED_PREF_NAME = "onboarding_file"
private val IS_ONBOARDING_PASSED_NAME = "is_onboarding_passed"


class OnboardingManagerImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : OnboardingManager {

    private val sharedPreferences by lazy(LazyThreadSafetyMode.NONE){
        context.getSharedPreferences(ONBOARDING_SHARED_PREF_NAME, Context.MODE_PRIVATE)
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