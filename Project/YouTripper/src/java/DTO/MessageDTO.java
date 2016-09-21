/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nick
 */
public class MessageDTO {

    private String content;
    private int userType;
    private int userID;
    private String name;
    private int isRead;


    public String getContent() {
        return content;
    }

    public int getUserType() {
        return userType;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public int getIsRead() {
        return isRead;
    }  
}
