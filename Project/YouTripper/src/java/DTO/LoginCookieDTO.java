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
public class LoginCookieDTO {
    private String username;
    private String token;
    private String lastUsed;

    public LoginCookieDTO(String username, String token, String lastUsed) {
        this.username = username;
        this.token = token;
        this.lastUsed = lastUsed;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public String getLastUsed() {
        return lastUsed;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setLastUsed(String lastUsed) {
        this.lastUsed = lastUsed;
    }
    
}
