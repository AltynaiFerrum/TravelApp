package com.jyldyzferr.travelapp.presentation.screens.onboarding.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.jyldyzferr.travelapp.R

sealed class OnboardingPageItem(
    @StringRes open val buttonTextId: Int,
    open val isLastPage: Boolean
) {
    data class Onboarding(
        @StringRes val titleId: Int,
        @DrawableRes val backgroundId: Int,
        @DrawableRes val imageId: Int,
        @StringRes val descriptionId: Int,
        @StringRes override val buttonTextId: Int,
        override val isLastPage: Boolean = false
    ) : OnboardingPageItem(buttonTextId, isLastPage)

    companion object {
        fun onboardingItems() = listOf<OnboardingPageItem>(
            Onboarding(
                titleId = R.string.first_onboarding_title,
                buttonTextId = R.string.next,
                imageId = R.drawable.first_image_id,
                descriptionId = R.string.first_onboarding_desc,
                backgroundId = R.drawable.back_onboarding
            ),
            Onboarding(
                titleId = R.string.second_onboarding_title,
                buttonTextId = R.string.next,
                imageId = R.drawable.second_image_id,
                descriptionId = R.string.second_onboarding_desc,
                backgroundId = R.drawable.back_onboarding
            ),
            Onboarding(
                titleId = R.string.third_onboarding_title,
                buttonTextId = R.string.get_started,
                imageId = R.drawable.third_image_id,
                descriptionId = R.string.third_onboarding_desc,
                backgroundId = R.drawable.back_onboarding,
                isLastPage = true
            ),
        )
    }
}
