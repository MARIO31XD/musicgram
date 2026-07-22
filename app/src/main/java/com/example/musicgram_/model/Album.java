package com.example.musicgram_.model;

import java.util.ArrayList;

public class Album {
    private String id;
    private String title;
    private Artist artist; // Cada artista tiene al menos un Album.
    private String coverImage;
    private int releaseYear;  // año lanzamiento del album

    private ArrayList<Song> songs;  // un Album tiene muchas canciones



    // Constructors
    public Album () {

        songs = new ArrayList<>();
    }

    // GETTERS & SETTERS
    public Album(String id, String title, Artist artist, String coverImage, int releaseYear) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.coverImage = coverImage;
        this.releaseYear = releaseYear;


        songs = new ArrayList<>();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                ", coverImage='" + coverImage + '\'' +
                ", releaseYear=" + releaseYear +
                ", songs=" + songs +
                '}';
    }
}
