package com.example.mova.ui.features.bottomnavigationbar.veiw

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.mova.data.consts.bottomNavigationBarItems
import com.example.mova.ui.features.bottomnavigationbar.viewmodel.BottomNavigationbarViewModel
import com.example.mova.ui.navigation.MovaAppScreens
import com.example.mova.ui.theme.primaryColor

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {
    val viewModel: BottomNavigationbarViewModel = hiltViewModel()
    NavigationBar(
        containerColor = Color.Transparent,
        contentColor = Color.Red,
    ) {
        bottomNavigationBarItems.forEach { item ->
            val color = animateColorAsState(
                targetValue = if (viewModel.selectedPage == item.label) primaryColor else Color.LightGray,
                label = "color",
                animationSpec = tween(300, easing = EaseInOut)
            )
            NavigationBarItem(
                selected = false,
                onClick = {
                    if(viewModel.selectedPage != item.label){
                        viewModel.changeSelectedPage(item.label)
                        navController.popBackStack()
                        when (viewModel.selectedPage) {
                            "Home" -> navController.navigate(MovaAppScreens.HOME.name)
                            "Explore" -> {
                                //vm.getExploreMovies()
                                navController.navigate(MovaAppScreens.EXPLORE.name)
                            }
                            "My List" -> navController.navigate(MovaAppScreens.MY_LIST.name)
                            "Download" -> navController.navigate(MovaAppScreens.DOWNLOAD.name)
                            else -> navController.navigate(MovaAppScreens.PROFILE.name)
                        }
                    }
                },
                icon = {
                    val size = animateDpAsState(
                        targetValue = if (viewModel.selectedPage == item.label) 28.dp else 24.dp,
                        label = "size",
                        animationSpec = tween(300, easing = EaseInOut)
                    )
                    Icon(
                        painter = if (viewModel.selectedPage == item.label)
                            painterResource(id = item.selectedIcon)
                        else
                            painterResource(id = item.unselectedIcon),
                        contentDescription = item.label,
                        tint = color.value,
                        modifier = Modifier.size(size.value)
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        color = color.value
                    )
                },
            )
        }
    }
}
