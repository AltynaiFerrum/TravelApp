package com.jyldyzferr.travelapp.presentation.screens.edit_profile

import android.graphics.Bitmap

sealed class EditProfileEvent {

    data class OnNameChanged(val value: String) : EditProfileEvent()

    data class OnLastNameChanged(val value: String) : EditProfileEvent()

    data class OnAboutChanged(val value: String) : EditProfileEvent()

    data class OnEmailChanged(val value: String) : EditProfileEvent()

    data class OnAvatarChanged(val bitmap: Bitmap) : EditProfileEvent()
    data object OnSaveButtonClick : EditProfileEvent()

}