/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DINH KHANG
 */
public class BookingMessageDTO {

    private int messageID;
    private String userType;
    private String message;
    private String time;
    private int userID;
    private String bookID;
    private String name;
    private String avatar;
    private boolean isRead;

    public BookingMessageDTO() {
    }

    public BookingMessageDTO(int messageID, String userType, String message, String time, int userID, String bookID) {
        this.messageID = messageID;
        this.userType = userType;
        this.message = message;
        this.time = time;
        this.userID = userID;
        this.bookID = bookID;
    }

    public BookingMessageDTO(String userType, String message, String time, int userID, String bookID, boolean isRead) {
        this.userType = userType;
        this.message = message;
        this.time = time;
        this.userID = userID;
        this.bookID = bookID;
        this.isRead = isRead;
    }

    public BookingMessageDTO(int messageID, String userType, String message, String time, int userID, String bookID, String name, String avatar, boolean isRead) {
        this.messageID = messageID;
        this.userType = userType;
        this.message = message;
        this.time = time;
        this.userID = userID;
        this.bookID = bookID;
        this.name = name;
        this.avatar = avatar;
        this.isRead = isRead;
    }

    public int getMessageID() {
        return messageID;
    }

    public String getUserType() {
        return userType;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public int getUserID() {
        return userID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

}
