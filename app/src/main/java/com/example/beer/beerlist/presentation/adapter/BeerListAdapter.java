package com.example.beer.beerlist.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.beer.beerlist.domain.model.BeerListModel;
import com.example.beer.beerlist.presentation.fragment.OnItemBeerClick;
import com.example.beer.beerlist.presentation.viewholder.BeerListHolder;

import java.util.List;

public class BeerListAdapter extends RecyclerView.Adapter<BeerListHolder> {

    private final List<BeerListModel> mBeers;
    private final Context context;
    private OnItemBeerClick mOnClickListener;

    public BeerListAdapter(List<BeerListModel> beers, Context context, OnItemBeerClick onClickListener) {
        mBeers = beers;
        mOnClickListener = onClickListener;
        this.context = context;
    }

    @Override
    public BeerListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        return new BeerListHolder(layoutInflater, parent, context);
    }

    @Override
    public void onBindViewHolder(BeerListHolder holder, int position) {
        BeerListModel beer = mBeers.get(position);
        holder.bind(beer, mOnClickListener);

    }

    @Override
    public int getItemCount() {
        return mBeers.size();
    }
}
