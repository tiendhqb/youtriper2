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
public class PackageCertificateDTO {
    private int certificateID;
    private int providerID;
    private String image;
    private String name;
    private String providerName;
    private boolean isApproved;

    public PackageCertificateDTO() {
    }
    
    public PackageCertificateDTO(int certificateID, String imageLink) {
        this.certificateID = certificateID;
        this.image = imageLink;
    }

    public PackageCertificateDTO(String image, boolean isApproved) {
        this.image = image;
        this.isApproved = isApproved;
    }
    
    public int getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(int certificateID) {
        this.certificateID = certificateID;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    
}
