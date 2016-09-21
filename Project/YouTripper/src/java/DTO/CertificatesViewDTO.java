/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Tien
 */
public class CertificatesViewDTO {
    
    private int providerID;
    private int certificateID;
    private String name;
    private String image;
    private boolean isApproved;

    public CertificatesViewDTO() {
    }

    public CertificatesViewDTO(int certificateID, String Name, String coverImage, boolean isApproved) {
        this.certificateID = certificateID;
        this.name = Name;
        this.image = coverImage;
        this.isApproved = isApproved;
    }
    
    public CertificatesViewDTO(String Image) {
        this.image = Image;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public int getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(int certificateID) {
        this.certificateID = certificateID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }

    
    
}
