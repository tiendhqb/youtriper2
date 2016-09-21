/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.ForgotPasswordDTO;

/**
 *
 * @author DINH KHANG
 */
public interface ForgotPasswordDAO {
    public boolean insertNewToken(String token,String email);
    
    public ForgotPasswordDTO checkForgotPasswordToken(String token);
    
    public boolean resetPassword(String token,String password);
    
    public boolean deleteEmail(String token);
    
}
