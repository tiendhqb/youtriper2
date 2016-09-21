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
public class DeleteReasonDTO {
    private int deleteReasonID;
    private String deleteContent;
    private boolean isOther;

    public DeleteReasonDTO() {
    }

    public DeleteReasonDTO(int deleteReasonID, String deleteContent, boolean isOther) {
        this.deleteReasonID = deleteReasonID;
        this.deleteContent = deleteContent;
        this.isOther = isOther;
    }
    

    /**
     * @return the deleteReasonID
     */
    public int getDeleteReasonID() {
        return deleteReasonID;
    }

    /**
     * @param deleteReasonID the deleteReasonID to set
     */
    public void setDeleteReasonID(int deleteReasonID) {
        this.deleteReasonID = deleteReasonID;
    }

    /**
     * @return the deleteContent
     */
    public String getDeleteContent() {
        return deleteContent;
    }

    /**
     * @param deleteContent the deleteContent to set
     */
    public void setDeleteContent(String deleteContent) {
        this.deleteContent = deleteContent;
    }

    /**
     * @return the isOther
     */
    public boolean isIsOther() {
        return isOther;
    }

    /**
     * @param isOther the isOther to set
     */
    public void setIsOther(boolean isOther) {
        this.isOther = isOther;
    }
    
    
}
