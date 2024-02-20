package com.jyldyzferr.travelapp.presentation.screens.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.jyldyzferr.travelapp.presentation.models.Tour
import com.jyldyzferr.travelapp.presentation.screens.common.ErrorScreen
import com.jyldyzferr.travelapp.presentation.screens.common.LoadingMainScreen
import com.jyldyzferr.travelapp.presentation.screens.common.LoadingScreen
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.MyBlue5
import com.jyldyzferr.travelapp.presentation.theme.MySignIn

@Composable
fun MainScreenSecond(
    uiState: MainUiState,
    navigateToDetails: (String) -> Unit,
    navigateToSearchScreen: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when (uiState) {
        is MainUiState.Initial -> Unit
        is MainUiState.Loading -> LoadingScreen()
        is MainUiState.Error -> ErrorScreen(
            message = uiState.message, onClick = {}
        )

        is MainUiState.Content -> HomeScreenSecond(
            navigateToDetailScreen = navigateToDetails,
            navigateToSearchScreen = navigateToSearchScreen,
            tours = uiState.tour,
        )
    }
}


@Composable
fun HomeScreenSecond(
    modifier: Modifier = Modifier,
    tours: List<Tour>,
    navigateToDetailScreen: (String) -> Unit,
    navigateToSearchScreen: () -> Unit,
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
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                modifier = Modifier,
                text = "Travel App",
                fontFamily = GILROY,
                color = MaterialTheme.colorScheme.onBackground,
                style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.ExtraBold),
            )
            Spacer(modifier = Modifier.width(20.dp))
            androidx.compose.material3.Icon(
                modifier = Modifier
                    .size(40.dp)
                    .clickable { navigateToSearchScreen() },
                imageVector = Icons.Filled.Search,
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = "Search",
            )
        }
        HomeTopComponent(
            viewModel = HomeViewModel()
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            modifier = Modifier
                .padding(start = 24.dp),
            text = "All Tours",
            fontFamily = GILROY,
            color = MaterialTheme.colorScheme.onBackground,
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.ExtraBold),
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = PaddingValues(horizontal = 24.dp),
        ) {
            items(
                items = tours,
                key = { it.objectId }
            ) { tours ->
                PopularPlaceCard(
                    image = tours.image,
                    title = tours.title,
                    id = tours.objectId,
                    navigateToDetailScreen = {
                        navigateToDetailScreen(it)
                    }
                )
            }
        }

//            content = {
//                items(tours.size,
//                ) { index ->
//                    PopularPlaceCard(
//                        tourism = tours[index],
//                        modifier = modifier,
////                            onClickCard = { navigateToDetail(tourismList[index].id) }
//                    )
//                }
//            }


//        LazyColumn(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.background)
//        ) {
//            items(
//                items = tours,
//                key = { it.objectId }
//            ) { tours ->
//                BookDetails(
//                    image = tours.image,
//                    title = tours.title,
//                    description = tours.description,
//                    id = tours.objectId,
//                    navigateToDetailScreen = {
//                        navigateToDetailScreen(it)
//                    }
//                )
//            }
//        }


    }
}


@Composable
fun BookDetails(
    image: String,
    title: String,
    description: String,
    id: String,
    navigateToDetailScreen: (String) -> Unit,
) {
    var showBookDescription by remember { mutableStateOf(false) }
    val bookCoverImageSize by animateDpAsState(
        targetValue =
        if (showBookDescription) 50.dp else 80.dp
    )
    Column(modifier = Modifier.clickable {
        showBookDescription = showBookDescription.not()
    }) {
        Row(modifier = Modifier.padding(12.dp)) {
            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier
                    .shadow(20.dp, shape = RoundedCornerShape(30.dp), true)
            )
        }
        Row {
            Text(
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, bottom = 16.dp),
                text = title,
                color = MaterialTheme.colorScheme.onBackground,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
        }
    }
    AnimatedVisibility(visible = showBookDescription) {
        Column {
            Text(
                text = description,
                maxLines = 5,
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Italic
                ),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { navigateToDetailScreen(id) },
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp, bottom = 16.dp)
                    .width(150.dp)
                    .height(50.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isSystemInDarkTheme()) MySignIn
                    else MyBlue5
                )
            ) {
                androidx.compose.material3.Text(
                    text = "Show more",
                    fontFamily = GILROY,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                )
            }
        }
    }
}




