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
public class AccountSession {
    private int id;
    private String name;
    private int role;
    private String image;
    private String token;
    private String email;
    
    public AccountSession() {
    }

    public AccountSession(int id, String name, int role, String image, String token, String email) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.image = image;
        this.token = token;
        this.email = email;
    }
    
    public AccountSession(int id, String name, int role, String image, String token) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.image = image;
        this.token = token;
    }

    public AccountSession(int id, String name, int role, String image) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
     
}