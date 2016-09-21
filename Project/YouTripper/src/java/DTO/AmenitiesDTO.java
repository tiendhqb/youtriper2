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
public class AmenitiesDTO {

    private int amenitiesID;
    private String amenitiesType;
    private String image;
    private String icon;

    public AmenitiesDTO() {
    }

    public AmenitiesDTO(int amenitiesID, String amenitiesType, String icon) {
        this.amenitiesID = amenitiesID;
        this.amenitiesType = amenitiesType;
        this.icon = icon;
    }

    public AmenitiesDTO(String amenitiesType, String image) {
        this.amenitiesType = amenitiesType;
        this.image = image;
    }
    
    public int getAmenitiesID() {
        return amenitiesID;
    }

    public void setAmenitiesID(int amenitiesID) {
        this.amenitiesID = amenitiesID;
    }

    public String getAmenitiesType() {
        return amenitiesType;
    }

    public void setAmenitiesType(String amenitiesType) {
        this.amenitiesType = amenitiesType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
    
    
}
