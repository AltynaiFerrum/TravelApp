package com.jyldyzferr.travelapp.presentation.screens.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.components.TabBarr
import com.jyldyzferr.travelapp.presentation.screens.common.ErrorScreen
import com.jyldyzferr.travelapp.presentation.screens.common.LoadingScreen
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import kotlinx.coroutines.flow.StateFlow


@Composable
fun WishlistScreen(
    uiStateFlow: StateFlow<WishlistUiState>,
    modifier: Modifier = Modifier,
    popBackStack: () -> Unit,
    navigateToDetails: (String) -> Unit,
    ) {
    val uiState = uiStateFlow.collectAsStateWithLifecycle().value
    when (uiState) {
        is WishlistUiState.Loading -> LoadingScreen()
        is WishlistUiState.Error -> ErrorScreen(message = uiState.message, onClick = {})
        is WishlistUiState.Loaded -> LoadedSaveScreen(
            uiState = uiState,
            modifier = modifier,
            navigateToDetails = navigateToDetails,
            popBackStack = {}
        )
    }
}








@Composable
fun LoadedSaveScreen(
    uiState: WishlistUiState.Loaded,
    popBackStack: () -> Unit,
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
//    val uiState = uiStateFlow.collectAsStateWithLifecycle().value

    Scaffold(
        modifier = modifier,
        topBar = {
            TabBarr(title = stringResource(id = R.string.wish_list))
        }
    ) { innerPaddings ->
        Column(
            modifier = Modifier
                .padding(innerPaddings)
                .fillMaxSize()
//                .verticalScroll(state = scrollState)
                .background(MaterialTheme.colorScheme.background)
        ) {
            if (uiState.tours.isEmpty()) {
                NoFavoriteMovieTub()
            } else {
                LazyColumn {
                    items(
                        items = uiState.tours,
                        key = { it.objectId }
                    ) { tour ->
                        FavoriteComponentTwo(
                            navigateToDetails = {
                                navigateToDetails(it)
                            },
                            imageUrl = tour.image,
                            title = tour.title,
                            id = tour.objectId
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun NoFavoriteMovieTub(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.no_wish_list),
            contentDescription = "fav",
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
                .align(Alignment.Center)
        )
    }
}

@Composable
fun FavoriteComponentTwo(
    id: String,
    title: String,
    imageUrl: String,
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { navigateToDetails(id) },
        elevation = CardDefaults.cardElevation(10.dp),
        shape = RoundedCornerShape(30.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                painter = rememberAsyncImagePainter(model = imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontFamily = GILROY,
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 18.sp,
                modifier = Modifier
                    .height(50.dp)
                    .padding(15.dp)
            )
        }
    }
}
