package com.naufalalf.submisiontiga.TVShow;

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

public class TVShowAdapter extends RecyclerView.Adapter<TVShowAdapter.ItemViewHolder> {

    private ArrayList<TVShowModel> dataTV = new ArrayList<>();

    public ArrayList<TVShowModel> getDataTV() {
        return dataTV;
    }

    public void  setDataTV(ArrayList<TVShowModel> item){
        dataTV.clear();
        dataTV.addAll(item);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public TVShowAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemtvshow,parent,false);
        return new TVShowAdapter.ItemViewHolder(root);

    }

    @Override
    public void onBindViewHolder(@NonNull TVShowAdapter.ItemViewHolder holder, int position) {
        TVShowModel tvShowModel = getDataTV().get(position);
        String urlimgtv = "https://image.tmdb.org/t/p/w185" + tvShowModel.getPoster_path();

        Picasso.get().load(urlimgtv).placeholder(R.color.colorAccent).into(holder.viegambar);
        holder.viewjudul.setText(tvShowModel.getName());
        holder.viewrilis.setText(tvShowModel.getFirst_air_date());
        holder.viewoverview.setText(tvShowModel.getOverview());
    }

    @Override
    public int getItemCount() {
        return dataTV.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView viegambar;
        private TextView viewjudul;
        private TextView viewrilis;
        private TextView viewoverview;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            viegambar = itemView.findViewById(R.id.gambarTV);
            viewjudul = itemView.findViewById(R.id.tvJudulTV);
            viewoverview = itemView.findViewById(R.id.tvOverviewTV);
            viewrilis = itemView.findViewById(R.id.tvRilisTV);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            TVShowModel tvShowModel = dataTV.get(position);
            tvShowModel.setName(tvShowModel.getName());
            tvShowModel.setOverview(tvShowModel.getOverview());

            Intent intentObj = new Intent(itemView.getContext(), TVShowDetailActivity.class);
            intentObj.putExtra(TVShowDetailActivity.KEY_TV,tvShowModel);
            itemView.getContext().startActivity(intentObj);
        }
    }
}
