package com.jyldyzferr.travelapp.presentation.screens.profile

import android.widget.Toast
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Nightlight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.components.SpacerHeight
import com.jyldyzferr.travelapp.presentation.components.TabBarr
import com.jyldyzferr.travelapp.presentation.navigations.BottomBarNavigationDestinations
import com.jyldyzferr.travelapp.presentation.screens.auth.sign_up.SignUpDestination
import com.jyldyzferr.travelapp.presentation.screens.common.ErrorScreen
import com.jyldyzferr.travelapp.presentation.screens.common.LoadingScreen
import com.jyldyzferr.travelapp.presentation.theme.BackgroundPrimaryDark
import com.jyldyzferr.travelapp.presentation.theme.BackgroundPrimaryLight
import com.jyldyzferr.travelapp.presentation.theme.ExtraLargeSpacing
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.LargeSpacing
import com.jyldyzferr.travelapp.presentation.theme.MyBlue1
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(
    uiState: ProfileUiState,
    onEvent: (ProfileEvent) -> Unit,
    popBackStack: () -> Unit,
    navigateToEditScreen: () -> Unit,
    navigateToSignIn: () -> Unit,
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (uiState) {
        is ProfileUiState.Initial -> Unit
        is ProfileUiState.Loading -> LoadingScreen()
        is ProfileUiState.Error -> ErrorScreen(
            message = uiState.message,
            onClick = { }
        )

        is ProfileUiState.Content -> LoadedProfileScreen(
            uiState = uiState,
            onEvent = onEvent,
            modifier = modifier,
            navigateToEditScreen = navigateToEditScreen,
            popBackStack = popBackStack,
            darkTheme = darkTheme,
            onThemeUpdated = onThemeUpdated,
            navigateToSignIn = navigateToSignIn
        )
    }
}

@Composable
fun LoadedProfileScreen(
    uiState: ProfileUiState.Content,
    navigateToEditScreen: () -> Unit,
    popBackStack: () -> Unit,
    darkTheme: Boolean,
    navigateToSignIn: () -> Unit,
    onEvent: (ProfileEvent) -> Unit,
    onThemeUpdated: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navHostController = rememberNavController()

    Scaffold(
        modifier = modifier,
        topBar = {
            TabBarr(
                title = stringResource(id = R.string.profile)
            )
        }
    ) { innerPaddings ->
        Column(
            modifier = modifier
                .padding(innerPaddings)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .padding(end = LargeSpacing)
                        .padding(top = ExtraLargeSpacing)
                        .align(Alignment.TopEnd)
                        .size(32.dp)
                        .border(
                            width = 1.dp,
                            color = Color.LightGray,
                            shape = CircleShape
                        )
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background)
                        .clickable { onEvent(ProfileEvent.OnEditBackgroundImage) },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .size(16.dp)
//                            .clickable { onEvent(ProfileEvent.OnEditProfile)},
                            .clickable { navigateToEditScreen() },
                        imageVector = Icons.Default.Edit,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
                Column(
                    modifier = Modifier
                        .padding(top = 80.dp)
                        .padding(horizontal = ExtraLargeSpacing),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularImage(
                        path = uiState.user.avatar,
                        modifier = Modifier,
                        size = 150
                    )
                    Text(
                        text = "${uiState.user.name} ${uiState.user.lastName}",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = GILROY,
                        fontWeight = FontWeight.Bold
                    )
                    SpacerHeight(18.dp)
                    Settings(
                        darkTheme = darkTheme,
                        onThemeUpdated = onThemeUpdated,
                        text = "Do you want to log out?",
                        title = "Confirmation",
                        navigateToSignIn = navigateToSignIn
                    )
                }
            }
        }
    }
}

private const val DEFAULT_IMAGE_SIZE = 40

