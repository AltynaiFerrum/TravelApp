package com.jyldyzferr.travelapp.presentation.navigations

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

enum class BottomBarNavigationDestinations(
    val icon: ImageVector,
    val title: String,
    val route: String,
    val hasBadge: Boolean,
    val messages: Int

) {
    MAIN(
        route = "main",
        title = "Home",
        icon = Icons.Default.Home,
        hasBadge = false,
        messages = 12
    ),
    FAVORITE(
        route = "favorite",
        title = "Favorite",
        icon = Icons.Default.Favorite,
        hasBadge = false,
        messages = 0
    ),
    PROFILE(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person,
        hasBadge = false,
        messages = 0
    ),
    INFO(
        route = "info",
        title = "Info",
        icon = Icons.Default.Info,
        hasBadge = false,
        messages = 0
    ),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val screens = listOf(
        BottomBarNavigationDestinations.MAIN,
        BottomBarNavigationDestinations.FAVORITE,
        BottomBarNavigationDestinations.PROFILE,
        BottomBarNavigationDestinations.INFO,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var bottomNavState by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar(
        modifier
            .clip(RoundedCornerShape(20.dp)),
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        screens.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                    BadgedBox(badge = {
                        if (item.hasBadge) Badge {}
                        if (item.messages != 0) Badge {
                            Text(text = "${item.messages}")
                        }
                    }) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                    }

                },
                label = { Text(text = item.title) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onBackground,
                    selectedTextColor = MaterialTheme.colorScheme.onBackground,
                    indicatorColor = Color(0xFFBB7E7A)
                )
            )
        }
    }
}

