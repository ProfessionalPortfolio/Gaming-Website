package com.example.demo;

import java.util.ArrayList;

import static com.sun.xml.internal.org.jvnet.fastinfoset.EncodingAlgorithmIndexes.UUID;

public class User {
    public String name;
    public int id;
    public String email;
    public String password;
    public ArrayList<Game> games = new ArrayList<Game>();
    public ArrayList<User> friends = new ArrayList();
    public String token;

    public User()
    {
        this.email = "";
        this.friends = null;
    }
    public User(String name, String email, String pw) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = pw;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public void setFriends(ArrayList<User> friends) {
        this.friends = friends;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
