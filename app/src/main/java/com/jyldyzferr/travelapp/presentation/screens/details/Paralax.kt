package com.jyldyzferr.travelapp.presentation.screens.details


import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarHalf
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.insets.LocalWindowInsets
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.models.Tour
import com.jyldyzferr.travelapp.presentation.screens.common.ErrorScreen
import com.jyldyzferr.travelapp.presentation.screens.common.LoadingScreen
import com.jyldyzferr.travelapp.presentation.theme.AppBarCollapsedHeight
import com.jyldyzferr.travelapp.presentation.theme.AppBarExpendedHeight
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.MyBlue5
import com.jyldyzferr.travelapp.presentation.theme.MySignIn
import com.jyldyzferr.travelapp.presentation.theme.MyWhite
import com.jyldyzferr.travelapp.presentation.theme.POPPINS
import com.jyldyzferr.travelapp.presentation.theme.Purple40
import kotlinx.coroutines.flow.StateFlow
import kotlin.math.max
import kotlin.math.min


@Composable
fun DetailsAboutTourScreen(
    popBackStack: () -> Unit,
    navigateToInfoScreen: () -> Unit,
    uiStateFlow: StateFlow<DetailsUiState>,
    fetchTour: () -> Unit,
    addOrDeleteMovie: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberLazyListState()
    LaunchedEffect(key1 = Unit) {
        fetchTour()
    }
    when (val uiState = uiStateFlow.collectAsStateWithLifecycle().value) {
        is DetailsUiState.Initial -> Unit
        is DetailsUiState.Loading -> LoadingScreen()
        is DetailsUiState.Error -> ErrorScreen(
            message = uiState.message,
            onClick = { }
        )

        is DetailsUiState.Content -> ContentDetailsScreen(
            contentType = uiState.tour,
            popBackStack = popBackStack,
            addOrDeleteMovie = { addOrDeleteMovie() },
            isSaved = uiState.isSaved,
            scrollState = scrollState,
            modifier = modifier,
            navigateToInfoScreen = navigateToInfoScreen,
        )
    }
}


@Composable
fun ContentDetailsScreen(
    contentType: Tour,
    popBackStack: () -> Unit,
    addOrDeleteMovie: () -> Unit,
    navigateToInfoScreen: () -> Unit,
    isSaved: Boolean,
    scrollState: LazyListState,
    modifier: Modifier = Modifier
) {
    Box {
        Column {
            when (contentType) {
                is Tour -> LoadedDetailsScreen(
                    popBackStack = popBackStack,
                    tour = contentType,
                    addOrDeleteMovie = { addOrDeleteMovie() },
                    isSaved = isSaved,
                    scrollState = scrollState,
                    navigateToInfoScreen = navigateToInfoScreen,
                )
            }
        }
    }
}


@Composable
fun LoadedDetailsScreen(
    popBackStack: () -> Unit,
    navigateToInfoScreen: () -> Unit,
    tour: Tour,
    addOrDeleteMovie: () -> Unit,
    isSaved: Boolean,
    scrollState: LazyListState,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberLazyListState()
    Box {
        LazyColumn(
            contentPadding = PaddingValues(
                top = AppBarExpendedHeight
            ),
            state = scrollState
        ) {
            item {
                BasicInfoDetails(tripEvent = tour)
                DescriptionDetails(text = tour.description)
                BookingButton(
                    navigateToInfoScreen = navigateToInfoScreen
                )
                DetailImages(tour)
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
        ParallaxToolbar(
            tour,
            scrollState = scrollState,
            popBackStack = popBackStack,
            addOrDeleteMovie = {
                addOrDeleteMovie()
            },
            isSaved = isSaved,
            image = tour.image,
        )
    }
}


@Composable
fun InfoColumn(
    location: String,
    text: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = location,
            maxLines = 1,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun BasicInfoDetails(
    tripEvent: Tour,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ) {
        InfoColumn(
            location = tripEvent.location,
            "Location"
        )
        RatingBar(
            tripEvent = tripEvent,
            text = "Rating"
        )
        InfoColumn(
            location = tripEvent.price,
            "Price"
        )
    }
}

@Composable
fun RatingBar(
    text: String,
    tripEvent: Tour
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LazyRow(
            Modifier
                .background(Color.Transparent)
                .width(145.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            items(count = tripEvent.rating) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    contentDescription = null,
                    tint = Color.Yellow
                )
            }
        }
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )
    }
}


