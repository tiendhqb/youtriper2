/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.AccountSession;
import DTO.BookingStatistics;
import DTO.CountryDTO;
import DTO.PackageDTO;
import DTO.ProviderDTO;
import DTO.ProviderNotification;
import DTO.ProviderNotificationSetting;
import DTO.CertificatesViewDTO;
import DTO.TemporaryPackageDTO;
import Interface.Service.CommonService;
import Interface.Service.ErrorService;
import Interface.Service.MessageService;
import Interface.Service.ProviderService;
import Interface.Service.TripperService;
import JavaClass.FileMeta;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Nick
 */
@Controller
@RequestMapping("/Provider")
public class ProviderController {

    private static final String accountInfoUrl = "provider/accountInfo";

    @Autowired
    ProviderService providerService;

    @Autowired
    CommonService commonService;

    @Autowired
    MessageService messageService;

    @Autowired
    TripperService tripperService;

    @Autowired
    ErrorService errorService;

    @Autowired
    private SimpMessagingTemplate template;

    @RequestMapping()
    public String goToProviderPage(HttpServletRequest request) {
        try {
            if (request.getParameter("language") != null) {
                return "redirect:/Provider/AccountInfo" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/Provider/AccountInfo";
            }

        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: ProviderController - goToProviderPage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package", method = RequestMethod.GET)
    public String getAllProviderPackages(ModelMap map, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            map.addAttribute("packages", providerService.getPackagesOfProvider(account.getId()));
            map.addAttribute("page", "providerPackage");
            return "provider/providerPackage";
        } catch (Exception e) {
            String content = "Function: ProviderController - getAllProviderPackages\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/CertificateManagement", method = RequestMethod.GET)
    public String getAllProviderCertificates(ModelMap map, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            map.addAttribute("certificates", providerService.getCertificatesOfProvider(account.getId()));
            map.addAttribute("page", "providerCertificate");
            return "provider/providerCertificate";
        } catch (Exception e) {
            String content = "Function: ProviderController - getAllProviderCertificates\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/PassportManagement")
    public String accountInfo2(ModelMap map, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            ProviderDTO result = providerService.getAccountInfo(account.getId());
            Gson gson = new Gson();
            map.addAttribute("AccountInfo", gson.toJson(result));
            map.addAttribute("page", "Info");
            return "provider/providerPassport";
        } catch (Exception e) {
            String content = "Function: ProviderController - accountInfo\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Chat", method = RequestMethod.GET)
    public String gotoChat(HttpServletRequest request, ModelMap map) {
        try {
            HttpSession session = request.getSession();
            request.setAttribute("page", "providerMessage");
            String conversationList = "";
            String packageList = "";
            AccountSession account = (AccountSession) session.getAttribute("account");
            packageList = providerService.getPackageForChat(account.getId());
            conversationList = messageService.providerLoadConversationList(account.getId());

            request.setAttribute("conversationList", conversationList);
            request.setAttribute("packageList", packageList);
            return "provider/chat";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: ProviderController - gotoChat\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Creation", method = RequestMethod.GET)
    public String createPackage(ModelMap model, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            boolean checkPhone = providerService.checkValidatePhoneNumber(account.getId());
            if (checkPhone) {
                TemporaryPackageDTO temporaryPackage = providerService.getTemporaryPackage(account.getId());
                if (!temporaryPackage.isIsFinshed()) {
                    // get content of creation form
                    String packageFormJSON = providerService.getPackageForm(account.getId());

                    // change to json
                    Gson gson = new Gson();
                    String temporaryPackageJSON = gson.toJson(temporaryPackage);
                    // set attribute
                    String mac = commonService.getGeolocation();

                    model.addAttribute("temporaryPackage", temporaryPackageJSON);
                    model.addAttribute("packageForm", packageFormJSON);
                    model.addAttribute("macAddress", mac);

//                    return "provider/createForm";
                    return "provider/packageCreation";
                } else {
                    return "provider/apply";
                }
            } else {
                model.addAttribute("error", "You need verify your Phone number before create package!");
                return "forward:/Provider/Verify";
            }
        } catch (Exception e) {
            String content = "Function: ProviderController - createPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Registration", method = RequestMethod.GET)
    public String registerPackage(ModelMap model, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            boolean checkPhone = providerService.checkValidatePhoneNumber(account.getId());
            if (checkPhone) {
                TemporaryPackageDTO temporaryPackage = providerService.getTemporaryPackage(account.getId());
                if (!temporaryPackage.isIsFinshed()) {
                    // get content of creation form
                    String packageFormJSON = providerService.getPackageForm(account.getId());

                    // change to json
                    Gson gson = new Gson();
                    String temporaryPackageJSON = gson.toJson(temporaryPackage);
                    // set attribute
                    String mac = commonService.getGeolocation();

                    model.addAttribute("temporaryPackage", temporaryPackageJSON);
                    model.addAttribute("packageForm", packageFormJSON);
                    model.addAttribute("macAddress", mac);

                    String timeNow = new DateTime().toString("MM/dd/yyyy");
                    model.addAttribute("timeNow", timeNow);
//                    return "provider/createForm";
                    return "provider/PackageRegistration";
                } else {
                    return "provider/apply";
                }
            } else {
                model.addAttribute("error", "You need verify your Phone number before create package!");
                return "forward:/Provider/Verify";
            }
        } catch (Exception e) {
            String content = "Function: ProviderController - registerPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Registration", method = RequestMethod.POST)
    public String CloneRegisterPackage(ModelMap model, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            boolean checkPhone = providerService.checkValidatePhoneNumber(account.getId());
            if (checkPhone) {
                TemporaryPackageDTO temporaryPackage = providerService.getTemporaryPackage(account.getId());
                if (!temporaryPackage.isIsFinshed()) {
                    // get content of creation form
                    String packageFormJSON = providerService.getPackageForm(account.getId());

                    // change to json
                    Gson gson = new Gson();
                    String temporaryPackageJSON = gson.toJson(temporaryPackage);
                    // set attribute
                    String mac = commonService.getGeolocation();

                    model.addAttribute("temporaryPackage", temporaryPackageJSON);
                    model.addAttribute("packageForm", packageFormJSON);
                    model.addAttribute("macAddress", mac);

                    String timeNow = new DateTime().toString("MM/dd/yyyy");
                    model.addAttribute("timeNow", timeNow);
//                    return "provider/createForm";
                    return "provider/PackageRegistration";
                } else {
                    return "provider/apply";
                }
            } else {
                model.addAttribute("error", "You need verify your Phone number before create package!");
                return "forward:/Provider/Verify";
            }
        } catch (Exception e) {
            String content = "Function: ProviderController - registerPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Editing/{packageID}", method = RequestMethod.GET)
    public String editPackage(ModelMap model, HttpSession session, @PathVariable int packageID) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            PackageDTO packageDTO = providerService.getPackage(packageID);

            if (packageDTO.getProviderID() == account.getId()) {
                String packageFormJSON = providerService.getPackageFormForEdit(account.getId());
                // change to json
                Gson gson = new Gson();
                String packageJSON = gson.toJson(packageDTO);
                // set attribute
                String mac = commonService.getGeolocation();
                model.addAttribute("packageEdit", packageJSON);
                model.addAttribute("packageForm", packageFormJSON);
                model.addAttribute("macAddress", mac);

                String timeNow = new DateTime().toString("MM/dd/yyyy");
                model.addAttribute("timeNow", timeNow);
                return "provider/editPage";

            } else {
                return "forward:/Common/Error";
            }

        } catch (Exception e) {
            String content = "Function: ProviderController - editPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Stopping", method = RequestMethod.POST)
    public @ResponseBody
    String stopPackage(ModelMap model, HttpSession session, @RequestBody final String data) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            providerService.stopPackage(data, account.getId());
            return "{\"result\": \"OK\"}";

        } catch (Exception e) {
            String content = "Function: ProviderController - editPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Starting", method = RequestMethod.POST)
    public @ResponseBody
    String startPackage(ModelMap model, HttpSession session, @RequestBody final String data) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            providerService.startPackage(data, account.getId());
            return "{\"result\": \"OK\"}";

        } catch (Exception e) {
            String content = "Function: ProviderController - editPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Deleting", method = RequestMethod.POST)
    public @ResponseBody
    String deletePackage(ModelMap model, HttpSession session, @RequestBody final String data) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            providerService.deletePackage(data, account.getId());
            return "{\"result\": \"OK\"}";

        } catch (Exception e) {
            String content = "Function: ProviderController - Deleting\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/DeletingTempPackage", method = RequestMethod.POST)
    public @ResponseBody
    String deleteTemporaryPackage(ModelMap model, HttpSession session, @RequestBody final String data) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            providerService.deleteTemporaryPackage(data, account.getId());
            return "{\"result\": \"OK\"}";

        } catch (Exception e) {
            String content = "Function: ProviderController - DeletingTempPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/CheckExistBooking", method = RequestMethod.POST)
    public @ResponseBody
    String checkBooking(ModelMap model, HttpSession session, @RequestBody final String data) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            if (!providerService.checkExistBooking(data, account.getId())) {
                return "{\"result\": \"OK\"}";
            } else {
                return "{\"result\": \"False\"}";
            }

        } catch (Exception e) {
            String content = "Function: ProviderController - editPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Deletion/{packageID}", method = RequestMethod.GET)
    public String deletePackage(ModelMap model, HttpSession session, @PathVariable int packageID) {
        try {
            boolean result = providerService.deletePackage(packageID);
            AccountSession account = (AccountSession) session.getAttribute("account");
            model.addAttribute("packages", providerService.getPackagesOfProvider(account.getId()));
            model.addAttribute("page", "providerPackage");
            if (result) {
                model.addAttribute("message", "Delete Package Successfully");
            } else {
                model.addAttribute("message", "You can not delete package which contain active booking");
            }
            return "provider/providerPackage";

        } catch (Exception e) {
            String content = "Function: ProviderController - deletePackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Apply/{packageID}", method = RequestMethod.GET)
    public String applyTempPackageToPreview(@PathVariable int packageID, ModelMap model, HttpSession session, HttpServletRequest request) {
        try {
            System.out.println("GETsssss");
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            boolean isRedirectToMyPacakges = !providerService.applyTempPackageToPreview(packageID, providerID);
            if (isRedirectToMyPacakges) {
                if (request.getParameter("language") != null) {
                    return "redirect:/Provider/Package" + "?language=" + request.getParameter("language");
                } else {
                    return "redirect:/Provider/Package";
                }

            } else if (request.getParameter("language") != null) {
                return "provider/apply" + "?language=" + request.getParameter("language");
            } else {
                return "provider/apply";
            }
        } catch (Exception e) {
            String content = "Function: ProviderController - applyTempPackageToPreview\n"
                    + "***Input***\n"
                    + "packageID: " + packageID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Apply", method = RequestMethod.POST)
    public String applyTempPackageToAprove(HttpServletRequest request, ModelMap model, HttpSession session) {
        try {
            System.out.println("sssss");
            String packageIDStr = request.getParameter("packageID");
            int packageID = Integer.parseInt(packageIDStr);
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            boolean isRedirectToMyPacakges = !providerService.applyTempPackageToPreview(packageID, providerID);
            if (isRedirectToMyPacakges) {
                if (request.getParameter("language") != null) {
                    return "redirect:/Provider/Package" + "?language=" + request.getParameter("language");
                } else {
                    return "redirect:/Provider/Package";
                }

            } else if (request.getParameter("language") != null) {
                return "provider/apply" + "?language=" + request.getParameter("language");
            } else {
                return "provider/apply";
            }
        } catch (Exception e) {
            String content = "Function: ProviderController - applyTempPackageToAprove\n"
                    + "***Input***\n"
                    + "packageID: " + request.getParameter("packageID") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Applyv2/{packageID}", method = RequestMethod.GET)
    public String applyTempPackageToPreviewv2(@PathVariable int packageID, ModelMap model, HttpSession session) {
        try {
            if (!providerService.applyTempPackageToPreviewv2(packageID)) {
                return "{\"result\": \"error\"}";
            }
            return "provider/apply";
        } catch (Exception e) {
            String content = "Function: ProviderController - applyTempPackageToPreviewv2\n"
                    + "***Input***\n"
                    + "packageID: " + packageID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Keywords", method = RequestMethod.POST)
    public @ResponseBody
    String getTags(@RequestBody final String data, HttpSession session) {
        try {
            List<String> keywords = providerService.getKeywords(data);
            Gson gson = new Gson();
            String result = gson.toJson(keywords);
            return result;
        } catch (Exception e) {
            String content = "Function: ProviderController - getTags\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }

    }

    @RequestMapping(value = "/Package/PreView/{packageID}", method = RequestMethod.GET)
    public String goToPreview(@PathVariable("packageID") int packageID, HttpSession session, ModelMap model) {
        try {
            String reportType = commonService.getReportType();
            String json = providerService.getTemporaryPackageForPreviewing(packageID, true);
            model.addAttribute("ReportType", reportType);

            // if temporary package data is not correct
            if (json.equals("fail")) {
                return "forward:/Provider/Package/Creation/";
            } else {
                model.addAttribute("isFinished", true);
                model.addAttribute("packageDTO", json);
                model.addAttribute("toDate", commonService.getToDateUnderFormatMMddyyyy());
                return "provider/packagePreview";
            }
        } catch (Exception e) {
            String content = "Function: ProviderController - goToPreview\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/PreViewv2/{packageID}", method = RequestMethod.GET)
    public String goToPreviewv2(@PathVariable("packageID") int packageID, HttpSession session, ModelMap model) {
        try {
            String reportType = commonService.getReportType();
            String json = providerService.getTemporaryPackageForPreviewingv2(packageID, true);
            model.addAttribute("ReportType", reportType);
            // if temporary package data is not correct
            if (json.equals("fail")) {
                return "forward:/Provider/Package/Creation/";
            } else {
                model.addAttribute("temporaryPackage", json);
                return "provider/previewPagev2";
            }
        } catch (Exception e) {
            String content = "Function: ProviderController - goToPreviewv2\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/PreView", method = RequestMethod.POST)
    public String getPackagePreview(HttpServletRequest request, HttpSession session, ModelMap model) {
        try {
            String packageIDStr = request.getParameter("packageID");
            int packageID = Integer.parseInt(packageIDStr);
            System.out.println("tien");
            String reportType = commonService.getReportType();
            String json = providerService.getTemporaryPackageForPreviewing(packageID, false);
            model.addAttribute("packageDTO", json);
            model.addAttribute("ReportType", reportType);
            model.addAttribute("isFinished", false);
            model.addAttribute("toDate", commonService.getToDateUnderFormatMMddyyyy());
            return "provider/packagePreview";
        } catch (Exception e) {
            String content = "Function: ProviderController - getPackagePreview tien\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/PreView/{packageID}", method = RequestMethod.POST)
    public String getPackagePreviewPage(@PathVariable("packageID") int packageID, HttpSession session, ModelMap model) {
        try {
            String reportType = commonService.getReportType();
            String json = providerService.getTemporaryPackageForPreviewing(packageID, false);
            model.addAttribute("packageDTO", json);
            model.addAttribute("ReportType", reportType);
            model.addAttribute("isFinished", false);
            model.addAttribute("toDate", commonService.getToDateUnderFormatMMddyyyy());
            return "provider/packagePreview";
        } catch (Exception e) {
            String content = "Function: ProviderController - getPackagePreviewPage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/saveActivities", method = RequestMethod.POST)
    public @ResponseBody
    String saveActivities(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            providerService.insertActivityForm(data, providerID);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - saveActivities\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/editActivities", method = RequestMethod.POST)
    public @ResponseBody
    String editActivities(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            providerService.editActivityForm(data, providerID);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - editActivities\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/editDescription", method = RequestMethod.POST)
    public @ResponseBody
    String editDescription(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            providerService.updateDescriptionFormOfPackage(data, providerID);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - editDescription\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/saveDescription", method = RequestMethod.POST)
    public @ResponseBody
    String saveDescription(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            providerService.updateDescriptionFormOfTempPackage(data, providerID);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - saveDescription\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/saveBookingRegistration", method = RequestMethod.POST)
    public @ResponseBody
    String saveBookingRegistration(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            providerService.updateBookingRegistrationFom(data, providerID);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - saveBookingRegistration\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/editBookingRegistration", method = RequestMethod.POST)
    public @ResponseBody
    String editBookingRegistration(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            providerService.updateBookingOfMainPackage(data, providerID);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - editBookingRegistration\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/saveExtra", method = RequestMethod.POST)
    public @ResponseBody
    String saveExtra(@RequestBody final String data, HttpSession session) {
        try {
            providerService.updateExtrasOfTempPackage(data);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - saveExtra\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/saveExtrav2", method = RequestMethod.POST)
    public @ResponseBody
    String saveExtrav2(@RequestBody final String data, HttpSession session) {
        try {
            providerService.updateExtrasOfTempPackagev2(data);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - saveExtrav2\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/editExtra", method = RequestMethod.POST)
    public @ResponseBody
    String editExtra(@RequestBody final String data, HttpSession session) {
        try {
            providerService.editExtrasOfPackage(data);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - editExtra\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/savePhotos", method = RequestMethod.POST)
    public @ResponseBody
    String savePhotos(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            //get type cover image
            FileMeta getFile = (FileMeta) session.getAttribute("coverPackageImage");
            String type = "";
            if (getFile != null) {
                type = getFile.getFileName();
                providerService.updateCoverAndPhotoOfTempPackage(type, data, providerID);
            }

            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - savePhotos\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

//    @RequestMapping(value = "/Package/editPhotos2", method = RequestMethod.POST)
//    public @ResponseBody
//    String editPhotos2(@RequestBody final String data, HttpSession session) {
//        try {
//            providerService.updateCoverAndPhotoOfTempPackagev2(data);
//            return "{\"result\": \"success\"}";
//        } catch (Exception e) {
//            String content = "Function: ProviderController - editPhotos\n"
//                    + "***Input***\n"
//                    + "data: " + data + "\n"
//                    + "**********\n"
//                    + "****Error****\n"
//                    + e.getMessage() + "\n"
//                    + "**********";
//            errorService.logBugWithAccount(content, session, e);
//            return "{\"result\": \"error\"}";
//        }
//    }
    @RequestMapping(value = "/Package/editPhotos", method = RequestMethod.POST)
    public @ResponseBody
    String editPhotos(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            //get type cover image
            FileMeta getFile = (FileMeta) session.getAttribute("coverEditPackageImage");
            String type = "";
            if (getFile != null) {
                type = getFile.getFileName();
                providerService.editPhotoOfPackage(type, data, providerID);
            }

            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - editPhotos\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/saveLocation", method = RequestMethod.POST)
    public @ResponseBody
    String saveLocation(@RequestBody final String data, HttpSession session) {
        try {
            providerService.updateLocationOfTemPackage(data);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - saveLocation\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/saveLocationv2", method = RequestMethod.POST)
    public @ResponseBody
    String saveLocationv2(@RequestBody final String data, HttpSession session) {
        try {
            providerService.updateLocationOfTemPackagev2(data);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - saveLocationv2\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/editLocation", method = RequestMethod.POST)
    public @ResponseBody
    String editLocation(@RequestBody final String data, HttpSession session) {
        try {
            providerService.editLocationOfPackage(data);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - editLocation\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/saveOrdinaryPrice", method = RequestMethod.POST)
    public @ResponseBody
    String saveOrdinaryPrice(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            providerService.updatePriceOfTemPackage(data, providerID);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - saveOrdinaryPrice\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/editPrice", method = RequestMethod.POST)
    public @ResponseBody
    String editPrice(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            providerService.editPriceOfPackage(data, providerID);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - editPrice\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/savePromotions", method = RequestMethod.POST)
    public @ResponseBody
    String savePromotions(@RequestBody final String data, HttpSession session) {
        try {
            providerService.updatePromotionOfTempPackage(data);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - savePromotions\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/savePromotionsv2", method = RequestMethod.POST)
    public @ResponseBody
    String savePromotionsv2(@RequestBody final String data, HttpSession session) {
        try {
            providerService.updatePromotionOfTempPackage(data);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - savePromotionsv2\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/editPromotions", method = RequestMethod.POST)
    public @ResponseBody
    String editPromotions(@RequestBody final String data, HttpSession session) {
        try {
            providerService.editPromotionOfPackage(data);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - savePromotions\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/uploadCoverImage", method = RequestMethod.POST)
    public @ResponseBody
    String uploadCoverImage(@RequestParam("coverImage") MultipartFile coverImage, @RequestParam("temporaryPackageID") int temporaryPackageID, HttpSession session) {
        try {

            String path = System.getProperty("catalina.base");
            File folderPackage = new File(path + "/webapps/Images/TemporaryPackages/" + temporaryPackageID);
            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }
            // String name = "cover." + FilenameUtils.getExtension(coverImage.getOriginalFilename());
            // FileOutputStream fos = new FileOutputStream(new File(folderPackage, name));
            // fos.write(coverImage.getBytes());
            // fos.close();

            String name = "cover." + FilenameUtils.getExtension(coverImage.getOriginalFilename());
            FileCopyUtils.copy(coverImage.getBytes(), new FileOutputStream(new File(folderPackage, name)));

            // get data from image
            String fileName = coverImage.getOriginalFilename();
            String fileType = coverImage.getContentType();
            String fileSize = coverImage.getSize() / 1024 + " Kb";
            byte[] imageInByte = coverImage.getBytes();

            FileMeta metaFile = new FileMeta(fileName, fileSize, fileType, imageInByte);
            // save temporary Image to session
            session.setAttribute("coverPackageImage", metaFile);

            return "/Images/TemporaryPackages/" + temporaryPackageID + "/" + name;
        } catch (Exception e) {
            String content = "Function: ProviderController - uploadCoverImage\n"
                    + "***Input***\n"
                    + "temporaryPackageID: " + temporaryPackageID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/editCoverImage", method = RequestMethod.POST)
    public @ResponseBody
    String editCoverImage(@RequestParam("coverImage") MultipartFile coverImage, @RequestParam("packageID") int packageID, HttpSession session) {
        try {
            String path = System.getProperty("catalina.base");
            File folderPackage = new File(path + "/webapps/Images/PrimaryPackages/" + packageID);
            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }
            String name = "cover." + FilenameUtils.getExtension(coverImage.getOriginalFilename());
            FileCopyUtils.copy(coverImage.getBytes(), new FileOutputStream(new File(folderPackage, name)));

            // get data from image
            String fileName = coverImage.getOriginalFilename();
            String fileType = coverImage.getContentType();
            String fileSize = coverImage.getSize() / 1024 + " Kb";
            byte[] imageInByte = coverImage.getBytes();

            FileMeta metaFile = new FileMeta(fileName, fileSize, fileType, imageInByte);
            // save temporary Image to session
            session.setAttribute("coverEditPackageImage", metaFile);

            return "/Images/PrimaryPackages/" + packageID + "/" + name;
        } catch (Exception e) {
            String content = "Function: ProviderController - uploadCoverImage\n"
                    + "***Input***\n"
                    + "PackageID: " + packageID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/uploadCoverImagev2", method = RequestMethod.POST)
    public @ResponseBody
    String uploadCoverImagev2(@RequestParam("coverImage") MultipartFile coverImage, @RequestParam("temporaryPackageID") int temporaryPackageID, HttpSession session) {
        try {
            String path = System.getProperty("catalina.base");
            File folderPackage = new File(path + "/webapps/Imagesv2/" + temporaryPackageID);
            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }
            String name = "cover." + FilenameUtils.getExtension(coverImage.getOriginalFilename());
            FileCopyUtils.copy(coverImage.getBytes(), new FileOutputStream(new File(folderPackage, name)));
            return "/Imagesv2/" + temporaryPackageID + "/" + name;
        } catch (Exception e) {
            String content = "Function: ProviderController - uploadCoverImagev2\n"
                    + "***Input***\n"
                    + "temporaryPackageID: " + temporaryPackageID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/uploadCertificateImageProvider", method = RequestMethod.POST)
    public @ResponseBody
    String uploadCertificateImage(@RequestParam("certificateImage") MultipartFile certificateImage, HttpSession session) {
        try {
            // get data from image
            String fileName = certificateImage.getOriginalFilename();
            String fileSize = certificateImage.getSize() / 1024 + " Kb";
            String fileType = certificateImage.getContentType();
            byte[] bytes = certificateImage.getBytes();
            FileMeta metaFile = new FileMeta(fileName, fileSize, fileType, bytes);

            // save temporary Image to session
            session.setAttribute("certificateImage", metaFile);
            return "{\"result\":\"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - uploadCertificateImage\n"
                    + "***Input***\n"
                    + "certificateImage: " + certificateImage + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/CertificateUploading", method = RequestMethod.POST)
    public @ResponseBody
    String certificateUploading(@RequestParam("certificateImage") MultipartFile certificateImage, @RequestParam("dataJson") String data,
            HttpSession session) {
        try {
            // get data from image
            String fileName = certificateImage.getOriginalFilename();
            String fileSize = certificateImage.getSize() / 1024 + " Kb";
            String fileType = certificateImage.getContentType();
            byte[] bytes = certificateImage.getBytes();
            FileMeta metaFile = new FileMeta(fileName, fileSize, fileType, bytes);

            // insert image
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();

            String imageUrl = providerService.insertNewCertificate(data, metaFile, providerID);

            return "{\"result\":" + imageUrl + "}";
        } catch (Exception e) {
            String content = "Function: ProviderController - certificateUploading\n"
                    + "***Input***\n"
                    + "certificateImage: " + certificateImage + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/TempCertificate", method = RequestMethod.GET)
    public void getTempCertificate(HttpSession session, HttpServletResponse response) {
        try {
            // get temporary certificate in session
            FileMeta getFile = (FileMeta) session.getAttribute("certificateImage");
            if (getFile != null) { // if exist return image
                response.setContentType(getFile.getFileType());
                response.setHeader("Content-disposition", "attachment; filename=\"" + getFile.getFileName() + "\"");
                FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/Package/InsertCertificate", method = RequestMethod.POST)
    public @ResponseBody
    String insertCertificate(@RequestBody final String data, HttpSession session) {
        try {
            // get temporary certificate in session
            FileMeta certificateImage = (FileMeta) session.getAttribute("certificateImage");
            if (certificateImage != null) {
//                return "{\"result\":" + providerService.insertNewCertificate(data, certificateImage) + "}";
                return "";
            } else {
                return "{\"result\":\"fail\"}";
            }
        } catch (Exception e) {
            String content = "Function: ProviderController - insertCertificate\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/InsertCertificateProvider", method = RequestMethod.POST)
    public @ResponseBody
    String insertCertificateProvider(@RequestBody final String data, HttpSession session) {
        try {
            // get temporary certificate in session
            FileMeta certificateImage = (FileMeta) session.getAttribute("certificateImage");
            if (certificateImage != null) {
                return "{\"result\":" + providerService.insertNewCertificateProvider(data, certificateImage) + "}";
            } else {
                return "{\"result\":\"fail\"}";
            }
        } catch (Exception e) {
            String content = "Function: ProviderController - insertCertificate\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/uploadAdditionalImages", method = RequestMethod.POST)
    public @ResponseBody
    String uploadAdditionalImages(@RequestParam("additionalImages[]") MultipartFile[] additionalImages, @RequestParam("temporaryPackageID") int temporaryPackageID,
            @RequestParam("imagesJson") String imagesJson, HttpSession session) {
        try {
            return providerService.uploadAdditionalImages(additionalImages, temporaryPackageID, imagesJson);
        } catch (Exception e) {
            String content = "Function: ProviderController - uploadAdditionalImages\n"
                    + "***Input***\n"
                    + "temporaryPackageID: " + temporaryPackageID + "\n"
                    + "imagesJson: " + imagesJson + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/editAdditionalImages", method = RequestMethod.POST)
    public @ResponseBody
    String editAdditionalImages(@RequestParam("additionalImages[]") MultipartFile[] additionalImages, @RequestParam("packageID") int packageID,
            @RequestParam("imagesJson") String imagesJson, HttpSession session) {
        try {
            return providerService.uploadAdditionalImagesPackage(additionalImages, packageID, imagesJson);
        } catch (Exception e) {
            String content = "Function: ProviderController - uploadAdditionalImages\n"
                    + "***Input***\n"
                    + "packageID: " + packageID + "\n"
                    + "imagesJson: " + imagesJson + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/uploadAdditionalImagesv2", method = RequestMethod.POST)
    public @ResponseBody
    String uploadAdditionalImagesv2(@RequestParam("additionalImages[]") MultipartFile[] additionalImages, @RequestParam("temporaryPackageID") int temporaryPackageID,
            @RequestParam("imagesJson") String imagesJson, HttpSession session) {
        try {
            return providerService.uploadAdditionalImagesv2(additionalImages, temporaryPackageID, imagesJson);
        } catch (Exception e) {
            String content = "Function: ProviderController - uploadAdditionalImagesv2\n"
                    + "***Input***\n"
                    + "temporaryPackageID: " + temporaryPackageID + "\n"
                    + "imagesJson: " + imagesJson + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/deleteAdditionalImage", method = RequestMethod.POST)
    public @ResponseBody
    String deleteAdditionalImage(@RequestBody final String data, HttpSession session) {
        try {
            return providerService.removeAdditionalImage(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - deleteAdditionalImage\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/deleteAdditionalImagePackage", method = RequestMethod.POST)
    public @ResponseBody
    String deleteAdditionalImagePackage(@RequestBody final String data, HttpSession session) {
        try {
            return providerService.removeAdditionalImagePackage(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - deleteAdditionalImage\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/deleteAdditionalImagev2", method = RequestMethod.POST)
    public @ResponseBody
    String deleteAdditionalImagev2(@RequestBody final String data, HttpSession session) {
        try {
            return providerService.removeAdditionalImagev2(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - deleteAdditionalImagev2\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Verify")
    public String verifyPhone(ModelMap model, HttpSession session, HttpServletRequest request) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            boolean isVerify = providerService.isVerifyPhoneNumber(account.getId());
            if (account != null) {
                if (!isVerify) {
                    List<CountryDTO> countryList = commonService.getAllCountry();
                    Gson gson = new Gson();
                    model.addAttribute("countryList", gson.toJson(countryList));
                    ProviderDTO provider = providerService.getPhoneNumber(account.getId());
                    model.addAttribute("phoneNumber", gson.toJson(provider));
                    return "provider/verifyPhoneNumber";
                } else if (request.getParameter("language") != null) {
                    return "redirect:/Provider/AccountInfo" + "?language=" + request.getParameter("language");
                } else {
                    return "redirect:/Provider/AccountInfo";
                }
            }
            if (request.getParameter("language") != null) {
                return "redirect:/Common" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/Common";
            }

        } catch (Exception e) {
            String content = "Function: ProviderController - verifyPhone\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SendSMS/{providerID}/{phoneCode}/{phoneNumber}")
    public @ResponseBody
    String sendSMS(HttpSession session, @PathVariable String providerID, @PathVariable String phoneCode, @PathVariable String phoneNumber) {
        try {
            String smsCode = providerService.getSMSCode(Integer.parseInt(providerID), phoneCode, phoneNumber);
            if (Integer.parseInt(smsCode.trim()) != 0) {
                commonService.sendSMS(phoneCode + phoneNumber, "Your active code is:" + smsCode);
                return "Enter your code below";
            }
            return "You have exceeded the maximum number of request for today!";
        } catch (Exception e) {
            String content = "Function: ProviderController - sendSMS\n"
                    + "***Input***\n"
                    + "providerID: " + providerID + "\n"
                    + "phoneCode: " + phoneCode + "\n"
                    + "phoneNumber: " + phoneNumber + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/VerifySMS/{providerID}/{smsCode}")
    public @ResponseBody
    String verifySMS(HttpSession session, @PathVariable String providerID, @PathVariable String smsCode) {
        try {
            String result = providerService.verifySMS(Integer.parseInt(providerID), smsCode);
            if (result.equals("true")) {
                return "Your account is verified!";
            }
            return "You code is invalid!";
        } catch (Exception e) {
            String content = "Function: ProviderController - verifySMS\n"
                    + "***Input***\n"
                    + "providerID: " + providerID + "\n"
                    + "smsCode: " + smsCode + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/AccountInfo")
    public String accountInfo(ModelMap map, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            ProviderDTO result = providerService.getAccountInfo(account.getId());
            Gson gson = new Gson();
            map.addAttribute("AccountInfo", gson.toJson(result));
            map.addAttribute("page", "Info");
            //get Notification           
//            List<ProviderNotification> providerNoti = providerService.getProviderNotification();
//            List<ProviderNotificationSetting> providerSetting = providerService.getProviderNotificationSetting(account.getId());
//            List<Integer> providerSettingList = new ArrayList<Integer>();
//            for (int i = 0; i < providerSetting.size(); i++) {
//                providerSettingList.add(providerSetting.get(i).getProviderNotificationID());
//            }
//            map.addAttribute("providerSetting", gson.toJson(providerSettingList));
//            map.addAttribute("providerNotification", gson.toJson(providerNoti));
            return accountInfoUrl;
        } catch (Exception e) {
            String content = "Function: ProviderController - accountInfo\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/UploadImage", method = RequestMethod.POST)
    public @ResponseBody
    String uploadProviderImage(@RequestParam("providerImage") MultipartFile providerImage, @RequestParam("providerID") int providerID, HttpSession session) {
        try {
            String path = System.getProperty("catalina.base");
            File folderPackage = new File(path + "/webapps/Images/Provider/" + providerID);
            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }
            String extension = FilenameUtils.getExtension(providerImage.getOriginalFilename());
            String name = "provider." + extension;
            String name2 = "avatar." + extension;

            // get Bytes and crop
            byte[] imageInByte = providerImage.getBytes();
            InputStream in = new ByteArrayInputStream(imageInByte);
            BufferedImage bImageFromConvert = ImageIO.read(in);
            // create a cropped image from the original image
            BufferedImage croppedImage = bImageFromConvert.getSubimage(0, 0, 100, 100);

//            // then convert BufferedImage to byte array to save
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(croppedImage, extension, baos);
//            baos.flush();
//            imageInByte = baos.toByteArray();
//            baos.close();
            ImageIO.write(croppedImage, extension, new File(folderPackage, name2));

            FileCopyUtils.copy(providerImage.getBytes(), new FileOutputStream(new File(folderPackage, name)));
            String image = "Images/Provider/" + providerID + "/" + name;
            AccountSession account = (AccountSession) session.getAttribute("account");
            account.setImage(image);
            session.setAttribute("account", account);
            providerService.updateProviderImage(providerID, image);
            return image;
        } catch (Exception e) {
            String content = "Function: ProviderController - uploadProviderImage\n"
                    + "***Input***\n"
                    + "providerID: " + providerID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/UploadAvatar", method = RequestMethod.POST)
    public @ResponseBody
    String saveAvatarToCrop(@RequestParam("providerImage") MultipartFile providerImage, HttpSession session) {
        try {
            // get data from image
            String fileName = providerImage.getOriginalFilename();
            String fileType = providerImage.getContentType();
            String fileSize = providerImage.getSize() / 1024 + " Kb";
            byte[] imageInByte = providerImage.getBytes();

            FileMeta metaFile = new FileMeta(fileName, fileSize, fileType, imageInByte);
            // save temporary Image to session
            session.setAttribute("avatarImage", metaFile);

            // get width and height of image
            InputStream in = new ByteArrayInputStream(imageInByte);
            BufferedImage bImageFromConvert = ImageIO.read(in);
            String data = "{\"width\": " + bImageFromConvert.getWidth() + ", \"height\": " + bImageFromConvert.getHeight() + "}";

            return "{\"result\": " + data + "}";
        } catch (IIOException ie) {

            return "{\"result\": \"image broken\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - saveAvatarToCrop\n"
                    + "***Input***\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Avatar/CropAndSave", method = RequestMethod.POST)
    public @ResponseBody
    String cropAndSaveAvatar(@RequestBody final String data, HttpSession session) {
        try {

            // change to buffered image to crop
//            InputStream in = new ByteArrayInputStream(imageInByte);
//            BufferedImage bImageFromConvert = ImageIO.read(in);
            // create a cropped image from the original image
//            BufferedImage croppedImage = bImageFromConvert.getSubimage(positionX, positionY, width, height);
            FileMeta metaFile = (FileMeta) session.getAttribute("avatarImage");

            if (metaFile != null) { // if exist crop and save
                // get Bytes and crop
//                byte[] imageInByte = metaFile.getBytes();
//                InputStream in = new ByteArrayInputStream(imageInByte);
//                BufferedImage bImageFromConvert = ImageIO.read(in);
//                // create a cropped image from the original image
//                BufferedImage croppedImage = bImageFromConvert.getSubimage(positionX, positionY, width, height);
//
//                AccountSession account = (AccountSession) session.getAttribute("account");
//                int providerID = account.getId();
//
//                String path = System.getProperty("catalina.base");
//                File folderPackage = new File(path + "/webapps/Images/Provider/" + providerID);
//                if (!folderPackage.exists()) {
//                    folderPackage.mkdirs();
//                }
//
//                String extension = FilenameUtils.getExtension(metaFile.getFileName());
//                String name = "provider." + extension;
//                ImageIO.write(croppedImage, extension, new File(folderPackage, name));
//
//                // update to database and session
//                String image = "Images/Provider/" + providerID + "/" + name;
//                account.setImage(image);
//                session.setAttribute("account", account);
//                providerService.updateProviderImage(providerID, image);

                AccountSession account = (AccountSession) session.getAttribute("account");
                int providerID = account.getId();
                String image = providerService.cropAndSaveProviderImage(data, providerID, metaFile);
                account.setImage(image);
                session.setAttribute("account", account);
                return "{\"result\":\"" + image + "\"}";
            }

            return "{\"result\":\"error\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - cropAndSaveAvatar\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/TemporaryAvatar", method = RequestMethod.GET)
    public void getTemporaryAvatar(HttpSession session, HttpServletResponse response) {
        try {
            // get temporary avatar in session
            FileMeta getFile = (FileMeta) session.getAttribute("avatarImage");
            if (getFile != null) { // if exist return image
                response.setContentType(getFile.getFileType());
                response.setHeader("Content-disposition", "attachment; filename=\"" + getFile.getFileName() + "\"");
                FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/TemporaryCoverImage", method = RequestMethod.GET)
    public void getTemporaryCoverImage(HttpSession session, HttpServletResponse response) {
        try {
            // get temporary avatar in session
            FileMeta getFile = (FileMeta) session.getAttribute("coverPackageImage");
            if (getFile != null) { // if exist return image
                response.setContentType(getFile.getFileType());
                response.setHeader("Content-disposition", "attachment; filename=\"" + getFile.getFileName() + "\"");
                FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/TemporaryEditCoverImage", method = RequestMethod.GET)
    public void getTemporaryEditCoverImage(HttpSession session, HttpServletResponse response) {
        try {
            // get temporary avatar in session
            FileMeta getFile = (FileMeta) session.getAttribute("coverEditPackageImage");
            if (getFile != null) { // if exist return image
                response.setContentType(getFile.getFileType());
                response.setHeader("Content-disposition", "attachment; filename=\"" + getFile.getFileName() + "\"");
                FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/UploadPassportImage", method = RequestMethod.POST)
    public @ResponseBody
    String uploadProviderPassportImage(@RequestParam("providerImage") MultipartFile providerImage, @RequestParam("providerID") int providerID, HttpSession session) {
        try {
            return providerService.updateProviderPassportImage(providerID, providerImage);

        } catch (Exception e) {
            String content = "Function: ProviderController - uploadProviderImage\n"
                    + "***Input***\n"
                    + "providerID: " + providerID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/UploadUpdateCertificateImage", method = RequestMethod.POST)
    public @ResponseBody
    String uploadUpdateCertificateImage(@RequestParam("certificateImage") MultipartFile certificateImage, @RequestParam("providerID") int providerID, @RequestParam("certificateID") int certificateID, HttpSession session) {
        CertificatesViewDTO getDTO;

        String url;
        try {
            String path = System.getProperty("catalina.base");
            File folderPackage = new File(path + "/webapps/Images/Provider/" + providerID + "/Certificate/");
            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }

            getDTO = providerService.getCertificateURL(certificateID);
            url = getDTO.getImage();
            String name = url.substring(url.lastIndexOf("/") + 1);

            //String name = "4K88AE3SU58A" + "." + FilenameUtils.getExtension(certificateImage.getOriginalFilename());
            FileCopyUtils.copy(certificateImage.getBytes(), new FileOutputStream(new File(folderPackage, name)));
            String image = "/Images/Provider/" + providerID + "/Certificate/" + name;

            // providerService.updateCertificateImage(certificateID, image);
            boolean status = providerService.updateCertificateUpdate(certificateID);
            if (status) {
                return image;
            } else {
                return "{\"result\": \"error\"}";
            }

        } catch (Exception e) {
            String content = "Function: ProviderController - uploadUpdateCertificateImage\n"
                    + "***Input***\n"
                    + "providerID: " + providerID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Booking")
    public String booking(HttpSession session, ModelMap map) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            List<PackageDTO> listPackage = providerService.getPackageForStatictis(account.getId());
            Gson gson = new Gson();
            map.addAttribute("listPackage", gson.toJson(listPackage));
            map.addAttribute("page", "providerBookings");
            return "provider/booking";
        } catch (Exception e) {
            String content = "Function: ProviderController - booking\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/BookingManagement")
    public String bookingManagement(HttpSession session, ModelMap map) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            map.addAttribute("bookingsOverview", providerService.getBookings(0, providerID));
            map.addAttribute("packages", providerService.getAllPackageOfProviderWithName(providerID));
            return "provider/bookingManagement";
        } catch (Exception e) {
            String content = "Function: ProviderController - bookingManagement\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/BookingManagement/{packageID}")
    public @ResponseBody
    String getPackageBookingOverview(HttpSession session, @PathVariable int packageID) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            return providerService.getBookings(packageID, providerID);
        } catch (Exception e) {
            String content = "Function: ProviderController - getPackageBookingOverview\n"
                    + "***Input***\n"
                    + "packageID: " + packageID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/BookingManagement/Detail/{packageID}")
    public @ResponseBody
    String getDateBookingDetail(HttpSession session, @PathVariable int packageID, @RequestBody final String data) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            return providerService.getDateBookingDetail(providerID, packageID, data);
        } catch (Exception e) {
            String content = "Function: ProviderController - getDateBookingDetail\n"
                    + "***Input***\n"
                    + "packageID: " + packageID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/BookingCode")
    public @ResponseBody
    String getDetailPerBooking(HttpSession session, @RequestBody final String data) {
        try {
            return providerService.getBookingDetail(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - getDetailPerBooking\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Booking/{packageID}")
    public @ResponseBody
    String getBookingDetail(HttpSession session, @PathVariable String packageID) {
        try {
            int packID = Integer.parseInt(packageID);
            String result = providerService.getBookingForStatictis(packID);
            return result;
        } catch (Exception e) {
            String content = "Function: ProviderController - getBookingDetail\n"
                    + "***Input***\n"
                    + "packageID: " + packageID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Sales")
    public String getSales(ModelMap map, HttpSession session) {
        try {
            return "provider/saleManagement";
        } catch (Exception e) {
            String content = "Function: ProviderController - getSales\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SalesLeft")
    public String getSalesLeft(ModelMap map, HttpSession session) {
        try {
            return "provider/saleManagementContentLeft";
        } catch (Exception e) {
            String content = "Function: ProviderController - getSales\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/updateSale")
    public @ResponseBody
    String updateSale(HttpSession session, @RequestBody final String data) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
            int providerID = jsonObject.get("providerID").getAsInt();
            return providerService.getSales(data, providerID);
        } catch (Exception e) {
            String content = "Function: ProviderController - updateSale\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Notification")
    String getNotification(ModelMap map, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            List<ProviderNotification> providerNoti = providerService.getProviderNotification();
            Gson gson = new Gson();
            List<ProviderNotificationSetting> providerSetting = providerService.getProviderNotificationSetting(account.getId());
            List<Integer> providerSettingList = new ArrayList<Integer>();
            for (int i = 0; i < providerSetting.size(); i++) {
                providerSettingList.add(providerSetting.get(i).getProviderNotificationID());
            }
            map.addAttribute("providerSetting", gson.toJson(providerSettingList));
            map.addAttribute("providerNotification", gson.toJson(providerNoti));
            map.addAttribute("page", "providerNotification");
            return "provider/notification";
        } catch (Exception e) {
            String content = "Function: ProviderController - getNotification\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SaveSetting", method = RequestMethod.POST)
    public String saveSetting(HttpServletRequest request) {
        try {
            int providerID;
            try {
                providerID = Integer.parseInt(request.getParameter("providerID"));
            } catch (NumberFormatException e) {
                providerID = 0;
            }
            providerService.saveSetting(providerID, request.getParameter("settingJson"));
            if (request.getParameter("language") != null) {
                return "redirect:/Provider/Notification" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/Provider/Notification";
            }

        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: ProviderController - saveSetting\n"
                    + "***Input***\n"
                    + "providerID: " + request.getParameter("providerID") + "\n"
                    + "settingJson: " + request.getParameter("settingJson") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/UpdateInformation", method = RequestMethod.POST)
    public String updateInformation(HttpServletRequest request, HttpSession session) {
        try {
            AccountSession account = providerService.updateProviderInformation(request, session);
            request.getSession().setAttribute("account", account);
            if (request.getParameter("language") != null) {
                return "redirect:/Provider/AccountInfo" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/Provider/AccountInfo";
            }

        } catch (Exception e) {
            String content = "Function: ProviderController - updateInformation\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/UpdateCertificateInformation", method = RequestMethod.POST)
    public String updateCertificateInformation(HttpServletRequest request, HttpSession session) {
        try {
            providerService.updateCertificateInformation(request, session);
            if (request.getParameter("language") != null) {
                return "redirect:/Provider/CertificateManagement" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/Provider/CertificateManagement";
            }

        } catch (Exception e) {
            String content = "Function: ProviderController - updateCertificateInformation\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Password", method = RequestMethod.GET)
    public String ProviderPassword(HttpServletRequest request) {
        try {
            request.setAttribute("page", "providerPassword");
            return "provider/password";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: ProviderController - ProviderPassword\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ChangePassword", method = RequestMethod.POST)
    public String changePassword(HttpServletRequest request) {
        try {
            String oldPassword = request.getParameter("currentPass");
            String newPassword = (String) request.getParameter("newPass");
            HttpSession session = request.getSession();
            AccountSession account = (AccountSession) session.getAttribute("account");
            boolean result = providerService.changeProviderPassword(account.getId(), oldPassword, newPassword);
            if (result) {
                if (request.getParameter("language") != null) {
                    return "redirect:/Provider/AccountInfo" + "?language=" + request.getParameter("language");
                } else {
                    return "redirect:/Provider/AccountInfo";
                }

            } else {
                request.setAttribute("message", "Your current password not correct!");
            }
            return "provider/password";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: ProviderController - changePassword\n"
                    + "***Input***\n"
                    + "currentPass: " + request.getParameter("currentPass") + "\n"
                    + "newPass: " + request.getParameter("newPass") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ExportPackage", method = RequestMethod.POST)
    public @ResponseBody
    String ExportPackage(@RequestBody
            final String data, HttpSession session) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class
            );
            int packageID = jsonObject.get("packageID").getAsInt();

            String path = System.getProperty("catalina.base");
            File folderPackage = new File(path + "/webapps/Export/");
            String excelFileName = path + "/webapps/Export/" + packageID + ".xls";
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Package " + packageID);

            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }
            String result = providerService.getBookingForStatictis(packageID);
            Map< String, Object[]> empinfo
                    = new TreeMap< String, Object[]>();
            JsonObject jsonObject2 = gson.fromJson(result, JsonObject.class);
            Set<Map.Entry<String, JsonElement>> entrySet = jsonObject2.entrySet();
            int i = 1;
            HSSFRow rowhead = sheet.createRow((short) 0);

            rowhead.createCell(
                    0).setCellValue("Trip Start");
            rowhead.createCell(
                    1).setCellValue("Number of Bookings");
            rowhead.createCell(
                    2).setCellValue("Number of Trippers");
            rowhead.createCell(
                    3).setCellValue("Max quota / Day");
            rowhead.createCell(
                    4).setCellValue("Pending");
            rowhead.createCell(
                    5).setCellValue("Completed");

            for (Map.Entry<String, JsonElement> entry : entrySet) {
                String bookingDate = entry.getKey();
                BookingStatistics bookingStatistics = gson.fromJson(entry.getValue(), BookingStatistics.class);
                rowhead = sheet.createRow((short) i);
                rowhead.createCell(0).setCellValue(bookingDate);
                rowhead.createCell(1).setCellValue(bookingStatistics.getNumberOfBooking());
                rowhead.createCell(2).setCellValue(bookingStatistics.getNumberOfTripper());
                rowhead.createCell(3).setCellValue(bookingStatistics.getMaxQuota());
                rowhead.createCell(4).setCellValue(bookingStatistics.getPending());
                rowhead.createCell(5).setCellValue(bookingStatistics.getCompleted());
                i++;
            }
            FileOutputStream fileOut = new FileOutputStream(excelFileName);

            workbook.write(fileOut);

            fileOut.close();
            return "/Export/" + packageID
                    + ".xls";
        } catch (Exception e) {
            String content = "Function: ProviderController - ExportPackage\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/ExportSales", method = RequestMethod.POST)
    public @ResponseBody
    String ExportSales(@RequestBody
            final String data, HttpSession session) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class
            );
            int providerID = jsonObject.get("ProviderID").getAsInt();
            JsonArray sales = jsonObject.get("ExportSales").getAsJsonArray();
            for (int i = 0;
                    i < sales.size();
                    i++) {

            }
            String path = System.getProperty("catalina.base");
            File folderPackage = new File(path + "/webapps/ExportSale/");
            String excelFileName = path + "/webapps/ExportSale/" + providerID + ".xls";
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Revenue Detail");

            if (!folderPackage.exists()) {
                folderPackage.mkdirs();
            }

            HSSFRow rowhead = sheet.createRow((short) 0);

            rowhead.createCell(
                    0).setCellValue("Package Name");
            rowhead.createCell(
                    1).setCellValue("Number of Bookings");
            rowhead.createCell(
                    2).setCellValue("Completed Booking");
            rowhead.createCell(
                    3).setCellValue("Expire Date");
            rowhead.createCell(
                    4).setCellValue("Revenue");
            rowhead.createCell(
                    5).setCellValue("Payment Due");

            for (int i = 1;
                    i < sales.size();
                    i++) {
                rowhead = sheet.createRow((short) i);
                rowhead.createCell(0).setCellValue(sales.get(i).getAsJsonObject().get("packageName").getAsString());
                rowhead.createCell(1).setCellValue(sales.get(i).getAsJsonObject().get("numberOfBooking").getAsString());
                rowhead.createCell(2).setCellValue(sales.get(i).getAsJsonObject().get("completedBooking").getAsString());
                rowhead.createCell(3).setCellValue(sales.get(i).getAsJsonObject().get("endDay").getAsString());
                rowhead.createCell(4).setCellValue(sales.get(i).getAsJsonObject().get("Revenue").getAsString());
                rowhead.createCell(5).setCellValue(sales.get(i).getAsJsonObject().get("paymentDue").getAsString());
            }
            FileOutputStream fileOut = new FileOutputStream(excelFileName);

            workbook.write(fileOut);

            fileOut.close();
            return "/ExportSale/" + providerID
                    + ".xls";
        } catch (Exception e) {
            String content = "Function: ProviderController - ExportSales\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/BookingEngine", method = RequestMethod.GET)
    public String toBookingEngine(HttpServletRequest request, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
//            request.setAttribute("bookingData", providerService.getBookingEngineDat(providerID));

//            request.setAttribute("packages", providerService.getPackagesOfProvider(providerID));
//            request.setAttribute("sales", providerService.getSales(null, providerID));
            String timeNow = new DateTime().toString("MM/dd/yyyy HH:mm:ss");
            request.setAttribute("timeNow", timeNow);
//            return "provider/newBookingEngine";
            return "provider/BookingEngine";
        } catch (Exception e) {
            String content = "Function: ProviderController - toBookingEngine\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ResourceManagement", method = RequestMethod.GET)
    public String toResourceManagement(HttpServletRequest request, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            request.setAttribute("resourceManagementData", providerService.getResourceManagementData(providerID));
            return "provider/resourceManagement";
        } catch (Exception e) {
            String content = "Function: ProviderController - toResourceManagement\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/loadResourceList", method = RequestMethod.POST)
    public @ResponseBody
    String loadResorceList(@RequestBody final String data, HttpSession session) {
        try {
            return providerService.getResourceListbyProviderID(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - loadResorceList\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/DeleteCertificate/{CertificateID}", method = RequestMethod.GET)
    public String deleteCertificate(@PathVariable int CertificateID, HttpSession session, ModelMap map, HttpServletRequest request) {

        try {
            providerService.deleteCertificate(CertificateID, session);
            if (request.getParameter("language") != null) {
                return "redirect:/Provider/CertificateManagement" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/Provider/CertificateManagement";
            }

        } catch (Exception e) {
            String content = "Function: UserController - deleteCertificate\n"
                    + "***Input***\n"
                    + "CertificateID: " + CertificateID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            if (request.getParameter("language") != null) {
                return "redirect:/Provider/CertificateManagement" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/Provider/CertificateManagement";
            }

        }

    }

    @RequestMapping(value = "/Package/addNewResource", method = RequestMethod.POST)
    public @ResponseBody
    String addNewResource(@RequestBody final String data, HttpSession session) {
        try {
            return providerService.addNewResourceByProviderID(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - addNewResource\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Resource/Insert", method = RequestMethod.POST)
    public @ResponseBody
    String insertNewResource(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            return providerService.insertResourceAndGetInsertedID(data, account.getId());
        } catch (Exception e) {
            String content = "Function: ProviderController - insertNewResource\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Serving/Insert", method = RequestMethod.POST)
    public @ResponseBody
    String insertNewServingPeriod(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            return providerService.insertServingPeriodAndGetID(account.getId(), data);
        } catch (Exception e) {
            String content = "Function: ProviderController - insertNewServingPeriod\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Serving/Update", method = RequestMethod.POST)
    public @ResponseBody
    String updateServingPeriod(@RequestBody final String data, HttpSession session) {
        try {
            if (providerService.updateServingPeriodAndGetID(data)) {
                return "{\"result\": \"success\"}";
            } else {
                return "{\"result\": \"error\"}";
            }

        } catch (Exception e) {
            String content = "Function: ProviderController - updateNewServingPeriod\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/saveAvailability", method = RequestMethod.POST)
    public @ResponseBody
    String saveAvailability(@RequestBody final String data, HttpSession session) {
        try {
            providerService.saveAvailability(data);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - saveAvailability\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/BookingEngine/Insert", method = RequestMethod.POST)
    public @ResponseBody
    String insertEngineBookings(@RequestBody
            final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            return providerService.insertEngineBooking(data, account.getId());
        } catch (Exception e) {
            String content = "Function: ProviderController - insertEngineBookings\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/BookingEngine/OfflineInserting", method = RequestMethod.POST)
    public @ResponseBody
    String insertOfflineBookings(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            providerService.insertOfflineBooking(data, providerID);
            this.template.convertAndSend("/topic/bookingEngine/" + providerID, "{\"result\": \"success\"}}");
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - insertOfflineBookings\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/BookingEngine/OfflinePackage/Insert", method = RequestMethod.POST)
    public @ResponseBody
    String insertNewOfflineBooking(@RequestBody
            final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            return providerService.insertNewOfflineAndReturnNewList(data, account.getId());
        } catch (Exception e) {
            String content = "Function: ProviderController - insertNewOfflineBooking\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/BookingEngine", method = RequestMethod.POST)
    public @ResponseBody
    String loadBookingEngineData(HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            return providerService.getBookingEngineDat(account.getId());
        } catch (Exception e) {
            String content = "Function: ProviderController - loadBookingEngineData\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Promotion")
    public String promotion(HttpSession session, HttpServletRequest request) {
        try {
            request.setAttribute("page", "promotion");
            return "provider/PromotionPage";
        } catch (Exception e) {
            String content = "Function: ProviderController - promotion\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Dashboard")
    public String dashboard(HttpSession session, HttpServletRequest request) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            request.setAttribute("tripDash", providerService.getProviderTrippDash(account.getId()));
            request.setAttribute("today", commonService.getToDateUnderFormatyyyyMMdd());
            request.setAttribute("currentMillisecond", commonService.getToDateInMillisecond());
            request.setAttribute("page", "dashboard");
            return "provider/dashboard";
        } catch (Exception e) {
            String content = "Function: ProviderController - dashboard\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/InviteFriend")
    public String inviteFriend(HttpSession session, HttpServletRequest request) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            String referralList = providerService.getReferralList(providerID);
            String officialID = providerService.getAccountInfo(providerID).getOfficialID();
            request.setAttribute("referralList", referralList);
            request.setAttribute("officialID", officialID);
            request.setAttribute("page", "Referral");
            return "provider/inviteFriend";
        } catch (Exception e) {
            String content = "Function: ProviderController - inviteFriend\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SendEmailReferral", method = RequestMethod.POST)
    public @ResponseBody
    String SendEmailReferral(@RequestBody final String data, HttpServletRequest request, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            String contextPath = request.getContextPath();
            String baseUrl;
            if (contextPath != null || contextPath.isEmpty() || !contextPath.equals("")) {
                baseUrl = String.format("%s://%s:%d" + contextPath, request.getScheme(), request.getServerName(), request.getServerPort());
            } else {
                baseUrl = String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
            }
            providerService.sendEmailReferral(data, providerID, baseUrl);
            request.setAttribute("emailSent", "Email Sent!");
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - send email invite friend\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SendEmailInviteFriend", method = RequestMethod.POST)
    public String SendEmailInviteFriend(HttpServletRequest request, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            String contextPath = request.getContextPath();
            String baseUrl;
            if (contextPath != null || contextPath.isEmpty() || !contextPath.equals("")) {
                baseUrl = String.format("%s://%s:%d" + contextPath, request.getScheme(), request.getServerName(), request.getServerPort());
            } else {
                baseUrl = String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
            }
            providerService.sendMail(request, account.getName(), providerID, baseUrl);
            request.setAttribute("emailSent", "Email Sent!");
            return "forward:/Provider/InviteFriend";
        } catch (Exception e) {
            String content = "Function: ProviderController - send email invite friend\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/EditPolicy", method = RequestMethod.POST)
    public @ResponseBody
    String EditPolicy(@RequestBody final String data, HttpSession session) {
        try {
            return providerService.editPolicy(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - EditPolicy\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/CreatePolicy", method = RequestMethod.POST)
    public @ResponseBody
    String CreatePolicy(@RequestBody final String data, HttpSession session) {
        try {
            return providerService.createPolicy(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - CreatePolicy\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/CreateChildrenDiscount", method = RequestMethod.POST)
    public @ResponseBody
    String CreateChildrenDiscount(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            return providerService.createChildrenDiscount(data, account.getId());
        } catch (Exception e) {
            String content = "Function: ProviderController - CreateChildrenDiscount\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/CreateChildrenDiscountForMainPackage", method = RequestMethod.POST)
    public @ResponseBody
    String CreateChildrenDiscountForMainPackage(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            return providerService.createChildrenDiscountForMainPackage(data, account.getId());
        } catch (Exception e) {
            String content = "Function: ProviderController - CreateChildrenDiscountForMainPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/CreateDisabledDiscount", method = RequestMethod.POST)
    public @ResponseBody
    String CreateDisabledDiscount(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            return providerService.createDisabledDiscount(data, account.getId());
        } catch (Exception e) {
            String content = "Function: ProviderController - CreateDisabledDiscount\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/CreateDisabledDiscountForMainPackage", method = RequestMethod.POST)
    public @ResponseBody
    String CreateDisabledDiscountForMainPackage(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            return providerService.createDisabledDiscountForMainPackage(data, account.getId());
        } catch (Exception e) {
            String content = "Function: ProviderController - CreateDisabledDiscountForMainPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/EditChildrenDiscount", method = RequestMethod.POST)
    public @ResponseBody
    String EditChildrenDiscount(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            return providerService.editChildrenDiscount(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - EditChildrenDiscount\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/EditDisabledDiscount", method = RequestMethod.POST)
    public @ResponseBody
    String editDisabledDiscount(@RequestBody final String data, HttpSession session) {
        try {
            return providerService.editDisabledDiscount(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - EditDisabledDiscount\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "data:" + data + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/InsertResourceSkill", method = RequestMethod.POST)
    public @ResponseBody
    String insertNewResourceSkill(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            String result = providerService.insertNewResourceSkillAndGetNewResourceManagementData(data, providerID);
            this.template.convertAndSend("/topic/bookingEngine/" + providerID, "{\"result\": \"success\"}}");
            return result;
        } catch (Exception e) {
            String content = "Function: ProviderController - insertNewResourceSkill\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "data:" + data + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/InsertProviderResource", method = RequestMethod.POST)
    public @ResponseBody
    String insertProviderResource(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            String result = providerService.insertNewProviderResourceAndGetNewResourceManagementData(data, providerID);
            this.template.convertAndSend("/topic/bookingEngine/" + providerID, "{\"result\": \"success\"}}");
            return result;
        } catch (Exception e) {
            String content = "Function: ProviderController - insertProviderResource\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "data:" + data + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/AssignNewTrippSourceToPackage", method = RequestMethod.POST)
    public @ResponseBody
    String assignNewTrippSource(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            String result = providerService.assignNewTrippSourceToPackageAndGetNewResourceManagementData(data, providerID);
            this.template.convertAndSend("/topic/bookingEngine/" + providerID, "{\"result\": \"success\"}}");
            return result;
        } catch (Exception e) {
            String content = "Function: ProviderController - assignNewTrippSource\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "data:" + data + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/EditProviderResource", method = RequestMethod.POST)
    public @ResponseBody
    String editProviderResource(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            String result = providerService.editProviderResource(data, providerID);
            this.template.convertAndSend("/topic/bookingEngine/" + providerID, "{\"result\": \"success\"}}");
            return result;
        } catch (Exception e) {
            String content = "Function: ProviderController - editProviderResource\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "data:" + data + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/DeleteProviderResource", method = RequestMethod.POST)
    public @ResponseBody
    String deleteProviderResource(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            String result = providerService.deleteProviderResource(data, providerID);
            this.template.convertAndSend("/topic/bookingEngine/" + providerID, "{\"result\": \"success\"}}");
            return result;
        } catch (Exception e) {
            String content = "Function: ProviderController - deleteProviderResource\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "data:" + data + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/DeleteTrippSource", method = RequestMethod.POST)
    public @ResponseBody
    String deleteTrippSource(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            String result = providerService.deleteTrippSource(data, providerID);
            this.template.convertAndSend("/topic/bookingEngine/" + providerID, "{\"result\": \"success\"}}");
            return result;
        } catch (Exception e) {
            String content = "Function: ProviderController - deleteTrippSource\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "data:" + data + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/EditTrippSource", method = RequestMethod.POST)
    public @ResponseBody
    String editTrippSource(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            String result = providerService.editTrippSource(data, providerID);
            this.template.convertAndSend("/topic/bookingEngine/" + providerID, "{\"result\": \"success\"}}");
            return result;
        } catch (Exception e) {
            String content = "Function: ProviderController - editTrippSource\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "data:" + data + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/EditResourceSkill", method = RequestMethod.POST)
    public @ResponseBody
    String editResourceSkill(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            String result = providerService.editSkill(data, providerID);
            this.template.convertAndSend("/topic/bookingEngine/" + providerID, "{\"result\": \"success\"}}");
            return result;
        } catch (Exception e) {
            String content = "Function: ProviderController - editResourceSkill\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "data:" + data + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/DeleteResourceSkill", method = RequestMethod.POST)
    public @ResponseBody
    String deleteResourceSkill(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();

            String result = providerService.deleteSkill(data, providerID);
            this.template.convertAndSend("/topic/bookingEngine/" + providerID, "{\"result\": \"success\"}}");
            return result;
        } catch (Exception e) {
            String content = "Function: ProviderController - deleteResourceSkill\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "data:" + data + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/Package/CloneCheck", method = RequestMethod.POST)
    public @ResponseBody
    String cloneCheck(@RequestBody final String data, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            boolean creatngPackageExist = providerService.checkCreatingPackageExist(providerID);
            if (creatngPackageExist) {
                return "{\"result\": \"packageExisting\"}";
            }
            return "{\"result\": \"noPackage\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - cloneCheck\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/Clone")
    public String clonePackage(HttpServletRequest request, HttpSession session, ModelMap map) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            int packageID = Integer.parseInt(request.getParameter("packageID"));
            String packageStatus = request.getParameter("status");
            boolean cloneAll = Boolean.parseBoolean(request.getParameter("cloneAll"));
            boolean cloneCategory = Boolean.parseBoolean(request.getParameter("cloneCategory"));
            boolean cloneDescription = Boolean.parseBoolean(request.getParameter("cloneDescription"));
            boolean clonePhoto = Boolean.parseBoolean(request.getParameter("clonePhoto"));
            boolean cloneBooking = Boolean.parseBoolean(request.getParameter("cloneBooking"));
            boolean clonePricing = Boolean.parseBoolean(request.getParameter("clonePricing"));

            if (cloneAll) {
                cloneCategory = true;
                cloneDescription = true;
                clonePhoto = true;
                cloneBooking = true;
                clonePricing = true;
            }
            //System.out.println("clonePricing"+clonePricing);
            providerService.clonePackage(providerID, packageID, packageStatus,
                    cloneAll, cloneCategory, cloneDescription, clonePhoto, cloneBooking, clonePricing);

            //return "forward:/Provider/AccountInfo";
            return "forward:/Provider/Package/Registration";
        } catch (Exception e) {
            String content = "Function: ProviderController - clonePackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/PreViewEditing", method = RequestMethod.POST)
    public String previewEditing(HttpServletRequest request, HttpSession session, ModelMap model) {
        try {
            String packageIDStr = request.getParameter("packageID");
            int packageID = Integer.parseInt(packageIDStr);

            String reportType = commonService.getReportType();
            request.setAttribute("ReportType", reportType);
            model.addAttribute("packageDTO", commonService.getPreviewPackageEditing(packageID));
            model.addAttribute("toDate", commonService.getToDateUnderFormatMMddyyyy());
            return "provider/editPackagePreview";
        } catch (Exception e) {
            String content = "Function: ProviderController - previewEditing\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/ApplyPackageEditing", method = RequestMethod.POST)
    public String applyPackageEditing(HttpServletRequest request, HttpSession session, ModelMap model) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int providerID = account.getId();
            String packageIDStr = request.getParameter("packageID");
            int packageID = Integer.parseInt(packageIDStr);

            providerService.applyPackageEditing(packageID, providerID);
            return "provider/apply";
        } catch (Exception e) {
            String content = "Function: ProviderController - ApplyPackageEditing\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/InsertEditingReason", method = RequestMethod.POST)
    public @ResponseBody
    String insertEditingReason(ModelMap model, HttpSession session, @RequestBody final String data) {
        try {
            providerService.insertEditingReason(data);
            return "{\"result\": \"OK\"}";
        } catch (Exception e) {
            String content = "Function: ProviderController - insertEditingReason\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/LoadTopLeftBooking", method = RequestMethod.POST)
    public @ResponseBody
    String loadTopLeftBooking(ModelMap model, HttpSession session, @RequestBody final String data) {
        try {
            String result = providerService.loadTopLeftBooking(data);
            return result;
        } catch (Exception e) {
            String content = "Function: ProviderController - loadTopLeftBooking\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/LoadHighestPackage", method = RequestMethod.POST)
    public @ResponseBody
    String loadHighestPackage(ModelMap model, HttpSession session, @RequestBody final String data) {
        try {
            return providerService.loadHighestPackage(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - loadHighestPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/LoadLowestPackage", method = RequestMethod.POST)
    public @ResponseBody
    String loadLowestPackage(ModelMap model, HttpSession session, @RequestBody final String data) {
        try {
            return providerService.loadLowestPackage(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - loadLowestPackage\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/CountPackage", method = RequestMethod.POST)
    public @ResponseBody
    String getNumberOfPackage(ModelMap map, HttpSession session) {
        try {
            AccountSession account = (AccountSession) session.getAttribute("account");
            int numberOfpackage = providerService.countNumberOfPackage(account.getId());

            return "{\"result\": " + numberOfpackage + "}";
        } catch (Exception e) {
            String content = "Function: ProviderController - getAllProviderPackages\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/LoadStatisticsInTripDash", method = RequestMethod.POST)
    public @ResponseBody
    String loadStatisticsInTripDash(ModelMap model, HttpSession session, @RequestBody final String data) {
        try {
            System.out.println("data" + data);
            return providerService.loadStatisticsInTripDash(data);
        } catch (Exception e) {
            String content = "Function: ProviderController - loadStatisticsInTripDash\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Survey", method = RequestMethod.GET)
    public String takeSurvey(ModelMap model, HttpSession session, HttpServletRequest request) {
        try {
            return "provider/apply";
        } catch (Exception e) {
            String content = "Function: ProviderController - takeSurvey\n"
                    + "***Input***\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }
}
