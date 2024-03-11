package com.aayushi.laughlines.navigation

import androidx.compose.material.icons.Icons
import com.aayushi.laughlines.R

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Quotes",
            icon = R.drawable.baseline_format_quote_24,
            route = "quotes"
        ),
        BottomNavItem(
            label = "Memes",
            icon = R.drawable.baseline_insert_emoticon_24,
            route = "memes"
        )
    )
}