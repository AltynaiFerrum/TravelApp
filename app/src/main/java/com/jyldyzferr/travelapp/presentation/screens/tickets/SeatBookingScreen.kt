package com.jyldyzferr.travelapp.presentation.screens.tickets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.foundation.border
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jyldyzferr.travelapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Path
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color.Companion.Black

import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jyldyzferr.travelapp.presentation.theme.DarkGrey
import com.jyldyzferr.travelapp.presentation.theme.Grey
import com.jyldyzferr.travelapp.presentation.theme.LightGrey
import com.jyldyzferr.travelapp.presentation.theme.MyDarkGrey
import com.jyldyzferr.travelapp.presentation.theme.MyOrange
import com.jyldyzferr.travelapp.presentation.theme.Orange
import com.jyldyzferr.travelapp.presentation.theme.POPPINS


@Composable
fun SeatBookingScreen(
//    navController: NavController,
    viewModel: ReservationViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    ReservationScreenContent(
        state,
        onSeatClick = viewModel::onSeatSelected,
        onCloseClicked = {
//            navController.popBackStack()
        }
    )
}

@Composable
private fun ReservationScreenContent(
    state: ReservationUIState,
    onSeatClick: (id: Int) -> Unit,
    onCloseClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        ReservationScreenHeader(
            modifier = Modifier.align(Alignment.TopCenter),
            onCloseClicked = onCloseClicked
        )
        ReservationScreenSeats(
            seatsPairs = state.seats.toSeatPairs(),
            onSeatClick = onSeatClick,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 250.dp)
        )
        ReservationScreenFooter(
            state = state,
            modifier = Modifier.align(Alignment.BottomCenter),
        )
    }
}

@Composable
fun ReservationScreenFooter(
    state: ReservationUIState,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            ),
        colors = CardDefaults.cardColors(
            containerColor = White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ReservationDays(state)
            ReservationTimes(state)
            ReservationPriceAndSubmitButton()
        }
    }
}

@Composable
fun DayItem(
    dayOfMonth: Int,
    dayOfWeek: String,
    isSelected: Boolean = false,
) {
    Column(
        modifier = Modifier
            .border(1.dp, if (isSelected) Grey else LightGrey, RoundedCornerShape(24.dp))
            .clip(RoundedCornerShape(24.dp))
            .background(if (isSelected) Grey else Color.Transparent)
            .padding(vertical = 12.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = dayOfMonth.toString(),
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = if (isSelected) White else Black
        )
        Text(
            text = dayOfWeek,
            color = if (isSelected) White else Grey,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = POPPINS,
        )
    }
}

@Composable
fun ReservationDays(state: ReservationUIState) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(state.days) {
            DayItem(
                dayOfMonth = it.dayOfMonth,
                dayOfWeek = it.dayOfWeek,
                isSelected = it.isSelected
            )
        }
    }
}

@Composable
fun ReservationTimes(state: ReservationUIState) {
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(state.times) {
            TimeItem(it.time, it.isSelected)
        }
    }
}

@Composable
fun TimeItem(
    time: String,
    isSelected: Boolean,
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .background(if (isSelected) Grey else Color.Transparent)
            .border(1.dp, if (isSelected) Grey else LightGrey, RoundedCornerShape(24.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
            text = time,
            fontSize = 18.sp,
            fontFamily = POPPINS,
            fontWeight = FontWeight.Medium,
            color = if (isSelected) White else Black
        )
    }
}
@Composable
fun ReservationScreenHeader(modifier: Modifier, onCloseClicked: () -> Unit) {
    Column(
        modifier = modifier.padding(vertical = 16.dp, horizontal = 16.dp),
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(30.dp))
                .background(White.copy(alpha = 0.3f))
                .clickable { onCloseClicked() }
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_close_circle),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(28.dp),
                tint = White,
            )
        }
        RoundedBannerImage()
    }
}

