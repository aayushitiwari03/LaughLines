package com.aayushi.laughlines

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.aayushi.laughlines.navigation.BottomNavigationBar
import com.aayushi.laughlines.navigation.NavHostContainer
import com.aayushi.laughlines.screens.QuoteScreen
import com.aayushi.laughlines.ui.theme.LaughLinesTheme
import com.aayushi.laughlines.viewmodel.QuoteViewModel


class MainActivity : ComponentActivity() {
    private val viewModel : QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            LaughLinesTheme {
                val navController = rememberNavController()
                Surface(color = Color.DarkGray) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController)
                        }, content = { padding ->

                            NavHostContainer(navController = navController, paddingValues = padding)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun SplashScreen(){

}



