//package com.jyldyzferr.travelapp.presentation.navigation
//
//import androidx.compose.animation.animateColorAsState
//import androidx.compose.animation.core.FastOutSlowInEasing
//import androidx.compose.animation.core.TweenSpec
//import androidx.compose.animation.core.animateFloatAsState
//import androidx.compose.foundation.background
//import androidx.compose.foundation.isSystemInDarkTheme
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.BottomNavigation
//import androidx.compose.material.IconButton
//import androidx.compose.material.LocalContentColor
//import androidx.compose.material.Surface
//import androidx.compose.material3.Badge
//import androidx.compose.material3.BadgedBox
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.material3.NavigationBarItemDefaults
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.draw.scale
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.currentBackStackEntryAsState
//import com.jyldyzferr.travelapp.presentation.theme.MyBlue5
//import com.jyldyzferr.travelapp.presentation.theme.TravelAppTheme
//
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun BottomBar(
//    modifier: Modifier = Modifier,
//    navController: NavHostController
//) {
//    val screens = listOf(
//        BottomBarNavigationDestinations.Main,
//        BottomBarNavigationDestinations.Favorite,
//        BottomBarNavigationDestinations.Profile,
//        BottomBarNavigationDestinations.Info,
//    )
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route
//
//        var bottomNavState by rememberSaveable {
//            mutableStateOf(0)
//        }
//        NavigationBar(
//            modifier
//                .padding(10.dp)
//                .clip(RoundedCornerShape(20.dp)),
//            containerColor = Color(0xFFE0A9A5),
////                Color(0xFFE0A9A5)
//        ) {
//            screens.forEachIndexed { index, item ->
//                NavigationBarItem(
//                    selected = currentRoute == item.route,
//                    onClick = {
//                        navController.navigate(item.route)
//                    },
////                    selected = bottomNavState == index,
////                    onClick = { bottomNavState = index },
//                    icon = {
//                        BadgedBox(badge = {
//                            if (item.hasBadge) Badge {}
//                            if (item.messages != 0) Badge {
//                                Text(text = "${item.messages}")
//                            }
//                        }) {
//                            Icon(
//                                imageVector = item.icon,
////                                imageVector = if (bottomNavState == index) item.icon
////                                else item.icon,
//                                contentDescription = item.title
//                            )
//                        }
//
//                    },
//                    label = { Text(text = item.title) },
//                    colors = NavigationBarItemDefaults.colors(
//                        selectedIconColor = MaterialTheme.colorScheme.background,
//                        selectedTextColor = MaterialTheme.colorScheme.onBackground,
////                        selectedIconColor = Color(0xFF552A27),
////                        selectedTextColor = Color(0xFF63332F),
//                        indicatorColor = Color(0xFFBB7E7A)
//                    )
//                )
//            }
//        }
//
////    NavigationBar(
////        modifier = Modifier
////            .fillMaxWidth()
////            .background(MaterialTheme.colorScheme.background),
////        containerColor = MaterialTheme.colorScheme.background,
////        contentColor = LocalContentColor.current,
//////            backgroundColor = MaterialTheme.colorScheme.background,
//////            if (isSystemInDarkTheme()) Color.Black
//////            else Color.White
//////            MaterialTheme.colorScheme.background
////    ) {
////        Row(
////            modifier = Modifier
////                .background(MaterialTheme.colorScheme.background)
////        ) {
////            screens.forEach { screen ->
////                AddItem(
////                    modifier = Modifier
////                        .background(MaterialTheme.colorScheme.background)
////                        .weight(1f),
////                    selected = currentRoute == screen.route,
////                    onClick = {
////                        navController.navigate(screen.route)
////                    },
////                    icon = screen.icon,
////                )
////            }
////        }
////    }
//}
//
//
//private const val DEFAULT_ICON_SIZE = 56
//
//@Composable
//fun AddItem(
//    selected: Boolean,
//    onClick: () -> Unit,
//    icon: ImageVector,
//    modifier: Modifier = Modifier,
//    iconSize: Dp = DEFAULT_ICON_SIZE.dp,
//) {
//    val scale = if (selected) 1.5f else 1.0f
//
//    val color = if (selected) MyBlue5
//    else Color.Gray
//
//    val animatedScale: Float by animateFloatAsState(
//        targetValue = scale,
//        animationSpec = TweenSpec(
//            durationMillis = 500,
//            easing = FastOutSlowInEasing
//        ), label = ""
//    )
//    val animatedColor by animateColorAsState(
//        targetValue = color,
//        animationSpec = TweenSpec(
//            durationMillis = 500,
//            easing = FastOutSlowInEasing
//        ), label = ""
//    )
//    IconButton(
//        onClick = onClick,
//        modifier = modifier.size(iconSize)
//    ) {
//        Icon(
//            imageVector = icon,
//            contentDescription = String(),
//            tint = animatedColor,
//            modifier = Modifier
//                .scale(animatedScale)
//                .background(MaterialTheme.colorScheme.surface)
//        )
//    }
//}
//
//
