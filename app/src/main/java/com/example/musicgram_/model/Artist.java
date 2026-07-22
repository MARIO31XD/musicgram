package com.example.musicgram_.model;


import java.util.ArrayList;

// propiedades del artista
public class Artist {
    private String id;
    private String name;
    private String biography;
    private String image;

    private ArrayList<Album> albums;
    private ArrayList<Song> songs;

    public Artist() {
        albums = new ArrayList<>();
        songs = new ArrayList<>();

    }

    public Artist(String id, String name, String biography, String image) {
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.image = image;

        albums = new ArrayList<>();
        songs = new ArrayList<>();
    }
    // GETTERS AND SETTERS
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<Album> albums) {
        this.albums = albums;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    // ToString
    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", biography='" + biography + '\'' +
                ", image='" + image + '\'' +
                ", albums=" + albums +
                ", songs=" + songs +
                '}';
    }
}
