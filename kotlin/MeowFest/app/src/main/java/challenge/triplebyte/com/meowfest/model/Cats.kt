package challenge.triplebyte.com.meowfest.model

import com.google.gson.annotations.SerializedName

/**
 *
 *   Created by Dilip Maharjan on 15-07-2018
 */
data class Cats(
        @SerializedName("title") val title: String,
        @SerializedName("timestamp") val time: String,
        @SerializedName("image_url") val image: String,
        @SerializedName("description") val description: String)