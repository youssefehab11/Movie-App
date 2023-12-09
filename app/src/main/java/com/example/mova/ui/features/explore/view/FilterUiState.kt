package com.example.mova.ui.features.explore.view

data class FilterUiState(
    val category: String = "",
    val region: String = "",
    val genre: String = "",
    val time: String = "",
    val sort: String = "",
    val hasFilter: Boolean
)
