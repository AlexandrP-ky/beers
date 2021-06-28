package com.example.beer.beer.data.api;

import com.example.beer.beerlist.data.model.BeerResponseModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BeerService {
    @GET("{id}")
    Single<List<BeerResponseModel>> getBeer(@Path("id") int id);
}
