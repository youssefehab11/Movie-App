package com.example.mova.ui.features.bottomnavigationbar.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomNavigationbarViewModel @Inject constructor(): ViewModel() {
    var selectedPage by mutableStateOf("Home")
        private set
    fun changeSelectedPage(currentPage: String){
        selectedPage = currentPage
    }
}