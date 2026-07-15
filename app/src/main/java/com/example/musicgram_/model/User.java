package com.example.musicgram_.model;

import java.util.ArrayList;  // Importamos la ArrayList porque el usuario tendrá una colección de Playlists.

// propiedades del usuario
public class User {

    private String id;
    private String username;
    private String email;
    private String password;
    private String biography;
    private String profileImage;
    private String bannerImage;  // imagen de fondo del profile?

    
    // Un User puede tener varias playlists
    private ArrayList<Playlist>playlists;  // ArrayList de las Playlists el USER puede tener varias playlists

    private ArrayList<User> following; // lista de usuarios following personas que sigo
    private ArrayList<User> followers; // lista de followers

}
