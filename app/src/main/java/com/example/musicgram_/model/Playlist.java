package com.example.musicgram_.model;

import java.util.ArrayList;
public class Playlist {

    private String id;
    private String title;
    private String description;
    private User owner;  // creador y dueño de la PlayList

    private ArrayList<Song> songs; // una Playlist tiene varias Songs

    private ArrayList<Comment> comments;  // la PlayList puede tener una lista de comentarios

    private ArrayList<User> likes; // un User puede dar likes a las PlayList

    // Constructor donde iniciamos la lista de las canciones
    public Playlist() {
        songs = new ArrayList<>();

    }


}
