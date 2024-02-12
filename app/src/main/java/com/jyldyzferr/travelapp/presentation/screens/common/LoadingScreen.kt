package com.jyldyzferr.travelapp.presentation.screens.common

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.models.Tour
import com.jyldyzferr.travelapp.presentation.screens.utils.shimmerEffect
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import java.util.UUID

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
            tours = LoadingData.data()
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
            Spacer(modifier = Modifier.width(10.dp))
            androidx.compose.material.Text(
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
                    .clickable { },
                imageVector = Icons.Filled.Search,
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = "Search",
            )
        }
        LazyColumn(
            modifier = Modifier
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
                        .background(MaterialTheme.colorScheme.background),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    TripDetailsLoading()
                }
            }
        }
    }
}


@Composable
fun TripDetailsLoading(
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
        Column(
            modifier = Modifier
                .alpha(0.5f)
                .shimmerEffect()
        ) {
            AsyncImage(
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .shadow(
                        20.dp,
                        shape = RoundedCornerShape(16.dp), true
                    )
                    .aspectRatio(.6f),
                model = ImageRequest.Builder(context = LocalContext.current)
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
    }
}


data class LoadingData(
    val id: String,
    val title: String,
    val imageUrl: String
) {
    companion object {

        fun data() = listOf(
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