package com.example.demo;

public class Review {
    public String UserID;
    public int Rating;
    public String Text_writing;
    public String Game_Title;


    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int rating) {
        Rating = rating;
    }

    public String getText_writing() {
        return Text_writing;
    }

    public void setText_writing(String text_writing) {
        Text_writing = text_writing;
    }

    public String getGame_Title() {
        return Game_Title;
    }

    public void setGame_Title(String game_Title) {
        Game_Title = game_Title;
    }
}
