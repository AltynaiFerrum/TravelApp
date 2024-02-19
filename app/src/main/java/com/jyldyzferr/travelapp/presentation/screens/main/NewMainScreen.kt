package com.jyldyzferr.travelapp.presentation.screens.main


import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import com.google.accompanist.pager.rememberPagerState
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.models.Tour
import com.jyldyzferr.travelapp.presentation.screens.utils.Utils
import com.jyldyzferr.travelapp.presentation.theme.BlackColor500
import com.jyldyzferr.travelapp.presentation.theme.GreyColor300
import com.jyldyzferr.travelapp.presentation.theme.MySignIn
import com.jyldyzferr.travelapp.presentation.theme.POPPINS
import com.jyldyzferr.travelapp.presentation.theme.WhiteColor
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.absoluteValue


//class NewMainScreen {
//}


enum class ButtonState {
    DEFAULT,
    LOADING,
    LOADED
}

class HomeViewModel : ViewModel() {

    val screenState = mutableStateOf<UiState>(UiState.Home)

    val buttonState = mutableStateOf(ButtonState.DEFAULT)

    val cartFlow = MutableSharedFlow<Boolean>()


    sealed class UiState {
        class Details(val carouselDataModel: CarouselDataModel) : UiState()
        object Home : UiState()
    }

    fun onBackClick() {
        screenState.value = UiState.Home
    }

    fun changeButtonState() {
        if (buttonState.value == ButtonState.LOADED) {
            viewModelScope.launch {
                cartFlow.emit(true)
            }
            return
        }
        viewModelScope.launch {
            buttonState.value = ButtonState.LOADING
            delay(1500)
            buttonState.value = ButtonState.LOADED
        }
    }

}

//@HiltViewModel
//class MoviesViewModel @Inject constructor(
//    private val fetchOshTours: FetchOshToursUseCase,
////    private val oshService: OshService
//) : ViewModel() {
//
//    private val _uiStateFlow = MutableStateFlow<HomeViewUiState>(HomeViewUiState.Loading)
//    val uiStateFlow: StateFlow<HomeViewUiState> = _uiStateFlow.asStateFlow()
//
//    init {
//        fetchAllMovies()
//    }
//
//    fun fetchAllMovies() {
//        val handler = CoroutineExceptionHandler { _, throwable ->
//            _uiStateFlow.tryEmit(HomeViewUiState.Error(throwable.localizedMessage ?: ""))
//        }
//        viewModelScope.launch(handler + Dispatchers.IO) {
//            _uiStateFlow.tryEmit(HomeViewUiState.Loading)
//
//            val oshTours = fetchOshTours.fetchOshTours()
//
//
////            viewModelScope.launch{
////                val movieResponse = movieService.fetchMovieById(290).body()
////            }
//            val loaded = HomeViewUiState.Loaded(
//                oshTours = oshTours,
//            )
//            Log.i("Maki", "${loaded.oshTours.message}")
//
//            _uiStateFlow.tryEmit(loaded)
//        }
//    }
//}



