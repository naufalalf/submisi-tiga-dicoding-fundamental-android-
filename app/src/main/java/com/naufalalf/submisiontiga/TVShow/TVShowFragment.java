package com.naufalalf.submisiontiga.TVShow;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.naufalalf.submisiontiga.R;

import java.util.ArrayList;


public class TVShowFragment extends Fragment {
     TVShowAdapter tvShowAdapter;
     ProgressBar progressBar;
     TVShowViewModel tvViewModel;
     RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvShowAdapter = new TVShowAdapter();

        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView = view.findViewById(R.id.rv_tvshow);
        loadRecyclerTV();
    }

    private void loadRecyclerTV(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(tvShowAdapter);

        tvViewModel = ViewModelProviders.of(this).get(TVShowViewModel.class);
        tvViewModel.getTVShowModel().observe(getViewLifecycleOwner(),getTV);
        tvViewModel.setTVShowModel("KEY_TV");
    }

    private Observer<ArrayList<TVShowModel>> getTV = new Observer<ArrayList<TVShowModel>>() {
        @Override
        public void onChanged(ArrayList<TVShowModel> tvShowModels ) {
            if (tvShowModels!=null){
                tvShowAdapter.setDataTV(tvShowModels);
                tvShowAdapter.notifyDataSetChanged();
            }
            progressBar.setVisibility(View.GONE);
        }
    };
}
