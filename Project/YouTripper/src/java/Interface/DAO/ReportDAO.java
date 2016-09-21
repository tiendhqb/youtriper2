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
public interface ReportDAO {
    public boolean reportProvider(int providerID,String report);
    
    public boolean reportTripper(int tripperID,String report);
}
