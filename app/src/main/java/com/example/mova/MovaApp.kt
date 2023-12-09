package com.example.mova

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mova.ui.features.bottomnavigationbar.veiw.BottomNavigationBar
import com.example.mova.ui.navigation.MovaAppScreens
import com.example.mova.ui.navigation.MovaNavHost

@Composable
fun MovaApp(
    navController: NavHostController = rememberNavController(),
) {
    val screens = listOf(
        MovaAppScreens.HOME.name,
        MovaAppScreens.EXPLORE.name,
        MovaAppScreens.MY_LIST.name,
        MovaAppScreens.DOWNLOAD.name,
        MovaAppScreens.PROFILE.name
    )
    val showBottomNavigationBar = navController.currentBackStackEntryAsState().value?.destination?.route in screens.map { it }
    //navController.previousBackStackEntry?.destination?.route == null
    Scaffold(
        bottomBar = { if(showBottomNavigationBar) BottomNavigationBar(navController)},
        )
    {
        Box(
            modifier = Modifier.padding(it)
        ) {
            MovaNavHost(
                navController = navController,
            )
        }
    }
}