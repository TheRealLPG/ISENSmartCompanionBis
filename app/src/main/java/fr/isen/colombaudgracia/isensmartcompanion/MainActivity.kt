package fr.isen.colombaudgracia.isensmartcompanion

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.isen.colombaudgracia.isensmartcompanion.api.NetworkManager
import fr.isen.colombaudgracia.isensmartcompanion.models.EventModel
import fr.isen.colombaudgracia.isensmartcompanion.models.TabBarItemModel
import fr.isen.colombaudgracia.isensmartcompanion.screens.EventsScreen
import fr.isen.colombaudgracia.isensmartcompanion.screens.HistoryScreen
import fr.isen.colombaudgracia.isensmartcompanion.screens.MainScreen
import fr.isen.colombaudgracia.isensmartcompanion.screens.TabView
import fr.isen.colombaudgracia.isensmartcompanion.ui.theme.ISENSmartCompanionTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        fun startEventDetailActivity(event: EventModel) {
            val intent = Intent(this, EventDetailActivity::class.java).apply {
                putExtra(EventDetailActivity.EVENT_EXTRA_KEY, event)
            }
            startActivity(intent)
        }

        fun fetchEvents() {
            val call = NetworkManager.api.getEvents()
            call.enqueue(object : Callback<List<EventModel>> {
                override fun onResponse(p0: Call<List<EventModel>>, p1: Response<List<EventModel>>) {
                    p1.body()?.forEach {
                        Log.d("request", "event : ${it.title}")
                    }
                }

                override fun onFailure(p0: Call<List<EventModel>>, p1: Throwable) {
                    Log.e("request", p1.message ?: "request failed")
                }
            })
        }

        fetchEvents()

        setContent {

            // setting up the individual tabs
            val homeTab = TabBarItemModel(title = "Home", selectedIcon = Icons.Filled.Home, unselectedIcon = Icons.Outlined.Home)
            val eventsTab = TabBarItemModel(title = "Events", selectedIcon = Icons.Filled.Notifications, unselectedIcon = Icons.Outlined.Notifications)
            val historyTab = TabBarItemModel(title = "History", selectedIcon = Icons.AutoMirrored.Filled.List, unselectedIcon = Icons.AutoMirrored.Outlined.List)

            // creating a list of all the tabs
            val tabBarItems = listOf(homeTab, eventsTab, historyTab)

            // creating our navController
            val navController = rememberNavController()

            ISENSmartCompanionTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { TabView(tabBarItems, navController) }
                ) { innerPadding ->
                    NavHost(navController = navController, startDestination = homeTab.title) {
                        composable(homeTab.title) {
                            MainScreen(innerPadding)
                        }
                        composable(eventsTab.title) {
                            EventsScreen(innerPadding) { event -> startEventDetailActivity(event) }
                        }
                        composable(historyTab.title) {
                            HistoryScreen(innerPadding)
                        }
                    }
                }
            }
        }
    }
}

