package com.example.beer.beerlist.data.repository;

import com.example.beer.beerlist.data.api.BeerListService;
import com.example.beer.beerlist.data.model.BeerResponseModel;
import com.example.beer.beerlist.domain.model.BeerListModel;
import com.example.beer.beerlist.domain.repository.MainRepository;
import com.example.beer.network.NetworkModule;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

public class MainRepositoryImpl implements MainRepository {

    public MainRepositoryImpl() {
        service = NetworkModule.getInstance().getRetrofit().create(BeerListService.class);
    }

    private final BeerListService service;

    @Override
    public Single<List<BeerListModel>> getBeerList() {
        return service.getBeers()
                .map(this::mapToListBeerModel);
    }

    private List<BeerListModel> mapToListBeerModel(List<BeerResponseModel> models) {
        List<BeerListModel> list = new ArrayList<>();
        for (BeerResponseModel model : models) {
            list.add(mapToBeerModel(model));
        }
        return list;
    }

    private BeerListModel mapToBeerModel(BeerResponseModel model) {
        return new BeerListModel(model.getId(), model.getName(), model.getImage_url());
    }
}
