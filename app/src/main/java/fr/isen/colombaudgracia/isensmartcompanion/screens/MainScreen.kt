package fr.isen.colombaudgracia.isensmartcompanion.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.isen.colombaudgracia.isensmartcompanion.ui.theme.ISENSmartCompanionTheme

@Composable
fun MainScreen(innerPadding : PaddingValues) {
    Text(modifier = Modifier.padding(innerPadding), text = "Hello")
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ISENSmartCompanionTheme {
        MainScreen(PaddingValues(8.dp))
    }
}