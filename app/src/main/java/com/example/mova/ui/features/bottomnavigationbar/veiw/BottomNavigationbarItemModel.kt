package com.example.mova.ui.features.bottomnavigationbar.veiw

import androidx.annotation.DrawableRes

data class BottomNavigationBarItem(
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val label: String,
)
