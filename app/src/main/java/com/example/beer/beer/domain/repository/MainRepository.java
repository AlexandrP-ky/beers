package com.example.beer.beer.domain.repository;

import com.example.beer.beer.domain.model.BeerModel;

import io.reactivex.rxjava3.core.Single;

public interface MainRepository {
    Single<BeerModel> getBeer(int id);
}
