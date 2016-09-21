/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.Service;

import DTO.AccountSession;
import DTO.AdminSession;
import Interface.Service.ErrorService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

/**
 *
 * @author Nick
 */
public class ErrorServiceImpl implements ErrorService {

    private static final org.apache.log4j.Logger log = Logger.getLogger(ErrorServiceImpl.class);
    private final static DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:ss:mm");

    @Override
    public String logBug(String content, String sessionID) {
        Date currentDate = new Date();
        String dateStr = dateFormat.format(currentDate);
        String logContent = "---------- " + sessionID + " ----------\n";
        logContent += "TIME: " + dateStr + "\n"
                + content + "\n"
                + "---------- End ----------\n\n";
        log.error(logContent);
        return dateStr;
    }

    @Override
    public String logBugWithAccount(String content, HttpSession session, Exception e) {
        String stackTraceStr = "";
        StackTraceElement[] stackTraces = e.getStackTrace();
        for (StackTraceElement stackTrace : stackTraces) {
            stackTraceStr = stackTraceStr + System.lineSeparator() + stackTrace.toString();
        }
        Date currentDate = new Date();
        String dateStr = dateFormat.format(currentDate);
        String logContent = "---------- " + session.getId() + " ----------\n";
        String accountInfor = "***Account***\n";
        Object obj = session.getAttribute("account");
        if (obj != null) {
            if (obj instanceof AccountSession) {
                AccountSession account = (AccountSession) obj;
                accountInfor += "ID: " + account.getId() + "\n"
                        + "Role: " + account.getRole() + "\n";
            } else {
                AdminSession account = (AdminSession) obj;
                accountInfor += "ID: " + account.getAdminID() + "\n"
                        + "Role: " + account.getRole() + "\n";
            }
        } else {
            accountInfor += "Null\n";
        }
        accountInfor += "*********\n";
        logContent += accountInfor + "TIME: " + dateStr + "\n"
                + content + "\n"
                + "*** Stact Trace ***\n"
                + stackTraceStr
                + "\n**********\n"
                + "---------- End ----------\n\n";
        log.error(logContent);
        return dateStr;
    }

}
