package com.jyldyzferr.travelapp.presentation.screens.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.models.Tour
import com.jyldyzferr.travelapp.presentation.screens.utils.Utils
import com.jyldyzferr.travelapp.presentation.screens.utils.shimmerEffect
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.MyBlue5
import com.jyldyzferr.travelapp.presentation.theme.MySignIn
import kotlinx.coroutines.launch
import java.util.UUID
import kotlin.math.absoluteValue


enum class LoadingPage(
    @StringRes val titleResId: Int,
    @DrawableRes val drawableResId: Int
) {
    TOURS(R.string.kg, R.drawable.save_icon),
    ABROAD(R.string.abroad, R.drawable.save_icon)
}

data class LoadingData(
    val id: String,
    val title: String,
    val imageUrl: String
) {
    companion object {

        fun plantt() = listOf(
            LoadingData(
                id = UUID.randomUUID().toString(),
                title = "Electronics",
                imageUrl = "https://images.unsplash.com/photo-1588508065123-287b28e013da?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1287&q=80"
            ),
            LoadingData(
                id = UUID.randomUUID().toString(),
                title = "Musics",
                imageUrl = "https://images.unsplash.com/photo-1460036521480-ff49c08c2781?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1173&q=80",
            ),
            LoadingData(
                id = UUID.randomUUID().toString(),
                title = "Fashion",
                imageUrl = "https://images.unsplash.com/photo-1492707892479-7bc8d5a4ee93?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=765&q=80"
            ),
            LoadingData(
                id = UUID.randomUUID().toString(),
                title = "Digital service",
                imageUrl = "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1172&q=80",
            ),
            LoadingData(
                id = UUID.randomUUID().toString(),
                title = "Fashion",
                imageUrl = "https://images.unsplash.com/photo-1509631179647-0177331693ae?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1288&q=80",
            ),
            LoadingData(
                id = UUID.randomUUID().toString(),
                title = "Digital service",
                imageUrl = "https://images.unsplash.com/photo-1504270997636-07ddfbd48945?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1171&q=80",
            ),
        )
    }
}

@Composable
fun LoadingScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = modifier
                .background(MaterialTheme.colorScheme.background),
        )
    }
}

@Composable
fun LoadingMainScreen(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HomeBoxLoadingSecond(
            tours = LoadingData.plantt()
        )
    }
}

@Composable
fun HomeBoxLoadingSecond(
    modifier: Modifier = Modifier,
    tours: List<LoadingData>,
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding(),
            horizontalArrangement = Arrangement.Center,
        ) {
//            Icon(
//                modifier = Modifier
//                    .size(38.dp)
//                    .clickable { },
//                imageVector = Icons.Default.KeyboardArrowLeft,
//                contentDescription = null,
//                tint = MaterialTheme.colorScheme.onBackground
//            )
            Spacer(modifier = Modifier.width(10.dp))
            androidx.compose.material.Text(
                modifier = Modifier,
//                style = MaterialTheme.typography.titleMedium,
//                fontWeight = FontWeight.Bold,
                text = "Travel App",
                fontFamily = GILROY,
                color = MaterialTheme.colorScheme.onBackground,
                style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.ExtraBold),
            )
            Spacer(modifier = Modifier.width(20.dp))
            androidx.compose.material3.Icon(
                modifier = Modifier
                    .size(40.dp)
                    .clickable { },
                imageVector = Icons.Filled.Search,
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = "Search",
            )
        }
        LazyColumn(
            modifier = Modifier
//                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.background)
        ) {
            items(
                items = tours,
                key = { it.imageUrl }
            ) { tours ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .background(MaterialTheme.colorScheme.background)
                    ,
                    shape = RoundedCornerShape(16.dp),
                ) {
                BookDetailsLoading()
            }
        }
    }
}
}


