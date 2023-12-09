package com.example.mova.data.consts

import com.example.mova.R
import com.example.mova.ui.features.bottomnavigationbar.veiw.BottomNavigationBarItem
import com.example.mova.ui.features.explore.model.FilterComponent

val categories = FilterComponent(
    title = "Categories",
    choices = listOf("Movie", "TV Shows", "K-Drama", "Anime")
)
val regions = FilterComponent(
    title = "Regions",
    choices = listOf("All Regions", "US", "South Korea", "China")
)
val genres = FilterComponent(
    title = "Genre",
    choices = listOf("Action", "Comedy", "Romance", "Thriller", "Drama")
)
val time_periods = FilterComponent(
    title = "Time/Periods",
    choices = listOf("All Periods", "2023", "2022", "2021", "2020", "2019","2018", "2017", "2016", "2015")
)
val sort = FilterComponent(
    title = "Sort",
    choices = listOf("Popularity", "Latest Release")
)

val bottomNavigationBarItems: List<BottomNavigationBarItem> = listOf(
    BottomNavigationBarItem(
        selectedIcon = R.drawable.home_filled_icon,
        unselectedIcon = R.drawable.home_outlined_icon,
        label = "Home",
    ),
    BottomNavigationBarItem(
        selectedIcon = R.drawable.explore_filled_icon,
        unselectedIcon = R.drawable.explore_outlined_icon,
        label = "Explore",
    ),
    BottomNavigationBarItem(
        selectedIcon = R.drawable.mylist_filled_icon,
        unselectedIcon = R.drawable.mylist_outlined_icon,
        label = "My List",
    ),
    BottomNavigationBarItem(
        selectedIcon = R.drawable.download_filled_icon,
        unselectedIcon = R.drawable.download_outlined_icon,
        label = "Download",
    ),
    BottomNavigationBarItem(
        selectedIcon = R.drawable.profile_filled_icon,
        unselectedIcon = R.drawable.profile_outlined_icon,
        label = "Profile",
    ),
)