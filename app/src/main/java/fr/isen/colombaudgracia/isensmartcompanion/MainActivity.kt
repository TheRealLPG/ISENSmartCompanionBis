package fr.isen.colombaudgracia.isensmartcompanion

import android.content.Intent
import android.os.Bundle
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
import fr.isen.colombaudgracia.isensmartcompanion.models.TabBarItemModel
import fr.isen.colombaudgracia.isensmartcompanion.screens.EventsScreen
import fr.isen.colombaudgracia.isensmartcompanion.screens.HistoryScreen
import fr.isen.colombaudgracia.isensmartcompanion.screens.MainScreen
import fr.isen.colombaudgracia.isensmartcompanion.screens.TabView
import fr.isen.colombaudgracia.isensmartcompanion.ui.theme.ISENSmartCompanionTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        fun startEventDetailActivity() {
            val intent = Intent(this, EventDetailActivity::class.java)
            startActivity(intent)
        }

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
                            EventsScreen(innerPadding, { startEventDetailActivity() })
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

