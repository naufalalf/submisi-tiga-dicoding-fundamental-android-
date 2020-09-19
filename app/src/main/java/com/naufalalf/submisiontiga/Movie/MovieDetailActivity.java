package com.naufalalf.submisiontiga.Movie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.naufalalf.submisiontiga.R;
import com.squareup.picasso.Picasso;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String KEY_MOVIE = "key";
    ImageView viegambardetail;
    TextView viewjuduldetail;
    TextView viewrilisdetail;
    TextView viewpopularitydetail;
    TextView viewoverviewdetail;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        viewjuduldetail = findViewById(R.id.tvjuduldetil);
        viewoverviewdetail = findViewById(R.id.sinopsis_detail);
        viewrilisdetail = findViewById(R.id.tv_rilis_detail);
        viegambardetail = findViewById(R.id.gambar_detil);
        viewpopularitydetail = findViewById(R.id.tv_rating_detail);
        progressBar = findViewById(R.id.progressDetailMovie);

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
                        MovieModel movieModel=getIntent().getParcelableExtra(KEY_MOVIE);

                        String urlimgmovie = "https://image.tmdb.org/t/p/w500" + movieModel.getPoster_path();
                        Picasso.get().load(urlimgmovie).placeholder(R.color.colorAccent).into(viegambardetail);
                        viewjuduldetail.setText(movieModel.getTitle());
                        viewoverviewdetail.setText(movieModel.getOverview());
                        viewpopularitydetail.setText(String.valueOf(movieModel.getPopularity()));
                        viewrilisdetail.setText(movieModel.getRelease_date());
                        viewoverviewdetail.setText(movieModel.getOverview());
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        }).start();
    }
}
