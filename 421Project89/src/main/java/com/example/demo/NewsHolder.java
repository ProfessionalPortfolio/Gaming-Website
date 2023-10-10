package com.example.demo;

//import java.time.LocalDateTime;

public class NewsHolder {
    public int ID;
    public String userName;
    public String messageBody;
    //private LocalDateTime timeStamp;

    public NewsHolder(int ID, String userName, String messageBody) {
        this.ID = ID;
        this.userName = userName;
        this.messageBody = messageBody;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

//    public LocalDateTime getTimeStamp() {
//        return timeStamp;
//    }
//
//    public void setTimeStamp(LocalDateTime timeStamp) {
//        this.timeStamp = timeStamp;
//    }
}
