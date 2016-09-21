/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.AccountSession;
import DTO.PackagesViewDTO;
import Interface.Service.CommonService;
import Interface.Service.ErrorService;
import Implement.Service.CommonServiceImpl;
import com.google.gson.Gson;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Nick
 */
@Controller

public class HomeController {

    @Autowired
    CommonService commonService;

    @Autowired
    ErrorService errorService;

    @RequestMapping("/")
    public String goToRoute(HttpServletRequest request) {
        try {
            request.setAttribute("page", "Homepage");
            request.setAttribute("fromHomePage", "true");
            request.setAttribute("newTrip", commonService.getNewTrip());
            request.setAttribute("recommendedPackage", commonService.getRecommendedPackage());
            request.setAttribute("packageInBangkok", commonService.getPackageInBangkok());
            return "homepage";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: HomeController - goToRoute\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping("/Test")
    public String test(HttpServletRequest request) {
        try {
//            commonService.updateNearMeJson();
//            request.setAttribute("locationTable", CommonServiceImpl.nearMeJson);
            return "welcome";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: HomeController - test\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }

    }

    @RequestMapping("/Home/Content")
    public String goToHomePage(HttpServletRequest request) {
        try {
            request.setAttribute("newTrip2", commonService.getNewTrip2());
            return "homepageContent";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: HomeController - goToHomePage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping("/SmartSearch/Content/{txtSearch}")
    public String goToSmartSearchContent(HttpServletRequest request) {
        try {
            request.setAttribute("pageSize", commonService.getSearchPageSize());
            return "smartSearch";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: HomeController - goToSmartSearchContent\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }

    }

    @RequestMapping("/SmartSearch/{txtSearch}")
    public String goToSmartSearch(HttpServletRequest request, @PathVariable String txtSearch) {
//
//        request.setAttribute("aaa", commonService.smartSearchPakages("{\"searchText\": " + txtSearch + ", \"trips\": \"\", \"groups\": \"\","
//                + "\"amenities\": \"\", \"minPrice\": 0, \"maxPrice\": 999999999, \"rate\": 0, \"pageNumber\": 1}"));
//        return "smartSearchPage";
        request.setAttribute("pageSize", commonService.getSearchPageSize());
        request.setAttribute("txtSearch", txtSearch);
        request.setAttribute("fromHomePage", "false");
        return "homepage";
    }

    @RequestMapping(value = "/SmartSearch", method = RequestMethod.POST)
    public @ResponseBody
    String searchPagekages(@RequestBody final String data, HttpServletRequest request) {
        try {
            return commonService.smartSearchPakages(data);
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: HomeController - searchPagekages\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "{\"result\": \"error\"}";
        }
    }
    
    @RequestMapping(value = "/citySearch", method = RequestMethod.POST)
    public String citySearch(HttpServletRequest request, HttpSession session) {
        try {
           // request.setAttribute("packageByCity", commonService.citySearch(request, session));
            // list package DTO 
           List<PackagesViewDTO> packages = commonService.citySearch(request, session);   
            //did not change return yet
            request.setAttribute("packages",packages);
            return "smartSearch";
//            if (request.getParameter("language") != null) {
//                return "redirect:/" + "?language=" + request.getParameter("language");
//            } else {
//                return "redirect:/";
//            }

        } catch (Exception e) {
            String content = "Function: HomeController - citySearch\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Package/{packageID}")
    public String viewPackage(@PathVariable int packageID, ModelMap map, HttpServletRequest request) {
        try {
            String reportType = commonService.getReportType();
            request.setAttribute("ReportType", reportType);
            map.addAttribute("packageDTO", commonService.getPackageByID(packageID));
            map.addAttribute("toDate", commonService.getToDateUnderFormatMMddyyyy());
            return "package";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: HomeController - viewPackage\n"
                    + "***Input***\n"
                    + "packageID: " + packageID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Categories/{location}/{selectedCate}")
    public String getSubWithinCate(ModelMap map, HttpSession session, @PathVariable String location, @PathVariable String selectedCate) {
        try {
            Gson gson = new Gson();
            map.addAttribute("allCate", gson.toJson(commonService.getAllCategories()));
            map.addAttribute("allSubCate", gson.toJson(commonService.getAllSubCategories()));
            map.addAttribute("selectedLocation", location);
            map.addAttribute("selectedCate", selectedCate);
            return "viewAllCate";
        } catch (Exception e) {
            String content = "Function: HomeController - getSubWithinCate\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping("/{subCate}/{location}/SmartSearch")
    public String goToMatrixSmartSearch(HttpServletRequest request, @PathVariable String location, @PathVariable String subCate) {
        request.setAttribute("pageSize", commonService.getSearchPageSize());
        request.setAttribute("locate", location);
        request.setAttribute("subCate", subCate);
        return "matrixSmartSearch";
    }

    @RequestMapping(value = "/MatrixSmartSearch", method = RequestMethod.POST)
    public @ResponseBody
    String searchPagekagesInMatrix(@RequestBody final String data, HttpServletRequest request) {
        try {
            return commonService.matrixSearchPakages(data);
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: HomeController - searchPagekagesInMatrix\n"
                    + "***Input***\n"
                    + "data: " + data + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/LoginPage")
    public String goToLoginPage(HttpServletRequest request, HttpSession session) {
        try {
            int packageID = 0;

            try {
                packageID = (int) request.getAttribute("review");

            } catch (Exception e) {
            }

            if (session != null) {
                if (session.getAttribute("account") != null) {
                    if (request.getParameter("language") != null) {
                        return "redirect:/" + "?language=" + request.getParameter("language");
                    } else {
                        return "redirect:/";
                    }

                }
            }
            if (packageID > 0) {
                request.setAttribute("review", packageID);
            }
            return "login";
        } catch (Exception e) {
            String content = "Function: CommonController - goToLoginPage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            
            int packageIDforBooking = 0;
            if (session != null) {
                if (session.getAttribute("provider") == null && session.getAttribute("user") == null) { // check whether logined or not
                    String username = request.getParameter("email");
                    String password = request.getParameter("password");
                    int packageID;
                    try {
                        packageID = Integer.valueOf(request.getParameter("review"));

                    } catch (Exception e) {
                        packageID = 0;
                    }
                    try {
                        packageIDforBooking = Integer.valueOf(request.getParameter("packageID"));

                    } catch (Exception e) {
                        packageID = 0;
                    }
                    String rememberMe = request.getParameter("rememberMe");
                    AccountSession account = commonService.loginToYouTripper(username, password);
                    if (account.getId() != 0) {

                        if (account.getRole() == 1) {
                            boolean result = commonService.existingUserLogin(username, "Tripper", session.getAttribute("accessTime").toString(), session.getAttribute("accessIP").toString());

                        } else {
                            boolean result = commonService.existingUserLogin(username, "Provider", session.getAttribute("accessTime").toString(), session.getAttribute("accessIP").toString());

                        }

                        if (rememberMe != null) {
                            String token = commonService.insertNewCookie(username);
                            Cookie cookie = new Cookie("loginToken", token);
                            cookie.setMaxAge(60 * 60 * 24 * 30); //1 hour
                            response.addCookie(cookie);
                            cookie = new Cookie("rememberMe", "true");
                            cookie.setMaxAge(60 * 60 * 24 * 30); //1 hour
                            response.addCookie(cookie);
                            session.setAttribute("account", account);
                            if (packageID > 0) {
                                return "redirect:/Tripper/ReviewPackage/" + packageID;
                            } else if (packageID < 0) {
                                if (request.getParameter("language") != null) {
                                    return "redirect:/" + "?language=" + request.getParameter("language");
                                } else {
                                    return "redirect:/";
                                }

                            }
                            try {
                                if (packageIDforBooking > 0) {
                                    request.setAttribute("selectedDate", request.getParameter("selectedDate"));
                                    request.setAttribute("numberOfAdults", request.getParameter("numberOfAdults"));
                                    request.setAttribute("numberOfChilds", request.getParameter("numberOfChilds"));
                                    request.setAttribute("packageID", request.getParameter("packageID"));
                                    request.setAttribute("login", "true");
                                    return "forward:/Tripper/Book";
                                }

                            } catch (Exception e) {
                            }

                        } else {

                            session.setAttribute("account", account);

                            if (packageID > 0) {
                                return "redirect:/Tripper/ReviewPackage/" + packageID;
                            } else if (packageID < 0) {
                                if (request.getParameter("language") != null) {
                                    return "redirect:/" +"?language=" + request.getParameter("language");
                                } else {
                                    return "redirect:/";
                                }
                                
                            }
                            try {
                                if (packageIDforBooking > 0) {
                                    request.setAttribute("selectedDate", request.getParameter("selectedDate"));
                                    request.setAttribute("numberOfAdults", request.getParameter("numberOfAdults"));
                                    request.setAttribute("numberOfChilds", request.getParameter("numberOfChilds"));
                                    request.setAttribute("packageID", request.getParameter("packageID"));
                                    request.setAttribute("login", "true");
                                    return "forward:/Tripper/Book";
                                }

                            } catch (Exception e) {
                            }
                        }
                    } else {
                        request.setAttribute("loginfail", username);
                        return "forward:/LoginPage";
                    }
                }
            }
            if (request.getParameter("language") != null) {
                return "redirect:/" +"?language=" + request.getParameter("language");
            } else {
                return "redirect:/";
            }
            
        } catch (Exception e) {
            String content = "Function: CommonController - login\n"
                    + "***Input***\n"
                    + "email: " + request.getParameter("email") + "\n"
                    + "password: " + request.getParameter("password") + "\n"
                    + "review: " + request.getParameter("review") + "\n"
                    + "rememberMe: " + request.getParameter("rememberMe") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            if (request.getParameter("language") != null) {
                return "forward:/LoginPage" +"?language=" + request.getParameter("language");
            } else {
                return "forward:/LoginPage";
            }
            
        } catch (Exception e) {
            String content = "Function: CommonController - loginPage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/InsertNewLanguage")
    public String insertNewLanguage(HttpServletRequest request) {
        try {
            commonService.insertNewLanguage();
            return "Home";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - goToSub\n"
                    + "***Input***\n"
                    + "search: " + request.getParameter("search") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping("/TestPayment")
    public String testPayment(HttpServletRequest request) {
        try {

            return "tripper/testPayment";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: HomeController - test\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }

    }

    @RequestMapping(value = "/BeProvider")
    public String goToPageBeProvider(HttpSession session, HttpServletRequest request) {
        try {
            try {
                String language = request.getParameter("language");
                if (language != null) {
                    if (language.equals("th")) {
                        return "BeProviderInThai";
                    }
                }
            } catch (Exception e) {
            }
            return "beProvider";
        } catch (Exception e) {
            String content = "Function: CommonController - goToPageBeProvider\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Thai/BeProvider")
    public String goToPageBeProviderInThai(HttpSession session, HttpServletRequest request) {
        try {
            return "BeProviderInThai";
        } catch (Exception e) {
            String content = "Function: CommonController - goToPageBeProviderInThai\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ProviderSignup")
    public String goToSignupPage(HttpServletRequest request, ModelMap model, HttpSession session) {
        try {
            if (session.getAttribute("account") == null) {
                String form = commonService.getProviderSignupForm();
                if (form != null) {
                    model.addAttribute("form", form);
                    return "providerSignup";
                }
            }
            if (request.getParameter("language") != null) {
                return "redirect:/" +"?language=" + request.getParameter("language");
            } else {
                return "redirect:/";
            }
            
        } catch (Exception e) {
            String content = "Function: CommonController - goToProviderSignupPage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }

    }

    @RequestMapping(value = "/SignupSuccess")
    public String signupSuccess(ModelMap model, HttpSession session) {
        try {

            return "SignupSuccess";
        } catch (Exception e) {
            String content = "Function: CommonController - goToProviderSignupPage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            model.addAttribute("errorID", session.getId());
            model.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }

    }
}
