package com.jyldyzferr.travelapp.presentation.screens.details


import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DateRangePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.screens.main.BookingViewModel
import com.jyldyzferr.travelapp.presentation.theme.DisabledColor
import com.jyldyzferr.travelapp.presentation.theme.MyOrange
import com.jyldyzferr.travelapp.presentation.theme.MyTextField1
import com.jyldyzferr.travelapp.presentation.theme.primaryDark
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit
import kotlin.math.abs

const val HOTEL_BOOKING_ROUTE = "hotel_booking_route"

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(
//    isSystemInDarkMode: Boolean = isSystemInDarkTheme(),
//    detailViewModel: DetailViewModel,
    ) {


//    val useDarkIcons = !isSystemInDarkMode
//    val property by detailViewModel.property!!.collectAsStateWithLifecycle()
    val bookingViewModel: BookingViewModel = hiltViewModel()
    val guestState by bookingViewModel.guestState.collectAsStateWithLifecycle()


    val bottomSheetState = rememberModalBottomSheetState()
    val coroutineScope = rememberCoroutineScope()

    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    var dateType by rememberSaveable {
        mutableStateOf(DateType.CHECK_IN)
    }

    var checkInDate by rememberSaveable {
        mutableLongStateOf(0L)
    }

    var checkOutDate by rememberSaveable {
        mutableLongStateOf(0L)
    }

    val context = LocalContext.current

    val scrollState = rememberScrollState()
    val density = LocalDensity.current

    Scaffold(

    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(scrollState)
                    .padding(10.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(DpDimensions.Normal)
            ) {

                ListingItem(listing = property!!, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(DpDimensions.Small))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(DpDimensions.Normal)
                    ) {

                        DateSelector(
                            title = "Check in",
                            placeholder = if (checkInDate != 0L)
                                checkInDate.formatTimeToSmallDate()
                            else "check in",
                            modifier = Modifier.weight(1f),
                            onClick = {
                                isSheetOpen = true
                                dateType = DateType.CHECK_IN
                            }
                        )
                        DateSelector(
                            title = "check out",
                            placeholder = if (checkOutDate != 0L)
                                checkOutDate.formatTimeToSmallDate()
                            else "check out",
                            modifier = Modifier.weight(1f),
                            onClick = {
                                isSheetOpen = true
                                dateType = DateType.CHECK_OUT
                            }
                        )
                    }
                    AnimatedVisibility(visible = (checkInDate != 0L && checkOutDate != 0L),
                        enter = slideInVertically {
                            with(density) { -40.dp.roundToPx() }
                        } + expandVertically(expandFrom = Alignment.Top)
                                + fadeIn(initialAlpha = .3f),
                        exit = slideOutVertically() + shrinkVertically() + fadeOut(),
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Text(
                            text = "(${Pair(checkOutDate, checkInDate).getTotalDays()} days)",
                            style = MaterialTheme.typography.bodyMedium,
                            color = primaryDark,
                            modifier = Modifier.align(Alignment.End)
                        )
                    }
                }
                GuestSection(
                    guestState = guestState,
                    property = property!!,
                    modifier = Modifier.fillMaxWidth(),
                    onAdd = { guestType, value ->
                        bookingViewModel.setGuest(
                            numberOfGuest = value,
                            guestType = guestType,
                            state = guestState,
                            event = Event.ADD
                        )
                    },
                    onMinus = { guestType, value ->
                        bookingViewModel.setGuest(
                            numberOfGuest = value,
                            guestType = guestType, state = guestState,
                            event = Event.SUBTRACT
                        )
                    }
                )
                Spacer(modifier = Modifier.height(DpDimensions.Small))
                AnimatedVisibility(visible = (checkInDate != 0L && checkOutDate != 0L),
                    enter = slideInVertically {
                        with(density) { -40.dp.roundToPx() }
                    } + expandVertically(expandFrom = Alignment.Top)
                            + fadeIn(initialAlpha = .3f),
                    exit = slideOutVertically() + shrinkVertically() + fadeOut()
                ) {
                    TotalSection(
                        guestState = guestState,
                        checkInDate = checkInDate,
                        checkOutDate = checkOutDate,
                        property = property!!,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            Surface(
                modifier = Modifier.fillMaxWidth(), color = MaterialTheme.colorScheme.background,
                shadowElevation = DpDimensions.Small
            ) {
                CustomPadding(
                    verticalPadding = DpDimensions.Dp30,
                    horizontalPadding = DpDimensions.Dp20
                ) {
                    PrimaryButton(
                        label = "Book Now", disabledColor = DisabledColor,
                        onClick = {
                            context.showToast("This is the booking feature with proper validation")
                        },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
            if (isSheetOpen) {
                DatePickerBottomSheet(
                    bottomSheetState = bottomSheetState,
                    property = property!!,
                    onDismiss = {
                        isSheetOpen = false
                    },
                    onSelectDates = { dateIn, dateOut ->
                        checkInDate = dateIn
                        checkOutDate = dateOut
                        isSheetOpen = false
                    })
            }
        }
    }
}


@Composable
fun TotalSection(
    modifier: Modifier = Modifier,
    guestState: GuestState,
    checkInDate: Long,
    checkOutDate: Long,
    property: Property
) {

    Column(modifier = modifier) {

        Text(
            text = "price details",
            style = MaterialTheme.typography.headlineMedium,
            color = primaryDark
        )

        Spacer(modifier = Modifier.height(DpDimensions.Normal))

        Column(
            horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "USD ${property.price} x ${
                        Pair(
                            checkOutDate,
                            checkInDate
                        ).getTotalDays()
                    }",
                    style = MaterialTheme.typography.titleMedium,
                    color = primaryDark
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(
                        R.string.currency,
                        (property.price * Pair(checkOutDate, checkInDate).getTotalDays()).toFloat()
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = primaryDark,
                    textAlign = TextAlign.End
                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(R.string.service_fee),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(
                        R.string.currency,
                        (property.cleaning_fee ?: 0).toFloat()
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.End
                )
            }
            Spacer(modifier = Modifier.height(DpDimensions.Smallest))

            HorizontalDivider()

            Spacer(modifier = Modifier.height(DpDimensions.Smallest))

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Total",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(
                        R.string.currency,
                        (property.cleaning_fee ?: 0) + (property.price * Pair(
                            checkOutDate,
                            checkInDate
                        ).getTotalDays()).toFloat()
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}


@Composable
fun GuestSection(
    modifier: Modifier = Modifier,
    guestState: GuestState,
    property: Property,
    onAdd: (guestType: GuestType, value: Int) -> Unit = { _, _ -> },
    onMinus: (guestType: GuestType, value: Int) -> Unit = { _, _ -> },
) {

    var isInEditMode by rememberSaveable {
        mutableStateOf(false)
    }

    val density = LocalDensity.current

    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(DpDimensions.Normal)) {

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Quests",
                    style = MaterialTheme.typography.headlineMedium,
                    color = primaryDark
                )
                Text(
                    text = "Adults ${guestState.adults}, Children ${guestState.children}, Infants ${guestState.infant}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = primaryDark
                )
            }

            TextButton(
                onClick = {
                    isInEditMode = !isInEditMode
                },
                shape = CircleShape,
                border = BorderStroke(width = 1.dp, color = MyOrange)
            ) {
                CustomPadding(verticalPadding = 0.dp, horizontalPadding = DpDimensions.Normal) {
                    Text(
                        text = if (isInEditMode) stringResource(R.string.done) else stringResource(R.string.edit),
                        style = MaterialTheme.typography.titleMedium,
                        color = MyOrange
                    )
                }
            }
        }


        AnimatedVisibility(visible = isInEditMode,
            enter = slideInVertically {
                with(density) { -40.dp.roundToPx() }
            } + expandVertically(expandFrom = Alignment.Top)
                    + fadeIn(initialAlpha = .3f),
            exit = slideOutVertically() + shrinkVertically() + fadeOut()
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
            ) {
                GuestCounter(
                    guestType = GuestType.ADULT,
                    guestState = guestState,
                    property = property,
                    onAdd = { guestType, value ->
                        onAdd(guestType, value)
                    },
                    onMinus = { guestType, value ->
                        onMinus(guestType, value)
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                GuestCounter(
                    guestType = GuestType.CHILDREN,
                    guestState = guestState,
                    property = property,
                    onAdd = { guestType, value ->
                        onAdd(guestType, value)
                    },
                    onMinus = { guestType, value ->
                        onMinus(guestType, value)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                GuestCounter(guestType = GuestType.INFANT,
                    guestState = guestState,
                    property = property,
                    onAdd = { guestType, value ->
                        onAdd(guestType, value)
                    },
                    onMinus = { guestType, value ->
                        onMinus(guestType, value)
                    }
                )
            }
        }
    }
}


@Composable
fun GuestCounter(
    modifier: Modifier = Modifier,
    guestType: GuestType,
    guestState: GuestState,
    onAdd: (guestType: GuestType, value: Int) -> Unit = { _, _ -> },
    onMinus: (guestType: GuestType, value: Int) -> Unit = { _, _ -> },
    property: Property
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = when (guestType) {
                    GuestType.ADULT -> stringResource(R.string.adults)
                    GuestType.CHILDREN -> stringResource(R.string.children)
                    GuestType.INFANT -> stringResource(R.string.infant)
                },
                style = MaterialTheme.typography.titleMedium,
                color = primaryDark
            )
            Text(
                text = when (guestType) {
                    GuestType.ADULT -> stringResource(R.string.age_13)
                    GuestType.CHILDREN -> stringResource(R.string.ages_2_12)
                    GuestType.INFANT -> stringResource(R.string.under_2)
                },
                style = MaterialTheme.typography.bodyMedium,
                color = primaryDark
            )
        }
        AddMinusButtons(
            guestState = guestState, guestType = guestType,
            onAddClick = { value, guestType ->
                onAdd(guestType, value)
            },
            onMinusClick = { value, guestType ->
                onMinus(guestType, value)
            },
            property = property
        )
    }
}

