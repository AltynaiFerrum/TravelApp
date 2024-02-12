package com.jyldyzferr.travelapp.presentation.screens.edit_profile

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.jyldyzferr.travelapp.R
import com.jyldyzferr.travelapp.presentation.components.MyTextField
import com.jyldyzferr.travelapp.presentation.components.SpacerHeight
import com.jyldyzferr.travelapp.presentation.components.TabBarr
import com.jyldyzferr.travelapp.presentation.extensions.getCapturedImage
import com.jyldyzferr.travelapp.presentation.screens.common.ErrorScreen
import com.jyldyzferr.travelapp.presentation.screens.common.LoadingScreen
import com.jyldyzferr.travelapp.presentation.screens.profile.CircularImage
import com.jyldyzferr.travelapp.presentation.theme.Dark_Black
import com.jyldyzferr.travelapp.presentation.theme.ExtraLargeSpacing
import com.jyldyzferr.travelapp.presentation.theme.GILROY
import com.jyldyzferr.travelapp.presentation.theme.LargeSpacing
import com.jyldyzferr.travelapp.presentation.theme.MediumSpacing
import com.jyldyzferr.travelapp.presentation.theme.MyBlue5
import com.jyldyzferr.travelapp.presentation.theme.MySignIn

const val IMAGE_PICKER = "image/*"
const val EDIT_PROFILE_ROUTE = "edit_profile_route"

@Composable
fun EditProfileScreen(
    uiState: EditProfileUiState,
    uploadProgress: AvatarUploadProgress?,
    onEvent: (EditProfileEvent) -> Unit,
    popBackStack: () -> Unit,
    modifier: Modifier = Modifier
) {

    val progress = uploadProgress?.progress
    var openAlertDialog by remember { mutableStateOf(false) }
    openAlertDialog = uploadProgress != null

    if (openAlertDialog && progress != null) {
        UploadDialog(
            progress = progress!!,
            onDismissRequest = { openAlertDialog = false }
        )
    }

    when (uiState) {
        is EditProfileUiState.Initial -> Unit
        is EditProfileUiState.Loading -> LoadingScreen()
        is EditProfileUiState.Error -> ErrorScreen(
            message = uiState.message, onClick = { }
        )

        is EditProfileUiState.Content -> LoadedEditProfileScreen(
            uiState = uiState,
            onEvent = onEvent,
            popBackStack = popBackStack
        )
    }
}

