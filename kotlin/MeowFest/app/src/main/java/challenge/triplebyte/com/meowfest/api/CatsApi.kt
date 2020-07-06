package challenge.triplebyte.com.meowfest.api

/**
 *
 *   Created by Dilip Maharjan on 15-07-2018
 */

import challenge.triplebyte.com.meowfest.model.Cats
import retrofit2.Call
import retrofit2.http.GET

interface CatsApi {
    @GET("/api/cats?page=0")
    fun cats(): Call<List<Cats>>

}