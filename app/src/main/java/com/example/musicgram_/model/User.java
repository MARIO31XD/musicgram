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
    private String bannerImage;  // imagen de portada de perfil

    
    // Un User puede tener varias playlists
    private ArrayList<Playlist>playlists;  // ArrayList de las Playlists el USER puede tener varias playlists

    private ArrayList<User> following; // lista de usuarios following personas que sigo
    private ArrayList<User> followers; // lista de followers


    // Constructor que inicializa las listas de playlists, following & followers.
    public User() {
        playlists = new ArrayList<>();
        following = new ArrayList<>();
        followers = new ArrayList<>();


    }

    // Constructor con los atributos y las listas
    public User(String id, String username, String email, String password, String biography, String profileImage, String bannerImage) {

        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.biography = biography;
        this.profileImage = profileImage;
        this.bannerImage = bannerImage;

        playlists = new ArrayList<>();
        following = new ArrayList<>();
        followers = new ArrayList<>();


    }

    // Getters & Setters de los atributos
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public void setBannerImage(String bannerImage) {
        this.bannerImage = bannerImage;
    }


    // GETTERS & SETTERS de las listas
    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public ArrayList<User> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    // ToString
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", biography='" + biography + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", bannerImage='" + bannerImage + '\'' +
                ", playlists=" + playlists +
                ", following=" + following +
                ", followers=" + followers +
                '}';
    }





}
