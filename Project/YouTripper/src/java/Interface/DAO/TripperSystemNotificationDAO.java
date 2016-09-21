/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.TripperSystemNotificationDTO;
import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public interface TripperSystemNotificationDAO {

    public boolean insertNewTripperSystemNotification(String content, boolean seen, int tripperID);

    public List<TripperSystemNotificationDTO> getTripperNewNotification(int tripperID);

    public boolean seenNotification(int notificationID);
    
    public boolean seenMessage(int tripperID);

}
