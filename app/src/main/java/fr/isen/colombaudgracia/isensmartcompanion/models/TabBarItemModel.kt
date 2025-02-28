package fr.isen.colombaudgracia.isensmartcompanion.models

import androidx.compose.ui.graphics.vector.ImageVector

data class TabBarItemModel(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val badgeAmount: Int? = null
)
