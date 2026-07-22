package com.example.musicgram_.model;


public class Song {
    private String id;
    private String title;
    private Artist artist;
    private Album album;
    private int duration; // duración en segundos
    private String audioUrl;

    public Song () {
  // constructor vacio
    }

    public Song(String id, String title, Artist artist, Album album, int duration, String audioUrl) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.audioUrl = audioUrl;
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

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getAudioUrl() {
        return audioUrl;
    }
    public void setAudioUrl(String audioUrl){
        this.audioUrl = audioUrl;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", artist=" + artist +
                ", album=" + album +
                ", duration=" + duration +
                ", audioUrl='" + audioUrl + '\'' +
                '}';
    }
}
