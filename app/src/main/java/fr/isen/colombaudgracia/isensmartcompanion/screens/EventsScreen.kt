package fr.isen.colombaudgracia.isensmartcompanion.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import fr.isen.colombaudgracia.isensmartcompanion.R
import fr.isen.colombaudgracia.isensmartcompanion.models.EventModel

@Composable
fun EventsScreen(innerPadding : PaddingValues, eventHandler : (EventModel) -> Unit) {

    // Current page
    val context = LocalContext.current

    // Fake events
    val events = EventModel.fakeEvents()

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
        // Disabled now
        /*
        Button(
            onClick = {eventHandler(event)},
            content = { Text("Open Event Detail") }
        )
        */

        // Dynamic Column to display the different events
        // For now it is only the fake events
        LazyColumn {
            items(events) { event ->
                EventRow(event, eventHandler)
            }
        }
    }
}

// Function to make the events clickable
@Composable fun EventRow(event: EventModel, eventHandler: (EventModel) -> Unit) {
    Card(modifier = Modifier
        .padding(16.dp)
        .clickable { eventHandler(event) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(event.title)
            Text(event.description)
        }
    }
}