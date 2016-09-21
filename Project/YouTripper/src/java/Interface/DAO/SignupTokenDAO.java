/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.AccountSession;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author DINH KHANG
 */
public interface SignupTokenDAO {
    public String insertNewToken(String email, String referralToken) throws UnsupportedEncodingException;
    public AccountSession validateTokenForProvider(String token);
    
}
