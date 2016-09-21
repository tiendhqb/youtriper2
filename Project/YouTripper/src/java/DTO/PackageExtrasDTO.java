/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author Nick
 */
public class PackageExtrasDTO {

    private int packageID;
    private String included;
    private String excluded;
    private List<AmenitiesDTO> listAmenities;

    public PackageExtrasDTO() {
    }

    public PackageExtrasDTO(int packageID, String included, String excluded, List<AmenitiesDTO> listAmenities) {
        this.packageID = packageID;
        this.included = included;
        this.excluded = excluded;
        this.listAmenities = listAmenities;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getIncluded() {
        return included;
    }

    public void setIncluded(String included) {
        this.included = included;
    }

    public String getExcluded() {
        return excluded;
    }

    public void setExcluded(String excluded) {
        this.excluded = excluded;
    }

    public List<AmenitiesDTO> getListAmenities() {
        return listAmenities;
    }

    public void setListAmenities(List<AmenitiesDTO> listAmenities) {
        this.listAmenities = listAmenities;
    }
    
    
}
