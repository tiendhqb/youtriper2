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
public class ConversationDTO {

    private int conversationID;
    private String time;
    private String ip;
    private int providerID;
    private int tripperID;
    private String providerName;
    private String tripperName;
    private String latestMessage;
    private String latestTime;
    private String providerImage;
    private String tripperImage;
    private int numOfUnreadMessage;
    private String packageName;
    private String packageImage;

    public ConversationDTO(int conversationID, String latestMessage, String latestTime, int numOfUnreadMessage, String packageName, String packageImage,String time) {
        this.conversationID = conversationID;
        this.latestMessage = latestMessage;
        this.latestTime = latestTime;
        this.numOfUnreadMessage = numOfUnreadMessage;
        this.packageName = packageName;
        this.packageImage = packageImage;
        this.time = time;
    }

    
    public ConversationDTO(int conversationID, String time, String ip, int providerID, int tripperID) {
        this.conversationID = conversationID;
        this.time = time;
        this.ip = ip;
        this.providerID = providerID;
        this.tripperID = tripperID;
    }

    public ConversationDTO(int conversationID, String time, String ip, int providerID, int tripperID, String providerName, String tripperName) {
        this.conversationID = conversationID;
        this.time = time;
        this.ip = ip;
        this.providerID = providerID;
        this.tripperID = tripperID;
        this.providerName = providerName;
        this.tripperName = tripperName;
    }

    public ConversationDTO(int conversationID, String time, String ip, int providerID, int tripperID, String providerName, String tripperName, String latestMessage) {
        this.conversationID = conversationID;
        this.time = time;
        this.ip = ip;
        this.providerID = providerID;
        this.tripperID = tripperID;
        this.providerName = providerName;
        this.tripperName = tripperName;
        this.latestMessage = latestMessage;

    }

    public ConversationDTO(int conversationID, String time, String ip, int providerID, int tripperID, String providerName, String tripperName, String latestMessage, String providerImage, String tripperImage, String latestTime, int numOfUnreadMessage) {
        this.conversationID = conversationID;
        this.time = time;
        this.ip = ip;
        this.providerID = providerID;
        this.tripperID = tripperID;
        this.providerName = providerName;
        this.tripperName = tripperName;
        this.latestMessage = latestMessage;
        this.providerImage = providerImage;
        this.tripperImage = tripperImage;
        this.latestTime = latestTime;
        this.numOfUnreadMessage = numOfUnreadMessage;
    }

    public int getConversationID() {
        return conversationID;
    }

    public String getTime() {
        return time;
    }

    public String getIp() {
        return ip;
    }

    public int getProviderID() {
        return providerID;
    }

    public int getTripperID() {
        return tripperID;
    }

    public void setConversationID(int conversationID) {
        this.conversationID = conversationID;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public void setTripperID(int tripperID) {
        this.tripperID = tripperID;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getTripperName() {
        return tripperName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public void setTripperName(String tripperName) {
        this.tripperName = tripperName;
    }

    public String getLatestMessage() {
        return latestMessage;
    }

    public void setLatestMessage(String latestMessage) {
        this.latestMessage = latestMessage;
    }

    public String getProviderImage() {
        return providerImage;
    }

    public String getTripperImage() {
        return tripperImage;
    }

    public void setProviderImage(String providerImage) {
        this.providerImage = providerImage;
    }

    public void setTripperImage(String tripperImage) {
        this.tripperImage = tripperImage;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public int getNumOfUnreadMessage() {
        return numOfUnreadMessage;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }

    public void setNumOfUnreadMessage(int numOfUnreadMessage) {
        this.numOfUnreadMessage = numOfUnreadMessage;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getPackageImage() {
        return packageImage;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setPackageImage(String packageImage) {
        this.packageImage = packageImage;
    }

}
