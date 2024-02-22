package com.aayushi.laughlines.respo

import com.aayushi.laughlines.model.Quote
import com.aayushi.laughlines.remote.ApiService
import com.aayushi.laughlines.remote.RetrofitInstance
import kotlinx.coroutines.flow.Flow

class QuoteRepository(

) {
    private val api = RetrofitInstance.apiService

    //suspend fun getQuote() = api.getRandomQuote()
    suspend fun getAllQuotes(page: Int) : Quote{
        return api.getAllQuotes(page)
    }
//    suspend fun searchQuotes(query: String, page: Int) = api.searchQuotes(query, page)

}