@Composable
fun CircularImage(
    path: Any?,
    size: Int = DEFAULT_IMAGE_SIZE,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = path,
        contentDescription = null,
        modifier = modifier
            .size(size.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondary),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun Settings(
    darkTheme: Boolean,
    onThemeUpdated: () -> Unit,
    navigateToSignIn: () -> Unit,
    title: String,
    text: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val is_dialog_open = remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .width(430.dp)
            .height(320.dp),
        elevation = (10.dp),
        backgroundColor = MaterialTheme.colorScheme.background,
        shape = RoundedCornerShape(25.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, top = 40.dp)
        ) {
            Row(
                modifier = Modifier
                    .clickable {
                        Toast.makeText(
                            context,
                            "The feature is still in development",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            ) {
                Icon(
                    modifier = Modifier
                        .size(38.dp)
                        .padding(start = 5.dp),
                    tint = MaterialTheme.colorScheme.onBackground,
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    modifier = Modifier
                        .padding(start = 15.dp),
                    text = "My account",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = GILROY,
                    fontSize = 23.sp,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.width(45.dp))
                Icon(
                    modifier = Modifier
                        .size(38.dp)
                        .padding(end = 5.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Divider(
                color = MyBlue1,
                modifier = Modifier
                    .width(340.dp)
                    .height(1.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .clickable {
                        Toast.makeText(
                            context,
                            "The feature is still in development",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            ) {
                Icon(
                    modifier = Modifier
                        .size(38.dp)
                        .padding(start = 5.dp),
                    imageVector = Icons.Default.Wifi,
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    modifier = Modifier
                        .padding(start = 15.dp),
                    text = "Premium version",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = GILROY,
                    fontSize = 23.sp,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.width(85.dp))
                Icon(
                    modifier = Modifier
                        .size(38.dp)
                        .padding(end = 5.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = null
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Divider(
                color = MyBlue1,
                modifier = Modifier
                    .width(340.dp)
                    .height(1.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row {
                Icon(
                    modifier = Modifier
                        .size(38.dp)
                        .padding(start = 5.dp),
                    imageVector = Icons.Default.Settings,
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    modifier = Modifier
                        .padding(start = 15.dp),
                    text = "Dark Theme",
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontFamily = GILROY,
                    fontSize = 23.sp,
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(modifier = Modifier.width(45.dp))
                ThemeSwitcher(
                    darkTheme = darkTheme,
                    size = 30.dp,
                    padding = 5.dp,
                    onClick = onThemeUpdated
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Divider(
                color = MyBlue1,
                modifier = Modifier
                    .width(340.dp)
                    .height(1.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .clickable {
                        is_dialog_open.value = true
                    }
            ) {
                Icon(
                    modifier = Modifier
                        .size(38.dp)
                        .padding(start = 5.dp),
                    imageVector = Icons.Default.ExitToApp,
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    modifier = Modifier
                        .padding(start = 15.dp),
                    text = "Login out",
                    fontWeight = FontWeight.Bold,
                    fontFamily = GILROY,
                    fontSize = 23.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Red
                )
                Spacer(modifier = Modifier.width(75.dp))
                Icon(
                    modifier = Modifier
                        .size(38.dp)
                        .padding(end = 5.dp),
                    imageVector = Icons.Default.KeyboardArrowRight,
                    tint = MaterialTheme.colorScheme.onBackground,
                    contentDescription = null
                )
            }
            if (is_dialog_open.value) {
                AlertDialog(
                    onDismissRequest = {
                        is_dialog_open.value = false
                    },
                    title = {
                        androidx.compose.material.Text(
                            text = title,
                            color = androidx.compose.material.MaterialTheme.colors.primaryVariant,
                            fontSize = 24.sp
                        )
                    },
                    confirmButton = {
                        androidx.compose.material.Button(onClick = {
                            navigateToSignIn()
//                            onEvent(ProfileEvent.OnLogOut).also {
//                                navHostController.navigate(SignUpDestination.route()){
//                                    popUpTo(BottomBarNavigationDestinations.MAIN.route){
//                                        inclusive = true
//                                    }
//                                }
//
//                            }
                        }) {
                            androidx.compose.material.Text(
                                modifier = modifier,
//                                    .clickable {  },
                                text = "Confirm"
                            )
                        }
                    },
                    dismissButton = {
                        androidx.compose.material.Button(onClick = {
                            is_dialog_open.value = false
                        }) {
                            androidx.compose.material.Text(text = "Dismiss")
                        }
                    },
                    text = {
                        androidx.compose.material.Text(
                            text = text,
                            color = androidx.compose.material.MaterialTheme.colors.primary,
                            fontSize = 16.sp
                        )
                    }
                )
            }
        }
    }
}


@Composable
fun ThemeSwitcher(
    darkTheme: Boolean = false,
    size: Dp = 150.dp,
    iconSize: Dp = size / 3,
    padding: Dp = 10.dp,
    borderWidth: Dp = 1.dp,
    parentShape: Shape = CircleShape,
    toggleShape: Shape = CircleShape,
    animationSpec: AnimationSpec<Dp> = tween(durationMillis = 300),
    onClick: () -> Unit
) {
    val offset by animateDpAsState(
        targetValue = if (darkTheme) 0.dp else size,
        animationSpec = animationSpec
    )

    Box(modifier = Modifier
        .width(size * 2)
        .height(size)
        .clip(shape = parentShape)
        .clickable { onClick() }
        .background(MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Box(
            modifier = Modifier
                .size(size)
                .offset(x = offset)
                .padding(all = padding)
                .clip(shape = toggleShape)
                .background(MaterialTheme.colorScheme.primary)
        ) {}
        Row(
            modifier = Modifier
                .border(
                    border = BorderStroke(
                        width = borderWidth,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    shape = parentShape
                )
        ) {
            Box(
                modifier = Modifier.size(size),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(iconSize),
                    imageVector = Icons.Default.Nightlight,
                    contentDescription = "Theme Icon",
                    tint = MaterialTheme.colorScheme.onBackground,
//                    if (darkTheme) MaterialTheme.colorScheme.secondaryContainer
//                    else MaterialTheme.colorScheme.primary
                )
            }
            Box(
                modifier = Modifier.size(size),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(iconSize),
                    imageVector = Icons.Default.LightMode,
                    contentDescription = "Theme Icon",
                    tint = MaterialTheme.colorScheme.onBackground,
//                    tint = if (darkTheme) MaterialTheme.colorScheme.secondaryContainer
//                    else MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

