
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DTO.AccountSession;
import DTO.AdminSession;
import DTO.ForgotPasswordDTO;
import DTO.SalemanSession;
import Exception.CustomGenericException;
import Interface.Service.CommonService;
import Interface.Service.ErrorService;
import Interface.Service.ProviderService;
import Interface.Service.SalesmanService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.net.URL;
import java.util.UUID;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
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
@RequestMapping("/Common")
public class CommonController {

    @Autowired
    CommonService commonService;

    @Autowired
    ErrorService errorService;

    @Autowired
    SalesmanService salesmanService;

    @Autowired
    ProviderService providerService;

    @RequestMapping()
    public String goToHomePage(HttpServletRequest request) {
        try {
            request.setAttribute("page", "Homepage");
            return "home";
        } catch (Exception e) {
            HttpSession session = request.getSession();
            String content = "Function: CommonController - goToHomePage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Error")
    public String error(HttpServletRequest request) {
        if (request.getAttribute("errorID") == null) {
            HttpSession session = request.getSession(true);
            request.setAttribute("errorID", session.getId());
        }
        return "error";
    }

    @RequestMapping(value = "/Cp")
    public String cp(HttpServletRequest request) {
        return "comparisonPage";
    }

    @RequestMapping(value = "/Test")
    public String testInterface(HttpServletRequest request) {
        try {
            return "emailForm";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - testInterface\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Activation/{token}")
    public String validateToken(HttpServletRequest request, @PathVariable String token, HttpSession session) {
        try {

            AccountSession account = commonService.validateTokenForProvider(token);
            if (account.getId() != 0) {
                session.setAttribute("accountEmail", account.getEmail());
                session.setAttribute("account", account);
                session.setAttribute(("fromActivate"), "fromActivate");
                if (request.getParameter("language") != null) {
                    return "redirect:/Provider/Package/Registration" + "?language=" + request.getParameter("language");
                } else {
                    return "redirect:/Provider/Package/Registration";
                }

//                return "activateSuccess";
            }
            return "forward:/Home";
        } catch (Exception e) {
            String content = "Function: CommonController - validateToken\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Tripper/SignupPage")
    public String goToSignupPage(HttpSession session, HttpServletRequest request) {
        try {
            if (session.getAttribute("account") == null) {
                return "tripperSignup";
            }
            if (request.getParameter("language") != null) {
                return "redirect:/" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/";
            }
        } catch (Exception e) {
            String content = "Function: CommonController - goToTripperSignupPage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Provider/SignupReferral/{token}")
    public String goToSignupPageWithToken(HttpServletRequest request, ModelMap model, @PathVariable String token, HttpSession session) {
        try {
            session.setAttribute("referralToken", token);
            if (session.getAttribute("account") == null) {
                String form = commonService.getProviderSignupForm();
                if (form != null) {
                    model.addAttribute("form", form);
                    return "providerSignup";
                }
            }
            if (request.getParameter("language") != null) {
                return "redirect:/" + "?language=" + request.getParameter("language");
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

    @RequestMapping(value = "/TripperPage")
    public String goToTripperPage(HttpServletRequest request) {
        try {
            return "/tripper/welcome";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - goToTripperPage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Search")
    public String goToSearchPage(HttpServletRequest request, ModelMap map) {
        try {
            String searchText = request.getParameter("search");
            map.addAttribute("advancedSearch", commonService.commonSearchPackages(searchText));
            map.addAttribute("pageSize", commonService.getSearchPageSize());
            return "searchPage";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - goToSearchPage\n"
                    + "***Input***\n"
                    + "search: " + request.getParameter("search") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SmartSearch")
    public String goToSmartSearch(HttpServletRequest request, ModelMap map) {
        return "search";
    }

    @RequestMapping(value = "/LiveSearch")
    public @ResponseBody
    String liveSearch(@RequestBody final String data, HttpServletRequest request) {
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
            String searchText = jsonObject.get("searchText").getAsString();
            String result = commonService.liveSearch(searchText);
            return result;
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - liveSearch\n"
                    + "***Input***\n"
                    + "search: " + request.getParameter("search") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/SetLanguage")
    public @ResponseBody
    String setLanguage(@RequestBody final String data, HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(true);
            session.setAttribute("language", data);
            return "{\"result\": \"succeed\"}";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - liveSearch\n"
                    + "***Input***\n"
                    + "search: " + request.getParameter("search") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/LanguageSetting")
    public String setLanguage(HttpServletRequest request, ModelMap map) {
        try {
            String data = request.getParameter("language");
//            HttpSession session = request.getSession(true);
//            session.setAttribute("language", data);

            String referer = request.getHeader("Referer");
            URL oldUrl = new URL(referer);

            String queryStr = oldUrl.getQuery();
            String newUrl = oldUrl.getPath();

            if (queryStr != null) {
                String[] params = queryStr.split("&");
                int i = 0;
                for (String param : params) {
                    String key = param.substring(0, param.indexOf('='));
                    String val = param.substring(param.indexOf('=') + 1);
                    if (key.equals("language")) {
                        val = data;
                    }

                    if (val != null) {
                        if (i != 0) {
                            newUrl += "&" + key + "=" + val;
                        } else {
                            newUrl += "?" + key + "=" + val;
                        }
                    }
                }
            } else if (data != null) {
                newUrl += "?language=" + data;
            }

            return "redirect:" + newUrl;
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - setLanguage\n"
                    + "***Input***\n"
                    + "search: " + request.getParameter("search") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Search/PageNumber", method = RequestMethod.POST)
    public @ResponseBody
    String getPackagesByPage(@RequestBody final String data, HttpServletRequest request) {
        try {
            return commonService.searchPackagesWithFilter(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - getPackagesByPage\n"
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

    @RequestMapping(value = "/Search/Filter", method = RequestMethod.POST)
    public @ResponseBody
    String getPackagesWithFilter(@RequestBody final String data, HttpServletRequest request) {
        try {
            return commonService.searchPackagesWithFilter(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - getPackagesWithFilter\n"
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

    @RequestMapping(value = "/Search/GettingFilter", method = RequestMethod.POST)
    public @ResponseBody
    String getFilterOptions(@RequestBody final String data, HttpServletRequest request) {
        try {
            return commonService.getFilterOptions(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - getPackagesWithFilter\n"
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

//    @RequestMapping(value = "/Package/{packageID}")
//    public String viewPackage(@PathVariable int packageID, ModelMap map, HttpServletRequest request) {
//        try {
//            map.addAttribute("packageDTO", commonService.getPackageByID(packageID));
//            return "package";
//        } catch (Exception e) {
//            HttpSession session = request.getSession(true);
//            String content = "Function: CommonController - viewPackage\n"
//                    + "***Input***\n"
//                    + "packageID: " + packageID + "\n"
//                    + "**********\n"
//                    + "****Error****\n"
//                    + e + "\n"
//                    + "**********";
//            map.addAttribute("errorID", session.getId());
//            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
//            return "forward:/Common/Error";
//        }
//    }
    @RequestMapping(value = "/Logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        try {
            if (session != null) {
                session.setAttribute("account", null);
                boolean flag = false;
                Cookie[] cookielist = request.getCookies();
                for (Cookie obj : cookielist) {
                    if (obj.getName().equals("rememberMe")) {
                        flag = true;
                    }
                }
                if (flag) {
                    for (Cookie obj : cookielist) {
                        if (obj.getName().equals("loginToken")) {
                            String token = obj.getValue();
                            commonService.deleteCookie(token);
                            Cookie cookie = new Cookie("rememberMe", "0");
                            cookie.setMaxAge(0);
                            response.addCookie(cookie);
                            cookie = new Cookie("loginToken", "");
                            cookie.setMaxAge(0);
                            response.addCookie(cookie);
                        }
                    }
                }
            }
            if (request.getParameter("language") != null) {
                return "redirect:/" + "?language=" + request.getParameter("language");
            } else {
                return "redirect:/";
            }

        } catch (Exception e) {
            String content = "Function: CommonController - logout\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
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
                        return "redirect:/" +"?language=" + request.getParameter("language");
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

    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public @ResponseBody
    String checkEmail(@RequestBody final String data, HttpServletRequest request) {
        try {
            if (commonService.checkEmailIsExist(data)) {
                return "{\"result\": \"fail\"}";
            }
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - checkEmail\n"
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

    @RequestMapping(value = "/checkEmailRegister", method = RequestMethod.POST)
    public @ResponseBody
    String checkEmailRegister(@RequestBody final String data, HttpServletRequest request) {
        try {
            if (commonService.checkEmailIsExistRegister(data)) {
                return "{\"result\": \"fail\"}";
            }
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - checkEmail\n"
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

    @RequestMapping(value = "/checkBusinessName", method = RequestMethod.POST)
    public @ResponseBody
    String checkBusinessName(@RequestBody final String data, HttpServletRequest request) {
        try {
            if (commonService.checkBusinessNameIsExist(data)) {
                return "{\"result\": \"fail\"}";
            }
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - checkBusinessName\n"
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

    @RequestMapping(value = "/checkUsernameURL", method = RequestMethod.POST)
    public @ResponseBody
    String checkUsernameURL(@RequestBody final String data, HttpServletRequest request) {
        try {
            if (commonService.checkUsernameURLIsExist(data)) {
                return "{\"result\": \"fail\"}";
            }
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - checkUsernameURL\n"
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

    @RequestMapping(value = "/checkSalesCode", method = RequestMethod.POST)
    public @ResponseBody
    String checkSalesCode(@RequestBody final String data, HttpServletRequest request) {
        try {
            if (!commonService.checkSalesCode(data)) {
                return "{\"result\": \"fail\"}";
            }
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - checkBusinessName\n"
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

    @RequestMapping(value = "/getReviewByTime", method = RequestMethod.POST)
    public @ResponseBody
    String getReviewByTime(@RequestBody final String data, HttpServletRequest request) {
        try {
            return commonService.getReviewsByTime(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - getReviewByTime\n"
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

    @RequestMapping(value = "/getReviewOfProvider", method = RequestMethod.POST)
    public @ResponseBody
    String getReviewOfProviderByTime(@RequestBody final String data, HttpServletRequest request) {
        try {
            return commonService.getReviewsOfProviderByTime(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - getReviewOfProviderByTime\n"
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

    @RequestMapping(value = "/getReviewOfTripper", method = RequestMethod.POST)
    public @ResponseBody
    String getReviewOfTripperByTime(@RequestBody final String data, HttpServletRequest request) {
        try {
            return commonService.getReviewsOfTripperByTime(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - getReviewOfTripperByTime\n"
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

    @RequestMapping(value = "/Tripper/Register", method = RequestMethod.POST)
    public String registerTripper(HttpServletRequest request, HttpSession session) {
        try {
            String url = "redirect:/";
            if (request.getParameter("language") != null) {
                 url = "redirect:/" +"?language=" + request.getParameter("language");
            } 
            
            if (session.getAttribute("account") == null) {
//                String captcha = request.getParameter("captcha");
//                if (commonService.checkCaptcha(captcha)) {
                String email = request.getParameter("email");
                String data = "{\"email\": \"" + email + "\"}";
                if (commonService.checkEmailIsExist(data)) {
                    return url;
                }
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String password = request.getParameter("password");
                if (firstName.length() > 10 || lastName.length() > 10 || email.length() > 100) {
                    return url;
                }

                AccountSession provider = commonService.insertTripper(email, password, firstName, lastName);
                url = "forward:/Common/Tripper/SignupPage";
                if (provider != null) {
                    url = "SignupSuccess";
                    String newToken = commonService.insertNewSignUpToken(email, null);
                    if (!newToken.equals("")) {
                        String contextPath = request.getContextPath();
                        String baseUrl;
                        if (contextPath != null || contextPath.isEmpty() || !contextPath.equals("")) {
                            baseUrl = String.format("%s://%s:%d" + contextPath, request.getScheme(), request.getServerName(), request.getServerPort());
                        } else {
                            baseUrl = String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
                        }
                        commonService.sendActivationEmail("[YouTripper] Activation Email!", lastName, email, newToken, baseUrl);
                    }
                    session.setAttribute("resendEmail", email);
                    session.setAttribute("lastName", lastName);
                    session.setAttribute("newToken", newToken);
                }
            }

            return url;
        } catch (Exception e) {
            String content = "Function: CommonController - registerTripper\n"
                    + "***Input***\n"
                    + "captcha: " + request.getParameter("captcha") + "\n"
                    + "firstName: " + request.getParameter("firstName") + "\n"
                    + "lastName: " + request.getParameter("lastName") + "\n"
                    + "email: " + request.getParameter("email") + "\n"
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

    @RequestMapping(value = "/Tripper/RegisterFB", method = RequestMethod.POST)
    public @ResponseBody
    String registerTripperFB(HttpServletRequest request, HttpSession session, @RequestBody final String data) {
        try {
            String url = "redirect:/";
            if (request.getParameter("language") != null) {
               url = "redirect:/" +"?language=" + request.getParameter("language");
            } 
            Gson dataFb = new Gson();
            JsonObject jsonFb = dataFb.fromJson(data, JsonObject.class);
            if (session.getAttribute("account") == null) {
                String name = jsonFb.get("name").getAsString();
                String email = jsonFb.get("email").getAsString();
                AccountSession account = commonService.loginToYoutripperFacebook(email);
                if (account.getId() != 0) {
                    if (account.getToken().equals("")) {
                        session.setAttribute("account", account);
                        url = "{\"method\":\"login\"}";
                    } else {
                        url = "{\"method\":\"signup\",\"token\":\"" + account.getToken() + "\"}";
                    }

                } else {
                    String lastName = "";
                    String firstName = "";
                    if (name.split("\\w+").length > 1) {
                        lastName = name.substring(name.lastIndexOf(" ") + 1);
                        firstName = name.substring(0, name.lastIndexOf(' '));
                    } else {
                        firstName = name;
                    }
                    String password = "password";
                    AccountSession tripper = commonService.insertTripper(email, password, firstName, lastName);
                    if (tripper != null) {
                        String newToken = commonService.insertNewSignUpToken(email, null);
                        if (!newToken.equals("")) {
                            String contextPath = request.getContextPath();
                            String baseUrl;
                            if (contextPath != null || contextPath.isEmpty() || !contextPath.equals("")) {
                                baseUrl = String.format("%s://%s:%d" + contextPath, request.getScheme(), request.getServerName(), request.getServerPort());
                            } else {
                                baseUrl = String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
                            }
//                            account = commonService.validateTokenForProvider(newToken);
//                            session.setAttribute("account", account);
                        }
                        url = "{\"method\":\"signup\",\"token\":\"" + newToken + "\"}";
                    }

                }
            }
            return url;
        } catch (Exception e) {
            String content = "Function: CommonController - registerTripperFacebook\n"
                    + "***Input***\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Provider/Register", method = RequestMethod.POST)
    public String registerProvider(HttpServletRequest request, HttpSession session) {
        try {
            String url = "redirect:/";
            if (request.getParameter("language") != null) {
               url = "redirect:/" +"?language=" + request.getParameter("language");
            } 
            if (session.getAttribute("account") == null) {
//                String captcha = request.getParameter("captcha");
//                if (commonService.checkCaptcha(captcha)) {
                String email = request.getParameter("email");
                String referralOfficialID = request.getParameter("ref");
                String businessName = request.getParameter("businessName");
                //String usernameURL = request.getParameter("usernameURL");
                //usernameURL = usernameURL.toLowerCase();
                //usernameURL = usernameURL.replaceAll("\\s+", "");
                String data = "{\"email\": \"" + email + "\"}";
                String businessData = "{\"businessName\": \"" + businessName + "\"}";
                //String usernameURLData = "{\"usernameURL\": \"" + usernameURL + "\"}";

//                if (commonService.checkEmailIsExist(data)
//                        || commonService.checkBusinessNameIsExist(businessData)
//                        || commonService.checkUsernameURLIsExist(usernameURLData)) {
//                    return url;
//                }
                boolean checkBusinessType = true;
                int businessType = 0;
                try {
                    businessType = Integer.parseInt(request.getParameter("businessType"));
                } catch (Exception e) {
                    checkBusinessType = false;
                }

                int country = Integer.parseInt(request.getParameter("country"));
                String city = request.getParameter("city");
                String address = request.getParameter("address");
                String phoneCode = "0";
                String phone = request.getParameter("phone");
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String displayName = request.getParameter("displayName");
                String job = request.getParameter("jobTitle");

                String password = request.getParameter("password");
                String referralCode = request.getParameter("referralCode");
                String openTime = request.getParameter("openTime");
                String closeTime = request.getParameter("closeTime");
//                if (usernameURL.length() > 20 || businessName.length() > 200 || city.length() > 30
//                        || address.length() > 100 || phone.length() > 15
//                        || firstName.length() > 15 || lastName.length() > 15 || checkBusinessType == false
//                        || displayName.length() > 32 || job.length() > 20 || email.length() > 100) {
//                    return url;
//                }
                if (businessName.length() > 200 || city.length() > 30
                        || address.length() > 100 || phone.length() > 15
                        || firstName.length() > 15 || lastName.length() > 15 || checkBusinessType == false
                        || displayName.length() > 32 || job.length() > 20 || email.length() > 100) {
                    return url;
                }
                if (!phoneCode.contains("+")) {
                    phoneCode = "+" + phoneCode;
                }
                String referralToken = (String) session.getAttribute("referralToken");
//                AccountSession provider = commonService.insertProvider(businessType, usernameURL, businessName, country, city, address, phoneCode, phone,
//                        firstName, lastName, displayName, job, email, password, referralCode, openTime, closeTime);

                AccountSession provider = commonService.insertProvider(businessType, businessName, country, city, address, phoneCode, phone,
                        firstName, lastName, displayName, job, email, password, referralCode, openTime, closeTime, referralOfficialID);

                if (provider != null) {
                    String newToken = commonService.insertNewSignUpToken(email, referralToken);
                    if (!newToken.equals("")) {
                        String contextPath = request.getContextPath();
                        String baseUrl;
                        if (contextPath != null || contextPath.isEmpty() || !contextPath.equals("")) {
                            baseUrl = String.format("%s://%s:%d" + contextPath, request.getScheme(), request.getServerName(), request.getServerPort());
                        } else {
                            baseUrl = String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
                        }

                        commonService.sendActivationEmail("Youtripper Provider Register Confirmation", displayName, email, newToken, baseUrl);
                    }
                    session.setAttribute("resendEmail", email);
                    session.setAttribute("lastName", lastName);
                    session.setAttribute("newToken", newToken);
                    if (request.getParameter("language") != null) {
                        url = "redirect:/SignupSuccess" + "?language=" + request.getParameter("language");
                    }
                }
//                }
            }
            return url;
        } catch (Exception e) {
            String content = "Function: CommonController - registerProvider\n"
                    + "***Input***\n"
                    + "captcha: " + request.getParameter("captcha") + "\n"
                    + "businessType: " + request.getParameter("businessType") + "\n"
                    + "businessName: " + request.getParameter("businessName") + "\n"
                    + "country: " + request.getParameter("country") + "\n"
                    + "city: " + request.getParameter("city") + "\n"
                    + "address: " + request.getParameter("address") + "\n"
                    + "phone: " + request.getParameter("phone") + "\n"
                    + "firstName: " + request.getParameter("firstName") + "\n"
                    + "lastName: " + request.getParameter("lastName") + "\n"
                    + "displayName: " + request.getParameter("displayName") + "\n"
                    + "jobTitle: " + request.getParameter("jobTitle") + "\n"
                    + "email: " + request.getParameter("email") + "\n"
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

    @RequestMapping(value = "/EmailRegister", method = RequestMethod.POST)
    public @ResponseBody
    String EmailRegister(@RequestBody final String data, HttpServletRequest request) {
        try {
            //String data = "{\"email\": \"" + email + "\"}";
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(data, JsonObject.class);
            String email = jsonObject.get("email").getAsString();
            long time = (long) System.currentTimeMillis();
            if (!commonService.checkEmailIsExistRegister(data) && email.length() < 100) {
                commonService.insertEmail(email, time);

                //send mail
                String contextPath = request.getContextPath();
                String baseUrl;
                if (contextPath != null || contextPath.isEmpty() || !contextPath.equals("")) {
                    baseUrl = String.format("%s://%s:%d" + contextPath, request.getScheme(), request.getServerName(), request.getServerPort());
                } else {
                    baseUrl = String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
                }

                commonService.sendFollowEmail("Youtripper Follow NewLetter Confirmation", email, baseUrl);

            }
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - EmailRegister\n"
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

    @RequestMapping(value = "/AddToComparisonList", method = RequestMethod.POST)
    public @ResponseBody
    String addToComparisonList(HttpServletRequest request, HttpSession session, @RequestBody
            final String data
    ) {
        try {
            String comparisonListData = (String) session.getAttribute("ComparisonList");
            String result = commonService.getPackageForComparisonList(data, comparisonListData);
            if (!result.equals("{\"result\": \"full\"}") && !result.equals("{\"result\": \"exist\"}") && !result.equals("{\"result\": \"error\"}")) {
                session.setAttribute("ComparisonList", result);
            }
            return result;
        } catch (Exception e) {
            String content = "Function: CommonController - addToComparisonList\n"
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

    @RequestMapping(value = "/RemoveFromComparisonList", method = RequestMethod.POST)
    public @ResponseBody
    String removeFromComparisonList(HttpSession session,
            @RequestBody
            final String data
    ) {
        try {
            String comparisonListData = (String) session.getAttribute("ComparisonList");
            String result = commonService.removePackageFromComparisonList(data, comparisonListData);
            session.setAttribute("ComparisonList", result);
            return result;
        } catch (Exception e) {
            String content = "Function: CommonController - removeFromComparisonList\n"
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

    @RequestMapping(value = "/ComparisonPage")
    public String goToComparisonPage(HttpServletRequest request, HttpSession session
    ) {
        try {
//            List<Integer> comparisonList = (List<Integer>) session.getAttribute("ComparisonList");
//            if (comparisonList != null) {
//                String result = commonService.getComparisonList(comparisonList);
//                if (comparisonList.size() > 0) {
//                    request.setAttribute("ComparisonList", result);
//                } else {
//                    request.setAttribute("ComparisonList", null);
//                }
//                return "comparison";
//            } else {
//                request.setAttribute("ComparisonList", null);
//                return "comparison";
//            }
            String data = (String) session.getAttribute("ComparisonList");
            String result = commonService.getComparisonList(data);
            request.setAttribute("ComparisonPackages", result);
            return "comparisonPage";
        } catch (Exception e) {
            String content = "Function: CommonController - ComparisonPage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ProviderPage/{url}")
    public String goToProviderPage(HttpServletRequest request, HttpSession session, @PathVariable String url
    ) {
        try {

            String providerIDString = commonService.getProviderID(url);
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(providerIDString, JsonObject.class);
            int providerID = jsonObject.get("providerID").getAsInt();
            String result = commonService.getProviderPage(providerID);
            String reportType = commonService.getReportType();
            request.setAttribute("ProviderInfo", result);
            request.setAttribute("certificates", providerService.getApprovedCertificatesOfProvider(providerID));
            request.setAttribute("ReportType", reportType);

            return "providerPage";

        } catch (Exception e) {
            String content = "Function: CommonController - goToProviderPage\n"
                    + "***Input***\n"
                    + "url: " + url + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Unsubscribe/{emailID}")
    public String Unsubscribe(HttpServletRequest request, HttpSession session, @PathVariable int emailID
    ) {
        try {
            commonService.unSubscribe(emailID);
            return "unsubscribe";

        } catch (Exception e) {
            String content = "Function: CommonController - Unsubscribe\n"
                    + "***Input***\n"
                    + "email: " + emailID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ReportProvider", method = RequestMethod.POST)
    public String reportProvider(HttpServletRequest request, HttpSession session
    ) {
        int providerID = 0;
        try {
            String reason = "";
            providerID = Integer.valueOf(request.getParameter("providerID"));
            int reasonID = Integer.valueOf(request.getParameter("reportValue"));
            int packageID = Integer.valueOf(request.getParameter("packageID"));
            if (reasonID == 0) {
                reason = request.getParameter("otherReasonDetail");
            } else {
                reason = request.getParameter("ReasonDetail");
            }
            boolean result = commonService.reportProvider(providerID, reason);
            if (result) {
                request.setAttribute("ReportMessage", "Success");
            } else {
                request.setAttribute("ReportMessage", "Fail");
            }
            return "forward:/Package/" + packageID;
        } catch (Exception e) {
            String content = "Function: CommonController - reportProvider\n"
                    + "***Input***\n"
                    + "providerID: " + request.getParameter("providerID") + "\n"
                    + "reportValue: " + request.getParameter("reportValue") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/TripperPage/{tripperID}")
    public String goToTripperPage(HttpServletRequest request, HttpSession session, @PathVariable int tripperID) throws CustomGenericException {
        try {
            String result = commonService.getTripperPage(tripperID);
            String reportType = commonService.getReportType();
            request.setAttribute("TripperInfo", result);
            request.setAttribute("ReportType", reportType);
            return "tripperPage";
        } catch (Exception e) {
            String content = "Function: CommonController - goToTripperPage\n"
                    + "***Input***\n"
                    + "tripperID: " + tripperID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ReportTripper", method = RequestMethod.POST)
    public String reportTripper(HttpServletRequest request, HttpSession session
    ) {
        int tripperID = 0;
        try {
            String reason = "";
            tripperID = Integer.valueOf(request.getParameter("tripperID"));
            int reasonID = Integer.valueOf(request.getParameter("reportValue"));
            if (reasonID == 0) {
                reason = request.getParameter("otherReasonDetail");
            } else {
                reason = request.getParameter("ReasonDetail");
            }

            boolean result = commonService.reportTripper(tripperID, reason);
            if (result) {
                request.setAttribute("ReportMessage", "Success");
            } else {
                request.setAttribute("ReportMessage", "Fail");
            }
        } catch (Exception e) {
            String content = "Function: CommonController - reportTripper\n"
                    + "***Input***\n"
                    + "tripperID: " + request.getParameter("tripperID") + "\n"
                    + "reportValue: " + request.getParameter("reportValue") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
        return "forward:/Common/TripperPage/" + tripperID;
    }

    @RequestMapping(value = "/ForgotPassword")
    public String forgotPassword(HttpServletRequest request, HttpSession session
    ) {
        try {
            return "forgotPassword";
        } catch (Exception e) {
            String content = "Function: CommonController - forgotPassword\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/RequestResetPassword", method = RequestMethod.POST)
    public String requestResetPassword(HttpServletRequest request, HttpSession session
    ) {
        try {
            String email = request.getParameter("email");
            String uuid = UUID.randomUUID().toString();
            boolean result = commonService.insertNewForgotPasswordToken(uuid, email);
            // send mail here
            if (result) {
                String contextPath = request.getContextPath();
                String baseUrl;
                if (contextPath != null || contextPath.isEmpty() || !contextPath.equals("")) {
                    baseUrl = String.format("%s://%s:%d/" + contextPath, request.getScheme(), request.getServerName(), request.getServerPort());
                } else {
                    baseUrl = String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
                }

                String hashedtoken = DigestUtils.md5DigestAsHex((email + uuid).getBytes());
                boolean result1 = commonService.sendForgotPasswordEmail("[YouTripper] Reset Password!", email, hashedtoken, baseUrl);
                if (result1) {
                    return "RequestPassSuccess";
                } else {

                }
            }
            return "forgotPassword";
        } catch (Exception e) {
            String content = "Function: CommonController - requestResetPassword\n"
                    + "***Input***\n"
                    + "email: " + request.getParameter("email") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/ChangePassword/{token}")
    public String forgotPassword(HttpServletRequest request,
            @PathVariable String token
    ) {
        try {
            ForgotPasswordDTO result = commonService.checkForgotPasswordToken(token);
            if (result != null) {
                request.setAttribute("ResetToken", token);
                return "changePassword";
            }
            return "forward:404";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - forgotPassword\n"
                    + "***Input***\n"
                    + "token: " + token + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SubmitChangePassword", method = RequestMethod.POST)
    public String changePassword(HttpServletRequest request
    ) {
        try {
            String token = request.getParameter("token");
            String password = request.getParameter("password");
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            boolean result = commonService.resetPassword(token, password);
            if (result) {
                //delete token
                boolean deleteFlag = commonService.deleteEmail(token);
                if (deleteFlag) {
                    return "resetPasswordSuccess";
                }

            }
            request.setAttribute("token", token);
            request.setAttribute("error", "Something went wrong!");
            return "changePassword";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - changePassword\n"
                    + "***Input***\n"
                    + "token: " + request.getParameter("token") + "\n"
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

    @RequestMapping(value = "/AllActivities", method = RequestMethod.GET)
    public String getAllActivities(HttpServletRequest request
    ) {
        try {
            String result = commonService.getAllActivities();
            request.setAttribute("activities", result);
            request.setAttribute("pageSize", commonService.getActivitiesPageSize());
            return "allActivities";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - getAllActivities\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/AllActivities/PageNumber", method = RequestMethod.POST)
    public @ResponseBody
    String getActivitiesWithPageNumber(@RequestBody
            final String data, HttpSession session
    ) {
        try {
            return commonService.getActivitiesWithPageNumber(data);
        } catch (Exception e) {
            String content = "Function: CommonController - getActivitiesWithPageNumber\n"
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

    @RequestMapping(value = "/Activities/{location}", method = RequestMethod.GET)
    public String getAllActivitiesWithLocation(HttpServletRequest request,
            @PathVariable String location
    ) {
        try {
            String result = commonService.getAllActivitiesWithinLocation(location);
            request.setAttribute("activities", result);
            request.setAttribute("selectedLocation", location);
            request.setAttribute("pageSize", commonService.getActivitiesPageSize());
            return "allActivities";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - getAllActivitiesWithLocation\n"
                    + "***Input***\n"
                    + "location: " + location + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Packages/{location}/{activityID}", method = RequestMethod.GET)
    public String getPackagesWithLocationAnd(@PathVariable String location,
            @PathVariable int activityID, ModelMap map, HttpSession session
    ) {
        try {
            String result = commonService.getPackagesWithLocationAndActivity(activityID, location);
            map.addAttribute("result", result);
            map.addAttribute("pageSize", commonService.getActivitiesPageSize());
            map.addAttribute("selectedLocation", location);
            return "advancedPackages";
        } catch (Exception e) {
            String content = "Function: CommonController - getPackagesWithLocationAnd\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Packages/CoAndAct/PageNumber", method = RequestMethod.POST)
    public @ResponseBody
    String getPackagesWithLocationAnd(@RequestBody
            final String data, HttpSession session
    ) {
        try {
            return commonService.getPackagesWithLocationAndActivity(data);
        } catch (Exception e) {
            String content = "Function: CommonController - getPackagesWithLocationAnd\n"
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

    @RequestMapping(value = "/Package/QuickView", method = RequestMethod.POST)
    public @ResponseBody
    String getQuickInformation(@RequestBody
            final String data, HttpSession session
    ) {
        try {
            return commonService.getQuickInformationOfPackage(data);
        } catch (Exception e) {
            String content = "Function: CommonController - getQuickInformation\n"
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

    @RequestMapping(value = "/Package/QuickView/{packageID}", method = RequestMethod.GET)
    public String moveToQuickViewPage(@PathVariable int packageID, ModelMap map, HttpSession session
    ) {
        try {
            String result = commonService.getQuickInformationOfPackage(packageID);
            if (!result.equals("fail")) {
                map.addAttribute("packageDTO", result);
                return "quickView";
            }
            return "{\"result\": \"error\"}";
        } catch (Exception e) {
            String content = "Function: CommonController - moveToQuickViewPage\n"
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

    @RequestMapping(value = "/NewKeyword", method = RequestMethod.POST)
    public @ResponseBody
    String insertNewKeyword(@RequestBody
            final String data, HttpServletRequest request
    ) {
        try {
            return commonService.insertNewKeyword(data, request);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - insertNewKeyword\n"
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

    @RequestMapping(value = "/Careers")
    public String viewCareers(ModelMap map, HttpSession session
    ) {
        try {
            return "careers";
        } catch (Exception e) {
            String content = "Function: CommonController - viewCareers\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Contact")
    public String viewContact(ModelMap map, HttpSession session
    ) {
        try {
            return "contact";

        } catch (Exception e) {
            String content = "Function: CommonController - viewContact\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Help")
    public String viewHelp(ModelMap map, HttpSession session
    ) {
        try {
            return "help";
        } catch (Exception e) {
            String content = "Function: CommonController - viewHelp\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Policy")
    public String viewPolicy(ModelMap map, HttpSession session
    ) {
        try {
            map.addAttribute("page", "Policy");
            return "policy";
        } catch (Exception e) {
            String content = "Function: CommonController - viewPolicy\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/TOS")
    public String viewTOS(ModelMap map, HttpSession session
    ) {
        try {
            map.addAttribute("page", "ToS");
            return "tos";
        } catch (Exception e) {
            String content = "Function: CommonController - viewTOS\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/FeePolicy")
    public String viewFeePolicy(ModelMap map, HttpSession session
    ) {
        try {
            map.addAttribute("page", "Fee");
            return "feePolicy";
        } catch (Exception e) {
            String content = "Function: CommonController - viewFeePolicy\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }

    }

    @RequestMapping(value = "/HowItWork")
    public String howitwork(ModelMap map, HttpSession session
    ) {
        try {
            return "howitwork";
        } catch (Exception e) {
            String content = "Function: CommonController - goToTipsPage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/Tips")
    public String goToTipsPage(ModelMap map, HttpSession session
    ) {
        try {
            return "tips";
        } catch (Exception e) {
            String content = "Function: CommonController - goToTipsPage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/AboutUs", method = RequestMethod.GET)
    public String aboutUs(ModelMap map, HttpSession session
    ) {
        try {
            return "aboutUS";
        } catch (Exception e) {
            String content = "Function: CommonController - aboutUs\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SharePackageViaEMail", method = RequestMethod.POST)
    public @ResponseBody
    String sharePackageviaEmail(@RequestParam("email") String email,
            @RequestParam("message") String message,
            @RequestParam("packageID") int packageID,
            @RequestParam("senderName") String senderName,
            HttpServletRequest request
    ) {
        try {
            String[] emailList = email.split(",", -1);
            String contextPath = request.getContextPath();
            String baseUrl;
            String baseUrlNoContext;
            if (contextPath != null || contextPath.isEmpty() || !contextPath.equals("")) {
                baseUrl = String.format("%s:/%s:%d" + contextPath, request.getScheme(), request.getServerName(), request.getServerPort());
                baseUrlNoContext = String.format("%s:/%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
            } else {
                baseUrl = String.format("%s:/%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
                baseUrlNoContext = String.format("%s:/%s:%d", request.getServerName(), request.getServerPort());
            }
            for (int i = 0; i < emailList.length; i++) {
                commonService.sendPackageViaEmail(packageID, senderName, emailList[i], message, baseUrl, baseUrlNoContext);
            }
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = request.getSession();
            String content = "Function: CommonController - sharePackageviaEmail\n"
                    + "***Input***\n"
                    + "email: " + email + "\n"
                    + "message: " + message + "\n"
                    + "packageID: " + packageID + "\n"
                    + "senderName: " + senderName + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e.getMessage() + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/SimilarPackages", method = RequestMethod.POST)
    public @ResponseBody
    String getSimilarPackages(HttpServletRequest request,
            @RequestBody
            final String data
    ) {
        try {
            return commonService.getSimilarPackages(data);
        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = request.getSession();
            String content = "Function: CommonController - getSimilarPackages\n"
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

    @RequestMapping(value = "/AdminLoginPage", method = RequestMethod.GET)
    public String adminLoginPage(ModelMap map, HttpSession session
    ) {
        try {
            return "AdminLoginPage";
        } catch (Exception e) {
            String content = "Function: CommonController - adminLoginPage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/AdminLogin", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session, HttpServletRequest request
    ) {
        String result = "/AdminLoginPage";
//        AdminSession admin = (AdminSession) session.getAttribute("account");
//        if (admin == null) {
        AdminSession admin = commonService.loginToAdmin(username, password);
        if (admin != null) {
            session.setAttribute("account", admin);
            result = "redirect:/Admin";
        } else {
            request.setAttribute("errorAdminLogin", "Invalid username or password");
        }
//        }
        return result;
    }

    @RequestMapping(value = "/SalesLoginPage", method = RequestMethod.GET)
    public String salesLoginPage(ModelMap map, HttpSession session
    ) {
        try {
            return "SalesLogin";
        } catch (Exception e) {
            String content = "Function: CommonController - adminLoginPage\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/SalesmanLogin", method = RequestMethod.POST)
    public String salesmanLogin(@RequestParam("username") String username,
            @RequestParam("password") String password, HttpServletRequest request,
            HttpSession session
    ) {
        String result = "error";

        SalemanSession salesman = (SalemanSession) session.getAttribute("account");
        if (salesman == null) {
            salesman = salesmanService.loginToSalesmanAccount(username, password);
            if (salesman != null) {
                session.setAttribute("account", salesman);
            }
            if (request.getParameter("language") != null) {
                result = "redirect:/Salesman" +"?language=" + request.getParameter("language");
            } else {
                result = "redirect:/Salesman";
            }
            
        }
        return result;
    }

    @RequestMapping(value = "/SubCategoriesWithinLocation", method = RequestMethod.POST)
    public @ResponseBody
    String getSubCategoriesWithinLocation(@RequestBody
            final String data, HttpSession session
    ) {
        try {
            return commonService.getAllSubCategoriesWithinLocation(data);
        } catch (Exception e) {
            String content = "Function: CommonController - getSubCategoriesWithinLocation\n"
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

    @RequestMapping(value = "/SearchPackageBelongtoSub/{subID}/{location}")
    public String goToSub(HttpServletRequest request, ModelMap map, @PathVariable int subID,
            @PathVariable String location
    ) {
        try {
            if (location.equals("all")) {
                location = " ";
            }
            String searchText = " ";
            map.addAttribute("advancedSearch", commonService.searchPackageBelongtoSub(searchText, location, subID));
            map.addAttribute("pageSize", commonService.getSearchPageSize());
            return "SubCategory";
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - goToSub\n"
                    + "***Input***\n"
                    + "search: " + request.getParameter("search") + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            map.addAttribute("errorID", session.getId());
            map.addAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/getQuickComparison/{packageID}", method = RequestMethod.GET)
    public String getQuickComparison(@PathVariable int packageID, HttpServletRequest request, HttpSession session
    ) {
        try {
            String result = commonService.getQuickComparison(packageID);
            request.setAttribute("packageDTO", result);
            request.setAttribute("packageID", packageID);
            return "quickComparison";
        } catch (Exception e) {
            String content = "Function: CommonController - getQuickComparison\n"
                    + "***Input***\n"
                    + "packageID: " + packageID + "\n"
                    + "**********\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            errorService.logBugWithAccount(content, session, e);
            return "{\"result\": \"error\"}";
        }
    }

    @RequestMapping(value = "/updateSystemKeyWord", method = RequestMethod.POST)
    public @ResponseBody
    String updateSystemKeyWord(@RequestBody
            final String data, HttpSession session
    ) {
        try {
            commonService.updateKeyWordByPackage(data);
            return "{\"result\": \"success\"}";
        } catch (Exception e) {
            String content = "Function: CommonController - updateSystemKeyWord\n"
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

    @RequestMapping(value = "/Search/GettingFilterOnlyKeyword", method = RequestMethod.POST)
    public @ResponseBody
    String getFilterOptionsOnlyKeyword(@RequestBody
            final String data, HttpServletRequest request
    ) {
        try {
            return commonService.getFilterOptionOnlyKeyword(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - getFilterOptionsOnlyKeyword\n"
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

    @RequestMapping(value = "/Search/GettingFilterOnlyLocation", method = RequestMethod.POST)
    public @ResponseBody
    String getFilterOptionsOnlyLocation(@RequestBody
            final String data, HttpServletRequest request
    ) {
        try {
            return commonService.getFilterOptionOnlyLocation(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - getFilterOptionsOnlyLocation\n"
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

    @RequestMapping(value = "/Search/GettingFilterOnlyPackage", method = RequestMethod.POST)
    public @ResponseBody
    String getFilterOptionsOnlyPackage(@RequestBody
            final String data, HttpServletRequest request
    ) {
        try {
            return commonService.getFilterOptionOnlyPackage(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - getFilterOptionsOnlyPackage\n"
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

    @RequestMapping(value = "/NoTripper", method = RequestMethod.POST)
    public @ResponseBody
    String getNoTripper(@RequestBody
            final String data, HttpServletRequest request
    ) {
        try {
            return commonService.getNoTripperOfSpecificDate(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - getNoTripper\n"
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

    @RequestMapping(value = "/GetNoOfBookedPackage", method = RequestMethod.POST)
    public @ResponseBody
    String GetNoOfBookedPackage(@RequestBody
            final String data, HttpServletRequest request
    ) {
        try {
            return String.valueOf(commonService.getNoOfBookedPackages(data));
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - GetNoOfBookedPackage\n"
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

    @RequestMapping(value = "/IsDateAvailable", method = RequestMethod.POST)
    public @ResponseBody
    String isDateAvailable(@RequestBody
            final String data, HttpServletRequest request
    ) {
        try {
            return commonService.isAvailableForSpecificDate(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - isDateAvailable\n"
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

    @RequestMapping(value = "/IsTimeAvailable", method = RequestMethod.POST)
    public @ResponseBody
    String isTimeAvailable(@RequestBody
            final String data, HttpServletRequest request
    ) {
        try {
            return commonService.isAvailableForSpecificTime(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - isTimeAvailable\n"
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

    @RequestMapping(value = "/IsJointBooked", method = RequestMethod.POST)
    public @ResponseBody
    String isJointBooked(@RequestBody
            final String data, HttpServletRequest request
    ) {
        try {
            return commonService.isAvailableForSpecificTime(data);
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: CommonController - isJointBooked\n"
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

    @RequestMapping(value = "/NewPassword/{token}")
    public String addNewPassword(HttpServletRequest request,
            @PathVariable String token, HttpSession session
    ) {
        try {
            request.setAttribute("token", token);
            return "addPassword";
        } catch (Exception e) {
            String content = "Function: CommonController - addNewPassword\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }

    @RequestMapping(value = "/AddNewPassword", method = RequestMethod.POST)
    public String insertPasword(HttpServletRequest request
    ) {
        try {
            HttpSession session = request.getSession(true);
            String token = (String) request.getParameter("token");
            String newPassword = (String) request.getParameter("newPass");
            System.out.println(token);
            System.out.println(newPassword);
            AccountSession account = commonService.validateTokenForProvider(token);
            commonService.insertPassword(newPassword, account.getId());
            session.setAttribute("account", account);
            if (request.getParameter("language") != null) {
               return "redirect:/" +"?language=" + request.getParameter("language");
            } else {
                return "redirect:/";
            }
            
        } catch (Exception e) {
            HttpSession session = request.getSession(true);
            String content = "Function: UserController - changePassword\n"
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

    @RequestMapping(value = "/ResendActiveEmail")
    public String resendActiveEmail(HttpServletRequest request, HttpSession session
    ) {
        try {
            System.out.println("Resend Active Email");
            String email = (String) session.getAttribute("resendEmail");
            String lastName = (String) session.getAttribute("lastName");
            String newToken = (String) session.getAttribute("newToken");
            String contextPath = request.getContextPath();
            String baseUrl;
            if (contextPath != null || contextPath.isEmpty() || !contextPath.equals("")) {
                baseUrl = String.format("%s://%s:%d" + contextPath, request.getScheme(), request.getServerName(), request.getServerPort());
            } else {
                baseUrl = String.format("%s://%s:%d", request.getScheme(), request.getServerName(), request.getServerPort());
            }

            commonService.sendActivationEmail("Youtripper Provider Register Confirmation", lastName, email, newToken, baseUrl);
            return "SignupSuccess";
        } catch (Exception e) {
            String content = "Function: CommonController - resendActiveEmail\n"
                    + "****Error****\n"
                    + e + "\n"
                    + "**********";
            request.setAttribute("errorID", session.getId());
            request.setAttribute("errorTime", errorService.logBugWithAccount(content, session, e));
            return "forward:/Common/Error";
        }
    }
}
