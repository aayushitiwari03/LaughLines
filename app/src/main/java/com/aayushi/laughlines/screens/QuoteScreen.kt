package com.aayushi.laughlines.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aayushi.laughlines.viewmodel.QuoteViewModel
import com.aayushi.laughlines.model.Result

@Composable
fun QuoteScreen(
    viewModel: QuoteViewModel
) {
    val quotes = viewModel.quote.value

    LaunchedEffect(key1 = true) {
        viewModel.getAllQuotes(page = 1)
    }


   Column(
       Modifier.background(Color.LightGray)
   ) {
       LazyColumn() {
              items(quotes.size) { index ->
                Quote(result = quotes[index].results[index])
              }
       }
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


@Composable
fun Quote(result: Result) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp,
        backgroundColor = Color.Gray
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = result.content,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "~ ${result.author}",
                    style = TextStyle(fontSize = 16.sp, fontStyle = FontStyle.Italic, color = Color.White)
                )
            }
        }
    }


}
