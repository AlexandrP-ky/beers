package com.example.beer.beerlist.presentation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.beer.beerlist.domain.model.BeerListModel;
import com.example.beer.beerlist.presentation.fragment.OnItemBeerClick;
import com.example.beer.beerlist.presentation.viewholder.BeerListHolder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BeerListAdapter extends RecyclerView.Adapter<BeerListHolder> {

    private final List<BeerListModel> mBeers;
    private final Context mContext;
    private final OnItemBeerClick mOnClickListener;

    public BeerListAdapter(List<BeerListModel> beers, Context context, OnItemBeerClick onClickListener) {
        mBeers = beers;
        mOnClickListener = onClickListener;
        mContext = context;
    }

    @Override
    public BeerListHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return new BeerListHolder(layoutInflater, parent, mContext);
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
