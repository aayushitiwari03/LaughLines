package com.aayushi.laughlines.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aayushi.laughlines.model.Quote
import com.aayushi.laughlines.respo.QuoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class QuoteViewModel() : ViewModel()
{
    private val repository: QuoteRepository = QuoteRepository()

    private val _quote = mutableStateOf<List<Quote>>(emptyList())
    val quote: MutableState<List<Quote>> get() = _quote
    private var currentPage = 1

    suspend fun getRandomQuote() {
       try {
              val response = repository.getQuote()
                _quote.value = response
           Log.d("QuoteViewModel", "getRandomQuote: ${response[0].results}")
         } catch (e: Exception) {
              e.printStackTrace()
       }
    }

    suspend fun getAllQuotes(page: Int) {
        try {
           val response = repository.getAllQuotes(page)
            val result = response.results.map {
                Quote(
                    count = response.count,
                    lastItemIndex = response.lastItemIndex,
                    page = response.page,
                    results = response.results,
                    totalCount = response.totalCount,
                    totalPages = response.totalPages
                )
            }
            _quote.value += result
            currentPage++
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    suspend fun searchQuotes(query: String, page: Int) {
        try {
            _quote.value = repository.searchQuotes(query, page)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }




}