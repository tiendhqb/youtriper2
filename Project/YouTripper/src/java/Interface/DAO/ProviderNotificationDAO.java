/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.ProviderNotification;
import DTO.ProviderNotificationSetting;
import java.util.List;

/**
 *
 * @author DINH KHANG
 */
public interface ProviderNotificationDAO {
    public List<ProviderNotification> getProviderNotification();
    
    public List<ProviderNotificationSetting> getProviderNotificationSetting(int providerID);
    
    public void deleteSetting(int providerID);
    
    public boolean saveSetting(int providerID,int settingValue);    
    
}
