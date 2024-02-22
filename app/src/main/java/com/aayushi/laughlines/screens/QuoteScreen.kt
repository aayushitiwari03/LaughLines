package com.aayushi.laughlines.screens

import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.aayushi.laughlines.model.Quote
import com.aayushi.laughlines.viewmodel.QuoteViewModel

@Composable
fun QuoteScreen(
    viewModel: QuoteViewModel
) {
    val quotes = viewModel.quote.value

    LaunchedEffect(key1 = true) {
        viewModel.getAllQuotes(page = 1)
    }


   Column(

   ) {
       Text(text = quotes.toString())
   }



    
}

@Composable
fun SearchQuote() {
    Card {
        Text("Search Quote")
    }
}

@Composable
fun RandomQuote() {
    Card {

    }
}

//@Composable
//fun Quote(quote: Result) {
//    Card {
//        Text(text = quote.author)
//        Text(text = quote.content)
//    }
//
//}
