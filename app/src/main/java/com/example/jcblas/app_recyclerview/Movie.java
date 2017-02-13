package com.example.jcblas.app_recyclerview;



public class Movie {
    public String name;
    public int poster;

    public Movie(int poster, String name) {
        this.poster = poster;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
