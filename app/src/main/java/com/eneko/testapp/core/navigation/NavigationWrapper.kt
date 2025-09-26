package com.eneko.testapp.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.eneko.testapp.core.navigation.type.createNavType
import com.eneko.testapp.presentation.breeds_details_screen.BreedsDetailsScreen
import com.eneko.testapp.presentation.breeds_screen.BreedsScreen
import com.eneko.testapp.presentation.cart_screen.CartScreen
import com.eneko.testapp.presentation.home.HomeScreen
import com.eneko.testapp.presentation.main_screen.MainScreen
import com.eneko.testapp.presentation.navigation_screens.Screen1
import com.eneko.testapp.presentation.navigation_screens.Screen2
import com.eneko.testapp.presentation.navigation_screens.Screen3
import com.eneko.testapp.presentation.settings_screen.SettingsScreen
import com.eneko.testapp.presentation.splash_screen.SplashScreen
import com.eneko.testapp.presentation.time_screen.TimeScreen
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper(navController: NavHostController) {

    NavHost(navController=navController,startDestination = Splash){
        composable<Splash> {
            SplashScreen(
                onAnimationComplete = {
                    navController.navigate(Main) {
                        popUpTo(Splash) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<Main> {
            MainScreen (navController = navController)
        }

        composable<Home>{
            HomeScreen{navController.navigate(Breeds)}
        }

        composable<Breeds>{
            BreedsScreen{breed -> navController.navigate(BreedsDetails(breedName = breed))}
        }

        composable<BreedsDetails>{ backStackEntry ->
            val breedDetails: BreedsDetails = backStackEntry.toRoute()
            BreedsDetailsScreen(
                breedName = breedDetails.breedName,
                navigateToSettings = { settingsInfo -> navController.navigate(Settings(info = settingsInfo))},
                navigateBack = {
                    navController.navigate(Main){
                        popUpTo(Main){
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingsInfo>() to createNavType<SettingsInfo>())){ backStackEntry ->
            val settings: Settings = backStackEntry.toRoute()
            SettingsScreen(settingsInfo = settings.info)
        }
        composable<Screen1>{
            Screen1()
        }
        composable<Screen2>{
            Screen2()
        }
        composable<Screen3>{
            Screen3()
        }

        composable<TimeScreen>{
            TimeScreen()
        }

        composable<CartScreen>{
            CartScreen()
        }

    }
}