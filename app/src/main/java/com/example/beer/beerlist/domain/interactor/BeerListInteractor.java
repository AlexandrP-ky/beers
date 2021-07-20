package com.example.beer.beerlist.domain.interactor;

import com.example.beer.beerlist.data.repository.MainRepositoryImpl;
import com.example.beer.beerlist.domain.model.BeerListModel;
import com.example.beer.beerlist.domain.repository.MainRepository;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class BeerListInteractor {
    public BeerListInteractor() {
        mRepository = new MainRepositoryImpl();
    }

    private final MainRepository mRepository;

    public Single<List<BeerListModel>> getBeerList() {
        return mRepository.getBeerList();
    }
}
