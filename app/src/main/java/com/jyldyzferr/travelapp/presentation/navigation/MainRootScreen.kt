//package com.jyldyzferr.travelapp.presentation.navigation
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.background
//import androidx.compose.foundation.isSystemInDarkTheme
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.ModalBottomSheetState
//import androidx.compose.material.Surface
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.navigation.compose.rememberNavController
//import com.jyldyzferr.travelapp.presentation.theme.TravelAppTheme
//
//
//@SuppressLint("SuspiciousIndentation")
//@OptIn(ExperimentalMaterialApi::class)
//@Composable
//fun MainRootScreen(
////    sheetState: ModalBottomSheetState,
//    modifier: Modifier = Modifier,
//) {
////    var darkTheme by remember { mutableStateOf(false) }
////    TravelAppTheme(darkTheme = darkTheme) {
//    val navController = rememberNavController()
//    Scaffold(
//        modifier = modifier,
//        containerColor = Color(0xFFE0A9A5),
//        bottomBar = {
//            BottomBar(
//                navController = navController,
//                modifier = modifier
//                    .padding(10.dp)
//                    .clip(RoundedCornerShape(20.dp))
//                    .background(
//                        Color.Transparent
////                            if (isSystemInDarkTheme()) Color.Black
////                            else Color.White
//                    ),
//            )
//        }
//    ) { innerPaddings ->
//        BottomNavGraph(
//            modifier = Modifier
//                .padding(innerPaddings)
//                .background(Color(0xFFE0A9A5)),
//            navController = navController,
////            sheetState = sheetState
//        )
//    }
//}
////}
