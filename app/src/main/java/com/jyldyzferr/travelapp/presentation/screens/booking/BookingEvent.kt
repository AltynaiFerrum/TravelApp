package com.jyldyzferr.travelapp.presentation.screens.booking

sealed class BookingEvent {

    data class OnLocationChanged(val value: String) : BookingEvent()
    data class OnDestinationChanged(val value: String) : BookingEvent()
    data class OnDepartureChanged(val value: String) : BookingEvent()
    data class OnReturnDateChanged(val value: String) : BookingEvent()
    data class OnPassportChanged(val value: String) : BookingEvent()
    data object OnFlightSearchClick : BookingEvent()

}