package com.jyldyzferr.travelapp.presentation.screens.booking_pass

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.screens.common.ErrorScreen
import com.jyldyzferr.travelapp.presentation.screens.common.LoadingScreen
import com.jyldyzferr.travelapp.presentation.screens.profile.CircularImage
import com.jyldyzferr.travelapp.presentation.screens.profile.ProfileEvent
import com.jyldyzferr.travelapp.presentation.screens.profile.ProfileUiState
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.LargeSpacing
import com.jyldyzferr.travelapp.presentation.theme.MyBlue1
import com.jyldyzferr.travelapp.presentation.theme.SearchBackground

const val BOARDING_PASS_ROUTE = "boarding_pass_route"

@Composable
fun BoardingPassScreen(
    uiState: BoardingPassUiState,
) {
    when (uiState) {
        is BoardingPassUiState.Initial -> Unit
        is BoardingPassUiState.Loading -> LoadingScreen()
        is BoardingPassUiState.Error -> ErrorScreen(
            message = uiState.message,
            onClick = { }
        )

        is BoardingPassUiState.Content -> BoardingPassScreenOne(
            uiState = uiState,
        )
    }
}
@Composable
fun BoardingPassScreenOne(
    uiState: BoardingPassUiState.Content,
//    onEvent: (BoardingPassEvent) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(SearchBackground),
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
//                .fillMaxWidth()
                .statusBarsPadding(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Spacer(modifier = Modifier.width(20.dp))
            Icon(
                modifier = Modifier
                    .size(40.dp)
                    .clickable { },
                imageVector = Icons.Filled.KeyboardArrowLeft,
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = "Search",
            )
            Spacer(modifier = Modifier.width(50.dp))
            Text(
                modifier = Modifier,
                text = "Boarding Pass",
                fontFamily = GILROY,
                color = MaterialTheme.colorScheme.onBackground,
                style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.ExtraBold),
            )
        }
        Box(

        ) {
            Image(
                painter = painterResource(id = R.drawable.base),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .padding(end = LargeSpacing)
                    .padding(top = 34.dp)
                    .align(Alignment.TopCenter)
            ) {
                Column {
                    Row(
//                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 85.dp)
                    ) {
                        Text(
                            "Air Pegasus",
                            fontFamily = GILROY,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Spacer(modifier = Modifier.width(30.dp))
                        Text(
                            text = uiState.booking.departure,
                            fontFamily = GILROY,
                            fontSize = 14.sp,
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    BoardingPassOne()
                    Divider(
                        color = MyBlue1,
                        modifier = Modifier
                            .padding(start = 81.dp)
                            .width(235.dp)
                            .height(1.dp)
                    )
                    BoardingPassTwo()
                    Divider(
                        color = MyBlue1,
                        modifier = Modifier
                            .padding(start = 81.dp)
                            .width(235.dp)
                            .height(1.dp)
                    )
                    BoardingPassThree()
                }
            }
            Box(
                modifier = Modifier
                    .padding(end = LargeSpacing)
                    .padding(top = 70.dp)
                    .align(Alignment.CenterEnd)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.qr_scan),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .width(350.dp)
                        .height(350.dp)
                        .padding(start = 30.dp, top = 100.dp, end = 35.dp, bottom = 120.dp)
//                .padding(horizontal = 50.dp)
//                    .fillMaxSize()
                )
            }
            Box(
                modifier = Modifier
                    .padding(end = LargeSpacing)
                    .padding(top = 70.dp)
                    .align(Alignment.BottomCenter)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.print_button),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
//                .padding(horizontal = 50.dp)
//                    .fillMaxSize()
                )
            }
        }
    }
}



@Composable
fun BoardingPassOne(
//    tripEvent: Tour,
) {
    Row(
//        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, start = 85.dp)
    ) {
        InfoColumnBoarding(
//            location = tripEvent.location,
//            "Location"
        )
        Spacer(modifier = Modifier.width(24.dp))
        HourBoarding(
//            tripEvent = tripEvent,
//            text = "Rating"
        )
        Spacer(modifier = Modifier.width(24.dp))
        ReturnBoarding()
//                location = tripEvent.price,
//            "Price"

    }
}
@Composable
fun InfoColumnBoarding(
//    location: String,
//    text: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        androidx.compose.material3.Text(
            "07h05",
//            text = location,
            maxLines = 1,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
        androidx.compose.material3.Text(
            "YUL",
//            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun HourBoarding(

) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource(id = R.drawable.airplane_mini),
            contentDescription = null,
        )
        androidx.compose.material3.Text(
            "13:00h",
//            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ReturnBoarding() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        androidx.compose.material3.Text(
            "20h05",
//            text = location,
            maxLines = 1,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
        androidx.compose.material3.Text(
            "NRT",
//            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BoardingPassTwo(
//    tripEvent: Tour,
) {
    Row(
//        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 80.dp)
    ) {
        EconomyBoarding(
//            location = tripEvent.location,
//            "Location"
        )
        Spacer(modifier = Modifier.width(14.dp))
        GateBoarding(
//            tripEvent = tripEvent,
//            text = "Rating"
        )
        Spacer(modifier = Modifier.width(14.dp))
        TerminalBoarding()
        Spacer(modifier = Modifier.width(14.dp))
//                location = tripEvent.price,
//            "Price"
        FlightBoarding()
    }
}

@Composable
fun EconomyBoarding(

) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        androidx.compose.material3.Text(
            "Economy",
//            text = location,
            maxLines = 1,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold
        )
        androidx.compose.material3.Text(
            "Class",
            fontSize = 12.sp,

//            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun GateBoarding(

) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        androidx.compose.material3.Text(
            "8",
            fontSize = 12.sp,
//            text = location,
            maxLines = 1,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold
        )
        androidx.compose.material3.Text(
            "Gate",
            fontSize = 12.sp,
//            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
    }
}
@Composable
fun TerminalBoarding(

) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        androidx.compose.material3.Text(
            "3",
            fontSize = 12.sp,
//            text = location,
            maxLines = 1,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold
        )
        androidx.compose.material3.Text(
            "Terminal",
            fontSize = 12.sp,
//            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun FlightBoarding(

) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        androidx.compose.material3.Text(
            "AC006",
            fontSize = 12.sp,
//            text = location,
            maxLines = 1,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold
        )
        androidx.compose.material3.Text(
            "Flight",
            fontSize = 12.sp,
//            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun BoardingPassThree() {
    Row(
//        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 75.dp)
    ) {
        CircularImage(
            path = R.drawable.placeholder,
            modifier = Modifier
                .padding(start = 10.dp),
            size = 50
        )
        Spacer(modifier = Modifier.width(14.dp))
        PersonBoarding(
//            location = tripEvent.location,
//            "Location"
        )
        Spacer(modifier = Modifier.width(14.dp))
        SeatBoarding(
//            tripEvent = tripEvent,
//            text = "Rating"
        )
    }
}

@Composable
fun PersonBoarding(

) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        androidx.compose.material3.Text(
            "Catherine Dion",
//            text = location,
            maxLines = 1,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.SemiBold
        )
        androidx.compose.material3.Text(
            "24 years, female",
            fontSize = 12.sp,
//            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun SeatBoarding(

) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painterResource(id = R.drawable.sofa),
            contentDescription = null,
        )
        androidx.compose.material3.Text(
            "29A",
            fontSize = 12.sp,
//            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
    }
}

