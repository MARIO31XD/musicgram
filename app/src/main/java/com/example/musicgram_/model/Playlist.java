package com.example.musicgram_.model;

import java.util.ArrayList;
public class Playlist {

    private String id;
    private String title;
    private String description;
    private User owner;  // creador y dueño de la PlayList
    private String coverImage; // Imagen de la PlayList
    private boolean isPublic; // si la PlayList es publica o privada

    private ArrayList<Song> songs; // una Playlist tiene varias Songs

    private ArrayList<Comment> comments;  // la PlayList puede tener una lista de comentarios

    private ArrayList<User> likes; // un User puede dar likes a las PlayList

    // Constructor donde iniciamos la lista de las canciones
    public Playlist() {
        songs = new ArrayList<>();
        comments = new ArrayList<>();
        likes = new ArrayList<>();

    }
    public Playlist(String id, String title, String description, User owner, String coverImage, boolean isPublic) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.coverImage = coverImage;
        this.isPublic = isPublic;

        songs = new ArrayList<>();
        comments = new ArrayList<>();
        likes = new ArrayList<>();


    }

    // getters and setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<User> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<User> likes) {
        this.likes = likes;
    }

    // ToString


    @Override
    public String toString() {
        return "Playlist{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                ", coverImage='" + coverImage + '\'' +
                ", isPublic=" + isPublic +
                ", songs=" + songs +
                ", comments=" + comments +
                ", likes=" + likes +
                '}';
    }
}
