package com.example.beer.beer.domain.interactor;

import com.example.beer.beer.data.repository.MainRepositoryImpl;
import com.example.beer.beer.domain.model.BeerModel;
import com.example.beer.beer.domain.repository.MainRepository;

import io.reactivex.rxjava3.core.Single;

public class BeerInteractor {

    public BeerInteractor() {
        mRepository = new MainRepositoryImpl();
    }

    private final MainRepository mRepository;

    public Single<BeerModel> getBeer(int id) {
        return mRepository.getBeer(id);
    }
}
