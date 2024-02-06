package com.jyldyzferr.travelapp.presentation.screens.edit_profile

import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.ViewModel
import com.jyldyzferr.travelapp.presentation.extensions.convertToByteArray
import com.jyldyzferr.travelapp.presentation.extensions.firstLetterIsCapitalizedRestSmall
import com.jyldyzferr.travelapp.presentation.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.parse.ParseException
import com.parse.ParseFile
import com.parse.ProgressCallback
import com.parse.SaveCallback
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


private const val DEFAULT_IMAGE_TITLE = "image.png"

@HiltViewModel
class EditProfileViewModel @Inject constructor(

) : ViewModel(), SaveCallback, ProgressCallback {

    private val _uiState = MutableStateFlow<EditProfileUiState>(EditProfileUiState.Initial)
    val uiState: StateFlow<EditProfileUiState> = _uiState.asStateFlow()

    private var parseFile: ParseFile? = null

    private val _uploadProgress = MutableStateFlow<AvatarUploadProgress?>(null)
    val uploadProgress: StateFlow<AvatarUploadProgress?> = _uploadProgress.asStateFlow()

    init {
        val user = User.unknown
        _uiState.tryEmit(
            EditProfileUiState.Content(
//                user = user,
                name = user.name,
                lastName = user.lastName,
                email = user.email,
            )
        )
    }

    fun onEvent(event: EditProfileEvent) {
        when (event) {
//            is EditProfileEvent.OnAboutChanged -> doAboutChanged(event.value)
            is EditProfileEvent.OnEmailChanged -> doEmailChanged(event.value)
            is EditProfileEvent.OnNameChanged -> doNameChanged(event.value)
            is EditProfileEvent.OnLastNameChanged -> doLastNameChanged(event.value)
            is EditProfileEvent.OnAvatarChanged -> doAvatarChanged(event.bitmap)
            is EditProfileEvent.OnSaveButtonClick -> doSaveButtonClick()
            else -> {}
        }
    }

    private fun doSaveButtonClick() {
        startSaveAvatar()
    }

    private fun startSaveAvatar() {
        val file = parseFile ?: return
        file.saveInBackground(this, this)
    }

    private fun doAvatarChanged(bitmap: Bitmap) {
        val byteArray = bitmap.convertToByteArray()
        parseFile = ParseFile(DEFAULT_IMAGE_TITLE, byteArray)
    }

    private fun doEmailChanged(value: String) {
        _uiState.update { uiState ->
            val contentState = uiState as? EditProfileUiState.Content ?: return
            contentState.copy(email = value.lowercase())
        }
    }

    private fun doNameChanged(value: String) {
        _uiState.update { uiState ->
            val contentState = uiState as? EditProfileUiState.Content ?: return
            contentState.copy(name = value.firstLetterIsCapitalizedRestSmall())
        }
    }

    private fun doLastNameChanged(value: String) {
        _uiState.update { uiState ->
            val contentState = uiState as? EditProfileUiState.Content ?: return
            contentState.copy(lastName = value.firstLetterIsCapitalizedRestSmall())
        }
    }

    override fun done(e: ParseException?) {
        Log.i("CheckEditScreen", "ParseException = ${e?.stackTraceToString()}")
        _uploadProgress.tryEmit(null)
    }

    override fun done(percentDone: Int?) {
        val progress = percentDone ?: return
        val uploadProgress = AvatarUploadProgress(progress)
        _uploadProgress.tryEmit(uploadProgress)
    }
}


