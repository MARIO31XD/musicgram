package com.example.musicgram_.model;

import java.util.ArrayList;
public class Playlist {

    private String id;
    private String title;
    private String description;
    private User owner;  // creador y dueño de la PlayList

    private ArrayList<Song> songs; // una Playlist tiene varias Songs

    // Constructor donde iniciamos la lista de las canciones
    public Playlist() {
        songs = new ArrayList<>();

    }


}