@Composable
fun BookDetailsLoading(
) {
    var showBookDescription by remember { mutableStateOf(false) }
    val bookCoverImageSize by animateDpAsState(
        targetValue =
        if (showBookDescription) 50.dp else 80.dp
    )
    Column(modifier = Modifier
         .clickable {
        showBookDescription = showBookDescription.not()
    }) {
        Column(modifier = Modifier
            .alpha(0.5f)
            .shimmerEffect()
//            .padding(12.dp)
        ) {
            AsyncImage(
//                painter = painterResource(id = R.drawable.lake_k),
//                model = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
//                    .padding(16.dp)
                    .shadow(
                        20.dp,
                        shape = RoundedCornerShape(16.dp), true
                    )
                    .aspectRatio(.6f),
                model = ImageRequest.Builder(context = LocalContext.current)
//                        .data(book.volumeInfo.imageLinks?.thumbnail)
                    .crossfade(true)
                    .build(),
                error = painterResource(id = R.drawable.loading_img),
                placeholder = painterResource(id = R.drawable.loading_img),
                contentScale = ContentScale.FillBounds

            )
            androidx.compose.material.Text(
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, bottom = 16.dp),
                text = "Tour name",
                color = MaterialTheme.colorScheme.onBackground,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
        }
//            Spacer(modifier = Modifier.width(100.dp))
//            Button(
//                onClick = { navigateToDetailScreen(id) },
//                modifier = Modifier
//                    .width(150.dp)
//                    .height(50.dp),
//                shape = RoundedCornerShape(15.dp),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = MySignIn
//                )
//            ) {
//                androidx.compose.material3.Text(
//                    text = "Show more",
//                    fontFamily = GILROY,
//                    fontWeight = FontWeight.Bold,
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier
//                )
//            }
        }
    }
//    AnimatedVisibility(visible = showBookDescription) {
//        Column {
//            androidx.compose.material.Text(
//                text = stringResource(id = R.string.desc_details),
//                maxLines = 5,
//                style = TextStyle(
//                    fontWeight = FontWeight.SemiBold,
//                    fontStyle = FontStyle.Italic
//                ),
//                color = MaterialTheme.colorScheme.onBackground,
//                modifier = Modifier
//                    .background(MaterialTheme.colorScheme.background)
//                    .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
//            )
//            Spacer(modifier = Modifier.height(20.dp))
//            Button(
//                onClick = { },
//                modifier = Modifier
//                    .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
//                    .width(150.dp)
//                    .height(50.dp),
//                shape = RoundedCornerShape(15.dp),
//                colors = ButtonDefaults.buttonColors(
//                    containerColor = if (isSystemInDarkTheme()) MySignIn
//                    else MyBlue5
//                )
//            ) {
//                Text(
//                    text = "Show more",
//                    fontFamily = GILROY,
//                    color = MaterialTheme.colorScheme.onBackground,
//                    fontWeight = FontWeight.Bold,
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier
//                )
//            }
//
//        }
//    }
//}




























