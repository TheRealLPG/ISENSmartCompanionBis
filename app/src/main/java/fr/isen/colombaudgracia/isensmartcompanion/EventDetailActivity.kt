package fr.isen.colombaudgracia.isensmartcompanion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import fr.isen.colombaudgracia.isensmartcompanion.models.EventModel
import fr.isen.colombaudgracia.isensmartcompanion.screens.EventDetailScreen
import fr.isen.colombaudgracia.isensmartcompanion.ui.theme.ISENSmartCompanionTheme

class EventDetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val event = intent.getSerializableExtra(EVENT_EXTRA_KEY) as? EventModel

        enableEdgeToEdge()

        setContent {

            ISENSmartCompanionTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    if (event != null) {
                        EventDetailScreen(innerPadding, event)
                    }
                }
            }
        }
    }

    companion object {
        const val EVENT_EXTRA_KEY = "eventExtraKey"
    }
}