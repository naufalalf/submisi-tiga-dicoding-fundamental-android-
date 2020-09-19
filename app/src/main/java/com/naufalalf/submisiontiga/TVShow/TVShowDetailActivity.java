package com.naufalalf.submisiontiga.TVShow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.naufalalf.submisiontiga.R;
import com.squareup.picasso.Picasso;

public class TVShowDetailActivity extends AppCompatActivity {

    public static final String KEY_TV ="key" ;
    ImageView viegambardetail;
    TextView viewjuduldetail;
    TextView viewrilisdetail;
    TextView viewpopularitydetail;
    TextView viewoverviewdetail;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvshow_detail);

        viewjuduldetail = findViewById(R.id.tvjuduldetilTV);
        viewoverviewdetail = findViewById(R.id.sinopsis_detailTV);
        viewrilisdetail = findViewById(R.id.tv_rilisTV_detail);
        viegambardetail = findViewById(R.id.gambar_detilTV);
        viewpopularitydetail = findViewById(R.id.tv_ratingTV_detail);
        progressBar = findViewById(R.id.progressDetailtv);

        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                }catch (Exception e){

                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        TVShowModel tvShowModel = getIntent().getParcelableExtra(KEY_TV);

                        String urlimgtv = "https://image.tmdb.org/t/p/w500" + tvShowModel.getPoster_path();
                        Picasso.get().load(urlimgtv).placeholder(R.color.colorAccent).into(viegambardetail);
                        viewjuduldetail.setText(tvShowModel.getName());
                        viewoverviewdetail.setText(tvShowModel.getOverview());
                        viewpopularitydetail.setText(String.valueOf(tvShowModel.getPopularity()));
                        viewrilisdetail.setText(tvShowModel.getFirst_air_date());
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        }).start();
    }
}