@Composable
fun DescriptionDetails(
    text: String
) {
    Text(
        text = text,
        fontWeight = FontWeight.Medium,
        fontFamily = POPPINS,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
    )
}

@Composable
fun BookingButton(
    navigateToInfoScreen: () -> Unit
) {
    Button(
        onClick = { navigateToInfoScreen() },
        elevation = null,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (isSystemInDarkTheme()) MySignIn
            else MyBlue5,
        ), modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Book a trip",
            color = MaterialTheme.colorScheme.onBackground,
            fontFamily = GILROY,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
    }
}


@Composable
fun DetailImages(
    tour: Tour,
) {
    Row(
        Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            model = tour.image,
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(modifier = Modifier.weight(0.1f))
        AsyncImage(
            model = tour.image,
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}

@Composable
fun Reviews(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = "Good Luck on your Trip", fontWeight = FontWeight.Bold)
        }
        Button(
            onClick = { /*TODO*/ }, elevation = null, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent, contentColor = Purple40
            )
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("See all")
                Icon(
                    painter = painterResource(id = R.drawable.icon_travel_svg),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun ParallaxToolbar(
    tour: Tour,
    image: String,
    popBackStack: () -> Unit,
    addOrDeleteMovie: () -> Unit,
    isSaved: Boolean,
    scrollState: LazyListState
) {
    val imageHeight = AppBarExpendedHeight - AppBarCollapsedHeight

    val maxOffset =
        with(LocalDensity.current) { imageHeight.roundToPx() } - LocalWindowInsets.current.systemBars.layoutInsets.top

    val offset = min(scrollState.firstVisibleItemScrollOffset, maxOffset)

    val offsetProgress = max(0f, offset * 3f - 2f * maxOffset) / maxOffset
    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = MyWhite,
        modifier = Modifier
            .height(
                AppBarExpendedHeight
            )
            .offset { IntOffset(x = 0, y = -offset) },
        elevation = if (offset == maxOffset) 4.dp else 0.dp
    ) {
        Column {
            Box(
                Modifier
                    .height(imageHeight)
                    .graphicsLayer {
                        alpha = 1f - offsetProgress
                    }) {
                AsyncImage(
                    model = image,
                    modifier = Modifier
                        .fillMaxSize()
                        .height(imageHeight)
//                        .clip(RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp))
                        .graphicsLayer {
                            alpha = 1f - offsetProgress
                        },
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    Pair(0.4f, Color.Transparent),
                                    Pair(1f, Color.White)
                                )
                            )
                        )
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(AppBarCollapsedHeight),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    tour.title,
                    fontSize = 26.sp,
                    fontFamily = GILROY,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(horizontal = (16 + 28 * offsetProgress).dp)
                        .scale(1f - 0.25f * offsetProgress)
                )

            }
        }
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(AppBarCollapsedHeight)
            .padding(horizontal = 16.dp)
    ) {
        CircularDetailsBackButtons(
            popBackStack = popBackStack
        )
        CircularDetailsFavoriteButton(
            addOrDeleteMovie = {
                addOrDeleteMovie()
            },
            isSaved = isSaved
        )
    }
}


@Composable
fun CircularDetailsBackButtons(
    popBackStack: () -> Unit,
) {
    IconButton(
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape)
            .background(Color.Transparent.copy(alpha = 0.25f)),
        onClick = { popBackStack() }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_chevron_left_24),
            tint = Color.White,
            contentDescription = null
        )
    }
}


@Composable
fun CircularDetailsFavoriteButton(
    addOrDeleteMovie: () -> Unit,
    isSaved: Boolean,
) {
    IconButton(
        modifier = Modifier
            .size(24.dp)
            .clip(CircleShape)
            .background(Color.Transparent.copy(alpha = 0.25f)),
        onClick = {
            addOrDeleteMovie()
        }
    ) {
        Icon(
            painter = painterResource(id = if (isSaved) R.drawable.save_icon else R.drawable.not_saved_icon),
            tint = if (isSystemInDarkTheme()) Color.Black
            else Color.White,
            contentDescription = null
        )
    }
}


