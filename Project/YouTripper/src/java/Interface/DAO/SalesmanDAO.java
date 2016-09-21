/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.DAO;

import DTO.ProviderDTO;
import DTO.SalemanSession;
import DTO.SalesmanDTO;
import java.util.List;

/**
 *
 * @author QuangTran
 */
public interface SalesmanDAO{
    
    public SalemanSession loginToSalesmanAccount(String username, String password);
    
    public List<ProviderDTO> getProviderlistBySalesmanId(int salesmanId);
    
    public List<SalesmanDTO> getSalesmanList();
    
    public int getSalesmanIdByPhoneNumber(String phonenumber);
}
