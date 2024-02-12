package com.jyldyzferr.travelapp.presentation.screens.main.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.components.TabBarr
import com.jyldyzferr.travelapp.presentation.screens.common.LoadingScreen
import com.jyldyzferr.travelapp.presentation.screens.common.SearchWishListComponent
import com.jyldyzferr.travelapp.presentation.theme.MUSEO_MODERNO
import com.jyldyzferr.travelapp.presentation.theme.MyGray


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    uiState: SearchUiState,
    onValueChange: (String) -> Unit,
    navigateToDetails: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(modifier = modifier, topBar = {
        TabBarr(title = stringResource(id = R.string.search_screen))
    }) { innerPaddings ->
        Column(
            modifier = Modifier
                .padding(innerPaddings)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            OutlinedTextField(
                value = uiState.query,
                onValueChange = onValueChange,
                placeholder = { Text(text = "Search", fontFamily = MUSEO_MODERNO) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = "Search Icon"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, start = 15.dp, end = 15.dp)
                    .background(
                        color = MyGray, shape = RoundedCornerShape(10.dp)
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.DarkGray,
                )
            )
            when {
                uiState.query.isEmpty() -> NoSearchResultsTub()
                uiState.isLoading -> LoadingScreen()
                else -> LazyColumn {
                    items(items = uiState.tours, key = { it.objectId }) { tour ->
                        SearchWishListComponent(id = tour.objectId,
                            posterUrl = tour.image,
                            title = tour.title,
                            location = tour.location,
                            description = tour.description,
                            navigateToDetails = {
                                navigateToDetails(it)
                            })
                    }
                }
            }
        }
    }
}



@Composable
fun NoSearchResultsTub(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(top = 40.dp)
            .fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Image(
                painter = painterResource(id = R.drawable.oops),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "There is nothing yet",
                color = MaterialTheme.colorScheme.background,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Try again!",
                color = MaterialTheme.colorScheme.background,
                textAlign = TextAlign.Center
            )
        }
    }
}
