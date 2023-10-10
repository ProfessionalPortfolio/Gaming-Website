package com.example.demo;

import java.util.ArrayList;

public class ChatRoom {

    public String gamerTag;
    public String userMessage;
    public String[] listOfMessages;
    public ArrayList<User> chatters = new ArrayList();

    public ChatRoom(String gamerTag, String userMessage) {
        this.gamerTag = gamerTag;
        this.userMessage = userMessage;
    }


    public String[] getListOfMessages() {
        return listOfMessages;
    }

    public void setListOfMessages(String[] listOfMessages) {
        this.listOfMessages = listOfMessages;
    }

    public String getGamerTag() {
        return gamerTag;
    }

    public void setGamerTag(String gamerTag) {
        this.gamerTag = gamerTag;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

}
