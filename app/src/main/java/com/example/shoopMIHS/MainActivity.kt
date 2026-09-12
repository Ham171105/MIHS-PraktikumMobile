package com.example.shoopMIHS

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoopMIHS.ui.screen.BasicInfoScreen
import com.example.shoopMIHS.ui.screen.HubungiKamiScreen
import com.example.shoopMIHS.ui.theme.MIHSshoopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MIHSshoopTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    NavHost(
        navController = navController,
        startDestination = "basic_info"
    ) {
        composable("basic_info") {
            BasicInfoScreen(
                onNavigateToForm = {
                    navController.navigate("form_screen")
                }
            )
        }
        composable("form_screen") {
            HubungiKamiScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
