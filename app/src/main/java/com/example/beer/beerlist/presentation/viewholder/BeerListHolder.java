package com.example.beer.beerlist.presentation.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.beer.R;
import com.example.beer.beerlist.domain.model.BeerListModel;
import com.example.beer.beerlist.presentation.fragment.OnItemBeerClick;

public class BeerListHolder extends RecyclerView.ViewHolder {

    private final TextView mTitle;
    private final ImageView mIcon;
    private final Context mContext;

    public BeerListHolder(LayoutInflater inflater, ViewGroup parent, Context context) {
        super(inflater.inflate(R.layout.view_item_beerlist, parent, false));
        mTitle = itemView.findViewById(R.id.beer_title);
        mIcon = itemView.findViewById(R.id.beer_list_imageView);
        this.mContext = context;
    }

    public void bind(BeerListModel beer, OnItemBeerClick onItemBeerClick) {
        itemView.setOnClickListener(v -> onItemBeerClick.onItemClick(beer));
        mTitle.setText(beer.getName());
        Glide.with(mContext)
                .load(beer.getImageUrl())
                .into(mIcon);
    }
}
