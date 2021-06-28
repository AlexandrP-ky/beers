package com.example.beer.beerlist.presentation.view;

import com.example.beer.beerlist.domain.model.BeerListModel;

import java.util.List;

public interface BeerListView {
    void setData(List<BeerListModel> beers);
}
