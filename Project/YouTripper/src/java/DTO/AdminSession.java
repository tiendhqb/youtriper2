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
public class AdminSession {

    private int adminID;
    private String name;    
    private int role;

    public AdminSession() {
        this.role = 3;
    }

    public AdminSession(int adminID, String name) {
        this.adminID = adminID;
        this.name = name;
        this.role = 3;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
    
    
}
