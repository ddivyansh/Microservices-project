package com.example.moviecatalogservice.models;

public class Rating {
    int ratedValue;
    String movieId;

    public int getRatedValue() {
        return ratedValue;
    }

    public Rating(int ratedValue, String movieId) {
        this.ratedValue = ratedValue;
        this.movieId = movieId;
    }

    public void setRatedValue(int ratedValue) {
        this.ratedValue = ratedValue;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }
}
