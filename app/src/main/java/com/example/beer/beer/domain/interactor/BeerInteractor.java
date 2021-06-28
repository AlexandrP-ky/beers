package com.example.beer.beer.domain.interactor;

import com.example.beer.beer.data.repository.MainRepositoryImpl;
import com.example.beer.beer.domain.model.BeerModel;
import com.example.beer.beer.domain.repository.MainRepository;

import io.reactivex.rxjava3.core.Single;

public class BeerInteractor {

    public BeerInteractor() {
        repository = new MainRepositoryImpl();
    }

    private final MainRepository repository;

    public Single<BeerModel> getBeer(int id){return repository.getBeer(id);}
}
