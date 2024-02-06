package com.jyldyzferr.travelapp.presentation.screens.common

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.components.SpacerHeight
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.LargeSpacing
import kotlinx.coroutines.launch
import java.util.UUID
import kotlin.math.absoluteValue

enum class ErrorPage(
    @StringRes val titleResId: Int,
    @DrawableRes val drawableResId: Int
) {
    TOURS(R.string.kg, R.drawable.save_icon),
    ABROAD(R.string.abroad, R.drawable.save_icon)
}

data class ErrorData (
    val id: String,
    val title: String,
    val imageUrl: String
) {
    companion object {

        fun plantt() = listOf(
            ErrorData(
                id = UUID.randomUUID().toString(),
                title = "Electronics",
                imageUrl = "https://images.unsplash.com/photo-1588508065123-287b28e013da?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1287&q=80"
            ),
            ErrorData(
                id = UUID.randomUUID().toString(),
                title = "Musics",
                imageUrl = "https://images.unsplash.com/photo-1460036521480-ff49c08c2781?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1173&q=80",
            ),
            ErrorData(
                id = UUID.randomUUID().toString(),
                title = "Fashion",
                imageUrl = "https://images.unsplash.com/photo-1492707892479-7bc8d5a4ee93?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=765&q=80"
            ),
            ErrorData(
                id = UUID.randomUUID().toString(),
                title = "Digital service",
                imageUrl = "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1172&q=80",
            ),
            ErrorData(
                id = UUID.randomUUID().toString(),
                title = "Fashion",
                imageUrl = "https://images.unsplash.com/photo-1509631179647-0177331693ae?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1288&q=80",
            ),
            ErrorData(
                id = UUID.randomUUID().toString(),
                title = "Digital service",
                imageUrl = "https://images.unsplash.com/photo-1504270997636-07ddfbd48945?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1171&q=80",
            ),
        )
    }
}

@Composable
fun ErrorScreen(
    message:String,
    onClick:() -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
            SpacerHeight(LargeSpacing)
            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth(0.7f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text(
                    text = stringResource(id = R.string.refresh),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

@Composable
fun ErrorMainScreen(
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        HomeBoxError()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeBoxError(
    modifier: Modifier = Modifier,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            HomeTopAppBarError(
                scrollBehavior = scrollBehavior
            )
        }
    ) {
        HomePagerScreenError(
            modifier = Modifier.padding(it)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPagerApi::class)
@Composable
fun HomeTopAppBarError(
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
                    )
                )
            }
        },
        scrollBehavior = scrollBehavior
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomePagerScreenError(
    modifier: Modifier = Modifier,
    pages: Array<ErrorPage> = ErrorPage.values()
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
                    text = { Text(text = title) },
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
                ErrorPage.TOURS -> {
                    PlantListError(
                        modifier = Modifier.fillMaxSize(),
                        pageOffset = pageOffset,
                        gardenPlants = ErrorData.plantt()
                    )
                }

                ErrorPage.ABROAD -> {
                    GardenListError(
                        modifier = Modifier.fillMaxSize(),
                        pageOffset = pageOffset,
                        gardenPlants = ErrorData.plantt()
                    )
                }
            }
        }
    }
}

@Composable
fun PlantListError(
    gardenPlants: List<ErrorData>,
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
            ErrorMovieCard()
//            GardenListItemLoading(plant = it, onPlantClick = {})
//            MyPlant(pageOffset = pageOffset)
        }
    }
}

@Composable
fun GardenListError(
    gardenPlants: List<ErrorData>,
    pageOffset: Float,
    modifier: Modifier = Modifier,
) {
    val gridState = rememberLazyGridState()

    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier
        ,
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
            ErrorMovieCard()
//            MyGardenLoading(pageOffset = pageOffset)
        }
    }
}
@Composable
fun ErrorMovieCard(modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.plant_item_image_height))
//            .height(230.dp).width(170.dp)
    ) {
        Box(modifier = modifier.fillMaxSize()) {
            Box(
                modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.surface)
            )
            ErrorMessage(
                iconSize = 50.dp,
                textSize = 18.sp,
                errorColor = MaterialTheme.colorScheme.background,
                alpha = 1f
            )
        }
    }
}

@Composable
fun ErrorMessage(
    modifier: Modifier = Modifier,
    message: String = stringResource(R.string.loading_error_text),
    iconSize: Dp,
    textSize: TextUnit,
    errorColor: Color,
    alpha: Float
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .alpha(alpha)
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = stringResource(R.string.loading_error_content_description),
            tint = errorColor,
            modifier = modifier
                .size(iconSize)
        )
        Text(
            message,
            style = MaterialTheme.typography.bodyMedium.copy(
                color = errorColor,
                textAlign = TextAlign.Center,
                fontSize = textSize
            ),
            modifier = modifier.padding(top = 10.dp, start = 20.dp, end = 20.dp)
        )
    }
}