@Composable
fun AddMinusButtons(
    modifier: Modifier = Modifier,
    onAddClick: (value: Int, guestType: GuestType) -> Unit = { _, _ -> },
    onMinusClick: (value: Int, guestType: GuestType) -> Unit = { _, _ -> },
    guestState: GuestState,
    guestType: GuestType,
    property: Property
) {
    Row(
        modifier = modifier, verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
    ) {
        IconButton(
            onClick = {
                onMinusClick(
                    1, guestType
                )
            },
            enabled = when (guestType) {
                GuestType.ADULT -> {
                    guestState.adults > 0
                }

                GuestType.CHILDREN -> {
                    guestState.children > 0
                }

                GuestType.INFANT -> {
                    guestState.infant > 0
                }
            },
        ) {
            Icon(
                painter = painterResource(id = R.drawable.minus), contentDescription = "Minus Icon",
                modifier = Modifier.size(DpDimensions.Dp20),
                tint = when (guestType) {
                    GuestType.ADULT -> {
                        if (guestState.adults <= 0) {
                            MaterialTheme.colorScheme.secondary
                        } else primaryDark
                    }

                    GuestType.CHILDREN -> {
                        if (guestState.children <= 0) {
                            MaterialTheme.colorScheme.secondary
                        } else primaryDark
                    }

                    GuestType.INFANT -> {
                        if (guestState.infant <= 0) {
                            MaterialTheme.colorScheme.secondary
                        } else primaryDark
                    }
                }
            )
        }
        Text(
            text = (when (guestType) {
                GuestType.ADULT -> guestState.adults
                GuestType.CHILDREN -> guestState.children
                GuestType.INFANT -> guestState.infant
            }).toString(),
            style = MaterialTheme.typography.bodyMedium,
            color = primaryDark
        )
        IconButton(
            onClick = {
                onAddClick(1, guestType)
            },
            enabled = when (guestType) {
                GuestType.ADULT -> property.accommodates > (guestState.adults)
                GuestType.CHILDREN -> guestState.children < 10
                GuestType.INFANT -> guestState.infant < 10
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.add),
                contentDescription = "Add Icon",
                modifier = Modifier.size(DpDimensions.Dp20)
            )
        }
    }
}