@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeBoxLoading(
    modifier: Modifier = Modifier,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            HomeTopAppBarLoading(
                scrollBehavior = scrollBehavior
            )
        }
    ) {
        HomePagerScreen(
            modifier = Modifier.padding(it)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun HomeTopAppBarLoading(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier
) {
    val pagerState = com.google.accompanist.pager.rememberPagerState()

    TopAppBar(
        title = {
            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
//                        style = MaterialTheme.typography.titleMedium,
                    fontFamily = GILROY,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.displaySmall
                )
                Spacer(modifier = Modifier.width(20.dp))
                Icon(
                    modifier = Modifier
                        .size(44.dp)
                        .clickable {},
                    imageVector = Icons.Filled.Search,
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = "Search",
                )
            }
        },
        modifier = modifier
            .padding(10.dp)
            .statusBarsPadding(),
        actions = {
            if (pagerState.currentPage == ErrorPage.TOURS.ordinal) {
                Icon(
                    painter = painterResource(id = R.drawable.onclick_heart),
                    contentDescription = stringResource(
                        id = R.string.app_name
                    ),
                    tint = Color.Transparent
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePagerScreen(
    modifier: Modifier = Modifier,
    pages: Array<LoadingPage> = LoadingPage.values()
) {
    // Use Modifier.nestedScroll + rememberNestedScrollInteropConnection() here so that this
    // composable participates in the nested scroll hierarchy so that HomeScreen can be used in
    // use cases like a collapsing toolbar
    Column(modifier) {
        val coroutineScope = rememberCoroutineScope()
        val pagerState = rememberPagerState()


        // Tab Row
        TabRow(
            selectedTabIndex = pagerState.currentPage
        ) {
            pages.forEachIndexed { index, page ->
                val title = stringResource(id = page.titleResId)
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
                    text = {
                        Text(
                            text = title,
                            fontFamily = GILROY
                        )
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = page.drawableResId),
                            contentDescription = title
                        )
                    },
                    unselectedContentColor = MaterialTheme.colorScheme.secondary
                )
            }
        }

        // Pages
        HorizontalPager(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            count = pages.size,
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { page ->
            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
            when (pages[page]) {
                LoadingPage.TOURS -> {
                    PlantListLoading(
                        modifier = Modifier.fillMaxSize(),
                        pageOffset = pageOffset,
                        gardenPlants = LoadingData.plantt()
                    )
                }

                LoadingPage.ABROAD -> {
                    GardenListLoading(
                        modifier = Modifier.fillMaxSize(),
                        pageOffset = pageOffset,
                        gardenPlants = LoadingData.plantt()
                    )
                }
            }
        }
    }
}

@Composable
fun PlantListLoading(
    gardenPlants: List<LoadingData>,
    pageOffset: Float,
    modifier: Modifier = Modifier,
) {
    val gridState = rememberLazyGridState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier,
        state = gridState,
        contentPadding = PaddingValues(
            horizontal = dimensionResource(id = R.dimen.card_side_margin),
            vertical = dimensionResource(id = R.dimen.margin_normal)
        )
    ) {
        items(
            items = gardenPlants,
            key = { it.imageUrl }
        ) {
            GardenListItemLoading(plant = it, onPlantClick = {})
//            MyPlant(pageOffset = pageOffset)
        }
    }
}

@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
fun GardenListItemLoading(
    plant: LoadingData,
    onPlantClick: (LoadingData) -> Unit,
    modifier: Modifier = Modifier,
) {
    // Dimensions
    val cardSideMargin = dimensionResource(id = R.dimen.card_side_margin)
    val marginNormal = dimensionResource(id = R.dimen.margin_normal)
    Box(
        modifier
            .fillMaxSize()
    ) {
        ElevatedCard(
            onClick = { onPlantClick(plant) },
            modifier = Modifier
//            .shimmerEffect()
                .padding(
                    start = cardSideMargin,
                    end = cardSideMargin,
                    bottom = dimensionResource(id = R.dimen.card_bottom_margin)
                ),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
        ) {
            Column(
                Modifier
                    .alpha(0.5f)
                    .shimmerEffect()
//                    .fillMaxWidth()
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.plant_item_image_height))
                        .aspectRatio(.6f),
                    model = ImageRequest.Builder(context = LocalContext.current)
//                        .data(book.volumeInfo.imageLinks?.thumbnail)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    error = painterResource(id = R.drawable.loading_img),
                    placeholder = painterResource(id = R.drawable.loading_img),
                    contentScale = ContentScale.FillBounds
                )
//                Image(
//                    painter = rememberAsyncImagePainter(model = plant.imageUrl),
//                    contentDescription = null,
//                    Modifier
//                        .fillMaxWidth()
//                        .height(dimensionResource(id = R.dimen.plant_item_image_height)),
//                    contentScale = ContentScale.Crop,
//                )

                // Plant name
                Text(
                    text = "Tour Name",
                    Modifier
                        .padding(vertical = marginNormal)
                        .align(Alignment.CenterHorizontally),
                    fontFamily = GILROY,
                    style = MaterialTheme.typography.titleMedium,
                )

//                Text(
//                    text = stringResource(id = R.string.plant_date_header),
//                    Modifier.align(Alignment.CenterHorizontally),
//                    style = MaterialTheme.typography.titleSmall
//                )
//                Text(
//                    text = "plantDateString",
//                    Modifier.align(Alignment.CenterHorizontally),
//                    style = MaterialTheme.typography.labelSmall
//                )

                // Last Watered
                Text(
                    text = stringResource(id = R.string.desc_details),
                    Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(10.dp),
                    fontFamily = GILROY,
                    maxLines = 3,
                    style = MaterialTheme.typography.titleSmall
                )
//                Text(
//                    text = "waterDateString",
//                    Modifier.align(Alignment.CenterHorizontally),
//                    style = MaterialTheme.typography.labelSmall
//                )
//                Text(
//                    text = pluralStringResource(
//                        id = R.plurals.watering_next,
//                        count = 2,
//                    ),
//                    Modifier
//                        .align(Alignment.CenterHorizontally)
//                        .padding(bottom = marginNormal),
//                    style = MaterialTheme.typography.labelSmall
//                )
            }
        }
    }
}


