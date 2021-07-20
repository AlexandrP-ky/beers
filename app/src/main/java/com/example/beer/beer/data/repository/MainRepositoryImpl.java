package com.example.beer.beer.data.repository;

import com.example.beer.beer.data.api.BeerService;
import com.example.beer.beer.domain.model.BeerModel;
import com.example.beer.beer.domain.repository.MainRepository;
import com.example.beer.beerlist.data.model.BeerResponseModel;
import com.example.beer.network.NetworkModule;

import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class MainRepositoryImpl implements MainRepository {

    private final BeerService mService;

    public MainRepositoryImpl() {
        mService = NetworkModule.getInstance().getRetrofit().create(BeerService.class);
    }

    @Override
    public Single<BeerModel> getBeer(int id) {
        return mService.getBeer(id).map(this::mapToBeerModel);
    }

    private BeerModel mapToBeerModel(List<BeerResponseModel> list) {
        BeerResponseModel responseModel = list.get(0);
        return new BeerModel(
                responseModel.getName(),
                responseModel.getImageUrl(),
                responseModel.getDescription()
        );
    }
}