@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerBottomSheet(
    modifier: Modifier = Modifier,
    onSelectDates: (checkInDate: Long, checkOutDate: Long) -> Unit = { _, _ -> },
    cornerRadius: Dp = DpDimensions.Dp20,
    bottomSheetState: SheetState,
    property: Property,
    onDismiss: () -> Unit,
) {
    val dateRangerState = rememberDateRangePickerState(
        initialSelectedStartDateMillis = null,
        initialSelectedEndDateMillis = null,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return !property.booked_dates.contains(utcTimeMillis.formatTimeToSmallDate()) &&
                        utcTimeMillis > System.currentTimeMillis()
            }
        }
    )
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        shape = RoundedCornerShape(topStart = cornerRadius, topEnd = cornerRadius),
        sheetState = bottomSheetState,
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(start = DpDimensions.Normal, end = DpDimensions.Normal)
                .fillMaxWidth(),
        ) {
            DateRangePicker(
                state = dateRangerState,
                modifier = Modifier.weight(1f),
                colors = DatePickerDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.background,
                    weekdayContentColor = MyOrange,
                    dayContentColor = MyTextField1,
                    selectedDayContainerColor = MyOrange,
                    todayContentColor = primaryDark,
                    selectedDayContentColor = Color.White,
                    todayDateBorderColor = MyOrange
                )
            )
            CustomPadding(verticalPadding = 0.dp, horizontalPadding = DpDimensions.Normal) {
                PrimaryButton(
                    label = "Confirm Selection", disabledColor = DisabledColor,
                    isEnabled = dateRangerState.selectedStartDateMillis != null &&
                            dateRangerState.selectedEndDateMillis != null,
                    onClick = {
                        onSelectDates(
                            dateRangerState.selectedStartDateMillis!!,
                            dateRangerState.selectedEndDateMillis!!
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(DpDimensions.Dp30))
            }
        }
    }
}


