/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaClass;

/**
 *
 * @author DINH KHANG
 */
public class ProviderConversation {
private String message;
private boolean isRead;
private String userType;
private int conversationID;
private String time;
private int packageID;
private int noOfUnreads;
private int providerID;
private String lastName;
private String packageName;
private boolean isProviderMarked;

    public ProviderConversation(String message, boolean isRead, String userType, int conversationID, String time, int packageID, int noOfUnreads, int providerID, String lastName, String packageName, boolean isProviderMarked) {
        this.message = message;
        this.isRead = isRead;
        this.userType = userType;
        this.conversationID = conversationID;
        this.time = time;
        this.packageID = packageID;
        this.noOfUnreads = noOfUnreads;
        this.providerID = providerID;
        this.lastName = lastName;
        this.packageName = packageName;
        this.isProviderMarked = isProviderMarked;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public int getConversationID() {
        return conversationID;
    }

    public void setConversationID(int conversationID) {
        this.conversationID = conversationID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public int getNoOfUnreads() {
        return noOfUnreads;
    }

    public void setNoOfUnreads(int noOfUnreads) {
        this.noOfUnreads = noOfUnreads;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public boolean isIsProviderMarked() {
        return isProviderMarked;
    }

    public void setIsProviderMarked(boolean isProviderMarked) {
        this.isProviderMarked = isProviderMarked;
    }



}