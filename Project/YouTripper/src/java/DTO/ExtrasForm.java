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
public class ExtrasForm {

    private int packageID;
    private String included;
    private String excluded;
//    private List<AmenitiesDTO> listAmenities;
    private String otherContent;
    private List<TemporaryAmenitiesClassifierDTO> amenitiesClassifiers;
    private List<TemporaryTransoprtationWayDTO> transportationWays;
    
    private int certificateID;

    public ExtrasForm() {
    }

    public ExtrasForm(int packageID, String included, String excluded, List<TemporaryTransoprtationWayDTO> transportationWays, String otherContent, List<TemporaryAmenitiesClassifierDTO> amenitiesClassifiers) {
        this.packageID = packageID;
        this.included = included;
        this.excluded = excluded;
        this.transportationWays = transportationWays;
        this.otherContent = otherContent;
        this.amenitiesClassifiers = amenitiesClassifiers;
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

    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent;
    }

    public List<TemporaryAmenitiesClassifierDTO> getAmenitiesClassifiers() {
        return amenitiesClassifiers;
    }

    public void setAmenitiesClassifiers(List<TemporaryAmenitiesClassifierDTO> amenitiesClassifiers) {
        this.amenitiesClassifiers = amenitiesClassifiers;
    }

    public List<TemporaryTransoprtationWayDTO> getTransportationWays() {
        return transportationWays;
    }

    public void setTransportationWays(List<TemporaryTransoprtationWayDTO> transportationWays) {
        this.transportationWays = transportationWays;
    }

    public int getCertificateID() {
        return certificateID;
    }

    public void setCertificateID(int certificateID) {
        this.certificateID = certificateID;
    }
    
    

}