@Composable
fun DateSelector(
    modifier: Modifier = Modifier,
    title: String,
    placeholder: String,
    onClick: () -> Unit = {}
) {

    Column(modifier = modifier) {

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            color = primaryDark
        )

        Spacer(modifier = Modifier.height(DpDimensions.Normal))

        DateSelector(
            placeholder = placeholder,
            modifier = Modifier.fillMaxWidth(),
            onClick = onClick
        )

    }
}


@Composable
fun DateSelector(
    modifier: Modifier = Modifier,
    placeholder: String,
    onClick: () -> Unit = {}
) {

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surface,
        onClick = onClick,
        shape = RoundedCornerShape(DpDimensions.Small)
    ) {
        Row(modifier = Modifier.padding(DpDimensions.Normal)) {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodyMedium,
                color = primaryDark,
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.calendar),
                contentDescription = null,
                modifier = Modifier.size(DpDimensions.Dp20),
                tint = primaryDark
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarSection(
    modifier: Modifier = Modifier,
    property: Property,
    onDatesSelected: (Pair<Long, Long>) -> Unit = {},
    datePickerState: DateRangePickerState
) {

    Column(
        modifier = modifier
            .padding(DpDimensions.Normal)
            .fillMaxWidth()
    ) {

        Text(
            text = stringResource(R.string.location),
            style = MaterialTheme.typography.headlineMedium,
            color = primaryDark
        )
        Spacer(modifier = Modifier.height(DpDimensions.Normal))
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ListingItem(
    modifier: Modifier = Modifier,
    listing: Property,
    onClick: (Property) -> Unit = {}
) {

    Surface(
        modifier = modifier,
        onClick = { onClick(listing) },
        color = MaterialTheme.colorScheme.onSurface,
        shape = RoundedCornerShape(DpDimensions.Small),
        border = BorderStroke(width = 1.dp, color = MaterialTheme.colorScheme.surface)
    ) {

        Row(
            modifier = Modifier
                .padding(DpDimensions.Small)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {

            Box {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(listing.photos[0])
                        .placeholder(R.drawable.placeholder)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(RoundedCornerShape(DpDimensions.Small))
                        .height(120.dp)
                        .width(120.dp)
                )
            }

            Spacer(modifier = Modifier.height(DpDimensions.Normal))

            CustomPadding(
                verticalPadding = DpDimensions.Small,
                horizontalPadding = DpDimensions.Small,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = listing.name,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.basicMarquee(),
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(DpDimensions.Small))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.pin), contentDescription = null,
                        modifier = Modifier.size(DpDimensions.Normal),
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )
                    Text(
                        text = listing.smart_location,
                        color = MaterialTheme.colorScheme.inversePrimary,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(DpDimensions.Small))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(
                            R.string.currency,
                            listing.price.toFloat()
                        ),
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        text = "/night",
                        color = MaterialTheme.colorScheme.inversePrimary,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

val property = Property(
    access = "Great location, one block from the subway.",
    accommodates = 2,
    amenities = listOf(
        "TV",
        "Cable TV",
        "Internet",
        "Wireless Internet",
        "Air conditioning",
        "Kitchen",
        "Elevator in building",
        "Buzzer/wireless intercom",
        "Heating",
        "Essentials",
        "Hangers",
        "Hair dryer",
        "Iron",
        "translation missing: en.hosting_amenity_49",
        "translation missing: en.hosting_amenity_50"
    ),
    bathrooms = 1,
    bed_type = "Real Bed",
    bedrooms = 1,
    beds = 1,
    booked_dates = listOf(
        "01/05/2024",
        "01/12/2024",
        "01/20/2024",
        "02/02/2024",
        "02/10/2024",
        "02/18/2024",
        "03/05/2024",
        "03/12/2024",
        "03/20/2024",
        "04/02/2024"
    ),
    calculated_host_listings_count = 1,
    calendar_updated = "2 weeks ago",
    cancellation_policy = "flexible",
    city = "New York",
    cleaning_fee = 0, // You can assign an appropriate value for cleaning_fee
    country = "United States",
    country_code = "US",
    description = "An artistic, sunny and beautiful apartment with a one million dollar view.Cozy and modern interiors, it comfortably fits two. Perfect location just one block from the subway, supermarket, restaurants and everything you need.Enjoy the best atmosphere! A full one bedroom apartment with a million dólar view, artistic, sunny, cozy and beautifúl. Great location, one block from the subway. Astoria is a priceless neighborhood. Great étnic food and full of life, so close to Manhattan. The N and Q subway is one block from the apartment. The place is ideal for people who love to be in an artistic atmosphere.",
    experiences_offered = "none",
    extra_people = 65,
    first_review = "2015-05-09",
//    geolocation = Geolocation(
//        lon = -73.92223052287211,
//        lat = 40.76958098677077
//    ),
    guests_included = 1,
    host_about = "null", // You can assign an appropriate value for host_about
    host_acceptance_rate = "null",
    host_id = "25744379",
    host_listings_count = 1,
    host_location = "US",
    host_name = "Sonia",
    host_neighbourhood = "Astoria",
    host_picture_url = "https://a0.muscache.com/im/users/25744379/profile_pic/1422080280/original.jpg?aki_policy=profile_x_medium",
    host_response_rate = 100,
    host_response_time = "within a few hours",
    host_since = "2015-01-07",
    host_thumbnail_url = "https://a0.muscache.com/im/users/25744379/profile_pic/1422080280/original.jpg?aki_policy=profile_small",
    host_total_listings_count = 1,
    host_verifications = listOf("email", "phone", "reviews"),
    house_rules = "I'm glad with decent and clean people, no pets allowed.",
    id = "4993422",
    interaction = "", // You can assign an appropriate value for interaction
    last_review = "2016-07-11",
    latitude = "40.76958098677077",
    longitude = "-73.92223052287211",
    market = "New York",
    maximum_nights = 1125,
    minimum_nights = 1,
    monthly_price = 123,
    name = "A Beautiful and Sunny Artist's Home",
    neighborhood_overview = "Astoria is a priceless neighborhood. Great étnic food and full of life, so close to Manhattan.",
    neighbourhood = "Astoria",
    neighbourhood_cleansed = "Astoria",
    neighbourhood_group_cleansed = "Queens",
    notes = "The place is ideal for people who love to be in an artistic atmosphere.",
    number_of_reviews = 11,
    photos = listOf(
        "https://storage.googleapis.com/leizen-frontend.appspot.com/hotel/40989163b42dffb7cc69389fbe304ac5?GoogleAccessId=firebase-adminsdk-pe7p9%40leizen-frontend.iam.gserviceaccount.com&Expires=16749763200&Signature=V4%2BRhN1tIM3hioaHn%2B1uHKrT84pZwCUeSg%2BUPzCWBsDLOQGtIOz%2FeH6hWmReEbxSbYyEgu%2FJ8ezMnw3FftIvB2qNePXi%2BZSRogdB%2FYg4M%2BynXXLYPVuRPWH0LejutLNT%2Bb8Nc1QX7LC1CMyASWdQ8zDTCrktzGc5s9%2F5WZCvAJpz8boAFErXVTXJK2Y1gewpVEUSYB1Mbf95brRsijV7p0OwaOiv4JhjnMtCXCk1mv0Jg9DGGAzFNtUWFarV4wLVuUUP%2BO1hK4BisCr2Q7js%2FTj%2B011r%2BP9PDTqehyVdygTSy6JriAVAzn8qPB10y1RmQlyei05kJkiTSUUGmXxlsg%3D%3D",
        "https://storage.googleapis.com/leizen-frontend.appspot.com/hotel/d14e913296c6a8156a13d87c34da92e1?GoogleAccessId=firebase-adminsdk-pe7p9%40leizen-frontend.iam.gserviceaccount.com&Expires=16749763200&Signature=VsEX74YfL83a5o5eIgnRz7nExh5jZOuwLTPkqtfcTANenwLuNqvklMQsBGdP9cX92FwlN3MdUVWMHmMD1MBxzccRXayrp68v9UEOzoLpQxklaQYLww5CQ%2Fi%2B0tZ%2FS3j6CWouUiilvSc0GAbWaiotrieHgzsIEBTdkkrbWzjcP5tvo8RMc7a%2BRQMYFOF5emRMNSgPPuzEwP2y2FTHRcA57DKxVjx1KqvGCuJZpDFhLuHrRapG%2BGkoxmj9hpfghKH4g4P9OI1yzg3ErTO3QrXUoTRLhCtcD3Pi%2FJ2rzyp7rvEJ2XfSf7JzL0RVMgNXmRRqr8F6NcuXPbkN2ZSuqpylDg%3D%3D",
        "https://storage.googleapis.com/leizen-frontend.appspot.com/hotel/525b4e36bec7293c23fefe19b81ea8a9?GoogleAccessId=firebase-adminsdk-pe7p9%40leizen-frontend.iam.gserviceaccount.com&Expires=16749763200&Signature=eFdYniR7JyKq9hiRKIaFARE%2FJIQNLO4ZYAfoh1viiNFmiHbiUr09r33px2elrKYq9xncRYcRMTIlzOvapnlt1Z0Md%2FKUo%2BX47w5lkPSirHA63F0cVH3HuoMKVFL7NLZwS%2Fe7uZMzyqMfiwrlsxzyTo5i59W9L12g7V4fYz%2F%2FqRAGMbj5PdZR8RtU%2FWfHW9hPMiJCtHIlt810xBEUR9W%2F0vMdOPHtFau4urnfsAiASRNBkk6ZcW9JrcqmO1a3YLMAASNVEa%2FhZ7zzVtd9JLS0PdKjIFk7%2FCKDRZrz0zHlGzFebvRrRnzYevJ9v5OAIcYq8vhMgFsNL4UNgzkfQFcZvA%3D%3D",
        "https://storage.googleapis.com/leizen-frontend.appspot.com/hotel/36295e82bc7c21691fc6c1a69dbe3a13?GoogleAccessId=firebase-adminsdk-pe7p9%40leizen-frontend.iam.gserviceaccount.com&Expires=16749763200&Signature=DWAeTNHj5s92W16uvo57Pab8JJA1tsmqpI0tV3R03NgwoGQ1BFPBxY00pNYAhZpq2HYapf%2B8VqnKRb8LBQhrgI5uRK1sfXY8mOrS9Hrwvwx27JILqvzJNYPGpNZARHYtvCD9ZPbeJh5NP%2FEKZDTLI5gfPwPzDz%2FDXTOu35i0PjonqqQhEqkiva8OcJ1tgxZC1dDkpp6uJfOjOi6laV%2F5zKHut5cp%2FfKpwrmRQfZvhxwbr8CxgeQohprhF20Oko9VQ1Aiv1K3LHy8%2B4M%2FrYZnBi6uyIWUPA%2B9suFN2%2B2F1hDtTuQaJAHtT7%2Fwj5ygYR6DXclQaj4A8scpyC%2FxYLi3Mg%3D%3D",
        "https://storage.googleapis.com/leizen-frontend.appspot.com/hotel/a90e77c93611ca4fd5507810d28f3577?GoogleAccessId=firebase-adminsdk-pe7p9%40leizen-frontend.iam.gserviceaccount.com&Expires=16749763200&Signature=MHq5QvrwDcOwYLwrX3yZzxJL7uTwd%2B6jpCdPe7VN7eNgGObI0%2BXXCxpNO0rbBmUYwTelOqDbUjGYcGP471ktEHrdNzWAJKPikWjDDdHIZe4srvpGNH9wE%2BHB5kuc5TjBR%2FUNlHuTxmPUgrq%2BzDwrZh%2FrSH2gJCf6A3FdQBQ4d0gDuxkyx0qmo13in5tbsRhTi4SS3aC7fSWcZbwzHG0oJGZGc0RtYePjSLVHBrKL094CrH1ThZWXmtlgXR%2BumlUo5oDAIoC5KzOR8vuP7rzlCaUMpg2cmeau1wGcIyXt3%2FW5OSKQQtCH9%2FcTZPc9gNhe4U92Ghged1GVvJilBWYiJw%3D%3D",
        "https://storage.googleapis.com/leizen-frontend.appspot.com/hotel/cad0faa5d6ca2b2b0a85d0df43ab26bd?GoogleAccessId=firebase-adminsdk-pe7p9%40leizen-frontend.iam.gserviceaccount.com&Expires=16749763200&Signature=vJ0O5aMK7%2BrZ6MMg21Fv4NYDYP6teKNLmjNqK3YXzeTnedg%2B%2FieoEd8a6UQq09I5yFmpD%2FGWdUTfM%2F7RBV6gtQUHAGioiWW7kRXXcjWGIjVjpnuL6GE4C5utZU5tj87AdAFzsNj7UvX9ZUB0%2BUyffJnY6oisUuX7kem%2Fc9x%2BxpQP919ylwEbFsaPq58TpLihq3vISbvuxIhR%2FHjFDFntI4kUebeCPNlg%2BcWRhuj1tPZd1OOR8VhHIbz4DsEh982F013aOeHXKdMkRvNwX973UFmNuClXcTwTytxLupVx7xDvFkgDrjwqxhBpiNq1LCZbrB%2B2PkofBHD1QsMJxQM%2BfA%3D%3D"
    ),
    price = 135,
    property_type = "Apartment",
    review_scores_accuracy = 9,
    review_scores_checkin = 10,
    review_scores_cleanliness = 9,
    review_scores_communication = 9,
    review_scores_location = 9,
    review_scores_rating = 92,
    review_scores_value = 9,
    reviews_per_month = 0.45,
    room_type = "Entire home/apt",
    security_deposit = 0,  // You may need to provide the security deposit value
    smart_location = "New York, NY",
    space = "A full one-bedroom apartment with a million-dollar view, artistic, sunny, cozy, and beautiful.",
    state = "NY",
    street = "Astoria, New York, NY 11102, United States",
    summary = "An artistic, sunny and beautiful apartment with a one million dollar view. Cozy and modern interiors, it comfortably fits two. Perfect location just one block from the subway, supermarket, restaurants and everything you need. Enjoy the best atmosphere!",
    transit = "The N and Q subway is one block from the apartment.",
    weekly_price = 800,
    zipcode = "11102"
)

data class Property(
    val access: String?,
    val accommodates: Int,
    val amenities: List<String>?,
    val bathrooms: Int,
    val bed_type: String,
    val bedrooms: Int,
    val beds: Int,
    val booked_dates: List<String>,
    val calculated_host_listings_count: Int,
    val calendar_updated: String?,
    val cancellation_policy: String,
    val city: String,
    val cleaning_fee: Int?,
    val country: String,
    val country_code: String,
    val description: String,
    val experiences_offered: String,
    val extra_people: Int,
    val first_review: String?,
//    val geolocation: Geolocation,
    val guests_included: Int,
    val host_about: String?,
    val host_acceptance_rate: Any?,
    val host_id: String,
    val host_listings_count: Int,
    val host_location: String,
    val host_name: String,
    val host_neighbourhood: String?,
    val host_picture_url: String,
    val host_response_rate: Int?,
    val host_response_time: String?,
    val host_since: String,
    val host_thumbnail_url: String,
    val host_total_listings_count: Int,
    val host_verifications: List<String>,
    val house_rules: String?,
    val id: String,
    val interaction: String?,
    val last_review: String?,
    val latitude: String,
    val longitude: String,
    val market: String,
    val maximum_nights: Int,
    val minimum_nights: Int,
    val monthly_price: Int?,
    val name: String,
    val neighborhood_overview: String?,
    val neighbourhood: String?,
    val neighbourhood_cleansed: String,
    val neighbourhood_group_cleansed: String,
    val notes: String?,
    val number_of_reviews: Int,
    val photos: List<String>,
    val price: Int,
    val property_type: String,
    val review_scores_accuracy: Int?,
    val review_scores_checkin: Int?,
    val review_scores_cleanliness: Int?,
    val review_scores_communication: Int?,
    val review_scores_location: Int?,
    val review_scores_rating: Int?,
    val review_scores_value: Int?,
    val reviews_per_month: Double?,
    val room_type: String,
    val security_deposit: Int?,
    val smart_location: String,
    val space: String?,
    val state: String,
    val street: String,
    val summary: String?,
    val transit: String?,
    val weekly_price: Int?,
    val zipcode: String?
)
enum class DateType {
    CHECK_IN,
    CHECK_OUT
}

enum class GuestType {
    ADULT,
    CHILDREN,
    INFANT
}

data class GuestState(
    var adults: Int = 1,
    var children: Int = 0,
    var infant: Int = 0
)

object DpDimensions {

    val Dp20 = 20.dp
    val Dp50 = 50.dp
    val Dp40 = 40.dp
    val Dp100 = 100.dp
    val Dp150 = 150.dp
    val Dp130 = 130.dp
    val Dp30 = 30.dp
    val Normal = 16.dp
    val Small = 10.dp
    val Smallest = 5.dp
    val Dp24 = 24.dp
}

@Composable
fun CustomPadding(
    verticalPadding: Dp,
    horizontalPadding: Dp,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {}
) {
    Column(
        modifier = modifier.padding(
            horizontal = horizontalPadding,
            vertical = verticalPadding
        )
    ) {
        content()
    }
}

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit = {},
    isEnabled: Boolean = true,
    disabledColor: Color,
    height: Dp = DpDimensions.Dp50
) {

    Button(
        onClick = { onClick() },
        modifier = modifier.height(height),
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = disabledColor,
            containerColor = MyOrange
        )
    ) {
        Text(
            text = label,
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@SuppressLint("SimpleDateFormat")
fun Long.formatTimeToSmallDate(): String {
    val date = Date(this)
    val format = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
    return format.format(date)
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Pair<Long, Long>.getTotalDays(): Long {
    val millisDifference = first - second
    val daysDifference = TimeUnit.MILLISECONDS.toDays(millisDifference)
    return abs(daysDifference)
}

enum class Event {
    ADD,
    SUBTRACT
}