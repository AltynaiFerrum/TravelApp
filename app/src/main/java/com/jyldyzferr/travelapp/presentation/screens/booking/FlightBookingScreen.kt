package com.jyldyzferr.travelapp.presentation.screens.booking

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.components.MyTextField
import com.jyldyzferr.travelapp.presentation.models.Booking
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_in.LoginTextField
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_up.SignUpEvent
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_up.SignUpUiState
import com.jyldyzferr.travelapp.presentation.screens.details.DateType
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.MyBlue1
import com.jyldyzferr.travelapp.presentation.theme.MyBlue3
import com.jyldyzferr.travelapp.presentation.theme.MySignIn
import com.jyldyzferr.travelapp.presentation.theme.MyWhite
import com.jyldyzferr.travelapp.presentation.theme.POPPINS
import com.jyldyzferr.travelapp.presentation.theme.SearchFlights
import kotlinx.coroutines.launch

const val FLIGHT_BOOKING_ROUTE = "flight_booking_route"

@Composable
fun FlightBookingScreen(
    uiState: BookingUiState,
    onEvent: (BookingEvent) -> Unit,
    addToBasket: (Booking) -> Unit,
//    navigateToSelectFlight: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isShowInfoBlock by remember { mutableStateOf(false) }

    rememberCoroutineScope().launch() {
        kotlinx.coroutines.delay(100)
        isShowInfoBlock = true
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MyWhite)
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = painterResource(
                id = R.drawable.airplane_2
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        AnimatedVisibility(
            modifier = Modifier,
            visible = isShowInfoBlock,
            enter = fadeIn(
                animationSpec = tween(durationMillis = 1000)
            ),
            exit = fadeOut(
                animationSpec = tween(durationMillis = 1000)
            )
        ) {
            Card(
                modifier = Modifier
                    .padding(top = 200.dp)
                    .width(460.dp)
                    .height(693.dp),
                shape = RoundedCornerShape(25.dp),
            ) {
                Column(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 30.dp)) {
                    androidx.compose.material3.Text(
                        text = "Book your Flight!",
                        fontFamily = GILROY,
                        fontSize = 24.sp,
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    MyTextField(
                        modifier = Modifier
                            .fillMaxWidth(1f),
                        isPassword = false,
                        label = "Location",
                        value = uiState.addToBasket.location,
                        onValueChange = {
                            onEvent(BookingEvent.OnLocationChanged(it))
                        }
                    )
                    Spacer(modifier = modifier.height(24.dp))
                    MyTextField(
                        modifier = Modifier
                            .fillMaxWidth(1f),
                        isPassword = false,
                        label = "Destination",
                        value = uiState.addToBasket.destination,
                        onValueChange = {
                            onEvent(BookingEvent.OnDestinationChanged(it))
                        }
                    )
                    Spacer(modifier = modifier.height(24.dp))
                    MyTextField(
                        modifier = Modifier
                            .fillMaxWidth(1f),
                        isPassword = false,
                        label = "Passport",
                        value = uiState.addToBasket.passport,
                        onValueChange = {
                            onEvent(BookingEvent.OnPassportChanged(it))
                        }
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Row(
                        modifier = Modifier
//                            .padding(horizontal = 55.dp)
//                            .fillMaxSize(),
                    ) {
                        MyTextField(
                            modifier = Modifier
                                .width(170.dp)
                                .height(64.dp),
                            isPassword = false,
                            label = "Departure",
                            value = uiState.addToBasket.departure,
                            onValueChange = {
                                onEvent(BookingEvent.OnDepartureChanged(it))
                            }
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        MyTextField(
                            modifier = Modifier
                                .width(180.dp)
                                .height(64.dp),
                            isPassword = false,
                            label = "Return",
                            value = uiState.addToBasket.returnDate,
                            onValueChange = {
                                onEvent(BookingEvent.OnReturnDateChanged(it))
                            }
                        )
                    }
                    Spacer(modifier = modifier.height(20.dp))
                    Button(
                        onClick = {
                            onEvent(BookingEvent.OnFlightSearchClick)
                        },
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(50.dp),
//                            .padding(start = 90.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = SearchFlights
                        )
                    ) {
                        androidx.compose.material3.Text(
                            text = "Search Flights",
                            fontWeight = FontWeight.Bold,
                            fontFamily = GILROY,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}



