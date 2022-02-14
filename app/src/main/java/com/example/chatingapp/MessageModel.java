package com.example.chatingapp;

public class MessageModel {

    String uId , Message;
    Long timeStamp;

    public MessageModel(String uId, String message, Long timeStamp) {
        this.uId = uId;
       this.Message = message;
        this.timeStamp = timeStamp;
    }

    public MessageModel(String uId, String message) {
        this.uId = uId;
        Message = message;
    }

    public MessageModel() {

    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
