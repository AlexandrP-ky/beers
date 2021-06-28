package com.example.beer.beerlist.presentation.presenter;

import com.example.beer.beerlist.domain.interactor.BeerListInteractor;
import com.example.beer.beerlist.domain.model.BeerListModel;
import com.example.beer.beerlist.presentation.view.BeerListView;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BeerListPresenter {
    public BeerListPresenter(BeerListView beerListView) {
        this.beerListView = beerListView;
        beerListInteractor = new BeerListInteractor();
    }

    private final BeerListView beerListView;
    private final BeerListInteractor beerListInteractor;

    public void getBeerList() {
        beerListInteractor.getBeerList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<BeerListModel>>() {
                    @Override
                    public void onSuccess(@NonNull List<BeerListModel> beerListModels) {
                        beerListView.setData(beerListModels);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }
}
