package com.aayushi.laughlines

import android.os.Bundle
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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
                QuoteScreen(
                    viewModel
                )
            }
        }
    }
}

@Composable
fun SplashScreen(){

}



