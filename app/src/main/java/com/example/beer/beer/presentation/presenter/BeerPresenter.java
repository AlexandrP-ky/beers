package com.example.beer.beer.presentation.presenter;

import com.example.beer.beer.domain.interactor.BeerInteractor;
import com.example.beer.beer.presentation.view.BeerView;
import com.example.beer.beer.domain.model.BeerModel;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BeerPresenter {
    public BeerPresenter(BeerView beerView) {
        this.mBeerView = beerView;
        mBeerInteractor = new BeerInteractor();
    }

    private final BeerView mBeerView;
    private final BeerInteractor mBeerInteractor;

    public void getBeer(int id) {
        mBeerInteractor.getBeer(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<BeerModel>() {
                    @Override
                    public void onSuccess(@NonNull BeerModel beerModel) {
                        mBeerView.setData(beerModel);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        int a = 0;
                    }
                });
    }
}
