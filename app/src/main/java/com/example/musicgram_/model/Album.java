package com.example.musicgram_.model;

import java.util.ArrayList;

public class Album {
    private String id;
    private String title;
    private Artist artist; // Cada artista tiene al menos un Album.
    private String coverImage;
    private int releaseYear;  // año lanzamiento del album

    private ArrayList<Song> songs;  // un Album tiene muchas canciones

}
