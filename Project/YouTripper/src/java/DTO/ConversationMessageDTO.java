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
public class ConversationMessageDTO {

    private int messageID;
    private String userType;
    private String time;
    private String message;
    private int userID;
    private int conversationID;
    private String name;
    private String avatar;
    private boolean isRead;
    private int replyToTripperID;

    public ConversationMessageDTO(int messageID, String userType, String time, String message, int userID, int conversationID) {
        this.messageID = messageID;
        this.userType = userType;
        this.time = time;
        this.message = message;
        this.userID = userID;
        this.conversationID = conversationID;
    }

    public ConversationMessageDTO(String userType, String time, String message, int userID, int conversationID, boolean isRead) {
        this.userType = userType;
        this.time = time;
        this.message = message;
        this.userID = userID;
        this.conversationID = conversationID;
        this.isRead = isRead;
    }

    public ConversationMessageDTO(int messageID, String userType, String time, String message, int userID, int conversationID, String name, String avatar, boolean isRead) {
        this.messageID = messageID;
        this.userType = userType;
        this.time = time;
        this.message = message;
        this.userID = userID;
        this.conversationID = conversationID;
        this.name = name;
        this.avatar = avatar;
        this.isRead = isRead;
    }
        public ConversationMessageDTO(int messageID, String userType, String time, String message, int userID, int conversationID, String name, String avatar, boolean isRead,int replyToTripperID) {
        this.messageID = messageID;
        this.userType = userType;
        this.time = time;
        this.message = message;
        this.userID = userID;
        this.conversationID = conversationID;
        this.name = name;
        this.avatar = avatar;
        this.isRead = isRead;
        this.replyToTripperID = replyToTripperID;
    }

    public int getMessageID() {
        return messageID;
    }

    public String getUserType() {
        return userType;
    }

    public String getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public int getUserID() {
        return userID;
    }

    public int getConversationID() {
        return conversationID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setConversationID(int conversationID) {
        this.conversationID = conversationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
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

    public void setReplyToTripperID(int replyToTripperID) {
        this.replyToTripperID = replyToTripperID;
    }

    public int getReplyToTripperID() {
        return replyToTripperID;
    }

}
