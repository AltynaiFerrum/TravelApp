package com.jyldyzferr.travelapp.presentation.app

import androidx.lifecycle.ViewModel
import com.jyldyzferr.travelapp.presentation.managers.NavigatorManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val navigatorManager: NavigatorManager,
): ViewModel() {

    val destinationsFlow = navigatorManager.destinationsFlow()
}