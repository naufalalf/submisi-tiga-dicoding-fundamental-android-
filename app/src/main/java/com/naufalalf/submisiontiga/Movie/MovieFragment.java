package com.naufalalf.submisiontiga.Movie;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;


import com.naufalalf.submisiontiga.R;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MovieFragment extends Fragment {

    MovieAdapter movieAdapter;
    ProgressBar progressBar;
    MovieViewModel movieViewModel;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        movieAdapter = new MovieAdapter();

        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        recyclerView = view.findViewById(R.id.rv_movie);
        loadRecyclerMovie();
    }

    private void loadRecyclerMovie(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(movieAdapter);

        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.getMovieModel().observe(getViewLifecycleOwner(),getFilm);
        movieViewModel.setMovieModel("KEY_MOVIE");
    }

    private final Observer<ArrayList<MovieModel>> getFilm = new Observer<ArrayList<MovieModel>>() {
        @Override
        public void onChanged(ArrayList<MovieModel> movieModels) {
            if (movieModels!=null){
                movieAdapter.setDataMovie(movieModels);
                movieAdapter.notifyDataSetChanged();
            }
            progressBar.setVisibility(View.GONE);
        }
    };

}
