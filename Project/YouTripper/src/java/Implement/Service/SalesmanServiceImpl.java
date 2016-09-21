/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement.Service;

import DTO.ProviderDTO;
import DTO.SalemanSession;
import Interface.DAO.SalesmanDAO;
import Interface.Service.SalesmanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author QuangTran
 */
public class SalesmanServiceImpl implements SalesmanService {

    @Autowired
    SalesmanDAO salesmanDAO;

    @Override
    public SalemanSession loginToSalesmanAccount(String username, String password) {
        return salesmanDAO.loginToSalesmanAccount(username, password);
    }

    @Override
    public List<ProviderDTO> getProviderlistBySalesmanId(int salesmanId) {
        return salesmanDAO.getProviderlistBySalesmanId(salesmanId);
    }
    
    
}
