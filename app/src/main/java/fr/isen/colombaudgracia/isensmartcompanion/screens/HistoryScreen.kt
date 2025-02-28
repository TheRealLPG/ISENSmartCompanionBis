package fr.isen.colombaudgracia.isensmartcompanion.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HistoryScreen(innerPadding : PaddingValues) {

    // For now, is just a text to show that the screen switch is working
    Text(
        modifier = Modifier.padding(innerPadding),
        text = "HistoryScreen"
    )
}