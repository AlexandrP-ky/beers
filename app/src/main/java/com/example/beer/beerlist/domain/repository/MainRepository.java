package com.example.beer.beerlist.domain.repository;

import com.example.beer.beerlist.domain.model.BeerListModel;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public interface MainRepository {
    Single<List<BeerListModel>> getBeerList();
}
