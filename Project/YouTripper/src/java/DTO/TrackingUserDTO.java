/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author DINH KHANG
 */
public class TrackingUserDTO {
    private int visitorID;
    private int affiliateCode;
    private String referrerURL;
    private String ip;
    private String device;
    private String visitTime;
    private String visitURL;

    public TrackingUserDTO(int visitorID, int affiliateCode, String referrerURL, String ip, String device, String visitTime, String visitURL) {
        this.visitorID = visitorID;
        this.affiliateCode = affiliateCode;
        this.referrerURL = referrerURL;
        this.ip = ip;
        this.device = device;
        this.visitTime = visitTime;
        this.visitURL = visitURL;
    }      

    public TrackingUserDTO(int affiliateCode, String referrerURL, String ip, String device, String visitTime, String visitURL) {
        this.affiliateCode = affiliateCode;
        this.referrerURL = referrerURL;
        this.ip = ip;
        this.device = device;
        this.visitTime = visitTime;
        this.visitURL = visitURL;
    }
    
    public int getVisitorID() {
        return visitorID;
    }

    public int getAffiliateCode() {
        return affiliateCode;
    }

    public String getReferrerURL() {
        return referrerURL;
    }

    public String getIp() {
        return ip;
    }

    public String getDevice() {
        return device;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public String getVisitURL() {
        return visitURL;
    }

    public void setVisitorID(int visitorID) {
        this.visitorID = visitorID;
    }

    public void setAffiliateCode(int affiliateCode) {
        this.affiliateCode = affiliateCode;
    }

    public void setReferrerURL(String referrerURL) {
        this.referrerURL = referrerURL;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public void setVisitURL(String visitURL) {
        this.visitURL = visitURL;
    }
    
    
}
