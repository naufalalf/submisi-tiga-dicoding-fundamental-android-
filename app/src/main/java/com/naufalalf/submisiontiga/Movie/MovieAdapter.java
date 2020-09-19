package com.naufalalf.submisiontiga.Movie;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.naufalalf.submisiontiga.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ItemViewHolder> {
    private ArrayList<MovieModel> dataMovie = new ArrayList<>();

    public ArrayList<MovieModel> getDataMovie() {
        return dataMovie;
    }

    public void  setDataMovie(ArrayList<MovieModel> item){
        dataMovie.clear();
        dataMovie.addAll(item);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemmovie,parent,false);
        return new ItemViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ItemViewHolder holder, int position) {
        MovieModel movieModel=getDataMovie().get(position);
        String urlimgmovie = "https://image.tmdb.org/t/p/w185" + movieModel.getPoster_path();

        Picasso.get().load(urlimgmovie).placeholder(R.color.colorAccent).into(holder.viegambar);
        holder.viewjudul.setText(movieModel.getTitle());
        holder.viewrilis.setText(movieModel.getRelease_date());
        holder.viewoverview.setText(movieModel.getOverview());
    }

    @Override
    public int getItemCount() {
        return dataMovie.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView viegambar;
        private TextView viewjudul;
        private TextView viewrilis;
        private TextView viewoverview;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            viewjudul =  itemView.findViewById(R.id.tvJudulFilm);
            viewoverview = itemView.findViewById(R.id.tvOverviewFilm);
            viewrilis = itemView.findViewById(R.id.tvRilisFilm);
            viegambar = itemView.findViewById(R.id.gambarMovie);
            itemView.setOnClickListener(this);
        }

        public void bind(MovieModel movieModel) {

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            MovieModel movieModel = dataMovie.get(position);
            movieModel.setTitle(movieModel.getTitle());
            movieModel.setOverview(movieModel.getOverview());

            Intent intentObj = new Intent(itemView.getContext(),MovieDetailActivity.class);
            intentObj.putExtra(MovieDetailActivity.KEY_MOVIE,movieModel);
            itemView.getContext().startActivity(intentObj);
        }
    }
}
