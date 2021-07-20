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
        mView = beerListView;
        mBeerListInteractor = new BeerListInteractor();
    }

    private final BeerListView mView;
    private final BeerListInteractor mBeerListInteractor;

    public void getBeerList() {
        mBeerListInteractor.getBeerList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<List<BeerListModel>>() {
                    @Override
                    public void onSuccess(@NonNull List<BeerListModel> beerListModels) {
                        mView.setData(beerListModels);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
    }
}
