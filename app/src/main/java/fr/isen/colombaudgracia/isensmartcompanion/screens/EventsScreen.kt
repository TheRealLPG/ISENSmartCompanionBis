package fr.isen.colombaudgracia.isensmartcompanion.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import fr.isen.colombaudgracia.isensmartcompanion.R

@Composable
fun EventsScreen(innerPadding : PaddingValues, eventHandler : () -> Unit) {

    // Current page
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // ISEN Logo Image
        Image(painterResource(R.drawable.isen_logo), context.getString(R.string.isen_logo))

        Text("")

        // Text displaying the title of the screen we are currently
        Text(
            text = "EventsScreen\n"
        )

        // Temporary Button that starts the Event Detail Activity
        Button(
            onClick = eventHandler,
            content = { Text("Open Event Detail") }
        )
    }
}