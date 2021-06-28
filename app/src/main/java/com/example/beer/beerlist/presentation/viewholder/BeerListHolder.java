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

    private TextView titleTextView;
    private ImageView beerLabelView;
    private Context ctx;

    public BeerListHolder(LayoutInflater inflater, ViewGroup parent, Context ctx) {
        super(inflater.inflate(R.layout.view_item_beerlist, parent, false));
        titleTextView = itemView.findViewById(R.id.beer_title);
        beerLabelView = itemView.findViewById(R.id.beer_list_imageView);
        this.ctx = ctx;
    }

    public void bind(BeerListModel beer, OnItemBeerClick onItemBeerClick) {
        itemView.setOnClickListener(v -> onItemBeerClick.onItemClick(beer));
        titleTextView.setText(beer.getName());
        Glide.with(ctx)
                .load(beer.getImageUrl())
                .into(beerLabelView);
    }
}