@Composable
fun GardenListLoading(
    gardenPlants: List<LoadingData>,
    pageOffset: Float,
    modifier: Modifier = Modifier,
) {
    val gridState = rememberLazyGridState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier,
        state = gridState,
        contentPadding = PaddingValues(
            horizontal = dimensionResource(id = R.dimen.card_side_margin),
            vertical = dimensionResource(id = R.dimen.margin_normal)
        )
    ) {
        items(
            items = gardenPlants,
            key = { it.imageUrl }
        ) {
            MyGardenLoading(pageOffset = pageOffset)
        }
    }
}

@Composable
fun MyGardenLoading(
    modifier: Modifier = Modifier,
    pageOffset: Float,
) {
    val scale = Utils.lerp(
        start = 0.5f,
        stop = 1f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    val angle = Utils.lerp(
        start = 30f,
        stop = 0f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    val scaleXBox = Utils.lerp(
        start = 0.9f,
        stop = 1f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    val scaleYBox = Utils.lerp(
        start = 0.7f,
        stop = 1f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    val rotateY = Utils.lerp(
        start = 10f,
        stop = 0f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    val boxAngle: Float by animateFloatAsState(
        targetValue = rotateY,

        animationSpec = tween(durationMillis = 600, easing = Utils.EaseOutQuart)
    )
    val boxScaleX: Float by animateFloatAsState(
        targetValue = scaleXBox,

        animationSpec = tween(durationMillis = 800, easing = Utils.EaseOutQuart)
    )
    val boxScaleY: Float by animateFloatAsState(
        targetValue = scaleYBox,

        animationSpec = tween(durationMillis = 800, easing = Utils.EaseOutQuart)
    )
    val imageAngle: Float by animateFloatAsState(
        targetValue = angle,

        animationSpec = tween(durationMillis = 600, easing = Utils.EaseOutQuart)
    )
    val visibility = Utils.lerp(
        start = 0f,
        stop = 1f,
        fraction = 1f - pageOffset.coerceIn(0f, 1f)
    )
    Box(modifier = Modifier
        .clickable {
//        viewModel.screenState.value = HomeViewModel.UiState.Details(shoe)
        }) {
        Box(
            modifier = Modifier
                .graphicsLayer {
                    Utils
                        .lerp(
                            start = 0.90f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                        .also {
                            scaleX = boxScaleX
                            scaleY = boxScaleY
                            rotationY = boxAngle
                        }
                }
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(end = 16.dp, top = 16.dp)
        ) {
            Box(
                modifier = modifier
//                    .alpha(0.9f)
//                    .shimmerEffect()
//                    .fillMaxWidth()
//                    .clip(RoundedCornerShape(30.dp))
            ) {
                AsyncImage(
                    modifier = Modifier
                        .aspectRatio(.6f),
                    model = ImageRequest.Builder(context = LocalContext.current)
//                        .data(book.volumeInfo.imageLinks?.thumbnail)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    error = painterResource(id = R.drawable.loading_img),
                    placeholder = painterResource(id = R.drawable.loading_img),
                    contentScale = ContentScale.FillBounds
                )
//                Image(
//                    painter = rememberAsyncImagePainter(model = plant.imageUrl),
//                    contentDescription = null,
//                    modifier = Modifier
////                    .width(142.dp)
////                    .height(142.dp)
//                        .shadow(20.dp,
//                            shape = RoundedCornerShape(30.dp), true)
//
//                )
            }
        }
    }
}
//}

