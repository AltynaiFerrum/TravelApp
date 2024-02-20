package com.jyldyzferr.travelapp.presentation.screens.booking_pass

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.screens.common.ErrorScreen
import com.jyldyzferr.travelapp.presentation.screens.common.LoadingScreen
import com.jyldyzferr.travelapp.presentation.screens.profile.LoadedProfileScreen
import com.jyldyzferr.travelapp.presentation.screens.profile.ProfileEvent
import com.jyldyzferr.travelapp.presentation.screens.profile.ProfileUiState
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.SearchBackground
import com.jyldyzferr.travelapp.presentation.theme.SearchFlights
import kotlinx.coroutines.launch

const val SELECT_FLIGHT_ROUTE = "select_flight_route"


@Composable
fun SelectYourFlightScreen(
//    uiState: BoardingPassUiState,
    navigateToBoardingPass: () -> Unit,
) {
    SelectYourFlightScreenOne(
        navigateToBoardingPass = navigateToBoardingPass
    )
//    when (uiState) {
//        is BoardingPassUiState.Initial -> Unit
//        is BoardingPassUiState.Loading -> LoadingScreen()
//        is BoardingPassUiState.Error -> ErrorScreen(
//            message = uiState.message,
//            onClick = { }
//        )
//        is BoardingPassUiState.Content -> SelectYourFlightScreenOne(
//            uiState = uiState,
//            navigateToBoardingPass = navigateToBoardingPass
//        )
//    }
}

@Composable
fun SelectYourFlightScreenOne(
//    uiState: BoardingPassUiState.Content,
    navigateToBoardingPass: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isShowInfoBlock by remember { mutableStateOf(false) }

    rememberCoroutineScope().launch() {
        kotlinx.coroutines.delay(100)
        isShowInfoBlock = true
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(SearchBackground)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.distance),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxHeight(0.279f)
                .padding(10.dp)
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
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                    .background(MaterialTheme.colorScheme.background)
                    .verticalScroll(rememberScrollState())
                    .weight(1f, fill = false)
            ) {
                Spacer(modifier = modifier.height(20.dp))
                Row(
                    modifier = Modifier
                ) {
                    Card(
                        modifier = Modifier
                            .width(170.dp)
                            .height(64.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(10.dp),
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(26.dp),
                                imageVector = Icons.Default.CalendarMonth,
                                contentDescription = null
                            )
                            Spacer(modifier = modifier.width(4.dp))
                            Text(
                                text = "Feb 22, 2024",
                                fontSize = 19.sp
                            )
                        }
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    Card(
                        modifier = Modifier
                            .width(170.dp)
                            .height(64.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .padding(10.dp),
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(26.dp),
                                imageVector = Icons.Default.Person,
                                contentDescription = null
                            )
                            Spacer(modifier = modifier.width(4.dp))
                            Text(
                                text = "AN233535",
                                fontSize = 19.sp
                            )
                        }
                    }
                }
                Spacer(modifier = modifier.height(20.dp))
                Image(
                    modifier = Modifier
                        .width(350.dp)
                        .height(100.dp),
                    painter = painterResource(
                        id = R.drawable.ticket_1
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = modifier.height(10.dp))
                Image(
                    modifier = Modifier
                        .width(350.dp)
                        .height(100.dp),
                    painter = painterResource(
                        id = R.drawable.ticket_2
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = modifier.height(10.dp))
                Image(
                    modifier = Modifier
                        .width(350.dp)
                        .height(100.dp),
                    painter = painterResource(
                        id = R.drawable.ticket_3
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = modifier.height(10.dp))
                Button(
                    onClick = {
                        navigateToBoardingPass()
                    },
                    modifier = Modifier
//                        .width()
                        .height(50.dp),
//                            .padding(start = 90.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = SearchFlights
                    )
                ) {
                    androidx.compose.material3.Text(
                        text = "Another Tickets",
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