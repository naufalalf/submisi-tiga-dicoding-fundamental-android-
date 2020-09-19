package com.naufalalf.submisiontiga.TVShow;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import cz.msebera.android.httpclient.Header;

public class TVShowViewModel extends ViewModel {

    private MutableLiveData<ArrayList<TVShowModel>> listTVShow= new MutableLiveData<>();

    public void setTVShowModel(String key){
        final ArrayList<TVShowModel> listTV = new ArrayList<>();
        String url_tv = "https://api.themoviedb.org/3/discover/tv?api_key=9c27169c02ca67824d823c653526bd3b&language=en-US";

        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url_tv, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject response = new JSONObject(result);
                    JSONArray daftar = response.getJSONArray("results");

                    for (int x=0;x<daftar.length(); x++){
                        JSONObject jsonObj = daftar.getJSONObject(x);
                        TVShowModel tvS = new TVShowModel(jsonObj);
                        listTV.add(tvS);
                    }
                    listTVShow.postValue(listTV);
                }catch (Exception e){
                    Log.d("Exception",e.getMessage());
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("gagal",error.getMessage());
            }
        });
    }
    public LiveData<ArrayList<TVShowModel>> getTVShowModel(){
        return listTVShow;
    }
}
