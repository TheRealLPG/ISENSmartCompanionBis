package fr.isen.colombaudgracia.isensmartcompanion.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.isen.colombaudgracia.isensmartcompanion.R
import fr.isen.colombaudgracia.isensmartcompanion.models.EventModel
import fr.isen.colombaudgracia.isensmartcompanion.ui.theme.ISENSmartCompanionTheme

@Composable
fun EventDetailScreen(innerPadding : PaddingValues, event : EventModel) {

    // Current Context
    val context = LocalContext.current

    Column(modifier = Modifier.padding(innerPadding)) {

        // ISEN Logo Image
        Image(painterResource(R.drawable.isen_logo), context.getString(R.string.isen_logo))

        Text("")

        // Text displaying the title of the screen we are currently
        Text("EventDetailScreen")

        Text("")

        // Event information

        Text(event.title)

        Text("")

        Text(event.description)

        Text("")

        Text(event.location)

        Text("")

        Text(event.date)

        Text("")

        Text(event.category)

        Text("")

        Text(event.id)

    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailScreenPreview() {
    ISENSmartCompanionTheme {
        EventDetailScreen(PaddingValues(8.dp), EventModel.fakeEvents().first())
    }
}