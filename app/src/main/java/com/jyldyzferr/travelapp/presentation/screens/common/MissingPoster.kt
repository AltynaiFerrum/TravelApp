package com.jyldyzferr.travelapp.presentation.screens.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import coil.memory.MemoryCache
import coil.request.ImageRequest
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.screens.utils.shimmerEffect

@Composable
fun TourPosterImage(
    modifier: Modifier = Modifier,
    posterPath: String,
) {
    val imageLoader = LocalContext.current.imageLoader
    posterPath?.let {
        imageLoader.diskCache?.remove(posterPath)
        imageLoader.memoryCache?.remove(MemoryCache.Key(posterPath))
    }
    val posterImage = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(posterPath)
            .crossfade(true)
            .build()
    )
    Box(modifier = modifier.background(MaterialTheme.colorScheme.background)) {
        when (posterImage.state) {
            is AsyncImagePainter.State.Success -> {
                Image(
                    painter = posterImage,
                    contentDescription = stringResource(R.string.tour_poster_content_description),
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(dimensionResource(id = R.dimen.plant_item_image_height)),
                )
            }

            is AsyncImagePainter.State.Error -> {
                MissingPoster()
            }

            is AsyncImagePainter.State.Empty -> {
                MissingPoster()
            }

            is AsyncImagePainter.State.Loading -> {
                Image(
                    painter = posterImage,
                    contentDescription = stringResource(R.string.tour_poster_content_description),
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxSize()
                        .alpha(0.5f)
                        .shimmerEffect()
                )
            }
        }
    }
}

@Composable
fun MissingPoster(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = R.drawable.missing_poster),
        contentDescription = stringResource(id = R.string.loading_error_content_description),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .fillMaxSize()
            .alpha(0.5f)
    )
}