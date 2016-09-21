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
public class SuitabilityClassifierDTO {
    private int packageID;
    private int suitabilityID;
    private String suitabilityName;
    private String content;
    private boolean selected;
    
    public SuitabilityClassifierDTO() {
    }

    public SuitabilityClassifierDTO(int packageID, int suitabilityID, String suitabilityName, String content) {
        this.packageID = packageID;
        this.suitabilityID = suitabilityID;
        this.suitabilityName = suitabilityName;
        this.content = content;
    }
    public SuitabilityClassifierDTO(int suitabilityID, String suitabilityName, String content, boolean selected) {
        this.suitabilityID = suitabilityID;
        this.suitabilityName = suitabilityName;
        this.content = content;
        this.selected = selected;
    }
    /**
     * @return the packageID
     */
    public int getTemporaryPackageID() {
        return packageID;
    }

    /**
     * @param packageID the packageID to set
     */
    public void setTemporaryPackageID(int packageID) {
        this.packageID = packageID;
    }

    /**
     * @return the suitabilityID
     */
    public int getSuitabilityID() {
        return suitabilityID;
    }

    /**
     * @param suitabilityID the suitabilityID to set
     */
    public void setSuitabilityID(int suitabilityID) {
        this.suitabilityID = suitabilityID;
    }

    /**
     * @return the suitabilityName
     */
    public String getSuitabilityName() {
        return suitabilityName;
    }

    /**
     * @param suitabilityName the suitabilityName to set
     */
    public void setSuitabilityName(String suitabilityName) {
        this.suitabilityName = suitabilityName;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
}
