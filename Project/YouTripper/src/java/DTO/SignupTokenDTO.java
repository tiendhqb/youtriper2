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
public class SignupTokenDTO {
    private String email;
    private String token;
    private String expireTime;

    public SignupTokenDTO(String email, String token, String expireTime) {
        this.email = email;
        this.token = token;
        this.expireTime = expireTime;
    }

    public SignupTokenDTO(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }
    
}
