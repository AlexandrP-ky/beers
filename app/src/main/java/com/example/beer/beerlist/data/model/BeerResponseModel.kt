package com.example.beer.beerlist.data.model

import com.google.gson.annotations.SerializedName

data class BeerResponseModel(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String?,
        @SerializedName("image_url")
        val image_url: String?,
        @SerializedName("description")
        val description: String?
)