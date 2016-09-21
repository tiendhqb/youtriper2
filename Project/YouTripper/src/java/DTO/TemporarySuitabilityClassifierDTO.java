/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nick
 */
public class TemporarySuitabilityClassifierDTO {

    private int temporaryPackageID;
    private int suitabilityID;
    private String suitabilityName;
    private String content;
    private boolean selected;

    public TemporarySuitabilityClassifierDTO() {
    }

    public TemporarySuitabilityClassifierDTO(int temporaryPackageID, int suitabilityID, String suitabilityName, String content) {
        this.temporaryPackageID = temporaryPackageID;
        this.suitabilityID = suitabilityID;
        this.suitabilityName = suitabilityName;
        this.content = content;
    }

    public TemporarySuitabilityClassifierDTO(int suitabilityID, String suitabilityName, String content, boolean selected) {
        this.suitabilityID = suitabilityID;
        this.suitabilityName = suitabilityName;
        this.content = content;
        this.selected = selected;
    }

    public TemporarySuitabilityClassifierDTO(String suitabilityName) {
        this.suitabilityName = suitabilityName;
    }

    public int getTemporaryPackageID() {
        return temporaryPackageID;
    }

    public void setTemporaryPackageID(int temporaryPackageID) {
        this.temporaryPackageID = temporaryPackageID;
    }

    public int getSuitabilityID() {
        return suitabilityID;
    }

    public void setSuitabilityID(int suitabilityID) {
        this.suitabilityID = suitabilityID;
    }

    public String getSuitabilityName() {
        return suitabilityName;
    }

    public void setSuitabilityName(String suitabilityName) {
        this.suitabilityName = suitabilityName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
