package com.jyldyzferr.travelapp.presentation.screens.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.components.AnimateTypewriterText
import com.jyldyzferr.travelapp.presentation.components.SpacerHeight
import com.jyldyzferr.travelapp.presentation.components.advancedShadow
import com.jyldyzferr.travelapp.presentation.screens.onboarding.models.OnboardingPageItem
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.MyOrange
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(
    navigateToSignInScreen: () -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState()
    val onboardings = OnboardingPageItem.onboardingItems()
    val scope = rememberCoroutineScope()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(
                id = R.drawable.back_onboarding
            ),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                 .padding(bottom = 45.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HorizontalPager(
                count = onboardings.size,
                state = pagerState,
                contentPadding = PaddingValues(0.dp)
            ) { position ->
                val onboarding = onboardings[position]
                when (onboarding) {
                    is OnboardingPageItem.Onboarding -> {
                        OnboardingPage(page = onboarding)
                    }
                }
            }
            val page = onboardings[pagerState.currentPage]
            if (page is OnboardingPageItem.Onboarding) {
                SpacerHeight(16.dp)
                Text(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth(),
                    text = stringResource(id = page.titleId),
                    fontFamily = GILROY,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Color.Black
                )
                SpacerHeight(16.dp)
                Text(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .fillMaxWidth(),
                    text = stringResource(id = page.descriptionId),
                    fontFamily = GILROY,
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(80.dp))
            OnboardingAnimatedTextField(
                page = onboardings[pagerState.currentPage],
                onNextPage = { isLastPage ->
                    if(isLastPage) navigateToSignInScreen()
                   else scope.launch { pagerState.animateScrollToPage(pagerState.currentPage.inc()) }
                })
            SpacerHeight(25.dp)
            HorizontalPagerIndicator(
                modifier = Modifier
                    .clip(shape = CircleShape),
                pagerState = pagerState,
                pageCount = onboardings.size,
                indicatorWidth = 8.dp,
                indicatorHeight = 4.dp,
                inactiveColor = Color.Gray,
                activeColor = MyOrange,
                spacing = 8.dp
            )
        }
    }
}


@Composable
fun OnboardingPage(
    page: OnboardingPageItem.Onboarding,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
    ) {
        Image(
            modifier = Modifier
                .padding(top = 20.dp)
                .width(421.dp)
                .height(422.dp),
            painter = painterResource(id = page.imageId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}


@Composable
fun OnboardingAnimatedTextField(
    page: OnboardingPageItem,
    onNextPage: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(165.dp)
            .height(56.dp)
            .advancedShadow(
                color = MyOrange,
                alpha = 0.9f,
                shadowBlurRadius = 40.dp,
            )
           .clip(RoundedCornerShape(10.dp))
            .background(MyOrange)
            .clickable { onNextPage(page.isLastPage) }
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 18.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (page.isLastPage) Spacer(modifier = Modifier.weight(1f))
            AnimateTypewriterText(
                modifier = Modifier,
                baseText = String(),
                highlightText = "|",
                parts = listOf(stringResource(id = page.buttonTextId))
            )
            Spacer(modifier = Modifier.weight(1f))
            AnimatedVisibility(visible = !page.isLastPage) {
                IconButton(
                    onClick = {onNextPage(page.isLastPage)}) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = Icons.Default.ArrowForward,
                        tint = Color.White,
                        contentDescription = null,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun OnboardingScreenPreview(
    modifier: Modifier = Modifier
) {
    MaterialTheme {
        OnboardingScreen(
            navigateToSignInScreen = {}
        )
    }
}



