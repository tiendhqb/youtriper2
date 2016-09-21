/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;
/**
 *
 * @author QuangTran
 */
public class ReferralDTO {
    private int senderID;
    private int receiverID;
    private String receiverEmail;
    private String sendDate;
    private String token;
    private String confirmDate;
    private int referralStatus;

    public ReferralDTO() {
    }

    public ReferralDTO(int senderID, String receiverEmail, String sendDate, String token, int referralStatus) {
        this.senderID = senderID;
        this.receiverEmail = receiverEmail;
        this.sendDate = sendDate;
        this.token = token;
        this.referralStatus = referralStatus;
    }

    public ReferralDTO(int senderID, int receiverID, String receiverEmail, String sendDate, String token, String confirmDate) {
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.receiverEmail = receiverEmail;
        this.sendDate = sendDate;
        this.token = token;
        this.confirmDate = confirmDate;
    }

    public ReferralDTO(int senderID, String receiverEmail, String sendDate, String token) {
        this.senderID = senderID;
        this.receiverEmail = receiverEmail;
        this.sendDate = sendDate;
        this.token = token;
    }
    /**
     * @return the senderID
     */
    
    public int getSenderID() {
        return senderID;
    }

    /**
     * @param senderID the senderID to set
     */
    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    /**
     * @return the receiverID
     */
    public int getReceiverID() {
        return receiverID;
    }

    /**
     * @param receiverID the receiverID to set
     */
    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }

    /**
     * @return the receiverEmail
     */
    public String getReceiverEmail() {
        return receiverEmail;
    }

    /**
     * @param receiverEmail the receiverEmail to set
     */
    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    /**
     * @return the sendDate
     */
    public String getSendDate() {
        return sendDate;
    }

    /**
     * @param sendDate the sendDate to set
     */
    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the confirmDate
     */
    public String getConfirmDate() {
        return confirmDate;
    }

    /**
     * @param confirmDate the confirmDate to set
     */
    public void setConfirmDate(String confirmDate) {
        this.confirmDate = confirmDate;
    }

    /**
     * @return the referralStatus
     */
    public int getReferralStatus() {
        return referralStatus;
    }

    /**
     * @param referralStatus the referralStatus to set
     */
    public void setReferralStatus(int referralStatus) {
        this.referralStatus = referralStatus;
    }
    
    
    
}
