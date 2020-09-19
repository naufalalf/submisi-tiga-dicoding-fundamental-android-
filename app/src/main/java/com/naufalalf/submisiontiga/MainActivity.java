package com.naufalalf.submisiontiga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.naufalalf.submisiontiga.Movie.MovieFragment;
import com.naufalalf.submisiontiga.TVShow.TVShowFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private SlidingAdapter slidingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager  = findViewById(R.id.view_pager);
        slidingAdapter = new SlidingAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager);

        String tabdua = getString(R.string.tab2);
        String tabsatu = getString(R.string.tab1);

        slidingAdapter.addFrag(new MovieFragment(),tabsatu);
        slidingAdapter.addFrag(new TVShowFragment(), tabdua);
        viewPager.setAdapter(slidingAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.setingbahasa){
            Intent intent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