@Composable
fun LoadedEditProfileScreen(
    uiState: EditProfileUiState.Content,
    onEvent: (EditProfileEvent) -> Unit,
    popBackStack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    val isAvatarPlaceholder = remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
        topBar = {
            TabBarr(
                title = stringResource(id = R.string.edit_profile)
            )
        }
    ) { innerPaddings ->
        Column(
            modifier = modifier
                .padding(innerPaddings)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .padding(start = LargeSpacing)
                        .padding(top = ExtraLargeSpacing)
                        .align(Alignment.TopStart)
                        .size(32.dp)
                        .border(
                            width = 1.dp,
                            color = androidx.compose.ui.graphics.Color.LightGray,
                            shape = CircleShape
                        )
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .size(16.dp)
                            .clickable { popBackStack() },
                        imageVector = Icons.Default.KeyboardArrowLeft,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
                Column(
                    modifier = modifier
                        .padding(horizontal = 40.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {
                    SpacerHeight(36.dp)
                    UserAvatar(
                        avatar = "",
                        onAvatarChanged = { onEvent(EditProfileEvent.OnAvatarChanged(it)) }
                    )
                    SpacerHeight(18.dp)
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                            .background(MaterialTheme.colorScheme.background)
                            .verticalScroll(rememberScrollState())
                            .weight(1f, fill = false)
                    ) {
                        SpacerHeight(35.dp)
                        MyTextField(
                            modifier = Modifier
                                .fillMaxWidth(1f),
                            isPassword = false,
                            label = "",
                            value = uiState.name,
                            onValueChange = { onEvent(EditProfileEvent.OnNameChanged(it)) }
                        )
                        SpacerHeight(ExtraLargeSpacing)
                        MyTextField(
                            modifier = Modifier
                                .fillMaxWidth(1f),
                            isPassword = false,
                            label = "",
                            value = uiState.lastName,
                            onValueChange = { onEvent(EditProfileEvent.OnLastNameChanged(it)) }
                        )
                        SpacerHeight(ExtraLargeSpacing)
                        MyTextField(
                            modifier = Modifier
                                .fillMaxWidth(1f),
                            isPassword = false,
                            label = "",
                            value = uiState.email,
                            onValueChange = { onEvent(EditProfileEvent.OnEmailChanged(it)) }
                        )
                        SpacerHeight(ExtraLargeSpacing)
                        Button(
                            onClick = { onEvent(EditProfileEvent.OnSaveButtonClick) },
                            elevation = null,
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor =  if (isSystemInDarkTheme()) MySignIn
                                else MyBlue5,
                                contentColor = Color.White
                            ), modifier = Modifier
                                .fillMaxWidth(1f)
                        ) {
                            Text(
                                text = "Save Changes",
                                color = MaterialTheme.colorScheme.onBackground,
                                fontFamily = GILROY,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun UserAvatar(
    avatar: String?,
    onAvatarChanged: (Bitmap) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var isAvatarPlaceholder by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri -> uri?.let { imageUri = it } }

    )
    LaunchedEffect(key1 = imageUri) {
        if (imageUri != null) {
            bitmap = imageUri.getCapturedImage(context)?.apply { onAvatarChanged(this) }
        }
    }
    Box(
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape)
    ) {
        CircularImage(
            modifier = Modifier.clickable {
                isAvatarPlaceholder = !isAvatarPlaceholder
            },
            path = bitmap ?: avatar,
            size = 120
        )
        AnimatedVisibility(
            visible = isAvatarPlaceholder,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        galleryLauncher.launch(IMAGE_PICKER)
                        isAvatarPlaceholder = false
                    }
                    .background(androidx.compose.ui.graphics.Color.Blue.copy(alpha = 0.5f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Outlined.PhotoCamera,
                    contentDescription = null,
                    tint = androidx.compose.ui.graphics.Color.White
                )
            }
        }
    }
}

@Composable
fun UploadDialog(
    progress: Int,
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Text(
                text = "progress = $progress",
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Composable
fun EditTextField(
    value: String,
    hint: String,
    topText: String,
    onValueChange: (String) -> Unit,
    isSingleLine: Boolean = true,
    modifier: Modifier = Modifier,
    fieldModifier: Modifier = Modifier
) {
    val gray = Dark_Black.copy(alpha = 0.5f)
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            modifier = fieldModifier,
            text = topText.uppercase(),
            fontFamily = GILROY,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = gray
        )
        SpacerHeight(MediumSpacing)
        TextField(
            modifier = fieldModifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            singleLine = isSingleLine,
            colors = TextFieldDefaults.colors(
                disabledContainerColor = androidx.compose.ui.graphics.Color.Transparent,
                focusedContainerColor = androidx.compose.ui.graphics.Color.Transparent,
                unfocusedContainerColor = androidx.compose.ui.graphics.Color.Transparent,
                disabledIndicatorColor = gray,
                focusedIndicatorColor = androidx.compose.ui.graphics.Color.Blue,
                unfocusedIndicatorColor = gray
            ),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.SemiBold
            ),
            placeholder = {
                Text(
                    text = hint,
                    fontFamily = GILROY,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.SemiBold
                    ),
                    color = gray
                )
            },
            trailingIcon = {
                if (value.isNotEmpty()) Icon(
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { onValueChange(String()) },
                    imageVector = Icons.Default.Clear,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        )
    }
}

