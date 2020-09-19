package com.naufalalf.submisiontiga.TVShow;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TVShowModel implements Parcelable {

    public String original_name;
    public List<Integer> genre_ids;
    public String name;
    public double popularity;
    public List<String> origin_country;
    public int vote_count;
    public String first_air_date;
    public String backdrop_path;
    public String original_language;
    public int id;
    public double vote_average;
    public String overview;
    public String poster_path;

    public TVShowModel() {
    }

    public static final Creator<TVShowModel> CREATOR = new Creator<TVShowModel>() {
        @Override
        public TVShowModel createFromParcel(Parcel source) {
            return new TVShowModel(source);
        }

        @Override
        public TVShowModel[] newArray(int size) {
            return new TVShowModel[size];
        }
    };

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public List<String> getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(List<String> origin_country) {
        this.origin_country = origin_country;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }


    public TVShowModel(JSONObject object) throws JSONException {
            String name = object.getString("name");
            String poster_path = object.getString("poster_path");
            String backdrop_path = object.getString("backdrop_path");
            String first_air_date = object.getString("first_air_date");
            Double popularity = object.getDouble("popularity");
            String overview = object.getString("overview");

            this.name=name;
            this.poster_path = poster_path;
            this.backdrop_path = backdrop_path;
            this.first_air_date=first_air_date;
            this.popularity=popularity;
            this.overview=overview;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.original_name);
        dest.writeList(this.genre_ids);
        dest.writeString(this.name);
        dest.writeDouble(this.popularity);
        dest.writeStringList(this.origin_country);
        dest.writeInt(this.vote_count);
        dest.writeString(this.first_air_date);
        dest.writeString(this.backdrop_path);
        dest.writeString(this.original_language);
        dest.writeInt(this.id);
        dest.writeDouble(this.vote_average);
        dest.writeString(this.overview);
        dest.writeString(this.poster_path);
    }

    protected TVShowModel(Parcel in) {
        this.original_name = in.readString();
        this.genre_ids = new ArrayList<Integer>();
        in.readList(this.genre_ids, Integer.class.getClassLoader());
        this.name = in.readString();
        this.popularity = in.readDouble();
        this.origin_country = in.createStringArrayList();
        this.vote_count = in.readInt();
        this.first_air_date = in.readString();
        this.backdrop_path = in.readString();
        this.original_language = in.readString();
        this.id = in.readInt();
        this.vote_average = in.readDouble();
        this.overview = in.readString();
        this.poster_path = in.readString();
    }
}
