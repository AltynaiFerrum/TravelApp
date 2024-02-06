//package com.jyldyzferr.travelapp.presentation.screens.main.see_all_screen
//
//import android.view.MotionEvent
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.animation.core.animateDpAsState
//import androidx.compose.animation.core.animateFloat
//import androidx.compose.animation.core.spring
//import androidx.compose.animation.core.updateTransition
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
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
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Card
//import androidx.compose.material.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material.Text
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.KeyboardArrowLeft
//import androidx.compose.material.icons.rounded.ArrowForward
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.ExperimentalComposeUiApi
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.shadow
//import androidx.compose.ui.graphics.Brush
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.pointer.pointerInteropFilter
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.text.TextStyle
//import androidx.compose.ui.text.font.FontStyle
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.hilt.navigation.compose.hiltViewModel
//import coil.compose.AsyncImage
//import com.jyldyzferr.travelapp.R
//import com.jyldyzferr.travelapp.data.fake_data.CarouselDataModel
//import com.jyldyzferr.travelapp.data.fake_data.FakeData
//import com.jyldyzferr.travelapp.presentation.screens.main.HomeViewModel
//import com.jyldyzferr.travelapp.presentation.theme.GILROY
//
//
//enum class TouchState {
//    Touched, NotTouched
//}
//
//@OptIn(ExperimentalComposeUiApi::class, ExperimentalAnimationApi::class)
//@Composable
//fun MusicCard(
//    carouselDataModel: CarouselDataModel = CarouselDataModel.listOfShoes.first(),
//) {
//
//    var currentState: TouchState by remember { mutableStateOf(TouchState.NotTouched) }
//
//    val transition = updateTransition(targetState = currentState, label = "animation")
//
//
//    val scale: Float by transition.animateFloat(
//        transitionSpec = { spring(stiffness = 900f) }, label = ""
//    ) { state ->
//        if (state == TouchState.Touched) {
//            1.3f
//        } else {
//            1f
//        }
//    }
//
//    val colorAlpha: Float by transition.animateFloat(
//        transitionSpec = { spring(stiffness = 900f) }, label = ""
//    ) { state ->
//        if (state == TouchState.Touched) {
//            1f
//        } else {
//            0.2f
//        }
//    }
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(180.dp)
//            .padding(4.dp),
//        contentAlignment = Alignment.BottomCenter
//    ) {
//        Card(
//            Modifier
//                .fillMaxWidth()
//                .height(120.dp)
//                .pointerInteropFilter {
//                    currentState = when (it.action) {
//                        MotionEvent.ACTION_DOWN -> {
//                            TouchState.Touched
//                        }
//
//                        else -> {
//                            TouchState.NotTouched
//                        }
//                    }
//                    true
//                },
//            shape = RoundedCornerShape(16.dp),
////            backgroundColor = tour.copy(alpha = 0.2f) ,
//            elevation = 0.dp
//        ) {
//            Row(
//                modifier = Modifier
//                    .matchParentSize()
//                    .background(
//                        Brush.linearGradient(
//                            colors = listOf(
//                                carouselDataModel.color.copy(alpha = 0.2f),
//                                carouselDataModel.color.copy(alpha = 0.2f),
//                                carouselDataModel.color.copy(alpha = colorAlpha),
//                            )
//                        )
//                    )
//            ) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxHeight()
//                        .padding(start = 32.dp),
//                    horizontalAlignment = Alignment.Start,
//                    verticalArrangement = Arrangement.Center
//                ) {
//                    Text(text = carouselDataModel.title, style = MaterialTheme.typography.bodyLarge)
//                    Spacer(modifier = Modifier.height(8.dp))
//                    AnimatedVisibility(visible = currentState == TouchState.NotTouched) {
//                        Text(
//                            text = carouselDataModel.description,
//                            style = MaterialTheme.typography.titleMedium,
//                        )
//                    }
//
//                    AnimatedVisibility(visible = currentState == TouchState.Touched) {
//                        Row(verticalAlignment = Alignment.Bottom) {
//                            Text(
//                                text = "Listen Now",
//                                style = MaterialTheme.typography.titleMedium
//                            )
//                            Icon(
//                                imageVector = Icons.Rounded.ArrowForward,
//                                contentDescription = null,
//                                Modifier.size(20.dp)
//                            )
//                        }
//                    }
//                }
//            }
//        }
//        AsyncImage(
//            model = carouselDataModel.resId,
//            contentDescription = null,
//            contentScale = ContentScale.FillHeight,
//            modifier = Modifier
//                .height((120 * scale).dp)
//                .padding(end = 32.dp)
//                .align(Alignment.BottomEnd)
//        )
//    }
//}
//
//@Composable
//fun CategoryScreen(
//    viewModel: HomeViewModel = hiltViewModel()
//) {
//    Column {
//        MusicCard(
//            viewModel = viewModel
//        )
//        MusicCard(
//            viewModel = viewModel
//        )
//        MusicCard(
//            viewModel = viewModel
//        )
//    }
//}
//
//@Composable
//fun SeeAllScreen(
//    modifier: Modifier = Modifier,
//    popBackStack: () -> Unit,
//) {
//    val listOfBooks = FakeData.fakeRecommendationsEvent()
//    Column(
//        modifier = modifier
//            .background(MaterialTheme.colorScheme.background),
//    ) {
//        Row(
//            modifier = Modifier
//                .statusBarsPadding()
//        ) {
//            Icon(
//                modifier = Modifier
//                    .size(38.dp)
//                    .clickable { popBackStack() },
//                imageVector = Icons.Default.KeyboardArrowLeft,
//                contentDescription = null,
//                tint = MaterialTheme.colorScheme.onBackground
//            )
//            Spacer(modifier = Modifier.width(10.dp))
//            Text(
//                modifier = Modifier,
////                style = MaterialTheme.typography.titleMedium,
////                fontWeight = FontWeight.Bold,
//                text = "All Tours",
//                fontFamily = GILROY,
//                color = MaterialTheme.colorScheme.onBackground,
//                style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.ExtraBold),
//            )
//        }
//        LazyColumn(modifier = Modifier
//            .fillMaxHeight()
//            .background(MaterialTheme.colorScheme.background)
//        ) {
//            items(listOfBooks) {
//                Card(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(16.dp)
////                        .background(MaterialTheme.colorScheme.background)
//                    ,
//                    shape = RoundedCornerShape(16.dp),
//                    backgroundColor = MaterialTheme.colorScheme.background
//                ) {
//                    BookDetails()
//                }
//            }
//        }
//    }
//}
//
//
//@Composable
//fun BookDetails(
//
//) {
//    var showBookDescription by remember { mutableStateOf(false) }
//    val bookCoverImageSize by animateDpAsState(
//        targetValue =
//        if (showBookDescription) 50.dp else 80.dp
//    )
//    Column(modifier = Modifier.clickable {
//        showBookDescription = showBookDescription.not()
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
//            Column {
//                Text(
//                    text = "name",
//                    style = TextStyle(
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 18.sp
//                    )
//                )
//
//                Text(
//                    text = "author",
//                    style = TextStyle(
//                        fontWeight = FontWeight.Light,
//                        fontSize = 12.sp
//                    )
//                )
//            }
//        }
//        AnimatedVisibility(visible = showBookDescription) {
//            Text(
//                text = stringResource(id = R.string.desc_details),
//                style = TextStyle(
//                    fontWeight = FontWeight.SemiBold,
//                    fontStyle = FontStyle.Italic
//                ),
//                color = MaterialTheme.colorScheme.onBackground,
//                modifier = Modifier
//                    .background(MaterialTheme.colorScheme.background)
//                    .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
//            )
//        }
//    }
//}
//
//
