/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Service;

import DTO.ProviderDTO;
import DTO.SalemanSession;
import java.util.List;

/**
 *
 * @author QuangTran
 */
public interface SalesmanService {
    public SalemanSession loginToSalesmanAccount(String username, String password);
    
    public List<ProviderDTO> getProviderlistBySalesmanId(int salesmanId);
}
