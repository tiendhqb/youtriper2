/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.AccountSession;
import DTO.ProviderDTO;
import DTO.SalemanSession;
import Interface.Service.ErrorService;
import Interface.Service.SalesmanService;
import com.google.gson.Gson;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author QuangTran
 */
@Controller
@RequestMapping("/Salesman")
public class SalesmanController {
    @Autowired
    SalesmanService salesmanService;
    
    @Autowired
    ErrorService errorService;
    
    @RequestMapping()
    public String manageSales(ModelMap map, HttpServletRequest request) {
        try {
            if (request.getParameter("language") != null) {
                return "redirect:Salesman/ManageSales" +"?language=" + request.getParameter("language");
            } else {
                return "redirect:Salesman/ManageSales";
            }
            
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: SalesmanController - ,manageSales\n"
                    + "****Error****\n"
                    + "ModelMap:" + map + "\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }
    
    @RequestMapping(value = "/ManageSales")
    public String accountInfo(ModelMap map, HttpSession session) {
        try {
            SalemanSession account = (SalemanSession) session.getAttribute("account");
            List<ProviderDTO> result = salesmanService.getProviderlistBySalesmanId(account.getSalesmanId());
            Gson gson = new Gson();
            map.addAttribute("ProviderInfo", gson.toJson(result));
            map.addAttribute("page", "Manager");
            return "salesman/manageSalesman";
        } catch (Exception e) {
            String content = "Function: SalesmanController - management\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }
}