data class CarouselDataModel(
    val resId: Int,
    val title: String,
    val description: String,
    val categoryType: ButtonState,
    val price: String,
    val color: Color,
    val aboutProduct: String = "Meet the $description TW. Inspired by the treasured franchise that brought $description cushioning to the world and laid the foundation for the aesthetic."
) {
    companion object {

        val listOfShoes = mutableListOf<CarouselDataModel>().apply {
            add(
                CarouselDataModel(
                    resId = R.drawable.first_image_id,
                    title = "Nike",
                    description = "Airmax 100",
                    price = "₹ 15,000",
                    categoryType = ButtonState.DEFAULT,
                    color = Color(0xFFeb4658)
                )
            )
            add(
                CarouselDataModel(
                    resId = R.drawable.second_image_id,
                    title = "Reebok",
                    description = "Epic React 2",
                    price = "₹ 20,000",
                    categoryType = ButtonState.LOADED,
                    color = Color(0xFF6887cb)
                )
            )
            add(
                CarouselDataModel(
                    resId = R.drawable.third_image_id,
                    title = "Under Armour",
                    description = "Hovr 2022",
                    price = "₹ 10,000",
                    categoryType = ButtonState.DEFAULT,
                    color = Color(0xFFfe7153)
                )
            )
            add(
                CarouselDataModel(
                    resId = R.drawable.second_image_id,
                    title = "Adidas",
                    description = "Supernova 200",
                    price = "₹ 6,500",
                    categoryType = ButtonState.DEFAULT,
                    color = Color(0xFF45bfff)
                )
            )
            add(
                CarouselDataModel(
                    resId = R.drawable.first_image_id,
                    title = "Under Armour",
                    description = "Hovr 1000",
                    price = "₹ 25,300",
                    categoryType = ButtonState.DEFAULT,
                    color = Color(0xFFAFCA71)
                )
            )
            add(
                CarouselDataModel(
                    resId = R.drawable.third_image_id,
                    title = "Adidas",
                    description = "Adidas s100",
                    price = "₹ 12,000",
                    categoryType = ButtonState.DEFAULT,
                    color = Color(0xFFBBA45C)
                )
            )
        }
        val categories = listOf("Tours", "Kyrgyzstan", "Abroad")
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeTopComponent(
    viewModel: HomeViewModel,
//    tourismList: List<Tour>,
    modifier: Modifier = Modifier,
    ) {
    val pagerState = rememberPagerState()
    val selectedCategory = remember { mutableStateOf(CarouselDataModel.categories.size - 1) }
    val rememberScope = rememberCoroutineScope()

    Row(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.width(64.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CarouselDataModel.categories.forEachIndexed { index, item ->
                Text(
                    text = item,
                    modifier = Modifier
                        .height(90.dp)
                        .graphicsLayer {
                            rotationZ = -90f
                            translationX = 100f
                        }
                        .clickable {
                            selectedCategory.value = index
                            rememberScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        },
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = if (selectedCategory.value == index) MySignIn else Color.LightGray,
                    maxLines = 1,
                )
            }
        }
        HorizontalPager(
            count = CarouselDataModel.categories.size,
            contentPadding = PaddingValues(end = 70.dp),
            state = pagerState
        ) { page ->
            val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
            ShoeItem(
                shoe = CarouselDataModel.listOfShoes[page],
                pageOffset, viewModel
            )
            Spacer(modifier = Modifier.height(10.dp))
//            LazyRow(
//                horizontalArrangement = Arrangement.spacedBy(24.dp),
//                contentPadding = PaddingValues(horizontal = 24.dp),
//                content = {
//                    items(tourismList.size) { index ->
//                        PopularPlaceCard(
//                            tourism = tourismList[index],
//                            modifier = modifier,
////                            onClickCard = { navigateToDetail(tourismList[index].id) }
//                        )
//                    }
//                }
//            )
        }
    }
}

@Composable
fun PopularPlaceCard(
    image: String,
    title: String,
    id: String,
    navigateToDetailScreen: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(18.dp))
            .background(WhiteColor)
            .clickable { navigateToDetailScreen(id) }
    ) {
        Box(contentAlignment = Alignment.TopEnd, modifier = modifier.padding(10.dp)) {
            AsyncImage(
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(220.dp)
                    .width(180.dp)
                    .clip(RoundedCornerShape(18.dp))
            )
            Card(
                shape = RoundedCornerShape(bottomStart = 18.dp),
                elevation = 0.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = modifier
                        .background(color = WhiteColor)
                        .height(30.dp)
                        .padding(bottom = 4.dp, end = 2.dp, start = 5.5.dp)

                ) {
//                    Image(
//                        painter = painterResource(id = androidx.compose.foundation.layout.R.drawable.icon_star),
//                        modifier = modifier.size(16.dp),
//                        contentDescription = ""
//                    )
//                    Spacer(modifier = modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null,
                        tint = Color.Yellow
                    )
//                    Text(
//                        text = tourism.rating,
//                        fontSize = 14.sp,
//                        fontFamily = POPPINS,
//                        fontWeight = FontWeight.SemiBold
//                    )
                }
            }
        }
        Column(modifier = modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp)) {
            Text(
                text = title,
                fontFamily = POPPINS,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onBackground,
            )
//            Spacer(modifier = Modifier.height(5.dp))
//            Text(
//                text = tourism.location,
//                fontFamily = POPPINS,
//                fontSize = 14.sp,
//                fontWeight = FontWeight.Light,
//                color = MaterialTheme.colorScheme.onBackground,
//            )
        }
    }
}
@Composable
fun ShoeItem(
    shoe: CarouselDataModel,
    pageOffset: Float,
    viewModel: HomeViewModel
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
    Box(modifier = Modifier.clickable {
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
                .height(280.dp)
                .width(210.dp)
                .background(color = shoe.color.copy(alpha = .8f), RoundedCornerShape(20.dp))
                .padding(end = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp)
                    .alpha(visibility)
            ) {
                Column {
                    Text(
                        text = shoe.title,
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = shoe.description,
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = shoe.price,
                        fontSize = 14.sp,
                        color = Color.White.copy(alpha = .9f),
                        fontWeight = FontWeight.Light
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Image(
                    modifier = Modifier.size(24.dp),
                    painter = painterResource(id = R.drawable.onclick_heart),
                    contentDescription = "like",
                    colorFilter = ColorFilter.tint(Color.White),
                )
            }
            Image(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .size(24.dp)
                    .align(Alignment.BottomEnd),
                painter = painterResource(id = R.drawable.movie_save_icon),
                contentDescription = "go to next",
                colorFilter = ColorFilter.tint(Color.White),
            )
        }
        Box(
            modifier = Modifier
                .height(300.dp)
                .width(220.dp)
        ) {
            Image(
                painter = painterResource(id = shoe.resId),
                contentDescription = "",
                modifier = Modifier
                    .height(340.dp)
                    .align(
                        Alignment.Center
                    )
                    .rotate(330f)
                    .offset(x = 20.dp, y = 10.dp)
                    .size(320.dp)
                    .graphicsLayer {
                        scaleX = scale
                        scaleY = scale
                        rotationZ = imageAngle
                    },
                contentScale = ContentScale.Fit
            )
        }
    }
}


