/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.ProviderSystemNotificationDTO;
import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public interface ProviderSystemNotificationDAO {
    public boolean insertNewProviderSystemNotification(String content,boolean seen,int providerID);
    
    public List<ProviderSystemNotificationDTO> getProviderNewNotification(int providerID);
    
    public boolean seenNotification(int notificationID);
    
    public boolean seenMessage(int providerID);
}
