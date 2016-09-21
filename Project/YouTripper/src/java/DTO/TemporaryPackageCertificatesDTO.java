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
public class TemporaryPackageCertificatesDTO {

    private int certificateID;
    private int temporaryPackageID;
    private String content;
    private String imageLink;
    private boolean isApproved;

    public TemporaryPackageCertificatesDTO() {
    }

    public TemporaryPackageCertificatesDTO(int certificateID, int temporaryPackageID, String content) {
        this.certificateID = certificateID;
        this.temporaryPackageID = temporaryPackageID;
        this.content = content;
    }

    public TemporaryPackageCertificatesDTO(String imageLink, boolean isApproved) {
        this.imageLink = imageLink;
        this.isApproved = isApproved;
    }
    
    public TemporaryPackageCertificatesDTO(int certificateID, String imageLink) {
        this.certificateID = certificateID;
        this.imageLink = imageLink;
    }
    
    public int getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(int certificateID) {
        this.certificateID = certificateID;
    }

    public int getTemporaryPackageID() {
        return temporaryPackageID;
    }

    public void setTemporaryPackageID(int temporaryPackageID) {
        this.temporaryPackageID = temporaryPackageID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    
}
