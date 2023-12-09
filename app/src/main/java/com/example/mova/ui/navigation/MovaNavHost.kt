package com.example.mova.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mova.ui.features.download.view.DownloadScreen
import com.example.mova.ui.features.explore.view.ExploreScreen
import com.example.mova.ui.features.home.view.HomeScreen
import com.example.mova.ui.features.movieDetails.MovieDetails
import com.example.mova.ui.features.mylist.view.MyListScreen
import com.example.mova.ui.features.profile.view.ProfileScreen

enum class MovaAppScreens {
    HOME,
    EXPLORE,
    MY_LIST,
    DOWNLOAD,
    PROFILE,
    MOVIE_DETAILS
}

@Composable
fun MovaNavHost(
    navController: NavHostController,
    modifier: Modifier
){
    NavHost(
        navController = navController,
        startDestination = MovaAppScreens.HOME.name,
        enterTransition = { EnterTransition.None}
    ){
        composable(
            route = MovaAppScreens.HOME.name,
            enterTransition = { NavigationAnimation.bottomNavigationBarScreensAnimation() }
        ){
            HomeScreen()
        }
        composable(
            route = MovaAppScreens.EXPLORE.name,
            enterTransition = { NavigationAnimation.bottomNavigationBarScreensAnimation() }
        ){
            ExploreScreen(navController = navController)
        }
        composable(
            route = MovaAppScreens.MY_LIST.name,
            enterTransition = { NavigationAnimation.bottomNavigationBarScreensAnimation() }
        ){
            MyListScreen()
        }
        composable(
            route = MovaAppScreens.DOWNLOAD.name,
            enterTransition = { NavigationAnimation.bottomNavigationBarScreensAnimation() }
        ){
            DownloadScreen()
        }
        composable(
            route = MovaAppScreens.PROFILE.name,
            enterTransition = { NavigationAnimation.bottomNavigationBarScreensAnimation() }
        ){
            ProfileScreen()
        }
        composable(
            route = MovaAppScreens.MOVIE_DETAILS.name,
            enterTransition = { NavigationAnimation.slideRightAnimation() },
            exitTransition = { NavigationAnimation.slideLeftAnimation() }
        ){
            MovieDetails(){
                navController.popBackStack()
            }
        }
    }
}

object NavigationAnimation{
    fun bottomNavigationBarScreensAnimation(): EnterTransition{
        return fadeIn(animationSpec = tween(500, easing = EaseInOut))
    }

    fun slideRightAnimation(): EnterTransition{
        return slideInHorizontally(
            initialOffsetX = { it },
            animationSpec = tween(300, easing = LinearEasing)
        )
    }

    fun slideLeftAnimation(): ExitTransition {
        return slideOutHorizontally(
            targetOffsetX = { it },
            animationSpec = tween(300, easing = LinearEasing)
        )
    }
}

