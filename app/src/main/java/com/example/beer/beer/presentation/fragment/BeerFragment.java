package com.example.beer.beer.presentation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.beer.R;
import com.example.beer.beer.domain.model.BeerModel;
import com.example.beer.beer.presentation.presenter.BeerPresenter;
import com.example.beer.beer.presentation.view.BeerView;
import com.example.beer.main.MainActivity;

import org.jetbrains.annotations.NotNull;


public class BeerFragment extends Fragment implements BeerView {

    private static final String BEER_ID = "id";

    private TextView mTitle;
    private TextView mDescription;
    private ImageView mImage;
    private BeerPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new BeerPresenter(this);
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_beer, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTitle = view.findViewById(R.id.fragment_beer_title);
        mDescription = view.findViewById(R.id.fragment_beer_description);
        mImage = view.findViewById(R.id.fragment_beer_image);
        if (getArguments() != null) {
            int id = getArguments().getInt(BEER_ID, 0);
            mPresenter.getBeer(id);
        }
    }

    @Override
    public void setData(BeerModel beer) {
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(beer.getName());
        mTitle.setText(beer.getName());
        mDescription.setText(beer.getDescription());
        Glide.with(this)
                .applyDefaultRequestOptions(new RequestOptions().override(600, 600))
                .load(beer.getImageUrl())
                .into(mImage);
    }
}
