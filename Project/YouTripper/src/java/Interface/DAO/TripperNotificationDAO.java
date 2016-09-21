/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.TripperNotification;
import DTO.TripperNotificationSetting;
import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public interface TripperNotificationDAO {

    public List<TripperNotification> getTripperNotification();

    public List<TripperNotificationSetting> getTripperNotificationSetting(int tripperID);

    public void deleteSetting(int tripperID);

    public boolean saveSetting(int tripperID, int settingValue);
    
}
