package com.example.musicgram_.model;

public class Comment {

    private String id;
    private User user;
    private String text;

    public Comment() {
       // constructor vacio
    }

    public Comment(String id, User user, String text) {
        this.id = id;
        this.user = user;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", text='" + text + '\'' +
                '}';
    }
}