@Composable
fun RoundedBannerImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.placeholder),
        contentDescription = "",
        modifier = modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(16.dp)
            .drawWithContent {
                val path = Path().apply {
                    val yRatio = 0.35f
                    moveTo(0f, size.height * yRatio)
                    lineTo(0f, size.height)
                    quadraticBezierTo(
                        size.width / 2,
                        size.height * 0.6f,
                        size.width,
                        size.height
                    )
                    lineTo(size.width, size.height * yRatio)
                    quadraticBezierTo(
                        size.width / 2,
                        0f,
                        0f,
                        size.height * yRatio,
                    )
                }
                clipPath(path = path) {
                    this@drawWithContent.drawContent()
                }
            }
            .graphicsLayer { this.rotationX = rotationX },
        contentScale = ContentScale.FillWidth
    )
}
@Composable
fun ReservationPriceAndSubmitButton() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 20.dp, bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                text = stringResource(R.string._100_00),
                fontSize = 36.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = POPPINS,
                color = Black
            )
            Text(
                text = stringResource(R.string._4_tickets),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = POPPINS,
                color = DarkGrey
            )
        }
        CustomButton(
            icon = R.drawable.ic_ticket,
            text = stringResource(R.string.buy_tickets),
        )
    }
}

@Composable
fun CustomButton(
    icon: Int = R.drawable.ic_ticket,
    text: String = stringResource(R.string.booking),
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Orange
        )
    ) {
        Row(
            modifier = Modifier.padding(8.dp)
        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null,
                tint = White,
                modifier = Modifier.size(28.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text,
                color = White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
@Composable
fun ReservationScreenSeats(
    seatsPairs: List<Pair<SeatUIState, SeatUIState>>,
    onSeatClick: (id: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        SeatsGrid(seatsPairs = seatsPairs, onSeatClick = onSeatClick)
        SeatsIndicators()
    }
}

@Composable
fun SeatsIndicators() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        SeatStatusIndicator(stringResource(R.string.available), color = White)
        SeatStatusIndicator(stringResource(R.string.taken), color = MyDarkGrey)
        SeatStatusIndicator(stringResource(R.string.selected), color = MyOrange)
    }
}

@Composable
fun SeatStatusIndicator(
    label: String,
    color: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(14.dp)
                .clip(shape = CircleShape)
                .background(color)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = label,
            color = MyDarkGrey,
            fontFamily = POPPINS,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
    }
}
@Composable
fun SeatsGrid(
    seatsPairs: List<Pair<SeatUIState, SeatUIState>>,
    onSeatClick: (id: Int) -> Unit
) {
    val leftSeatsIndexes = listOf(0, 3, 6, 9, 12)
    val rightSeatsIndexes = listOf(2, 5, 8, 11, 14)

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(0.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(seatsPairs.size) { index ->
            when (index) {
                in leftSeatsIndexes -> SeatPair(
                    seatsPairs[index],
                    modifier = Modifier.rotate(10f),
                    onSeatClick = onSeatClick
                )

                in rightSeatsIndexes -> SeatPair(
                    seatsPairs[index],
                    modifier = Modifier.rotate(-10f),
                    onSeatClick = onSeatClick
                )

                else -> SeatPair(
                    seatsPairs[index],
                    modifier = Modifier.padding(top = 9.dp),
                    onSeatClick = onSeatClick
                )
            }
        }
    }
}

@Composable
fun SeatPair(
    seatPair: Pair<SeatUIState, SeatUIState>,
    modifier: Modifier = Modifier,
    onSeatClick: (id: Int) -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.seat_belt), contentDescription = null,
            tint = if (seatPair.first.isSelected && seatPair.second.isSelected) MyOrange else MyDarkGrey,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(top = 6.dp),
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            SeatItem(seatPair.first, onSeatClick = onSeatClick)
            Spacer(modifier = Modifier.width(4.dp))
            SeatItem(seatPair.second, onSeatClick = onSeatClick)
        }
    }
}

@Composable
fun SeatItem(
    seatUIState: SeatUIState,
    onSeatClick: (id: Int) -> Unit
) {
    Icon(
        painterResource(R.drawable.seat),
        contentDescription = null,
        tint = when {
            seatUIState.isReserved -> MyDarkGrey
            seatUIState.isSelected -> MyOrange
            else -> White
        },
        modifier = Modifier
            .size(36.dp)
            .clickable(enabled = !seatUIState.isReserved) {
                onSeatClick(seatUIState.id)
            }
    )
}