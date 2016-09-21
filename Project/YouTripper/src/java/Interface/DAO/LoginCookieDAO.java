/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.AccountSession;

/**
 *
 * @author DINH KHANG
 */
public interface LoginCookieDAO {
    public String insertNewToken(String username,String token);
    
    public AccountSession checkCookie(String token);
    
    public void deleteCookie(String token);
    
}
