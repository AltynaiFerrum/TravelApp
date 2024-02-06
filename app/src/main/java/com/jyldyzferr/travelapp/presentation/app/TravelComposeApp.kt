package com.jyldyzferr.travelapp.presentation.app

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.jyldyzferr.travelapp.presentation.navigations.AppNavGraph
import com.jyldyzferr.travelapp.presentation.theme.TravelAppTheme
import kotlinx.coroutines.flow.Flow


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun TravelComposeApp(
    destinationFlow: Flow<Pair<String, Boolean>>,
    modifier: Modifier = Modifier
) {
    var darkTheme by remember { mutableStateOf(false) }
    TravelAppTheme(darkTheme = darkTheme) {
        val navHostController = rememberNavController()

        val (destination, isClearBackstack) = destinationFlow.collectAsState(initial = "" to false).value
        if (destination.isNotEmpty()) {
            navHostController.navigate(destination) {
                if (isClearBackstack) popUpTo(0)
            }
        }
        Scaffold(
            modifier = modifier.fillMaxSize()
        ) {
            AppNavGraph(
                navController = navHostController,
            )
        }
    }
}