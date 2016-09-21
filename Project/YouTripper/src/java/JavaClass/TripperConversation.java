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
public class TripperConversation {
    private String message;
private boolean isRead;
private String userType;
private int conversationID;
private String time;
private int packageID;
private int noOfUnreads;
private int tripperID;
private String packageName;
private boolean isTripperMarked;

    public TripperConversation(String message, boolean isRead, String userType, int conversationID, String time, int packageID, int noOfUnreads, int tripperID, String packageName, boolean isTripperMarked) {
        this.message = message;
        this.isRead = isRead;
        this.userType = userType;
        this.conversationID = conversationID;
        this.time = time;
        this.packageID = packageID;
        this.noOfUnreads = noOfUnreads;
        this.tripperID = tripperID;
        this.packageName = packageName;
        this.isTripperMarked = isTripperMarked;
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

    public int getTripperID() {
        return tripperID;
    }

    public void setTripperID(int tripperID) {
        this.tripperID = tripperID;
    }


    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public boolean isIsTripperMarked() {
        return isTripperMarked;
    }

    public void setIsTripperMarked(boolean isTripperMarked) {
        this.isTripperMarked = isTripperMarked;
    }



}
