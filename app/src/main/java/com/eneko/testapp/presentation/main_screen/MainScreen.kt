package com.eneko.testapp.presentation.main_screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.eneko.testapp.R
import com.eneko.testapp.core.navigation.Breeds
import com.eneko.testapp.presentation.home.HomeScreen
import com.eneko.testapp.presentation.navigation_screens.Screen2
import com.eneko.testapp.presentation.time_screen.TimeScreen

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null,
)

@Composable
fun MainScreen(navController: NavHostController) {
    AppScaffold(navController = navController)
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppScaffold(navController: NavHostController) {
    val itemsList = listOf(

        BottomNavigationItem(
            title = stringResource(R.string.breeds),
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Default.Home,
            hasNews = false,
        ),
        BottomNavigationItem(
            title = stringResource(R.string.time_title),
            selectedIcon = Icons.Filled.DateRange,
            unselectedIcon = Icons.Default.DateRange,
            hasNews = false,
            badgeCount = 45,
        ),
        BottomNavigationItem(
            title = "screen2",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Default.Settings,
            hasNews = true,
        )
    )

    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                itemsList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedIndex,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = { Icon(item.selectedIcon, contentDescription = "") },
                        label = { Text(item.title) }
                    )
                }
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when(selectedIndex){
                0 -> HomeScreen { navController.navigate(Breeds) }
                1 -> TimeScreen()
                2 -> Screen2()
            }
        }
    }
}




