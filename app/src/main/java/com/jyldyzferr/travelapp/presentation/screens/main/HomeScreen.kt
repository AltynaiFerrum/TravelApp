//package com.jyldyzferr.travelapp.presentation.screens.main
//
//import androidx.annotation.DrawableRes
//import androidx.annotation.StringRes
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.animation.core.tween
//import androidx.compose.foundation.ExperimentalFoundationApi
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxHeight
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.statusBarsPadding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.lazy.grid.rememberLazyGridState
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.ModalBottomSheetValue
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.KeyboardArrowRight
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material.icons.filled.Settings
//import androidx.compose.material.rememberModalBottomSheetState
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ElevatedCard
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.SmallTopAppBar
//import androidx.compose.material3.Tab
//import androidx.compose.material3.TabRow
//import androidx.compose.material3.Text
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.material3.TopAppBarScrollBehavior
//import androidx.compose.material3.rememberBottomSheetScaffoldState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.graphicsLayer
//import androidx.compose.ui.input.nestedscroll.nestedScroll
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.dimensionResource
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextOverflow
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import coil.compose.rememberAsyncImagePainter
//import com.google.accompanist.pager.ExperimentalPagerApi
//import com.google.accompanist.pager.calculateCurrentOffsetForPage
//import com.jyldyzferr.travelapp.R
//import com.jyldyzferr.travelapp.presentation.components.SpacerHeight
//import com.jyldyzferr.travelapp.presentation.components.TabBarr
//import com.jyldyzferr.travelapp.presentation.models.Tour
//import com.jyldyzferr.travelapp.presentation.screens.common.ErrorMainScreen
//import com.jyldyzferr.travelapp.presentation.screens.common.LoadingMainScreen
//import com.jyldyzferr.travelapp.presentation.screens.utils.Utils
//import com.jyldyzferr.travelapp.presentation.theme.GILROY
//import com.jyldyzferr.travelapp.presentation.theme.MyOrange
//import com.jyldyzferr.travelapp.presentation.theme.Purple40
//import kotlinx.coroutines.launch
//import java.util.UUID
//import kotlin.math.absoluteValue
//
//
//@Composable
//fun MainScreen(
//    uiState: MainUiState,
//    navigateToDetails: (String) -> Unit,
//    navigateToSeeAllScreen: () -> Unit,
//    navigateToSearchScreen: () -> Unit,
//    modifier: Modifier = Modifier,
//) {
//    when (uiState) {
//        is MainUiState.Initial -> Unit
//        is MainUiState.Loading -> LoadingMainScreen()
//        is MainUiState.Error -> ErrorMainScreen(
////            message = uiState.message,
////            onClick = { }
//        )
//
//        is MainUiState.Content -> LoadedTourScreen(
//            navigateToDetailScreen = navigateToDetails,
//            tours = uiState.tour,
//            navigateToSearchScreen = navigateToSearchScreen,
//            )
////        HomeScreen(
////            navigateToDetailScreen = navigateToDetails,
////            navigateToSearchScreen = navigateToSearchScreen,
////            uiState = uiState
////        )
//
////        is MainUiState.Content -> LoadedMainScreen(
////            uiState = uiState,
////            modifier = modifier,
////            navigateToDetails = navigateToDetails,
////            navigateToSearchScreen = navigateToSearchScreen,
////            navigateToSeeAllScreen = navigateToSeeAllScreen,
////        )
//                is MainUiState.Content -> TODO()
//
//        is MainUiState.Error -> TODO()
//        MainUiState.Initial -> TODO()
//        MainUiState.Loading -> TODO()
//    }
//}
//
//@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
//@Composable
//fun LoadedMainScreen(
//    uiState: MainUiState.Content,
//    navigateToDetails: (String) -> Unit,
//    navigateToSeeAllScreen: () -> Unit,
//    navigateToSearchScreen: () -> Unit,
//    modifier: Modifier = Modifier,
//) {
////    val scrollState = rememberScrollState()
//
//    val scaffoldState = rememberBottomSheetScaffoldState()
//
//    var darkTheme by remember { mutableStateOf(false) }
//
//    val coroutineScope = rememberCoroutineScope()
//    var showBottomSheet by remember { mutableStateOf(false) }
//    val sheetState = rememberModalBottomSheetState(
//        initialValue = ModalBottomSheetValue.Hidden,
//        confirmStateChange = {
//            it != ModalBottomSheetValue.HalfExpanded
//        }
//    )
//    Scaffold(
//        modifier = modifier,
//        topBar = {
//            TabBarr(title = stringResource(id = R.string.app_name))
//        }
//    ) { innerPaddings ->
//        Column(
//            modifier = Modifier
//                .padding(innerPaddings)
//                .fillMaxSize()
////                .verticalScroll(state = scrollState)
//                .background(MaterialTheme.colorScheme.background)
//        ) {
//            Row(
//                modifier = Modifier
//                    .padding(start = 14.dp)
//                    .padding(20.dp)
//            ) {
//                Spacer(modifier = Modifier.height(10.dp))
//                Text(
//                    text = "Hi User!",
//                    fontSize = 26.sp,
//                    fontFamily = GILROY,
//                    color = MaterialTheme.colorScheme.onBackground,
//                    fontWeight = FontWeight.Bold,
//                    style = MaterialTheme.typography.titleMedium,
//                )
//                Spacer(modifier = Modifier.width(150.dp))
//                Icon(
//                    modifier = Modifier
//                        .size(34.dp)
//                        .clickable { navigateToSearchScreen() },
//                    imageVector = Icons.Filled.Search,
//                    tint = MaterialTheme.colorScheme.onBackground,
//                    contentDescription = "Search",
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Icon(
//                    modifier = Modifier
//                        .size(34.dp),
//                    tint = MaterialTheme.colorScheme.onBackground,
//                    imageVector = Icons.Filled.Settings,
//                    contentDescription = "Search",
//                )
//            }
//            SpacerHeight(30.dp)
//            Spacer(modifier = Modifier.height(10.dp))
//            Row(
//                modifier = Modifier
//                    .padding(start = 14.dp)
//                    .padding(20.dp),
//            ) {
//                Text(
//                    text = "Recommended",
//                    fontSize = 26.sp,
//                    fontFamily = GILROY,
//                    color = MaterialTheme.colorScheme.onBackground,
//                    fontWeight = FontWeight.Bold,
//                    style = MaterialTheme.typography.titleMedium,
//                )
//                Spacer(modifier = Modifier.width(80.dp))
//                Text(
//                    modifier = Modifier
//                        .clickable { navigateToSeeAllScreen() },
//                    text = "See All",
//                    fontSize = 20.sp,
//                    fontFamily = GILROY,
//                    color = MyOrange,
//                    style = MaterialTheme.typography.titleMedium,
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Icon(
//                    modifier = Modifier
//                        .size(32.dp),
//                    tint = MaterialTheme.colorScheme.onBackground,
//                    imageVector = Icons.Filled.KeyboardArrowRight,
//                    contentDescription = null,
//                )
//            }
//            Spacer(modifier = Modifier.height(10.dp))
////            Column(
////                modifier = Modifier
////                    .fillMaxWidth()
////            ) {
////                LazyRow(
////                    modifier = Modifier,
////                    horizontalArrangement = Arrangement.spacedBy(12.dp),
////                    contentPadding = PaddingValues(horizontal = 12.dp)
////                ) {
////                    items(
////                        items = uiState.tour,
////                        key = { data -> data.objectId })
////                    { event ->
////                        androidx.compose.material.Card(
////                            modifier = Modifier
////                                .height(300.dp)
////                                .width(220.dp)
////                                .padding(10.dp)
////                                .background(MaterialTheme.colorScheme.background),
////                            backgroundColor = MaterialTheme.colorScheme.background,
////                            shape = RoundedCornerShape(16.dp),
////                            elevation = (10.dp),
////                        ) {
////                            Column(
////                                modifier = Modifier
////                                    .background(MaterialTheme.colorScheme.background)
////                            ) {
////                                Image(
////                                    modifier = Modifier
////                                        .fillMaxWidth()
////                                        .height(140.dp)
////                                        .clickable { navigateToDetails(event.objectId) },
////                                    painter = rememberAsyncImagePainter(model = event.image),
////                                    contentDescription = null,
////                                    contentScale = ContentScale.Crop,
////                                )
////                                Text(
////                                    text = event.title,
////                                    fontFamily = GILROY,
////                                    fontWeight = FontWeight.Bold,
////                                    color = MaterialTheme.colorScheme.onBackground,
////                                    fontSize = 20.sp,
////                                    modifier = Modifier
////                                        .padding(start = 5.dp)
////                                )
////                                Text(
////                                    text = event.description,
////                                    fontSize = 18.sp,
////                                    modifier = Modifier
////                                        .padding(start = 5.dp),
////                                    maxLines = 5,
////                                    letterSpacing = 1.sp,
////                                    fontFamily = GILROY,
////                                    overflow = TextOverflow.Ellipsis,
////                                    color = MaterialTheme.colorScheme.onBackground,
////                                )
////                            }
////                        }
////                    }
////                }
////                SpacerHeight(100.dp)
////                Row(
////                    modifier = Modifier
////                        .fillMaxWidth()
////                        .padding(horizontal = 16.dp, vertical = 8.dp),
////                    horizontalArrangement = Arrangement.SpaceBetween
////                ) {
////                    Column {
////                        Text(text = "Good Luck on your Trip", fontWeight = FontWeight.Bold)
////                        Text(text = "title", color = Color.DarkGray)
////                    }
////                    Button(
////                        onClick = { /*TODO*/ },
////                        elevation = null,
////                        colors = ButtonDefaults.buttonColors(
////                            backgroundColor = Color.Transparent, contentColor = Purple40
////                        )
////                    ) {
////                        Row(verticalAlignment = Alignment.CenterVertically) {
////                            Text("See all")
////                            androidx.compose.material.Icon(
////                                painter = painterResource(id = R.drawable.icon_travel_svg),
////                                contentDescription = null
////                            )
////                        }
////                    }
////                }
////            }
//        }
//    }
//}
//
//
//data class Plant(
//    val plantId: String,
//    val name: String,
//    val description: String,
//    val growZoneNumber: Int,
//    val wateringInterval: Int = 7, // how often the plant should be watered, in days
//    val imageUrl: String = ""
//)
//
//
//enum class SunflowerPage(
//    @StringRes val titleResId: Int,
//    @DrawableRes val drawableResId: Int
//) {
//    MY_GARDEN(R.string.kg, R.drawable.save_icon),
//    PLANT_LIST(R.string.abroad, R.drawable.save_icon)
//}
//
//@OptIn(
//    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
//    ExperimentalPagerApi::class
//)
//@Composable
//fun HomeScreen(
//    modifier: Modifier = Modifier,
//    uiState: MainUiState.Content,
//    navigateToDetailScreen: (String) -> Unit,
//    navigateToSearchScreen: () -> Unit,
//    onPlantClick: (Tour) -> Unit = {},
//) {
////    val pagerState = com.google.accompanist.pager.rememberPagerState()
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
//    Scaffold(
//        modifier = modifier
//            .nestedScroll(scrollBehavior.nestedScrollConnection),
//        topBar = {
//            HomeTopAppBar(
//                scrollBehavior = scrollBehavior,
//                navigateToSearchScreen = navigateToSearchScreen
////                modifier.padding(top = 5.dp)
//            )
//        }
//    ) {
//        HomePagerScreen(
//            onPlantClick = onPlantClick,
//            modifier = Modifier.padding(it),
//            navigateToDetailScreen = navigateToDetailScreen,
//            uiState = uiState
//        )
//    }
//}
//
//@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
//@Composable
//fun HomePagerScreen(
//    onPlantClick: (Tour) -> Unit,
//    uiState: MainUiState.Content,
//    navigateToDetailScreen: (String) -> Unit,
//    modifier: Modifier = Modifier,
//    pages: Array<SunflowerPage> = SunflowerPage.values()
//) {
//    // Use Modifier.nestedScroll + rememberNestedScrollInteropConnection() here so that this
//    // composable participates in the nested scroll hierarchy so that HomeScreen can be used in
//    // use cases like a collapsing toolbar
//    Column(modifier) {
//        val coroutineScope = rememberCoroutineScope()
//        val pagerState = com.google.accompanist.pager.rememberPagerState()
//        // Tab Row
//        TabRow(
//            selectedTabIndex = pagerState.currentPage
//        ) {
//            pages.forEachIndexed { index, page ->
//                val title = stringResource(id = page.titleResId)
//                Tab(
//                    selected = pagerState.currentPage == index,
//                    onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
//                    text = { Text(text = title) },
//                    icon = {
//                        Icon(
//                            painter = painterResource(id = page.drawableResId),
//                            contentDescription = title
//                        )
//                    },
//                    unselectedContentColor = MaterialTheme.colorScheme.secondary
//                )
//            }
//        }
//
//        // Pages
//        com.google.accompanist.pager.HorizontalPager(
//            modifier = Modifier.background(MaterialTheme.colorScheme.background),
//            count = pages.size,
//            state = pagerState,
//            verticalAlignment = Alignment.Top
//        ) { page ->
//            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
//            when (pages[page]) {
//                SunflowerPage.MY_GARDEN -> {
//                    LoadedTourScreen(
//                        tours = uiState.tour,
//                        pageOffset = pageOffset,
//                        navigateToDetailScreen = navigateToDetailScreen
//                    )
////                    PlantList(
////                        modifier = Modifier.fillMaxSize(),
////                        pageOffset = pageOffset,
////                        gardenPlants = uiState.tour,
////                        navigateToDetailScreen = navigateToDetailScreen
//////                        PlantAndGardenPlantings.plantt()
////                    )
//                }
//
//                SunflowerPage.PLANT_LIST -> {
//                    GardenList(
//                        modifier = Modifier.fillMaxSize(),
//                        pageOffset = pageOffset,
//                        gardenPlants = uiState.tour
////                        PlantAndGardenPlantings.plantt()
//                    )
//                }
//            }
//        }
//    }
//}
//
//
//@Composable
//fun GardenList(
//    gardenPlants: List<Tour>,
//    pageOffset: Float,
//    modifier: Modifier = Modifier,
//) {
//    val gridState = rememberLazyGridState()
//
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(1),
//        modifier,
//        state = gridState,
//        contentPadding = PaddingValues(
//            horizontal = dimensionResource(id = R.dimen.card_side_margin),
//            vertical = dimensionResource(id = R.dimen.margin_normal)
//        )
//    ) {
//        items(
//            items = gardenPlants,
//            key = { it.image }
//        ) {
//            MyGarden(plant = it, pageOffset = pageOffset)
//        }
//    }
//}
//
//@Composable
//fun PlantList(
//    gardenPlants: List<Tour>,
//    pageOffset: Float,
//    navigateToDetailScreen: (String) -> Unit,
//    modifier: Modifier = Modifier,
//) {
//    val gridState = rememberLazyGridState()
//
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(2),
//        modifier,
//        state = gridState,
//        contentPadding = PaddingValues(
//            horizontal = dimensionResource(id = R.dimen.card_side_margin),
//            vertical = dimensionResource(id = R.dimen.margin_normal)
//        )
//    ) {
//        items(
//            items = gardenPlants,
//            key = { it.image }
//        ) {
//            GardenListItem(plant = it,
//                navigateToDetailScreen = {
//                    navigateToDetailScreen(String())
//                }
////                onPlantClick = {}
//            )
////            MyPlant(pageOffset = pageOffset)
//        }
//    }
//}
//
//
//@OptIn(
//    ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class,
//    ExperimentalPagerApi::class
//)
//@Composable
//fun HomeTopAppBar(
//    scrollBehavior: TopAppBarScrollBehavior,
//    navigateToSearchScreen: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    val pagerState = com.google.accompanist.pager.rememberPagerState()
//
//    SmallTopAppBar(
//        title = {
//            Row(
//                Modifier
//                    .fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center,
//            ) {
//                Text(
//                    text = stringResource(id = R.string.app_name),
////                        style = MaterialTheme.typography.titleMedium,
//                    fontFamily = GILROY,
//                    fontWeight = FontWeight.Bold,
//                    style = MaterialTheme.typography.displaySmall
//                )
//                Spacer(modifier = Modifier.width(20.dp))
//                Icon(
//                    modifier = Modifier
//                        .size(40.dp)
//                        .clickable { navigateToSearchScreen() },
//                    imageVector = Icons.Filled.Search,
//                    tint = MaterialTheme.colorScheme.onBackground,
//                    contentDescription = "Search",
//                )
//
//            }
//        },
//        modifier = modifier
//            .padding(10.dp)
//            .statusBarsPadding(),
//        actions = {
//            if (pagerState.currentPage == SunflowerPage.PLANT_LIST.ordinal) {
//                Icon(
//                    painter = painterResource(id = R.drawable.onclick_heart),
//                    contentDescription = stringResource(
//                        id = R.string.app_name
//                    )
//                )
//            }
//        },
//        scrollBehavior = scrollBehavior
//    )
//}
//
//
//@Composable
//fun MyGarden(
//    plant: Tour,
//    modifier: Modifier = Modifier,
//    pageOffset: Float,
//) {
//    val scale = Utils.lerp(
//        start = 0.5f,
//        stop = 1f,
//        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//    )
//    val angle = Utils.lerp(
//        start = 30f,
//        stop = 0f,
//        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//    )
//    val scaleXBox = Utils.lerp(
//        start = 0.9f,
//        stop = 1f,
//        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//    )
//    val scaleYBox = Utils.lerp(
//        start = 0.7f,
//        stop = 1f,
//        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//    )
//    val rotateY = Utils.lerp(
//        start = 10f,
//        stop = 0f,
//        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//    )
//    val boxAngle: Float by animateFloatAsState(
//        targetValue = rotateY,
//
//        animationSpec = tween(durationMillis = 600, easing = Utils.EaseOutQuart)
//    )
//    val boxScaleX: Float by animateFloatAsState(
//        targetValue = scaleXBox,
//
//        animationSpec = tween(durationMillis = 800, easing = Utils.EaseOutQuart)
//    )
//    val boxScaleY: Float by animateFloatAsState(
//        targetValue = scaleYBox,
//
//        animationSpec = tween(durationMillis = 800, easing = Utils.EaseOutQuart)
//    )
//    val imageAngle: Float by animateFloatAsState(
//        targetValue = angle,
//
//        animationSpec = tween(durationMillis = 600, easing = Utils.EaseOutQuart)
//    )
//    val visibility = Utils.lerp(
//        start = 0f,
//        stop = 1f,
//        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//    )
//    Box(modifier = Modifier.clickable {
////        viewModel.screenState.value = HomeViewModel.UiState.Details(shoe)
//    }) {
//        Box(
//            modifier = Modifier
//                .graphicsLayer {
//                    Utils
//                        .lerp(
//                            start = 0.90f,
//                            stop = 1f,
//                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                        )
//                        .also {
//                            scaleX = boxScaleX
//                            scaleY = boxScaleY
//                            rotationY = boxAngle
//                        }
//                }
//                .fillMaxWidth()
//                .fillMaxHeight()
//                .padding(end = 16.dp, top = 16.dp)
//        ) {
//            Image(
//                painter = rememberAsyncImagePainter(model = plant.image),
////                painter = painterResource(id = R.drawable.lake_k),
//                contentDescription = null,
//                modifier = Modifier
////                    .width(142.dp)
////                    .height(142.dp)
//                    .shadow(20.dp, shape = RoundedCornerShape(30.dp), true)
//
//            )
//        }
//    }
//}
////}
//
//@Composable
//fun MyPlant(
//    plant: PlantAndGardenPlantings,
//    modifier: Modifier = Modifier,
//    pageOffset: Float,
//) {
//    val scale = Utils.lerp(
//        start = 0.5f,
//        stop = 1f,
//        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//    )
//    val angle = Utils.lerp(
//        start = 30f,
//        stop = 0f,
//        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//    )
//    val scaleXBox = Utils.lerp(
//        start = 0.9f,
//        stop = 1f,
//        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//    )
//    val scaleYBox = Utils.lerp(
//        start = 0.7f,
//        stop = 1f,
//        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//    )
//    val rotateY = Utils.lerp(
//        start = 10f,
//        stop = 0f,
//        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//    )
//    val boxAngle: Float by animateFloatAsState(
//        targetValue = rotateY,
//
//        animationSpec = tween(durationMillis = 600, easing = Utils.EaseOutQuart)
//    )
//    val boxScaleX: Float by animateFloatAsState(
//        targetValue = scaleXBox,
//
//        animationSpec = tween(durationMillis = 800, easing = Utils.EaseOutQuart)
//    )
//    val boxScaleY: Float by animateFloatAsState(
//        targetValue = scaleYBox,
//
//        animationSpec = tween(durationMillis = 800, easing = Utils.EaseOutQuart)
//    )
//    val imageAngle: Float by animateFloatAsState(
//        targetValue = angle,
//
//        animationSpec = tween(durationMillis = 600, easing = Utils.EaseOutQuart)
//    )
//    val visibility = Utils.lerp(
//        start = 0f,
//        stop = 1f,
//        fraction = 1f - pageOffset.coerceIn(0f, 1f)
//    )
//    Box(modifier = Modifier.clickable {
////        viewModel.screenState.value = HomeViewModel.UiState.Details(shoe)
//    }) {
//        Box(
//            modifier = Modifier
//                .graphicsLayer {
//                    Utils
//                        .lerp(
//                            start = 0.90f,
//                            stop = 1f,
//                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
//                        )
//                        .also {
//                            scaleX = boxScaleX
//                            scaleY = boxScaleY
//                            rotationY = boxAngle
//                        }
//                }
//                .fillMaxWidth()
//                .fillMaxHeight()
////                .height(350.dp)
////                .width(300.dp)
////                .background(color = shoe.color.copy(alpha = .8f), RoundedCornerShape(20.dp))
//                .padding(end = 16.dp, top = 16.dp)
//        ) {
////            Card(
////                modifier = Modifier
////                    .fillMaxWidth()
////                    .padding(16.dp),
////                shape = RoundedCornerShape(16.dp)
////            ) {
//
//            Image(
//                painter = rememberAsyncImagePainter(model = plant.imageUrl),
////                painter = painterResource(id = R.drawable.third_image_id),
//                contentDescription = null,
//                modifier = Modifier
////                    .width(142.dp)
////                    .height(142.dp)
//                    .shadow(20.dp, shape = RoundedCornerShape(30.dp), true)
//
//            )
//
////            ItemMyGarden(
//////                movie = movie
////            )
//        }
//    }
//}
////}
//
//
//@Composable
//fun ItemMyGarden(
//
//) {
//    Column(modifier = Modifier.clickable {
//    }) {
//        Row(modifier = Modifier.padding(12.dp)) {
//            Image(
//                painter = painterResource(id = R.drawable.lake_k),
//                contentDescription = null,
//                modifier = Modifier
////                    .width(142.dp)
////                    .height(142.dp)
//                    .shadow(20.dp, shape = RoundedCornerShape(30.dp), true)
//
//            )
////            Column {
////                androidx.compose.material.Text(
////                    text = "name",
////                    style = TextStyle(
////                        fontWeight = FontWeight.Bold,
////                        fontSize = 18.sp
////                    )
////                )
////
////                androidx.compose.material.Text(
////                    text = "author",
////                    style = TextStyle(
////                        fontWeight = FontWeight.Light,
////                        fontSize = 12.sp
////                    )
////                )
////            }
//        }
//    }
//}
//
//data class PlantAndGardenPlantings(
//    val id: String,
//    val title: String,
//    val imageUrl: String
//) {
//    companion object {
//
//        fun plantt() = listOf(
//            PlantAndGardenPlantings(
//                id = UUID.randomUUID().toString(),
//                title = "Electronics",
//                imageUrl = "https://images.unsplash.com/photo-1588508065123-287b28e013da?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1287&q=80"
//            ),
//            PlantAndGardenPlantings(
//                id = UUID.randomUUID().toString(),
//                title = "Musics",
//                imageUrl = "https://images.unsplash.com/photo-1460036521480-ff49c08c2781?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1173&q=80",
//            ),
//            PlantAndGardenPlantings(
//                id = UUID.randomUUID().toString(),
//                title = "Fashion",
//                imageUrl = "https://images.unsplash.com/photo-1492707892479-7bc8d5a4ee93?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=765&q=80"
//            ),
//            PlantAndGardenPlantings(
//                id = UUID.randomUUID().toString(),
//                title = "Digital service",
//                imageUrl = "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1172&q=80",
//            ),
//            PlantAndGardenPlantings(
//                id = UUID.randomUUID().toString(),
//                title = "Fashion",
//                imageUrl = "https://images.unsplash.com/photo-1509631179647-0177331693ae?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1288&q=80",
//            ),
//            PlantAndGardenPlantings(
//                id = UUID.randomUUID().toString(),
//                title = "Digital service",
//                imageUrl = "https://images.unsplash.com/photo-1504270997636-07ddfbd48945?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1171&q=80",
//            ),
//        )
//    }
//}
//
//@OptIn(
//    ExperimentalMaterial3Api::class
//)
//@Composable
//fun GardenListItem(
//    plant: Tour,
//    navigateToDetailScreen: (String) -> Unit,
////    onPlantClick: (Tour) -> Unit
//) {
//    // Dimensions
//    val cardSideMargin = dimensionResource(id = R.dimen.card_side_margin)
//    val marginNormal = dimensionResource(id = R.dimen.margin_normal)
//
//    ElevatedCard(
//        onClick = { navigateToDetailScreen(String()) },
//        modifier = Modifier.padding(
//            start = cardSideMargin,
//            end = cardSideMargin,
//            bottom = dimensionResource(id = R.dimen.card_bottom_margin)
//        ),
//        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
//    ) {
//        Column(Modifier.fillMaxWidth()) {
////            TourPosterImage(posterPath = plant.image)
//            Image(
//                painter = rememberAsyncImagePainter(model = plant.image),
//                contentDescription = null,
//                Modifier
//                    .fillMaxWidth()
//                    .height(dimensionResource(id = R.dimen.plant_item_image_height)),
//                contentScale = ContentScale.Crop,
//            )
//
//            // Plant name
//            Text(
//                text = plant.title,
//                Modifier
//                    .padding(vertical = marginNormal)
//                    .align(Alignment.CenterHorizontally),
//                style = MaterialTheme.typography.titleMedium,
//            )
//
//            // Planted date
////            Text(
////                text = stringResource(id = R.string.plant_date_header),
////                Modifier.align(Alignment.CenterHorizontally),
////                style = MaterialTheme.typography.titleSmall
////            )
////            Text(
////                text = "plantDateString",
////                Modifier.align(Alignment.CenterHorizontally),
////                style = MaterialTheme.typography.labelSmall
////            )
//
//            // Last Watered
////            Text(
////                text = stringResource(id = R.string.plant_date_header),
////                Modifier
////                    .align(Alignment.CenterHorizontally)
////                    .padding(top = marginNormal),
////                style = MaterialTheme.typography.titleSmall
////            )
//            Text(
//                text = plant.description,
//                Modifier
//                    .padding(10.dp)
//                    .align(Alignment.CenterHorizontally),
//                style = MaterialTheme.typography.labelSmall,
//                maxLines = 4,
//            )
////            Text(
////                text = pluralStringResource(
////                    id = R.plurals.watering_next,
////                    count = 2,
////                ),
////                Modifier
////                    .align(Alignment.CenterHorizontally)
////                    .padding(bottom = marginNormal),
////                style = MaterialTheme.typography.labelSmall
////            )
//        }
//    }
//}
//
//
//
