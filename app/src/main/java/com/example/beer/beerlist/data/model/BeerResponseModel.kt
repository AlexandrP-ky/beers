package com.example.beer.beerlist.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BeerResponseModel(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String?,
        @Expose
        @SerializedName("image_url")
        val imageUrl: String?,
        @SerializedName("description")
        val description: String?
)