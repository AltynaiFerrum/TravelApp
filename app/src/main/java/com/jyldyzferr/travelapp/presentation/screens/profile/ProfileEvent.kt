package com.jyldyzferr.travelapp.presentation.screens.profile


sealed class ProfileEvent {

    data object OnEditBackgroundImage: ProfileEvent()

    data object OnEditProfile: ProfileEvent()

    data object OnLogOut: ProfileEvent()


}