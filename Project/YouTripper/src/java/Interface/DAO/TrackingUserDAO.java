/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

/**
 *
 * @author DINH KHANG
 */
public interface TrackingUserDAO {
    public boolean logNewVisitor(int affiliateCode,String referrerURL,String ip,String device,String visitTime,String visitURL);
    
    public boolean existingUserLogin(String username,String role,String time,String ip);
}
