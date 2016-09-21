/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.AdminSession;
import DTO.TemporaryPackageDTO;
import Interface.Service.AdminService;
import Interface.Service.ErrorService;
import Interface.Service.ProviderService;
import JavaClass.PackageApprovedEmailData;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Nick
 */
@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    ProviderService providerService;

    @Autowired
    ErrorService errorService;

    @RequestMapping()
    public String goToLoginPage(HttpSession session) {
        String result = "admin/adminLogin";
        if (session.getAttribute("account") != null) {
            result = "redirect:/Admin/SalesmanManagement";
        }
        return result;
    }

    @RequestMapping(value = "/CreatedPackage")
    public String getCreatedPackages(ModelMap map, HttpServletRequest request) {
        String result = "error";
        try {
            map.addAttribute("createdPackages", adminService.getCreatedTEmporaryPackage());
            map.addAttribute("page", "createdPackages");
            result = "admin/createdPackageManagement";
            return result;
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: AdminController - getCreatedPackages\n"
                    + "****Error****\n"
                    + "ModelMap:" + map + "\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/CreatedPassport")
    public String getCreatedPassports(ModelMap map, HttpServletRequest request) {
        String result = "error";
        try {
            map.addAttribute("createdPassports", adminService.getCreatedTEmporaryPassport());
            map.addAttribute("page", "createdPassports");
            result = "admin/createdPassportManagement";
            return result;
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: AdminController - getCreatedPackages\n"
                    + "****Error****\n"
                    + "ModelMap:" + map + "\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/CreatedPackagev2")
    public String getCreatedPackagesv2(ModelMap map, HttpServletRequest request) {
        String result = "error";
        try {
            map.addAttribute("createdPackages", adminService.getCreatedTEmporaryPackagev2());
            map.addAttribute("page", "createdPackages");
            result = "admin/createdPackageManagement";
            return result;
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: AdminController - getCreatedPackagesv2\n"
                    + "****Error****\n"
                    + "ModelMap:" + map + "\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/EditingPackages")
    public String getEditingPackages(ModelMap map) {
        String result = "error";
        try {
            map.addAttribute("editingPackages", adminService.getEditingPackages());
            result = "admin/editingPackages";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password,
            HttpSession session, HttpServletRequest request) {
        String result = "error";
        try {
            AdminSession admin = (AdminSession) session.getAttribute("account");
            if (admin == null) {
                admin = adminService.login(username, password);
                if (admin != null) {
                    session.setAttribute("account", admin);
                }
                result = "redirect:/Admin";
            }
            return result;
        } catch (Exception e) {
            String content = "Function: AdminController - login\n"
                    + "****Error****\n"
                    + "username:" + username + "\n"
                    + "password:" + password + "\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Logout", method = RequestMethod.GET)
    public String logout(HttpSession session, HttpServletRequest request) {
        try {
            if (session != null) {
                session.setAttribute("account", null);
            }
            return "forward:/Admin";
        } catch (Exception e) {
            String content = "Function: AdminController - logout\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/CreatedPackage/{packageID}", method = RequestMethod.GET)
    public String getTemporaryPackageByID(@PathVariable int packageID, ModelMap model, HttpServletRequest request) {
        try {
            model.addAttribute("temporaryPackage", providerService.getTemporaryPackageForPreviewing(packageID, false));
            return "admin/previewCreatedPackage";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: AdminController - getTemporaryPackageByID\n"
                    + "****Error****\n"
                    + "packageID:" + packageID + "\n"
                    + "model:" + model + "\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }

    }

    @RequestMapping(value = "/CreatedPackage/Approve/{packageID}", method = RequestMethod.GET)
    public String approveTemporaryPackage(@PathVariable int packageID, HttpServletRequest request) {
        try {
            adminService.insertKeywordToSystem(packageID);
            PackageApprovedEmailData emailData = adminService.getPackageApprovedEmailData(packageID);
            boolean approveResult = adminService.approveTemporaryPackage(packageID);
            if (approveResult) {
                adminService.sendPackageApprovedEmail(emailData);
            }
            return "forward:/Admin/CreatedPackage";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: AdminController - approveTemporaryPackage\n"
                    + "****Error****\n"
                    + "packageID:" + packageID + "\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/CreatedPackagev2/Approvev2/{packageID}", method = RequestMethod.GET)
    public String approveTemporaryPackagev2(@PathVariable int packageID, HttpServletRequest request) {
        try {
            adminService.insertKeywordToSystemv2(packageID);
            adminService.approveTemporaryPackagev2(packageID);
            return "forward:/Admin/CreatedPackagev2";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: AdminController - approveTemporaryPackagev2\n"
                    + "****Error****\n"
                    + "packageID:" + packageID + "\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Edition/{packageID}", method = RequestMethod.GET)
    public String editPackage(@PathVariable int packageID, ModelMap map) {
        try {
            TemporaryPackageDTO temporaryPackage = adminService.editPackage(packageID);
            // change to json
            Gson gson = new Gson();
            String temporaryPackageJSON = gson.toJson(temporaryPackage);
            map.addAttribute("temporaryPackage", temporaryPackageJSON);
//            map.addAttribute("packageForm", adminService.getPackageForm());
//            String[] coordinate = temporaryPackage.getCoordinates().split(",");
//            map.addAttribute("lat", coordinate[0]);
//            map.addAttribute("lng", coordinate[1]);
            return "admin/editForm";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    @RequestMapping(value = "/PaymentManagement")
    public String makePayment(HttpServletRequest request, HttpSession session) {
        AdminSession account = (AdminSession) session.getAttribute("account");

        try {
            String paymentList = adminService.getProviderPaymentList();
            request.setAttribute("page", "PaymentPage");
            request.setAttribute("paymentList", paymentList);
            return "admin/payment";

        } catch (Exception e) {
            String content = "Function: AdminController - makePayment\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ViewBookingDetail", method = RequestMethod.POST)
    public @ResponseBody
    String getBookingDetail(@RequestBody final String data, HttpServletRequest request) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
            int providerID = jsonObject.get("providerID").getAsInt();
            String result2 = adminService.viewBookingDetailByProviderID(providerID);
            return result2;
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: AdminController - getBookingDetail\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "error";
        }

    }

    @RequestMapping(value = "/Payout")
    public String payOut(HttpServletRequest request, HttpSession session) {
        AdminSession account = (AdminSession) session.getAttribute("account");
        try {
            boolean makePayout = adminService.payOut();
            if (makePayout) {
                return "admin/payOutSuccess";
            }
            return "redirect:/Admin/PaymentManagement";
        } catch (Exception e) {
            String content = "Function: AdminController - payOut\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ManageKeyword")
    public String viewKeyword(HttpServletRequest request, HttpSession session) {
        AdminSession account = (AdminSession) session.getAttribute("account");

        try {
            String keywordList = adminService.getKeywordCollection();
            request.setAttribute("page", "KeywordPage");
            request.setAttribute("keywordList", keywordList);
            if (request.getAttribute("message") != null) {
                request.setAttribute("message", request.getAttribute("message"));
            }
            return "admin/keyword";

        } catch (Exception e) {
            String content = "Function: AdminController - viewKeyword\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/AddKeyword/{keyword}/{times}")
    public String addKeyword(HttpServletRequest request, HttpSession session, @PathVariable String keyword, @PathVariable int times) {
        AdminSession account = (AdminSession) session.getAttribute("account");

        try {

            boolean result = adminService.insertNewSystemKeyword(keyword, times);
            if (result) {
                request.setAttribute("message", "keyword \"" + keyword + "\" was inserted to System Keyword");
            } else {
                request.setAttribute("message", "error happen");
            }
            return "forward:/Admin/ManageKeyword";

        } catch (Exception e) {
            String content = "Function: AdminController - addKeyword\n"
                    + "****Error****\n"
                    + "keyword:" + keyword + "\n"
                    + "times:" + times + "\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }

    }

    @RequestMapping(value = "/DeleteKeyword/{keyword}")
    public String deleteKeyword(HttpServletRequest request, HttpSession session, @PathVariable String keyword) {
        AdminSession account = (AdminSession) session.getAttribute("account");

        try {

            boolean result = adminService.deleteKeywordCollection(keyword);
            if (result) {
                request.setAttribute("message", "keyword \"" + keyword + "\" was deleted");
            } else {
                request.setAttribute("message", "error happen");
            }
            return "forward:/Admin/ManageKeyword";
        } catch (Exception e) {
            String content = "Function: AdminController - deleteKeyword\n"
                    + "****Error****\n"
                    + "keyword:" + keyword + "\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ProcessAllKeyword")
    public String processAllKeyword(HttpServletRequest request, HttpSession session) {
        AdminSession account = (AdminSession) session.getAttribute("account");
        try {

            String button = request.getParameter("submit");
            if (button.equals("Add All Keyword")) {
                boolean result = adminService.insertAllkeywordCollection();
                if (result) {
                    request.setAttribute("message", "All keyword was inserted to System keyword");
                } else {
                    request.setAttribute("message", "error happen");
                }
            } else if (button.equals("Delete All Keyword")) {
                boolean result = adminService.deleteAllKeywordCollection();
                if (result) {
                    request.setAttribute("message", "All keyword was deleted");
                } else {
                    request.setAttribute("message", "error happen");
                }
            }
            return "forward:/Admin/ManageKeyword";
        } catch (Exception e) {
            String content = "Function: AdminController - deleteKeyword\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/approveSubCategory/{temporaryPackageID}")
    public String approveSubCategory(HttpServletRequest request, HttpSession session, @PathVariable int temporaryPackageID) {
        AdminSession account = (AdminSession) session.getAttribute("account");
        try {

            if (account != null) {
                adminService.approveSubCategory(temporaryPackageID);
            }
            return "forward:/Admin/ManageKeyword";
        } catch (Exception e) {
            String content = "Function: AdminController - approveSubCategory\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SalesmanSignupPage")
    public String goToSalesmanSignupPage(HttpSession session, HttpServletRequest request) {
        try {
            return "admin/salesmanSignup";
        } catch (Exception e) {
            String content = "Function: AdminController - goToSalesmanSignupPage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SalesmanManagement")

    public String goToSalesmanManagePage(HttpSession session, ModelMap map, HttpServletRequest request) {
        try {
            map.addAttribute("Salesman", adminService.getSalesman());
            map.addAttribute("page", "SalesmanManagement");
            return "admin/managementSales";
        } catch (Exception e) {
            String content = "Function: AdminController - goToSalesmanManagePage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/LoadProviderWithSalesman")
    public @ResponseBody
    String getProviderListSalesman(@RequestBody final String data, HttpServletRequest request) {
        try {
            return adminService.getProviderListWithSalesman(data);
        } catch (Exception e) {
            String content = "Function: AdminController - getProviderListSalesman\n"
                    + "****Error****\n"
                    + e + "\n"
                    + data + "\n"
                    + "**********";
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SalesmanRegister", method = RequestMethod.POST)
    public String registerSalesman(HttpServletRequest request, HttpSession session) {
        try {
            String url = "admin/createSalesmanSuccess";
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phoneNumber");
            adminService.insertSalesman(email, firstName, lastName, phone);
            return url;
        } catch (Exception e) {
            String content = "Function: AdminController - registerSalesman\n"
                    + "***Input***\n"
                    + "captcha: " + request.getParameter("captcha") + "\n"
                    + "firstName: " + request.getParameter("firstName") + "\n"
                    + "lastName: " + request.getParameter("lastName") + "\n"
                    + "password: " + request.getParameter("password") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ManageCertificate")
    public String manageCertificate(ModelMap map, HttpServletRequest request) {
        String result = "error";
        try {
            map.addAttribute("Certificate", adminService.getCertificae());
            map.addAttribute("page", "Certificate");
            result = "admin/certificateManagement";
            return result;
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: AdminController - getAllCertificate\n"
                    + "****Error****\n"
                    + "ModelMap:" + map + "\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ApproveCertificate")
    public String approveCertificate(HttpServletRequest request, HttpSession session) {
        AdminSession account = (AdminSession) session.getAttribute("account");
        try {
            if (account != null) {
                String[] paramValues = request.getParameterValues("certificatesChecked");
                adminService.approveCertificate(paramValues);
            }
            return "redirect:/Admin/ManageCertificate";
        } catch (Exception e) {
            String content = "Function: AdminController - ApproveCertificate\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ApprovePassport")
    public String approvePassport(HttpServletRequest request, HttpSession session, @RequestBody final String data) {
        AdminSession account = (AdminSession) session.getAttribute("account");
        try {
            if (account != null) {
                adminService.approvePassport(data);
            }
            return "redirect:/Admin/CreatedPassport";
        } catch (Exception e) {
            String content = "Function: AdminController - ApprovePassport\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/checkMobileNumber", method = RequestMethod.POST)
    public @ResponseBody
    String checkMobileNumber(@RequestBody final String data, HttpServletRequest request) {
        try {
            if (adminService.checkPhoneNumberIsExist(data)) {
                return "{\"result\": \"fail\"}";
            }
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: AdminController - checkMobileNumber\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }
}
