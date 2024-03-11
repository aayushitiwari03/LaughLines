package com.aayushi.laughlines.navigation

import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.aayushi.laughlines.screens.MemeScreen
import com.aayushi.laughlines.screens.QuoteScreen
import com.aayushi.laughlines.viewmodel.QuoteViewModel


@Composable
fun NavHostContainer(
    navController: NavHostController,
    paddingValues: PaddingValues
) {

    NavHost(
        navController = navController,
        startDestination = "quotes",

        modifier = Modifier.padding(paddingValues = paddingValues),

        builder = {
            composable("quotes") {
                QuoteScreen(viewModel = QuoteViewModel())
            }
            composable("memes") {
                MemeScreen()
            }
        }
    )
}

@Composable
fun BottomNavigationBar(
    navController: NavHostController
) {

    BottomNavigation(
        backgroundColor = androidx.compose.ui.graphics.Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        val currentRoute = navBackStackEntry?.destination?.route

        Constants.BottomNavItems.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route)
                },
                icon = {
                     Icon(
                         imageVector = ImageVector.vectorResource(id = item.icon),
                         contentDescription = item.label
                     )
                },
                label = {
                    androidx.compose.material.Text(text = item.label)
                },

                alwaysShowLabel = false
            )

        }
    }
}