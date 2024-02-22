package com.aayushi.laughlines.remote

import com.aayushi.laughlines.model.Quote
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

//    @GET("/quotes/random")
//    suspend fun getRandomQuote(): List<Quote>

    @GET("/quotes")
    suspend fun getAllQuotes(
        @Query("page") page: Int,
    ): Quote

//    @GET("/search/quotes")
//    suspend fun searchQuotes(
//        @Query("query") query: String,
//        @Query("page") page: Int,
//    ): List<Quote>

}