/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Service;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Nick
 */
public interface ErrorService {

    public String logBug(String content, String sessionID);

    public String logBugWithAccount(String content, HttpSession sessionID, Exception e);

}
