package com.example.beer.beerlist.presentation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beer.R;
import com.example.beer.beerlist.domain.model.BeerListModel;
import com.example.beer.beerlist.presentation.adapter.BeerListAdapter;
import com.example.beer.beerlist.presentation.presenter.BeerListPresenter;
import com.example.beer.beerlist.presentation.view.BeerListView;
import com.example.beer.main.MainActivity;

import java.util.List;

public class BeerListFragment extends Fragment implements BeerListView {
    private static final String BEER_ID = "id";

    private RecyclerView BeerRecyclerView;
    private BeerListAdapter Adapter;
    private BeerListPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new BeerListPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_beer_list, container,
                false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BeerRecyclerView = view.findViewById(R.id.beer_recycler_view);
        BeerRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        presenter.getBeerList();
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.beer_list_lable));
    }

    @Override
    public void setData(List<BeerListModel> beers) {
        Adapter = new BeerListAdapter(beers, getContext(), beer -> {
            Bundle arg = new Bundle();
            arg.putInt(BEER_ID, beer.getId());
            navigateToBeerScreen(arg);
        });
        BeerRecyclerView.setAdapter(Adapter);
    }

    private void navigateToBeerScreen(Bundle arg) {
        if (getNavController() != null) {
            getNavController().navigate(R.id.beer_fragment, arg);
        }
    }

    private NavController getNavController() {
        NavHostFragment navHostFragment =
                (NavHostFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            return navHostFragment.getNavController();
        } else {
            return null;
        }
    }
}
